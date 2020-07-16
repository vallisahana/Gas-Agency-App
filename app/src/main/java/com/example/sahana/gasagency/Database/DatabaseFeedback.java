package com.example.sahana.gasagency.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseFeedback extends SQLiteOpenHelper {

    public static final String databasename="feedback";

    public static final String User_table="User_table";
    public static final int versioncode=1;

    public static final String User_name="Name";
    public static final String User_Email_ID="Email";


    public DatabaseFeedback(Context context){
        super(
                context,
                databasename,
                null,
                versioncode);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        String user_query;
        user_query="CREATE TABLE IF NOT EXISTS "+User_table+"(Name TEXT,Email TEXT PRIMARY KEY)";
        database.execSQL(user_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String user_query;
        user_query = "DROP TABLE IF EXISTS " + User_table;
                db.execSQL(user_query);

    }

    public boolean User_Data(String name,String email){
        SQLiteDatabase db1=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(User_name,name);
        cv.put(User_Email_ID,email);

        long result=db1.insert(User_table,null,cv);
        if(result==-1)
            return false;
        else
            return true;
    }


    public Cursor UserData()
    {
        SQLiteDatabase db1=this.getWritableDatabase();
        Cursor res = db1.rawQuery("select * from "+User_table,null);
        return res;
    }

    public Cursor searchClient(String name) {
        SQLiteDatabase db2 = this.getWritableDatabase();
        Cursor res = db2.rawQuery("select * from "+User_table+" Where name=?",new String[]{name});
        return res;
    }

    public Cursor DeleteClient(String name) {
        SQLiteDatabase db2 = this.getWritableDatabase();
        Cursor res = db2.rawQuery("delete from "+User_table+" Where name=?",new String[]{name});
        return res;
    }


}
