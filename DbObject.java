package com.example.ptljdf;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbObject {

    private static Crop2Database dbHelper;
    private SQLiteDatabase db;

    public DbObject(Context context) {
        dbHelper = new Crop2Database(context);
        this.db = dbHelper.getReadableDatabase();
    }

    public SQLiteDatabase getDbConnection(){
        return this.db;
    }

    public void closeDbConnection(){
        if(this.db != null){
            this.db.close();
        }
    }
}


