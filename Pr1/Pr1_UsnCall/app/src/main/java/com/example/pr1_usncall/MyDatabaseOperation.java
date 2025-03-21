package com.example.pr1_usncall;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseOperation extends SQLiteOpenHelper {
    public MyDatabaseOperation(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE StudentInfo(USN TEXT PRIMARY KEY, PHONE TEXT, SEM INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean data_insertion(String susn,String sphone,int ssem ){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("USN",susn);
        cv.put("PHONE",sphone);
        cv.put("SEM",ssem);
        long res=database.insert("StudentInfo",null,cv);
        if(res==-1){
            return false;
        }else{
            return true;
        }
    }

    public String getPhoneNumber(String ssusn){
        String phoneNumber=null;
        SQLiteDatabase database=getReadableDatabase();
        String query="SELECT PHONE FROM StudentInfo WHERE USN=?";
        Cursor cursor= database.rawQuery(query,new String[]{ssusn});

        if(cursor.moveToFirst()){
            phoneNumber=cursor.getString(0);
        }
        return phoneNumber;
    }


}
