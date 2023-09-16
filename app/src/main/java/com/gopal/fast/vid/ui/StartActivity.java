package com.gopal.fast.vid.ui;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gopal.fast.vid.R;
import com.gopal.fast.vid.SingleClickListener;
import com.gopal.fast.vid.ads.NativeAds;
import com.gopal.fast.vid.privacyPolice;

public class StartActivity extends AppCompatActivity {

    ImageView backImageView;
    ImageView rl_rate;
    ImageView ShareApp;
    ImageView ll_Privacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x_activity_start);


        NativeAds.nativeads(this, findViewById(R.id.adsContainer));

        backImageView = findViewById(R.id.backImageView);
        rl_rate = findViewById(R.id.rl_rate);
        ShareApp = findViewById(R.id.ShareApp);
        ll_Privacy = findViewById(R.id.ll_Privacy);

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        rl_rate.setOnClickListener(new SingleClickListener() {
            @Override
            public void performClick(View v) {
                RateUs(StartActivity.this);
            }
        });

        ShareApp.setOnClickListener(new SingleClickListener() {
            @Override
            public void performClick(View v) {
                ShareApp(StartActivity.this);
            }
        });

        ll_Privacy.setOnClickListener(new SingleClickListener() {
            @Override
            public void performClick(View v) {
                startActivity(new Intent(StartActivity.this, privacyPolice.class));
            }
        });

    }

    public static boolean isNetworkConnected(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public void startNew(View view) {
        startActivity(new Intent(StartActivity.this, MainBankSelectActivity.class));
    }

    public static void ShareApp(Context context) {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            String shareMessage = "\nLet me recommend you this application\n\n";
            String shareMessage1 = "Get Loan On PanCard Guide";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + context.getPackageName() + "\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareMessage1);
            context.startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch (Exception e) {
        }
    }

    public static void RateUs(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        sb.append(context.getPackageName());
        String str = "android.intent.action.VIEW";
        Intent intent = new Intent(str, Uri.parse(sb.toString()));
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("http://play.google.com/store/apps/details?id=");
            sb2.append(context.getPackageName());
            context.startActivity(new Intent(str, Uri.parse(sb2.toString())));
        }
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finishAffinity();
            System.exit(1);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Back again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);

    }

}