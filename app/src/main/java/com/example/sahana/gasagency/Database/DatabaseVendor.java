package com.example.sahana.gasagency.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseVendor extends SQLiteOpenHelper {

    public static final String databasename="Vendor";

    public static final String User_table="User_table";
    public static final int versioncode=1;

    public static final String User_name="Name";
    public static final String User_Email_ID="Email";
    public static final String User_Password="Password";
    public static final String User_Phone_number="Phone";

    public DatabaseVendor(Context context){
        super(
                context,
                databasename,
                null,
                versioncode);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        String user_query;
        user_query="CREATE TABLE IF NOT EXISTS "+User_table+"(Name TEXT,Email TEXT PRIMARY KEY,Password TEXT,Phone TEXT)";
        database.execSQL(user_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String user_query;
        user_query = "DROP TABLE IF EXISTS " + User_table;
                db.execSQL(user_query);

    }

    public boolean User_Data(String name,String email,String password,String mobile){
        SQLiteDatabase db1=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(User_name,name);
        cv.put(User_Email_ID,email);
        cv.put(User_Password,password);
        cv.put(User_Phone_number,mobile);
        long result=db1.insert(User_table,null,cv);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Boolean updatevendor(String name,String email,String password,String mobile){

        ContentValues cv= new ContentValues();
        cv.put(User_name,name);
        cv.put(User_Email_ID,email);
        cv.put(User_Password,password);
        cv.put(User_Phone_number,mobile);


        SQLiteDatabase db2 = this.getWritableDatabase();
        int res = db2.update(User_table,cv,User_name + "=?",new String[]{name});
        return res>0;

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

    public Boolean emailpassword(String email,String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from User_table where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0)

            return true;
        else
            return false;
    }
}
