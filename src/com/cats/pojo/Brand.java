package com.cats.pojo;

public class Brand {
    private int id;
    private String name;
    private String pwd;
    private String money;

    public Brand() {
    }

    public Brand(int id, String name, String pwd, String money) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
