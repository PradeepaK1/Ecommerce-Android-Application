package com.example.ptljdf;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class DbBackend extends DbObject{

    public DbBackend(Context context) {
        super(context);
    }

    public String[] crop2Name(){
        String query = "Select * from crop2";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> nameTerms = new ArrayList<String>();
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                nameTerms.add(name);
            }while(cursor.moveToNext());
        }
        cursor.close();
        String[] crop2Name = new String[nameTerms.size()];
        crop2Name = nameTerms.toArray(crop2Name);
        return crop2Name;
    }

    public Crop1Object getCrop1ById(int crop1Id){

        Crop1Object crop1Object = null;
        String query = "select * from crop2 where _id = " + crop1Id;
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String guide = cursor.getString(cursor.getColumnIndexOrThrow("guide"));
                crop1Object = new Crop1Object(name, guide);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return crop1Object;
    }
}
