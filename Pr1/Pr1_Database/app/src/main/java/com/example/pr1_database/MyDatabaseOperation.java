package com.example.pr1_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseOperation extends SQLiteOpenHelper {
    public MyDatabaseOperation(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE StudentInfo(USN TEXT PRIMARY KEY, NAME TEXT,SEM INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean data_insertion(String susn,String sname,int ssem){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("Name",sname);
        cv.put("Usn",susn);
        cv.put("Sem",ssem);
        long res=database.insert("StudentInfo",null,cv);
        if(res==-1){
            return false;
        }else{
            return true;
        }
    }

}
