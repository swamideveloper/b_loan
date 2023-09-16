package com.gopal.fast.vid.NewImplement.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.gopal.fast.vid.NewImplement.MyApplicationClass;
import com.gopal.fast.vid.R;
import com.gopal.fast.vid.NewImplement.Utils;
import com.gopal.fast.vid.NewImplement.model.InstantLoan;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

public class InstantLoan_Activity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout instant1, instant2, instant3, instant4, instant5, instant6, instant7, instant8, instant9, instant10, instant11, instant12;
    ImageView backImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instant_loan);

        InterEvent.inter(this);
        NativeAds.banner(this, findViewById(R.id.adsContainer));


        backImageView = findViewById(R.id.backImageView);
        instant1 = findViewById(R.id.instant1);
        instant2 = findViewById(R.id.instant2);
        instant3 = findViewById(R.id.instant3);
        instant4 = findViewById(R.id.instant4);
        instant5 = findViewById(R.id.instant5);
        instant6 = findViewById(R.id.instant6);
        instant7 = findViewById(R.id.instant7);
        instant8 = findViewById(R.id.instant8);
        instant9 = findViewById(R.id.instant9);
        instant10 = findViewById(R.id.instant10);
        instant11 = findViewById(R.id.instant11);
        instant12 = findViewById(R.id.instant12);

        instant1.setOnClickListener(this);
        instant2.setOnClickListener(this);
        instant3.setOnClickListener(this);
        instant4.setOnClickListener(this);
        instant5.setOnClickListener(this);
        instant6.setOnClickListener(this);
        instant7.setOnClickListener(this);
        instant8.setOnClickListener(this);
        instant9.setOnClickListener(this);
        instant10.setOnClickListener(this);
        instant11.setOnClickListener(this);
        instant12.setOnClickListener(this);

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.instant1:
                Log.e("JKHdi", "onClick: 111");
                Utils.gclick++;
                MyApplicationClass.instantLoan = InstantLoan.instan1;
                click(1);
                return;
            case R.id.instant2:
                Log.e("JKHdi", "onClick: 222");
                Utils.gclick++;
                MyApplicationClass.instantLoan = InstantLoan.instan2;
                click(2);
                return;
            case R.id.instant3:
                Log.e("JKHdi", "onClick: 33");
                Utils.gclick++;
                MyApplicationClass.instantLoan = InstantLoan.instan3;
                click(3);
                return;
            case R.id.instant4:
                Utils.gclick++;
                MyApplicationClass.instantLoan = InstantLoan.instan4;
                click(4);
                return;
            case R.id.instant5:
                Utils.gclick++;
                MyApplicationClass.instantLoan = InstantLoan.instan5;
                click(5);
                return;
            case R.id.instant6:
                Utils.gclick++;
                MyApplicationClass.instantLoan = InstantLoan.instan6;
                click(6);
                return;
            case R.id.instant7:
                Utils.gclick++;
                MyApplicationClass.instantLoan = InstantLoan.instan7;
                click(7);
                return;
            case R.id.instant8:
                Utils.gclick++;
                MyApplicationClass.instantLoan = InstantLoan.instan8;
                click(8);
                return;
            case R.id.instant9:
                Utils.gclick++;
                MyApplicationClass.instantLoan = InstantLoan.instan9;
                click(9);
                return;
            case R.id.instant10:
                Utils.gclick++;
                MyApplicationClass.instantLoan = InstantLoan.instan10;
                click(10);
                return;
            case R.id.instant11:
                Utils.gclick++;
                MyApplicationClass.instantLoan = InstantLoan.instan11;
                click(11);
                return;
            case R.id.instant12:
                Utils.gclick++;
                MyApplicationClass.instantLoan = InstantLoan.instan12;
                click(12);
                return;
        }
    }

    public void click(int i) {
        if (i == 1) {
            startActivity(new Intent(this, Instant_Details_Activity.class));
        } else if (i == 2) {
            startActivity(new Intent(this, Instant_Details_Activity.class));
        } else if (i == 3) {
            startActivity(new Intent(this, Instant_Details_Activity.class));
        } else if (i == 4) {
            startActivity(new Intent(this, Instant_Details_Activity.class));
        } else if (i == 5) {
            startActivity(new Intent(this, Instant_Details_Activity.class));
        } else if (i == 6) {
            startActivity(new Intent(this, Instant_Details_Activity.class));
        } else if (i == 7) {
            startActivity(new Intent(this, Instant_Details_Activity.class));
        } else if (i == 8) {
            startActivity(new Intent(this, Instant_Details_Activity.class));
        } else if (i == 9) {
            startActivity(new Intent(this, Instant_Details_Activity.class));
        } else if (i == 10) {
            startActivity(new Intent(this, Instant_Details_Activity.class));
        } else if (i == 11) {
            startActivity(new Intent(this, Instant_Details_Activity.class));
        } else if (i == 12) {
            startActivity(new Intent(this, Instant_Details_Activity.class));
        }

    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }

}