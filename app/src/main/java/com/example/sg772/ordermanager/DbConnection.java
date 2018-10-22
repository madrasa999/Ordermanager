package com.example.sg772.ordermanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbConnection extends SQLiteOpenHelper {
    public static final int DATABASE_VER=2;
    public static final String D_NAME="Order";
    public static final String TABLE_N="orderlist";
    public static final String NAME="name";
    public static final String PRICE="price";
    public static final String ORDER="order_";


   public DbConnection(Context context){
       super(context,D_NAME,null,DATABASE_VER);
   }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("CREATE TABLE " + TABLE_N + "(" + NAME + " TEXT, " + ORDER + " TEXT, " + PRICE + " NUMBER " + ")"  );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("drop table if exists "+ TABLE_N);
onCreate(db);

    }
}
