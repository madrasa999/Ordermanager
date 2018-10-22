package com.example.sg772.ordermanager;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addZakazi(Zakazi zakazi);

    @Query("select * from orders" )
    public List<Zakazi> getZakazi();
    @Delete
    public void deleteZakazi(Zakazi zakaz);
    @Update
    public void updateZakazi(Zakazi zakazi);


}
