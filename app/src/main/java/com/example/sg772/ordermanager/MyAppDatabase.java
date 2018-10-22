package com.example.sg772.ordermanager;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Zakazi.class},version = 3)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract MyDao myDao();

}
