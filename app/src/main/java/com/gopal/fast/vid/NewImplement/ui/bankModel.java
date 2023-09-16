package com.gopal.fast.vid.NewImplement.ui;

public class bankModel {
    String bankBalance;
    String bankCustomerCare;
    String bankName;
    String bankStatement;
    int id;

    public int getid() {
        return this.id;
    }

    public bankModel(int id, String bankName, String bankBalance, String bankStatement, String bankCustomerCare) {
        this.bankName = bankName;
        this.bankBalance = bankBalance;
        this.bankStatement = bankStatement;
        this.bankCustomerCare = bankCustomerCare;
        this.id = id;
    }

    public String getbankStatement() {
        return this.bankStatement;
    }

    public String getbankName() {
        return this.bankName;
    }

    public String getbankBalance() {
        return this.bankBalance;
    }

    public String getbankCustomerCare() {
        return this.bankCustomerCare;
    }
}
