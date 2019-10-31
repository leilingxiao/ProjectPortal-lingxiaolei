package edu.bu.projectportal.database;

/**
 * Created by danazh on 4/18/18.
 */

public final class ProjectPortalDBContract {
    public static final String DBName = "projectportal.db";
    public static final int DB_VERSION = 1;

    public static final class ProjectContract{
        public static final String TABLE_NAME = "projects";
        public static final String COLUMN_PROJECT_ID = "project_id";
        public static final String  COLUMN_PROJECT_Title = "project_title";
        public static final String COLUMN_PROJECT_SUMMARY = "project_summary";
        public static final String COLUMN_PROJECT_AUTHOR = "project_author";
        public static final String COLUMN_PROJECT_KEYWORD = "project_keyword";
        public static final String COLUMN_PROJECT_ISFAVORATE = "project_isFavorate";
        public static final String COLUMN_PROJECT_LINK1 = "project_link1";
        public static final String COLUMN_PROJECT_LINK2 = "project_link2";
    }

    public static final String CREATE_PROJECT_TABLE = "CREATE TABLE " +
            ProjectPortalDBContract.ProjectContract.TABLE_NAME +
            "(" +
            ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Title +
            " TEXT," +
            ProjectContract.COLUMN_PROJECT_SUMMARY +

            " TEXT,"+
            ProjectContract.COLUMN_PROJECT_AUTHOR +

            " TEXT,"+
            ProjectContract.COLUMN_PROJECT_KEYWORD +

            " TEXT,"+
            ProjectContract.COLUMN_PROJECT_ISFAVORATE +

            " TEXT,"+
            ProjectContract.COLUMN_PROJECT_LINK1 +

            " TEXT,"+
            ProjectContract.COLUMN_PROJECT_LINK2 +
            " TEXT);"
            ;

    public static final String DROP_PROJECT_TABLE = "DROP TABLE IF EXISTS "
            + ProjectPortalDBContract.ProjectContract.TABLE_NAME;
}
