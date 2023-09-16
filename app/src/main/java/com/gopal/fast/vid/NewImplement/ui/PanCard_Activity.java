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
import com.gopal.fast.vid.NewImplement.model.PanGuide;
import com.gopal.fast.vid.R;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

public class PanCard_Activity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout pan1, pan2, pan3, pan4, pan5, pan6, pan7;
    ImageView backImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pan_card);

        InterEvent.inter(this);
        NativeAds.banner(this, findViewById(R.id.adsContainer));


        backImageView = findViewById(R.id.backImageView);
        pan1 = findViewById(R.id.pan1);
        pan2 = findViewById(R.id.pan2);
        pan3 = findViewById(R.id.pan3);
        pan4 = findViewById(R.id.pan4);
        pan5 = findViewById(R.id.pan5);
        pan6 = findViewById(R.id.pan6);
        pan7 = findViewById(R.id.pan7);

        pan1.setOnClickListener(this);
        pan2.setOnClickListener(this);
        pan3.setOnClickListener(this);
        pan4.setOnClickListener(this);
        pan5.setOnClickListener(this);
        pan6.setOnClickListener(this);
        pan7.setOnClickListener(this);

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pan1:
                Log.e("JKHdi", "onClick: 111");
                Utils.gclick++;
                MyApplicationClass.panGuide = PanGuide.panguide1;
                click(1);
                return;
            case R.id.pan2:
                Log.e("JKHdi", "onClick: 222");
                Utils.gclick++;
                MyApplicationClass.panGuide = PanGuide.panguide2;
                click(2);
                return;
            case R.id.pan3:
                Log.e("JKHdi", "onClick: 33");
                Utils.gclick++;
                MyApplicationClass.panGuide = PanGuide.panguide3;
                click(3);
                return;
            case R.id.pan4:
                Utils.gclick++;
                MyApplicationClass.panGuide = PanGuide.panguide4;
                click(4);
                return;
            case R.id.pan5:
                Utils.gclick++;
                MyApplicationClass.panGuide = PanGuide.panguide5;
                click(5);
                return;
            case R.id.pan6:
                Utils.gclick++;
                MyApplicationClass.panGuide = PanGuide.panguide6;
                click(6);
                return;
            case R.id.pan7:
                Utils.gclick++;
                MyApplicationClass.panGuide = PanGuide.panguide7;
                click(7);
                return;
        }
    }

    public void click(int i) {
        if (i == 1) {
            startActivity(new Intent(this, PanGuide_Details_Activity.class));
        } else if (i == 2) {
            startActivity(new Intent(this, PanGuide_Details_Activity.class));
        } else if (i == 3) {
            startActivity(new Intent(this, PanGuide_Details_Activity.class));
        } else if (i == 4) {
            startActivity(new Intent(this, PanGuide_Details_Activity.class));
        } else if (i == 5) {
            startActivity(new Intent(this, PanGuide_Details_Activity.class));
        } else if (i == 6) {
            startActivity(new Intent(this, PanGuide_Details_Activity.class));
        } else if (i == 7) {
            startActivity(new Intent(this, PanGuide_Details_Activity.class));
        }
    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }

}