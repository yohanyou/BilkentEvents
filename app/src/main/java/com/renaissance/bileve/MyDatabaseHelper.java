package com.renaissance.bileve;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME="EventStore.db";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="my_store";
    private static final String COLUMN_ID="_id";
    private static final String COLUMN_TITLE= "event_title";
    private static final String COLUMN_LANGUAGE="event_language";
    private static final String COLUMN_LOCATION="event_location";
    private static final String COLUMN_DATE="event_date";


    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE " + TABLE_NAME +
            " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_LANGUAGE + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_LOCATION + " TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
    void addEvent(String title, String language, String date, String location){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_LANGUAGE, language);
        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_LOCATION, location);
        long result = db.insert(TABLE_NAME, null, cv );
        if(result==-1){
            Toast.makeText(context, "Failed",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Added Successfully",Toast.LENGTH_SHORT).show();
        }
    }
    Cursor readAllData(){
       String query= "SELECT * FROM " + TABLE_NAME ;
       SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = null;
       if(db != null){
           cursor= db.rawQuery(query, null);
       }
       return cursor;
    }
}
