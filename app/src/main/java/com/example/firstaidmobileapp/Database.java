package com.example.firstaidmobileapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private String name;
    private String email;
    private String number;

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table users(username text, email text, password text)";
        sqLiteDatabase.execSQL(qry1);
        String qry2 = "create table contacts(name text, email text, number text)";
        sqLiteDatabase.execSQL(qry2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void register(String username, String email, String password){
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }
    public int login(String username, String password){
        int result=0;
        String str[]= new String[2];
        str[0]=username;
        str[1]=password;
        SQLiteDatabase db=getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where username=? and password=?",str);
        if(c.moveToFirst()){
            result=1;
        }
        return result;
    }

    public void contacts(String name, String email, String number){
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("email",email);
        cv.put("number",number);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("contacts",null,cv);
        db.close();
    }
}
