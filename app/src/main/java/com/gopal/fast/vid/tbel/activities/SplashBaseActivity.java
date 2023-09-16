package com.gopal.fast.vid.tbel.activities;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class SplashBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public abstract void moveToNext();

    public SharedPreferences getPrefs() {
        return null;
    }

    @Override
    public void onBackPressed() {

    }

}
