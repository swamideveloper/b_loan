package com.gopal.fast.vid.model;

public class BankModel {
    private int iBankDetailsId;
    private String vName;
    private String vLogo;
    private String vBalance;
    private String vStatement;
    private String vCustomerCare;
    private String vLanguage;
    private String NetBanking;
    private String vHeader;
    private int iHeaderNum;
    private int iCategory;
    private String vTag;

    public BankModel(int iBankDetailsId, String vName, String vLogo, String vBalance, String vStatement, String vCustomerCare, String vLanguage, String NetBanking, String vHeader, int iHeaderNum, int iCategory, String vTag) {
        this.iBankDetailsId = iBankDetailsId;
        this.vName = vName;
        this.vLogo = vLogo;
        this.vBalance = vBalance;
        this.vStatement = vStatement;
        this.vCustomerCare = vCustomerCare;
        this.vLanguage = vLanguage;
        this.NetBanking = NetBanking;
        this.vHeader = vHeader;
        this.iHeaderNum = iHeaderNum;
        this.iCategory = iCategory;
        this.vTag = vTag;
    }

    public int getIBankDetailsId() {
        return iBankDetailsId;
    }

    public String getVName() {
        return vName;
    }

    public String getVLogo() {
        return vLogo;
    }

    public String getVBalance() {
        return vBalance;
    }

    public String getVStatement() {
        return vStatement;
    }

    public String getVCustomerCare() {
        return vCustomerCare;
    }

    public String getVLanguage() {
        return vLanguage;
    }

    public String getNetBanking() {
        return NetBanking;
    }

    public String getVHeader() {
        return vHeader;
    }

    public int getIHeaderNum() {
        return iHeaderNum;
    }

    public int getICategory() {
        return iCategory;
    }

    public String getVTag() {
        return vTag;
    }
}
