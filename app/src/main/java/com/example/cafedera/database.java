package com.example.cafedera;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    private static final String dbname="signup.db";

    public database(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String q = "create table staff (_id integer primary key autoincrement ,name text , email text , password text )";
        sqLiteDatabase.execSQL(q);

    }

    public boolean insert_data(String name , String email , String password){
        SQLiteDatabase db = this .getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("name" , name);
        c.put("email" , email);
        c.put("password" , password);

        long r = db.insert("staff" , null , c);
        if(r == -1){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists staff");
        onCreate(sqLiteDatabase);
    }

    // to retrieve data from database
    public Cursor getinfo()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from staff",null);
        return cursor;
    }
}
