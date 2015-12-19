package id.merv.cdp.book.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.meruvian.dnabook.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.path.android.jobqueue.JobManager;

import java.util.ArrayList;
import java.util.List;

import id.merv.cdp.book.activity.MainActivity;
import id.merv.cdp.book.entity.Contents;
import id.merv.cdp.book.entity.MainBody;

/**
 * Created by akm on 18/12/15.
 */
public class BooksInsideCategoryAdapter extends RecyclerView.Adapter<BooksInsideCategoryAdapter.ViewHolder> {

    private Context context;
    private String id;
    private String attachmentsId;
    List<Contents> bookList = new ArrayList<Contents>();
    private ImageLoader imageLoader = ImageLoader.getInstance();

    public BooksInsideCategoryAdapter(Context context, String id, String attachmentsId) {
        this.attachmentsId = attachmentsId;
        this.id = id;
        this.context = context;
        if (!imageLoader.isInited()) {
            imageLoader.init(ImageLoaderConfiguration.createDefault(context));
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choosed_book_category_inner_fragment, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    public void getId(String id) {

    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contents contents = bookList.get(position);
        holder.bookTitle.setText(contents.getTitle());
        holder.bookThumbnail.setImageResource(R.drawable.ssssss);
        holder.detailButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainActivity)context).getFragment(id, attachmentsId);

                Log.d("tes2", id);
            }
        });

    }

    @Override
    public int getItemCount() {

        Log.d("cek", String.valueOf(bookList.size()));

        return bookList.size();
    }

    public void addItem(Contents contents) {
        bookList.add(contents);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView bookTitle;
        public ImageView bookThumbnail;
        public TextView bookPrice;
        public ImageButton detailButton;

        public ViewHolder(View itemView) {
            super(itemView);
            bookTitle = (TextView) itemView.findViewById(R.id.book_title);
            bookThumbnail = (ImageView) itemView.findViewById(R.id.book_thumbnail);
            bookPrice = (TextView) itemView.findViewById(R.id.book_description);
            detailButton = (ImageButton) itemView.findViewById(R.id.detail_button);
        }
    }
}
