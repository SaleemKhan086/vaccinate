package com.example.vaccinate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
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
    public static final String COLUMN_ID = "EmailID";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_AADHAR = "Aadhar";
    public static final String COLUMN_FIRST_NAME = "FirstName";
    public static final String COLUMN_LAST_NAME = "LastName";
    public static final String COLUMN_PHONE = "PhoneNo";
    public static final String TABLE_CHILDREN = "Children";
    public static final String COLUMN_DOB = "DOB";
    @Override
    public void onCreate(SQLiteDatabase db) {
        //String query  = "create table "+TABLE_NAME+" (EMAIL VARCHAR PRIMARY KEY, PASSWORD VARCHAR, FIRSTNAME VARCHAR , LASTNAME VARCHAR , AADHAR VARCHAR,PHONE VARCHAR );";
        String query = "create table "+TABLE_NAME+" ( "+COLUMN_ID+" VARCHAR PRIMARY KEY, "+COLUMN_PASSWORD+" VARCHAR, "+COLUMN_AADHAR+" VARCHAR , "+COLUMN_FIRST_NAME+" VARCHAR , "+COLUMN_LAST_NAME+" VARCHAR, "+COLUMN_PHONE+" VARCHAR );";
        db.execSQL(query);
        String query1 = "CREATE TABLE "+TABLE_CHILDREN+"("+COLUMN_AADHAR+" VARCHAR PRIMARY KEY, "+COLUMN_FIRST_NAME+" VARCHAR, "+COLUMN_LAST_NAME+"VARCHAR,"+COLUMN_DOB+"DATE);";
        db.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String email,String pass,String aadhar,String fname,String lname,String phone) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("EmailID", email);
        contentValues.put("Password", pass);
        contentValues.put("Aadhar", aadhar);
        contentValues.put("FirstName", fname);
        contentValues.put("LastName",lname);
        contentValues.put("PhoneNo", phone);
        long res = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if (res == -1)
            return false;
        return true;
    }
    public Cursor readParent(SQLiteDatabase db,String tableName,String [] projection){
        //String [] projection = {COLUMN_ID,COLUMN_PASSWORD,COLUMN_AADHAR,COLUMN_FIRST_NAME,COLUMN_LAST_NAME,COLUMN_PHONE};
        return (db.query(tableName,projection,null,null,null,null,null));
    }


}
