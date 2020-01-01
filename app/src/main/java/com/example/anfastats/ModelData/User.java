package com.example.anfastats.ModelData;

public class User {

private String contact;
private String password;
private int userid;
private String name;
private int error;

    public User(String contact, String password, int userid, String name, int error) {
        this.contact = contact;
        this.password = password;
        this.userid = userid;
        this.name = name;
        this.error = error;
    }


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }
}

