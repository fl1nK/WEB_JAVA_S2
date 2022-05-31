package com.example.demo1.model;

public class User {
    private String login;
    private String pass;

    private int money;
    private ROLE role;

    public User(){}

    public User(String login, String pass, int money, ROLE role) {
        this.login = login;
        this.pass = pass;
        this.money = money;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public enum ROLE {
        USER, ADMIN, MASTER, UNKNOWN
    }
}
