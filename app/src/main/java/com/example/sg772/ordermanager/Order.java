package com.example.sg772.ordermanager;

import java.util.Date;

public class Order {
    private int orderId;
    private Date orderDate;
    private String clientsName;
    private int price;
    private String city;
    private String order;
    private String status;
    public Order(){
        orderDate=new Date();
        orderDate.getTime();
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setClientsName(String clientsName) {
        this.clientsName = clientsName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getClientsName() {
        return clientsName;
    }

    public int getPrice() {
        return price;
    }

    public String getCity() {
        return city;
    }

    public String getOrder() {
        return order;
    }

    public String getStatus() {
        return status;
    }
}
