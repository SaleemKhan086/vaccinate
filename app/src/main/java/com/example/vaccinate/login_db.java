package com.example.vaccinate;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class login_db extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "database1.db";
    public static final int DATABASE_VERSION = 1;
    public SQLiteDatabase db;
    public login_db(Context context){
        //, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //db = this.getWritableDatabase();

    }

    public static final String TABLE_NAME = "Login";
    public static final String COLUMN_ID = "Email ID";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_AADHAR = "Aadhar";
    public static final String COLUMN_FIRST_NAME = "First Name";
    public static final String COLUMN_LAST_NAME = "Last Name";
    public static final String COLUMN_PHONE = "Phone No";

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String query  = "create table DETAILS (ID INTEGER PRIMARY KEY, FIRST VARCHAR(15), LAST VARCHAR(10), MARKS INTEGER);";
        String query = "create table " + TABLE_NAME + " ( " + COLUMN_ID + " VARCHAR PRIMARY KEY , " + COLUMN_PASSWORD + " VARCHAR ); ";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String email,String pass){
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID",email);
        contentValues.put("PASSWORD",pass);
        long res = db.insert(TABLE_NAME,null,contentValues);

        if(res == -1)
            return false;
        return true;
    }
}
