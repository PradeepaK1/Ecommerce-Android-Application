package com.example.ptljdf;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

class DBlistHelper extends SQLiteOpenHelper {


    private static final String DATABASE_PATH = "";
    private static final String DATABASE_NAME = "crop1.db";
    private static final int SCHEMA_VERSION = 1;
    private static final String TABLE_NAME = "crop2";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    public static final String COLUMN_GUIDE = "guide";



    public SQLiteDatabase dbSqlite;

    private final Context myContext;

    public DBlistHelper(Context context){
        super(context, DATABASE_NAME, null, SCHEMA_VERSION );
        this.myContext= context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createDatabase() {

        createDB();

    }

    public void createDB(){

        boolean dbExist = DBExists();

        if(!dbExist){

            this.getReadableDatabase();

            copyDBFromResource();

        }

    }



    private boolean DBExists() {

        SQLiteDatabase db = null;

        try{
            String databasePath = DATABASE_PATH + DATABASE_NAME;
            db = SQLiteDatabase.openDatabase(databasePath, null, SQLiteDatabase.OPEN_READWRITE);
            db.setLocale(Locale.getDefault());
            db.setLockingEnabled(true);
            db.setVersion(1);

        } catch (SQLiteException e) {

            Log.e("SqlHelper", "database not found");
        }

        if (db != null){

            db.close();
        }

        return db != null ? true : false;

    }



    private void copyDBFromResource(){

        InputStream inputStream = null;
        OutputStream outStream = null;
        String dbFilePath =  DATABASE_PATH + DATABASE_NAME;

        try{

            inputStream = myContext.getAssets().open(DATABASE_NAME);

            outStream = new FileOutputStream(dbFilePath);

            byte [] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0){
                outStream.write(buffer, 0, length);

            }

            outStream.flush();
            outStream.close();
            inputStream.close();

        } catch (IOException e){

            throw new Error("Problem copying database from resource file.");
        }

    }


    public void openDatabase () throws SQLException {

        String myPath = DATABASE_PATH + DATABASE_NAME;
        dbSqlite = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);

    }

    @Override
    public synchronized void close () {

        if (dbSqlite !=null){

            dbSqlite.close();
        }

        super.close();

    }

    public Cursor getCursor() {

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder ();

        queryBuilder.setTables(TABLE_NAME);

        String [] asColumnsToReturn = new String [] { COLUMN_ID, COLUMN_NAME, COLUMN_GUIDE};

        Cursor mCursor = queryBuilder.query(dbSqlite, asColumnsToReturn, null, null, null, null, "Recipe ASC");

        return mCursor;
    }

    public String getName (Cursor c){
        return(c.getString(1));


    }

}