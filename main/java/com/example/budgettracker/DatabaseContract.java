package com.example.budgettracker;

import android.provider.BaseColumns;


public final class DatabaseContract {

    public DatabaseContract(){}

    public static abstract class budgetEntry implements BaseColumns{
        public static final String TABLE_NAME = "budget";
        public static final String COLUMN_NAME_VALUE = "value";
        public static final String COLUMN_NAME_AREA = "area";


    }
}
