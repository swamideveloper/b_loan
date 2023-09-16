package com.gopal.fast.vid.NewImplement;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.gopal.fast.vid.ads.AdsController;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.gopal.fast.vid.NewImplement.model.AdharGuide;
import com.gopal.fast.vid.NewImplement.model.EPFService;
import com.gopal.fast.vid.NewImplement.model.InstantLoan;
import com.gopal.fast.vid.NewImplement.model.LoanGuide;
import com.gopal.fast.vid.NewImplement.model.LoanType;
import com.gopal.fast.vid.NewImplement.model.PanGuide;

public class MyApplicationClass extends AdsController {

    public static MyApplicationClass MyApplicationClass;
    public static final String TAG = "MyApplicationClass";
    public static Context context = null;
    public static boolean isDownloaded = false;
    public static LoanType loanType;
    public static LoanGuide loanGuide;
    public static AdharGuide adharGuide;
    public static PanGuide panGuide;
    public static InstantLoan instantLoan;
    public static EPFService epfService;
    public Activity activity;
    public int width = 720;

    public void onCreate() {
        super.onCreate();
        MyApplicationClass = this;
        context = getApplicationContext();
        MyApplicationClass = this;
        Fresco.initialize(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

    }

    public static synchronized MyApplicationClass getInstance() {
        return MyApplicationClass;
    }

    public static Context getContext() {
        return context;
    }

}
