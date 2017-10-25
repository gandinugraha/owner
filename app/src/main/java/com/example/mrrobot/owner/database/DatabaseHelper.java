package com.example.mrrobot.owner.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLClientInfoException;

/**
 * Created by Mr Robot on 10/16/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "owner.db";
    public static final String TABLE_NAME = "owner_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "SALON_NAME";
    public static final String COL_3 = "SALON_ADDRESS";
    public static final String COL_4 = "MANAGER_NAME";
    public static final String COL_5 = "EMAIL";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, SALON_NAME TEXT, SALON_ADDRESS TEXT, MANAGER_NAME TEXT, EMAIL TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String salon_name, String salon_address, String manager_name, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,salon_name);
        contentValues.put(COL_3,salon_address);
        contentValues.put(COL_4,manager_name);
        contentValues.put(COL_5,email);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select *from "+ TABLE_NAME, null);
        return res;
    }

    public boolean updateData (String id, String salon_name, String salon_address, String manager_name, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,salon_name);
        contentValues.put(COL_3,salon_address);
        contentValues.put(COL_4,manager_name);
        contentValues.put(COL_5,email);
        db.update(TABLE_NAME,  contentValues, "ID = ?", new String[] {id});
        return true;
    }

    public Integer deleteData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }
}
