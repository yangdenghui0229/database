package com.ydh;

/**
 * Created by yangdenghui on 2017/11/6.
 */
public class User {
    private long id;

    private String name;

    private String phone;

    private double money;

    private String address;

    public User(){}

    public User(long id, String name, String phone, double money, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.money = money;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
