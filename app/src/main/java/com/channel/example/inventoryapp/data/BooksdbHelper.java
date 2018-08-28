package com.channel.example.inventoryapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.channel.example.inventoryapp.data.BooksContract.booksEnter;

public class BooksdbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_Name="Books.db";

    public BooksdbHelper(Context context) {
        super(context, DATABASE_Name, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_Create_Books_TABLE=    "CREATE TABLE "+ booksEnter.TABLE_NAME +"("+booksEnter.COLUMN_PRODUCTNAME+" TEXT NOT NULL,"+booksEnter.COLUMN_PRICE+" INTEGER," +
                booksEnter.COLUMN_QUANTITY+" INTEGER NOT NULL,"+booksEnter.COLUMN_SUPPLIERNAME+" TEXT NOT NULL,"+ booksEnter.COLUMN_SUPPLIERPHONENUMBER+" TEXT NOT NULL);";
        sqLiteDatabase.execSQL(SQL_Create_Books_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
