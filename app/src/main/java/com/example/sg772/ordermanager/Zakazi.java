package com.example.sg772.ordermanager;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity (tableName = "orders")
public class Zakazi {
    @PrimaryKey (autoGenerate = true )

    private int id;

    private String ClName;

    private String Order;

    private String date;

    private int pricec;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClName() {
        return ClName;
    }

    public void setClName(String clName) {
        ClName = clName;
    }

    public String getOrder() {
        return Order;
    }

    public void setOrder(String order) {
        Order = order;
    }

    public int getPricec() {
        return pricec;
    }

    public void setPricec(int pricec) {
        this.pricec = pricec;
    }


}
