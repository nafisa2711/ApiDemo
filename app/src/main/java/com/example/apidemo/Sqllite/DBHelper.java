package com.example.apidemo.Sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    // Table Name
    static final String TABLENAME = "EDUCATION";

    //Table Colums
    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String SUBJECT = "subject";

    // Database Information
    private static final String DB_NAME = "DETAIL.DB";

    // database version
    private static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLENAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT NOT NULL, " + SUBJECT + " TEXT);";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
        onCreate(sqLiteDatabase);

    }
}
