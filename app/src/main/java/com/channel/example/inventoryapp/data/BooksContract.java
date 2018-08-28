package com.channel.example.inventoryapp.data;

import android.provider.BaseColumns;

public final class BooksContract   {
    public abstract  static class booksEnter implements BaseColumns {
        public static final String TABLE_NAME="books";
        public static final String COLUMN_ID=BaseColumns._ID;
        public static final String COLUMN_PRODUCTNAME="ProductName";
        public static final String COLUMN_PRICE="Price";
        public static final String COLUMN_QUANTITY="Quantity";
        public static final String COLUMN_SUPPLIERNAME="SupplierName";
        public static final String COLUMN_SUPPLIERPHONENUMBER="SupplierPhoneNumber";


    }
}
