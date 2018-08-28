package com.channel.example.inventoryapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.channel.example.inventoryapp.data.BooksContract.booksEnter;


import com.channel.example.inventoryapp.data.BooksdbHelper;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayDatabaseInfo();


    }


    private void displayDatabaseInfo() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        BooksdbHelper mDbHelper = new BooksdbHelper(this);


        // Create and/or open a database to read from it
        SQLiteDatabase sqLiteDatabase = mDbHelper.getReadableDatabase();


        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.
        String[] projection = {booksEnter.COLUMN_PRODUCTNAME, booksEnter.COLUMN_PRICE, booksEnter.COLUMN_QUANTITY, booksEnter.COLUMN_SUPPLIERNAME, booksEnter.COLUMN_SUPPLIERPHONENUMBER};
        TextView displayView = (TextView) findViewById(R.id.Showinfo);
        Cursor cursor = sqLiteDatabase.query(booksEnter.TABLE_NAME, projection, null, null, null, null, null);
        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // pets table in the database).
            displayView.setText("The Books table contains " + cursor.getCount() + " Books.\n\n");
            displayView.append(booksEnter.COLUMN_PRODUCTNAME + " - " + booksEnter.COLUMN_PRICE + " - " + booksEnter.COLUMN_QUANTITY + " - " + booksEnter.COLUMN_SUPPLIERNAME + " - " + booksEnter.COLUMN_SUPPLIERPHONENUMBER );

            // Figure out the index of each column
            int ProductNameColumnIndex = cursor.getColumnIndex(booksEnter.COLUMN_PRODUCTNAME);
            int PriceColumnIndex = cursor.getColumnIndex(booksEnter.COLUMN_PRICE);
            int QuantityColumnIndex = cursor.getColumnIndex(booksEnter.COLUMN_QUANTITY);
            int SupplierNameColumnIndex = cursor.getColumnIndex(booksEnter.COLUMN_SUPPLIERNAME);
            int SupplierPhoneNumberColumnIndex = cursor.getColumnIndex(booksEnter.COLUMN_SUPPLIERPHONENUMBER);

            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                String currentProductName = cursor.getString(ProductNameColumnIndex);
                int currentPrice = cursor.getInt(PriceColumnIndex);
                int currentQuantity = cursor.getInt(QuantityColumnIndex);
                String currentSupplierName = cursor.getString(SupplierNameColumnIndex);
                String currentPhoneNumber = cursor.getString(SupplierPhoneNumberColumnIndex);
                // Display the values from each column of the current row in the cursor in the TextView
                displayView.append(("\n" + currentProductName + currentPrice + " - " + currentQuantity + " - " + currentSupplierName + " - " + currentPhoneNumber));
            }

        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.

            cursor.close();


        }
    }

    public   void insertData(View view) {
        BooksdbHelper mDbHelper = new BooksdbHelper(this);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();


// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(booksEnter.COLUMN_PRODUCTNAME, "Iphone");
        values.put(booksEnter.COLUMN_PRICE, 100);
        values.put(booksEnter.COLUMN_QUANTITY, 5);
        values.put(booksEnter.COLUMN_SUPPLIERNAME, "BOB");
        values.put(booksEnter.COLUMN_SUPPLIERPHONENUMBER, "0876785875");

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(booksEnter.TABLE_NAME, null, values);




    }




 /*   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu9
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_insert_dummy_data:
                insertData();
                displayDatabaseInfo();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}

