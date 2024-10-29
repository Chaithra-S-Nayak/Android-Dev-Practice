package com.example.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import androidx.annotation.Nullable;
public class MyDatabaseOperations extends SQLiteOpenHelper {
    public MyDatabaseOperations(@Nullable Context context, @Nullable String name,
                                @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE StudentInformation(NAME TEXT,USN TEXT PRIMARY KEY,Sem INTEGER,Branch TEXT,PhoneNumber TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    public boolean dataInsert(String s_name,String s_usn,int s_sem, String s_branch,String s_ph_no){
        SQLiteDatabase myDb = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("NAME",s_name);
        cv.put("USN",s_usn);
        cv.put("Sem",s_sem);
        cv.put("Branch",s_branch);
        cv.put("PhoneNumber",s_ph_no);
        long result = myDb.insert("StudentInformation",null,cv);
        if(result == -1)
            return false;
        else
            return  true;
    }
}