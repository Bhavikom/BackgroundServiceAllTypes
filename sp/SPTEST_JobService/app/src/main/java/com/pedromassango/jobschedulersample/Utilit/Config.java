package com.pedromassango.jobschedulersample.Utilit;

public class Config {

    public static final String DATABASE_NAME = "student-db";

    //column names of student table
    public static final String TABLE_STUDENT = "student";
    public static final String COLUMN_STUDENT_ID = "_id";
    public static final String COLUMN_TIME = "insert_time";
    public static final String COLUMN_SOURCE = "insert_source";
    public static final String COLUMN_JOB_ID = "job_id";
    public static final String COLUMN_STUDENT_EMAIL = "email";

    //others for general purpose key-value pair data
    public static final String TITLE = "title";
    public static final String CREATE_STUDENT = "create_student";
    public static final String UPDATE_STUDENT = "update_student";
}
