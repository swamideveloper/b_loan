package com.gopal.fast.vid.model;

public class ItemModel {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    private String amount;
    private int imageUrl;

    public ItemModel(String name, int imageUrl,String amount) {
        this.name = name;
        this.amount = amount;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getImageUrl() {
        return imageUrl;
    }
}
