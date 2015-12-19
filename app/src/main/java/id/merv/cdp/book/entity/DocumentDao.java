package id.merv.cdp.book.entity;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

import id.merv.cdp.book.entity.Document;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DOCUMENT".
*/
public class DocumentDao extends AbstractDao<Document, Long> {

    public static final String TABLENAME = "DOCUMENT";

    /**
     * Properties of entity Document.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property DbId = new Property(0, Long.class, "dbId", true, "_id");
        public final static Property DbCreateDate = new Property(1, java.util.Date.class, "dbCreateDate", false, "CREATE_DATE");
        public final static Property DbUpdateDate = new Property(2, java.util.Date.class, "dbUpdateDate", false, "UPDATE_DATE");
        public final static Property DbCreateBy = new Property(3, String.class, "dbCreateBy", false, "CREATE_BY");
        public final static Property DbUpdateBy = new Property(4, String.class, "dbUpdateBy", false, "UPDATE_BY");
        public final static Property DbActiveFlag = new Property(5, Integer.class, "dbActiveFlag", false, "ACTIVE_FLAG");
        public final static Property Id = new Property(6, String.class, "id", false, "REF_ID");
        public final static Property RefCreateDate = new Property(7, java.util.Date.class, "refCreateDate", false, "REF_CREATE_DATE");
        public final static Property RefCreateBy = new Property(8, String.class, "refCreateBy", false, "REF_CREATE_BY");
        public final static Property FileInfoId = new Property(9, Long.class, "fileInfoId", false, "FILE_INFO_ID");
        public final static Property Subject = new Property(10, String.class, "subject", false, "SUBJECT");
        public final static Property Description = new Property(11, String.class, "description", false, "DESCRIPTION");
        public final static Property Content = new Property(12, String.class, "content", false, "CONTENT");
        public final static Property Properties = new Property(13, String.class, "properties", false, "PROPERTIES");
        public final static Property ContentType = new Property(14, String.class, "contentType", false, "CONTENT_TYPE");
        public final static Property Status = new Property(15, String.class, "status", false, "STATUS");
        public final static Property Sha256Hash = new Property(16, String.class, "sha256Hash", false, "SHA256_HASH");
    };

    private DaoSession daoSession;


    public DocumentDao(DaoConfig config) {
        super(config);
    }
    
    public DocumentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DOCUMENT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: dbId
                "\"CREATE_DATE\" INTEGER," + // 1: dbCreateDate
                "\"UPDATE_DATE\" INTEGER," + // 2: dbUpdateDate
                "\"CREATE_BY\" TEXT," + // 3: dbCreateBy
                "\"UPDATE_BY\" TEXT," + // 4: dbUpdateBy
                "\"ACTIVE_FLAG\" INTEGER," + // 5: dbActiveFlag
                "\"REF_ID\" TEXT," + // 6: id
                "\"REF_CREATE_DATE\" INTEGER," + // 7: refCreateDate
                "\"REF_CREATE_BY\" TEXT," + // 8: refCreateBy
                "\"FILE_INFO_ID\" INTEGER," + // 9: fileInfoId
                "\"SUBJECT\" TEXT," + // 10: subject
                "\"DESCRIPTION\" TEXT," + // 11: description
                "\"CONTENT\" TEXT," + // 12: content
                "\"PROPERTIES\" TEXT," + // 13: properties
                "\"CONTENT_TYPE\" TEXT," + // 14: contentType
                "\"STATUS\" TEXT," + // 15: status
                "\"SHA256_HASH\" TEXT);"); // 16: sha256Hash
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DOCUMENT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Document entity) {
        stmt.clearBindings();
 
        Long dbId = entity.getDbId();
        if (dbId != null) {
            stmt.bindLong(1, dbId);
        }
 
        java.util.Date dbCreateDate = entity.getDbCreateDate();
        if (dbCreateDate != null) {
            stmt.bindLong(2, dbCreateDate.getTime());
        }
 
        java.util.Date dbUpdateDate = entity.getDbUpdateDate();
        if (dbUpdateDate != null) {
            stmt.bindLong(3, dbUpdateDate.getTime());
        }
 
        String dbCreateBy = entity.getDbCreateBy();
        if (dbCreateBy != null) {
            stmt.bindString(4, dbCreateBy);
        }
 
        String dbUpdateBy = entity.getDbUpdateBy();
        if (dbUpdateBy != null) {
            stmt.bindString(5, dbUpdateBy);
        }
 
        Integer dbActiveFlag = entity.getDbActiveFlag();
        if (dbActiveFlag != null) {
            stmt.bindLong(6, dbActiveFlag);
        }
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(7, id);
        }
 
        java.util.Date refCreateDate = entity.getRefCreateDate();
        if (refCreateDate != null) {
            stmt.bindLong(8, refCreateDate.getTime());
        }
 
        String refCreateBy = entity.getRefCreateBy();
        if (refCreateBy != null) {
            stmt.bindString(9, refCreateBy);
        }
 
        Long fileInfoId = entity.getFileInfoId();
        if (fileInfoId != null) {
            stmt.bindLong(10, fileInfoId);
        }
 
        String subject = entity.getSubject();
        if (subject != null) {
            stmt.bindString(11, subject);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(12, description);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(13, content);
        }
 
        String properties = entity.getProperties();
        if (properties != null) {
            stmt.bindString(14, properties);
        }
 
        String contentType = entity.getContentType();
        if (contentType != null) {
            stmt.bindString(15, contentType);
        }
 
        String status = entity.getStatus();
        if (status != null) {
            stmt.bindString(16, status);
        }
 
        String sha256Hash = entity.getSha256Hash();
        if (sha256Hash != null) {
            stmt.bindString(17, sha256Hash);
        }
    }

    @Override
    protected void attachEntity(Document entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Document readEntity(Cursor cursor, int offset) {
        Document entity = new Document( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // dbId
            cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)), // dbCreateDate
            cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)), // dbUpdateDate
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // dbCreateBy
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // dbUpdateBy
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // dbActiveFlag
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // id
            cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)), // refCreateDate
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // refCreateBy
            cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9), // fileInfoId
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // subject
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // description
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // content
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // properties
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // contentType
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // status
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16) // sha256Hash
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Document entity, int offset) {
        entity.setDbId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDbCreateDate(cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)));
        entity.setDbUpdateDate(cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)));
        entity.setDbCreateBy(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDbUpdateBy(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDbActiveFlag(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setId(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setRefCreateDate(cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)));
        entity.setRefCreateBy(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setFileInfoId(cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9));
        entity.setSubject(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setDescription(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setContent(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setProperties(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setContentType(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setStatus(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setSha256Hash(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Document entity, long rowId) {
        entity.setDbId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Document entity) {
        if(entity != null) {
            return entity.getDbId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getFileInfoDao().getAllColumns());
            builder.append(" FROM DOCUMENT T");
            builder.append(" LEFT JOIN FILE_INFO T0 ON T.\"FILE_INFO_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Document loadCurrentDeep(Cursor cursor, boolean lock) {
        Document entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        FileInfo fileInfo = loadCurrentOther(daoSession.getFileInfoDao(), cursor, offset);
        entity.setFileInfo(fileInfo);

        return entity;    
    }

    public Document loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Document> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Document> list = new ArrayList<Document>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Document> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Document> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
