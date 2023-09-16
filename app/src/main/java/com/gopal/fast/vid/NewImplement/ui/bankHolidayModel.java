package com.gopal.fast.vid.NewImplement.ui;

public class bankHolidayModel {
    String DisplayDate;
    String Month;
    String Occupation;
    String day;
    int id;

    public bankHolidayModel(int id, String month, String displayDate, String occupation, String day) {
        this.id = id;
        this.Month = month;
        this.DisplayDate = displayDate;
        this.Occupation = occupation;
        this.day = day;
    }

    public int getid() {
        return this.id;
    }

    public String getMonth() {
        return this.Month;
    }

    public String getDisplayDate() {
        return this.DisplayDate;
    }

    public String getOccupation() {
        return this.Occupation;
    }

    public String getday() {
        return this.day;
    }
}
