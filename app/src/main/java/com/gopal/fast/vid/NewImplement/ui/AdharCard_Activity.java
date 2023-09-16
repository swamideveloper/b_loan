package com.gopal.fast.vid.NewImplement.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.gopal.fast.vid.NewImplement.MyApplicationClass;
import com.gopal.fast.vid.NewImplement.Utils;
import com.gopal.fast.vid.NewImplement.model.AdharGuide;
import com.gopal.fast.vid.R;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

public class AdharCard_Activity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout aadhar1, aadhar2, aadhar3, aadhar4, aadhar5, aadhar6, aadhar7, aadhar8, aadhar9, aadhar10, aadhar11, aadhar12, aadhar13, aadhar14;
    ImageView backImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adhar_card);

        InterEvent.inter(this);
        NativeAds.banner(this,findViewById(R.id.adsContainer));


        backImageView = findViewById(R.id.backImageView);
        aadhar1 = findViewById(R.id.aadhar1);
        aadhar2 = findViewById(R.id.aadhar2);
        aadhar3 = findViewById(R.id.aadhar3);
        aadhar4 = findViewById(R.id.aadhar4);
        aadhar5 = findViewById(R.id.aadhar5);
        aadhar6 = findViewById(R.id.aadhar6);
        aadhar7 = findViewById(R.id.aadhar7);
        aadhar8 = findViewById(R.id.aadhar8);
        aadhar9 = findViewById(R.id.aadhar9);
        aadhar10 = findViewById(R.id.aadhar10);
        aadhar11 = findViewById(R.id.aadhar11);
        aadhar12 = findViewById(R.id.aadhar12);
        aadhar13 = findViewById(R.id.aadhar13);
        aadhar14 = findViewById(R.id.aadhar14);

        aadhar1.setOnClickListener(this);
        aadhar2.setOnClickListener(this);
        aadhar3.setOnClickListener(this);
        aadhar4.setOnClickListener(this);
        aadhar5.setOnClickListener(this);
        aadhar6.setOnClickListener(this);
        aadhar7.setOnClickListener(this);
        aadhar8.setOnClickListener(this);
        aadhar9.setOnClickListener(this);
        aadhar10.setOnClickListener(this);
        aadhar11.setOnClickListener(this);
        aadhar12.setOnClickListener(this);
        aadhar13.setOnClickListener(this);
        aadhar14.setOnClickListener(this);

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.aadhar1:
                Log.e("JKHdi", "onClick: 111");
                Utils.gclick++;
                MyApplicationClass.adharGuide = AdharGuide.adharguide1;
                click(1);
                return;
            case R.id.aadhar2:
                Log.e("JKHdi", "onClick: 222");
                Utils.gclick++;
                MyApplicationClass.adharGuide = AdharGuide.adharguide2;
                click(2);
                return;
            case R.id.aadhar3:
                Log.e("JKHdi", "onClick: 33");
                Utils.gclick++;
                MyApplicationClass.adharGuide = AdharGuide.adharguide3;
                click(3);
                return;
            case R.id.aadhar4:
                Utils.gclick++;
                MyApplicationClass.adharGuide = AdharGuide.adharguide4;
                click(4);
                return;
            case R.id.aadhar5:
                Utils.gclick++;
                MyApplicationClass.adharGuide = AdharGuide.adharguide5;
                click(5);
                return;
            case R.id.aadhar6:
                Utils.gclick++;
                MyApplicationClass.adharGuide = AdharGuide.adharguide6;
                click(6);
                return;
            case R.id.aadhar7:
                Utils.gclick++;
                MyApplicationClass.adharGuide = AdharGuide.adharguide7;
                click(7);
                return;
            case R.id.aadhar8:
                Utils.gclick++;
                MyApplicationClass.adharGuide = AdharGuide.adharguide8;
                click(8);
                return;
            case R.id.aadhar9:
                Utils.gclick++;
                MyApplicationClass.adharGuide = AdharGuide.adharguide9;
                click(9);
                return;
            case R.id.aadhar10:
                Utils.gclick++;
                MyApplicationClass.adharGuide = AdharGuide.adharguide10;
                click(10);
                return;
            case R.id.aadhar11:
                Utils.gclick++;
                MyApplicationClass.adharGuide = AdharGuide.adharguide11;
                click(11);
                return;
            case R.id.aadhar12:
                Utils.gclick++;
                MyApplicationClass.adharGuide = AdharGuide.adharguide12;
                click(12);
                return;
            case R.id.aadhar13:
                Utils.gclick++;
                MyApplicationClass.adharGuide = AdharGuide.adharguide13;
                click(13);
                return;
            case R.id.aadhar14:
                Utils.gclick++;
                MyApplicationClass.adharGuide = AdharGuide.adharguide14;
                click(14);
                return;
        }
    }

    public void click(int i) {
        if (i == 1) {
            startActivity(new Intent(this, AdharGuide_Details_Activity.class));
        } else if (i == 2) {
            startActivity(new Intent(this, AdharGuide_Details_Activity.class));
        } else if (i == 3) {
            startActivity(new Intent(this, AdharGuide_Details_Activity.class));
        } else if (i == 4) {
            startActivity(new Intent(this, AdharGuide_Details_Activity.class));
        } else if (i == 5) {
            startActivity(new Intent(this, AdharGuide_Details_Activity.class));
        } else if (i == 6) {
            startActivity(new Intent(this, AdharGuide_Details_Activity.class));
        } else if (i == 7) {
            startActivity(new Intent(this, AdharGuide_Details_Activity.class));
        } else if (i == 8) {
            startActivity(new Intent(this, AdharGuide_Details_Activity.class));
        } else if (i == 9) {
            startActivity(new Intent(this, AdharGuide_Details_Activity.class));
        } else if (i == 10) {
            startActivity(new Intent(this, AdharGuide_Details_Activity.class));
        } else if (i == 11) {
            startActivity(new Intent(this, AdharGuide_Details_Activity.class));
        } else if (i == 12) {
            startActivity(new Intent(this, AdharGuide_Details_Activity.class));
        } else if (i == 13) {
            startActivity(new Intent(this, AdharGuide_Details_Activity.class));
        } else if (i == 14) {
            startActivity(new Intent(this, AdharGuide_Details_Activity.class));
        }

    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }

}