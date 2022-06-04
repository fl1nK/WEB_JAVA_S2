package com.example.demo1.model;

public class Orders {
    private int ID;
    private String userLogin;
    private String device;
    private String date;
    private int price;
    private String masterLogin;
    private String status;

    private String comment;
    public  Orders(){}

    public Orders(String userLogin, int price) {
        this.userLogin = userLogin;
        this.price = price;
    }

    public Orders(String userLogin, String device, String date, int price, String masterLogin, String status) {
        this.userLogin = userLogin;
        this.device = device;
        this.date = date;
        this.price = price;
        this.masterLogin = masterLogin;
        this.status = status;
    }

    public Orders(int ID, String userLogin, String device, String date, int price, String masterLogin, String status, String comment) {
        this.ID = ID;
        this.userLogin = userLogin;
        this.device = device;
        this.date = date;
        this.price = price;
        this.masterLogin = masterLogin;
        this.status = status;
        this.comment = comment;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMasterLogin() {
        return masterLogin;
    }

    public void setMasterLogin(String masterLogin) {
        this.masterLogin = masterLogin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
