package com.example.sahana.gasagency.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseExtra extends SQLiteOpenHelper {

    public static final String databasename="Extradb";

    public static final String Extra_table="Extra_table";
    public static final int versioncode=1;

    public static final String User_name="Name";
    public static final String User_Email_ID="Email";
    public static final String User_Password="Password";



    public DatabaseExtra(Context context){
        super(
                context,
                databasename,
                null,
                versioncode);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String user_query;
        user_query="CREATE TABLE IF NOT EXISTS "+Extra_table+"(Name TEXT,Email TEXT PRIMARY KEY,Password TEXT)";
        database.execSQL(user_query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String user_query;
        user_query = "DROP TABLE IF EXISTS " + Extra_table;
                db.execSQL(user_query);


    }
    public boolean User_Data(String name,String email,String password){
        SQLiteDatabase db1=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(User_name,name);
        cv.put(User_Email_ID,email);
        cv.put(User_Password,password);
        long result=db1.insert(Extra_table,null,cv);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Cursor extraData()
    {
        SQLiteDatabase db1=this.getWritableDatabase();
        Cursor res = db1.rawQuery("select * from "+Extra_table,null);
        return res;
    }

}
