package com.example.ptljdf;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class Crop2Database  extends SQLiteAssetHelper {

    private static final String DATABASE_NAMES = "crop1";
    private static final int DATABASE_VERSION = 5;

    public Crop2Database(Context context) {
        super(context, DATABASE_NAMES, null, DATABASE_VERSION);
    }

}
