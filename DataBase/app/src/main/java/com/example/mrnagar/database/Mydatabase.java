package com.example.mrnagar.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mr.Nagar on 22-08-2017.
 */
public class Mydatabase extends SQLiteOpenHelper {
    String Datab_Name="MyDataBase";
    String Table_Name="General";
    String Col_1="No";
    String Col_2="Name";

    public Mydatabase(Context context) {
        super(context,"MyDatabase", null,1);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+Table_Name+"(NO INTEGER,NAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS"+Table_Name);
    }

    public void inserData(int no,String name){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Col_1,no);
        cv.put(Col_2,name);
        db.insert(Table_Name,null,cv);
    }

    public void updateData(int no,String name){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Col_1,no);
        cv.put(Col_2,name);
        db.update(Table_Name,cv,"NO =?",new String[]{String.valueOf(no)});
    }

    public void deleteData(int no){
        SQLiteDatabase db=getWritableDatabase();
        db.delete(Table_Name,"NO =?",new String[]{String.valueOf(no)});
    }
    public Cursor getData(){
        SQLiteDatabase db=getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM "+Table_Name,null);
        return res;
    }
}
