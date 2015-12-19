package id.merv.cdp.book.entity;

import id.merv.cdp.book.entity.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "DOCUMENT".
 */
public class Document implements java.io.Serializable, LogInformationAware {

    private Long dbId;
    private java.util.Date dbCreateDate;
    private java.util.Date dbUpdateDate;
    private String dbCreateBy;
    private String dbUpdateBy;
    private Integer dbActiveFlag;
    private String id;
    private java.util.Date refCreateDate;
    private String refCreateBy;
    private Long fileInfoId;
    private String subject;
    private String description;
    private String content;
    private String properties;
    private String contentType;
    private String status;
    private String sha256Hash;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient DocumentDao myDao;

    private FileInfo fileInfo;
    private Long fileInfo__resolvedKey;


    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Document() {
    }

    public Document(Long dbId) {
        this.dbId = dbId;
    }

    public Document(Long dbId, java.util.Date dbCreateDate, java.util.Date dbUpdateDate, String dbCreateBy, String dbUpdateBy, Integer dbActiveFlag, String id, java.util.Date refCreateDate, String refCreateBy, Long fileInfoId, String subject, String description, String content, String properties, String contentType, String status, String sha256Hash) {
        this.dbId = dbId;
        this.dbCreateDate = dbCreateDate;
        this.dbUpdateDate = dbUpdateDate;
        this.dbCreateBy = dbCreateBy;
        this.dbUpdateBy = dbUpdateBy;
        this.dbActiveFlag = dbActiveFlag;
        this.id = id;
        this.refCreateDate = refCreateDate;
        this.refCreateBy = refCreateBy;
        this.fileInfoId = fileInfoId;
        this.subject = subject;
        this.description = description;
        this.content = content;
        this.properties = properties;
        this.contentType = contentType;
        this.status = status;
        this.sha256Hash = sha256Hash;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDocumentDao() : null;
    }

    public Long getDbId() {
        return dbId;
    }

    public void setDbId(Long dbId) {
        this.dbId = dbId;
    }

    public java.util.Date getDbCreateDate() {
        return dbCreateDate;
    }

    public void setDbCreateDate(java.util.Date dbCreateDate) {
        this.dbCreateDate = dbCreateDate;
    }

    public java.util.Date getDbUpdateDate() {
        return dbUpdateDate;
    }

    public void setDbUpdateDate(java.util.Date dbUpdateDate) {
        this.dbUpdateDate = dbUpdateDate;
    }

    public String getDbCreateBy() {
        return dbCreateBy;
    }

    public void setDbCreateBy(String dbCreateBy) {
        this.dbCreateBy = dbCreateBy;
    }

    public String getDbUpdateBy() {
        return dbUpdateBy;
    }

    public void setDbUpdateBy(String dbUpdateBy) {
        this.dbUpdateBy = dbUpdateBy;
    }

    public Integer getDbActiveFlag() {
        return dbActiveFlag;
    }

    public void setDbActiveFlag(Integer dbActiveFlag) {
        this.dbActiveFlag = dbActiveFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public java.util.Date getRefCreateDate() {
        return refCreateDate;
    }

    public void setRefCreateDate(java.util.Date refCreateDate) {
        this.refCreateDate = refCreateDate;
    }

    public String getRefCreateBy() {
        return refCreateBy;
    }

    public void setRefCreateBy(String refCreateBy) {
        this.refCreateBy = refCreateBy;
    }

    public Long getFileInfoId() {
        return fileInfoId;
    }

    public void setFileInfoId(Long fileInfoId) {
        this.fileInfoId = fileInfoId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSha256Hash() {
        return sha256Hash;
    }

    public void setSha256Hash(String sha256Hash) {
        this.sha256Hash = sha256Hash;
    }

    /** To-one relationship, resolved on first access. */
    public FileInfo getFileInfo() {
        Long __key = this.fileInfoId;
        if (fileInfo__resolvedKey == null || !fileInfo__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FileInfoDao targetDao = daoSession.getFileInfoDao();
            FileInfo fileInfoNew = targetDao.load(__key);
            synchronized (this) {
                fileInfo = fileInfoNew;
            	fileInfo__resolvedKey = __key;
            }
        }
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        synchronized (this) {
            this.fileInfo = fileInfo;
            fileInfoId = fileInfo == null ? null : fileInfo.getDbId();
            fileInfo__resolvedKey = fileInfoId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    @Override
    public void setLogInformation(LogInformation logInformation) {
        setRefCreateDate(logInformation.getCreateDate());
        setRefCreateBy(logInformation.getCreateBy());
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
