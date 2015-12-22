package id.merv.cdp.book.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.meruvian.dnabook.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import id.merv.cdp.book.MeruvianBookApplication;
import id.merv.cdp.book.adapter.BookListAdapter;
import id.merv.cdp.book.entity.Attachments;
import id.merv.cdp.book.entity.Contents;
import id.merv.cdp.book.entity.Document;
import id.merv.cdp.book.entity.DocumentDao;
import id.merv.cdp.book.entity.FileInfo;
import id.merv.cdp.book.entity.FileInfoDao;
import id.merv.cdp.book.entity.MainBody;
import id.merv.cdp.book.job.AttahmentsDownloadJob;
import id.merv.cdp.book.service.ContentService;
import id.merv.cdp.book.service.JobStatus;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by akm on 18/12/15.
 */
public class ChoosedCategoryBookDetailFragment extends Fragment {

    @Bind(R.id.list_book_contents) RecyclerView recyclerView;
    @Bind(R.id.contents_title) TextView contenTitle;
    @Bind(R.id.contents_description) TextView contenDescription;
    @Bind(R.id.category_image) ImageView categoryImage;
    @Bind(R.id.downloading_progress) ProgressBar progressBar;
    RecyclerView.LayoutManager layoutManager;
    private BookListAdapter adapter;
    private MainBody<Contents> mainBody;
    private MainBody<Document> attachmentsMainBody;
    private Document document;

    public static ChoosedCategoryBookDetailFragment newInstance(String id, String attachmentsId, long documentId) {
        ChoosedCategoryBookDetailFragment fragment = new ChoosedCategoryBookDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.getArguments().putString("id", id);
        fragment.getArguments().putString("attachmentsId", attachmentsId);
        fragment.getArguments().putLong("documentId", documentId);
        return fragment;
    }


    @Override
    public void onStart() {
        super.onStart();

        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();

        EventBus.getDefault().unregister(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choosed_category_book_detail, container, false);

        ButterKnife.bind(this, view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter = new BookListAdapter(getActivity(),getArguments().getLong("documentId")));

        String id = getArguments().getString("id");

        MeruvianBookApplication app = MeruvianBookApplication.getInstance();
        ContentService service = app.getRetrofit().create(ContentService.class);
        final String imageUrl = MeruvianBookApplication.SERVER_URL + "/api/contents/" + getArguments().getString("attachmentsId") + "/thumbnail";

        try {
            Map<String, String> param = new HashMap<>();
            param.put("category", id);
            Call<MainBody<Contents>> getContentsByCategory = service.getContentsById(param);
            getContentsByCategory.enqueue(new Callback<MainBody<Contents>>() {
                @Override
                public void onResponse(Response<MainBody<Contents>> response, Retrofit retrofit) {
                    if (response.isSuccess()) {
                        mainBody = response.body();
                        for (Contents s : mainBody.getContent()) {
                            Contents contents = new Contents();
                            contents.setTitle(s.getTitle());
                            contenTitle.setText(s.getTitle());
                            contenDescription.setText(Html.fromHtml(s.getDescription()));

                            ImageLoader imageLoader = ImageLoader.getInstance();
                            imageLoader.displayImage(imageUrl, categoryImage);
                        }
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.d("Error", t.getMessage());

                }
            });

        }catch (Exception e) {
            e.printStackTrace();
        }


        try {
            String attachmentsId = getArguments().getString("attachmentsId");
            Call<MainBody<Document>>getContentsAttachments = service.getContentsAttachment(attachmentsId);
            getContentsAttachments.enqueue(new Callback<MainBody<Document>>() {
                @Override
                public void onResponse(Response<MainBody<Document>> response, Retrofit retrofit) {
                    if (response.isSuccess()) {
                        attachmentsMainBody = response.body();

                        for (Document d : attachmentsMainBody.getContent()) {

                            adapter.addItem(d);

                        }
                        attachmentsMainBody.getTotalElements();
                    }
                }
                @Override
                public void onFailure(Throwable t) {

                }
            });

        }catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public void onEventMainThread(AttahmentsDownloadJob.AttachmentsDownloadEvent event) {
        if (event.getStatus() == JobStatus.ADDED) {
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            Toast.makeText(getActivity(), "Downloading...", Toast.LENGTH_LONG).show();
        }
        if (event.getStatus() == JobStatus.SUCCESS) {
            long attachmentsId = getArguments().getLong("documentId");
            FragmentUtils.replaceFragment(getFragmentManager(), BookViewFragment.newInstance(attachmentsId), true);
        }
    }


}