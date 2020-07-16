package com.example.sahana.gasagency.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;

public class DatabaseBooking extends SQLiteOpenHelper implements Serializable {

    public static final String databasename="userbooking";


    public static final int versioncode=1;

    public static final String Book_table="Book_table";

    public static final String User_id="id";
    public static final String User_date="Date";
    public static final String User_time="Time";
    public static final String User_address="address";
    public static final String User_price="price";
    public static final String User_phone="phone";
    public static final String User_radio="radio";


    public DatabaseBooking(Context context){
        super(
                context,
                databasename,
                null,
                versioncode);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {

        String book_query;
        book_query="CREATE TABLE IF NOT EXISTS "+Book_table+"(id TEXT,Date TEXT,Time TEXT PRIMARY KEY,address TEXT,price TEXT,phone TEXT,radio TEXT)";
        database.execSQL(book_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String book_query;
        book_query = "DROP TABLE IF EXISTS " + Book_table;
        db.execSQL(book_query);


    }

    public boolean Book_Data(String id,String date,String time ,String address,String price,String phone,String radio){
        SQLiteDatabase db1=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(User_id,id);
        cv.put(User_date,date);
        cv.put(User_time,time);
        cv.put(User_address,address);
        cv.put(User_price,price);
        cv.put(User_phone,phone);
        cv.put(User_radio,radio);
        long result=db1.insert(Book_table,null,cv);
        if(result==-1)
            return false;
        else
            return true;
    }


    public Cursor DeleteClient(String id) {
        SQLiteDatabase db2 = this.getWritableDatabase();
        Cursor res = db2.rawQuery("delete from "+Book_table+" Where id=?",new String[]{id});
        return res;
    }
    public Cursor BookData()
    {
        SQLiteDatabase db1=this.getWritableDatabase();
        Cursor res = db1.rawQuery("select * from "+Book_table,null);
        return res;
    }



}
