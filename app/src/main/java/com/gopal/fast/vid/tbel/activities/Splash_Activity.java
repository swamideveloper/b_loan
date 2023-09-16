package com.gopal.fast.vid.tbel.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gopal.fast.vid.R;
import com.google.android.material.snackbar.Snackbar;

public class Splash_Activity extends AppCompatActivity {

    public static int int_Language = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x_activity_launch);
        if (!isNetworkConnected(this)) {
            Snackbar.make(findViewById(R.id.parent), "Please Connect to the internet...", 9999999).show();
        }

    }


    public SharedPreferences getPrefs() {
        return null;
    }

    private static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}