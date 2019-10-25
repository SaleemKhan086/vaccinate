package com.example.vaccinate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class children_db extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "children_db.db";
    public static final int DATABASE_VERSION = 1;
    public SQLiteDatabase db;
    public children_db(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    public static final String TABLE_NAME = "Children";
    public static final String COLUMN_AADHAR = "Aadhar";
    public static final String COLUMN_FIRST_NAME = "FirstName";
    public static final String COLUMN_LAST_NAME = "LastName";
    public static final String COLUMN_DOB = "DOB";
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TABLE_NAME+"("+COLUMN_AADHAR+" VARCHAR PRIMARY KEY, "+COLUMN_FIRST_NAME+" VARCHAR, "+COLUMN_LAST_NAME+"VARCHAR,"+COLUMN_DOB+"DATE);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
