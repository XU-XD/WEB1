package com.dcs.Account.domain;

/**
 * projectName:AccountProject
 * author:dcs
 * time:2021/6/27 14:22
 * description:
 */
public class Account {
    private Integer id;
    private String username;
    private String password;
    private double money;

    public Account() {
    }

    public Account(Integer id, String username, String password, double money) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }
}
