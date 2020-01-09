package com.example.apidemo.Sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    DBHelper dbHelper;
    SQLiteDatabase database;
    Context context;

    public DBManager(Context context) {
        this.context = context;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String Name, String Subject) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.NAME, Name);
        contentValues.put(DBHelper.SUBJECT, Subject);
        database.insert(DBHelper.TABLENAME, null, contentValues);
    }

    public Cursor fetch() {
        String[] colums = new String[]{DBHelper._ID, DBHelper.NAME, DBHelper.SUBJECT};
        Cursor cursor = database.query(DBHelper.TABLENAME, colums, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String subject) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.NAME, name);
        contentValues.put(DBHelper.SUBJECT, subject);
        int i = database.update(DBHelper.TABLENAME, contentValues, DBHelper._ID + "=" + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DBHelper.TABLENAME, DBHelper._ID + "=" + _id, null);
    }
}
