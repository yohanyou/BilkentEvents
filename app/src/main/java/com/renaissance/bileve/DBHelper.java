package com.renaissance.bileve;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final  String DBNAME="login.db";
    public DBHelper(Context context) {
        super(context, "login.db", null, 1);
    } // initiliazing the name

    // creating local database for keeping id and password of the user
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(bilkentID TEXT primary key, password TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }

    // by using the methods we are putting the data in the tables of the local database
    public Boolean insertData(String bilkentID, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("bilkentID",bilkentID);
        values.put("password",password);

        long result = db.insert("users", null,values);
        if (result==-1) return false;
        else
            return true;

    }

    /**
     * Checking the if correct or not by using inner SQL methods
     * @param bilkentID
     * @return
     */
    public Boolean checkbilkentID(String bilkentID){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where bilkentID=?", new String[] {bilkentID});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    /**
     * Updating the password by getting ID and password. We update the location and return true if updated correctly
     * @param bilkentID
     * @param password
     * @return
     */
    public Boolean updatepassword(String bilkentID, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("password",password);
        long result = db.update("users",values, "bilkentID =?", new String[] {bilkentID} );
        if (result==-1) return false;
        else
            return true;

    }

    /**
     * Checking whether the our id and password matches to the information in the database
     * @param bilkentID
     * @param password
     * @return
     */
    public Boolean checkbilkentIDpassword(String bilkentID, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where bilkentID=? and password=?", new String[] {bilkentID, password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
