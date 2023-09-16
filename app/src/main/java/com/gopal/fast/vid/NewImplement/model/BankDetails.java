package com.gopal.fast.vid.NewImplement.model;

public class BankDetails {
    int image;
    String title;
    String name;
    String number;

    public BankDetails(int i, String title, String str, String str2) {
        this.image = i;
        this.title = title;
        this.name = str;
        this.number = str2;
    }

    public int getImage() {
        return this.image;
    }

    public void setImage(int i) {
        this.image = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String str) {
        this.number = str;
    }
}
