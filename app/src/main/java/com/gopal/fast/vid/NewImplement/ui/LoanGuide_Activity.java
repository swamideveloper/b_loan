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
import com.gopal.fast.vid.NewImplement.model.LoanGuide;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

public class LoanGuide_Activity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout loanguide1, loanguide2, loanguide3, loanguide4, loanguide5, loanguide6, loanguide7, loanguide8, loanguide9, loanguide10, loanguide11, loanguide12;
    ImageView backImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loan_guide);

        InterEvent.inter(this);
        NativeAds.banner(this,findViewById(R.id.adsContainer));


        backImageView = findViewById(R.id.backImageView);
        loanguide1 = findViewById(R.id.loanguide1);
        loanguide2 = findViewById(R.id.loanguide2);
        loanguide3 = findViewById(R.id.loanguide3);
        loanguide4 = findViewById(R.id.loanguide4);
        loanguide5 = findViewById(R.id.loanguide5);
        loanguide6 = findViewById(R.id.loanguide6);
        loanguide7 = findViewById(R.id.loanguide7);
        loanguide8 = findViewById(R.id.loanguide8);
        loanguide9 = findViewById(R.id.loanguide9);
        loanguide10 = findViewById(R.id.loanguide10);
        loanguide11 = findViewById(R.id.loanguide11);
        loanguide12 = findViewById(R.id.loanguide12);

        loanguide1.setOnClickListener(this);
        loanguide2.setOnClickListener(this);
        loanguide3.setOnClickListener(this);
        loanguide4.setOnClickListener(this);
        loanguide5.setOnClickListener(this);
        loanguide6.setOnClickListener(this);
        loanguide7.setOnClickListener(this);
        loanguide8.setOnClickListener(this);
        loanguide9.setOnClickListener(this);
        loanguide10.setOnClickListener(this);
        loanguide11.setOnClickListener(this);
        loanguide12.setOnClickListener(this);

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loanguide1:
                Log.e("JKHdi", "onClick: 111");
                Utils.gclick++;
                MyApplicationClass.loanGuide = LoanGuide.loanguide1;
                click(1);
                return;
            case R.id.loanguide2:
                Log.e("JKHdi", "onClick: 222");
                Utils.gclick++;
                MyApplicationClass.loanGuide = LoanGuide.loanguide2;
                click(2);
                return;
            case R.id.loanguide3:
                Log.e("JKHdi", "onClick: 33");
                Utils.gclick++;
                MyApplicationClass.loanGuide = LoanGuide.loanguide3;
                click(3);
                return;
            case R.id.loanguide4:
                Utils.gclick++;
                MyApplicationClass.loanGuide = LoanGuide.loanguide4;
                click(4);
                return;
            case R.id.loanguide5:
                Utils.gclick++;
                MyApplicationClass.loanGuide = LoanGuide.loanguide5;
                click(5);
                return;
            case R.id.loanguide6:
                Utils.gclick++;
                MyApplicationClass.loanGuide = LoanGuide.loanguide6;
                click(6);
                return;
            case R.id.loanguide7:
                Utils.gclick++;
                MyApplicationClass.loanGuide = LoanGuide.loanguide7;
                click(7);
                return;
            case R.id.loanguide8:
                Utils.gclick++;
                MyApplicationClass.loanGuide = LoanGuide.loanguide8;
                click(8);
                return;
            case R.id.loanguide9:
                Utils.gclick++;
                MyApplicationClass.loanGuide = LoanGuide.loanguide9;
                click(9);
                return;
            case R.id.loanguide10:
                Utils.gclick++;
                MyApplicationClass.loanGuide = LoanGuide.loanguide10;
                click(10);
                return;
            case R.id.loanguide11:
                Utils.gclick++;
                MyApplicationClass.loanGuide = LoanGuide.loanguide11;
                click(11);
                return;
            case R.id.loanguide12:
                Utils.gclick++;
                MyApplicationClass.loanGuide = LoanGuide.loanguide12;
                click(12);
                return;
        }
    }

    public void click(int i) {
        if (i == 1) {
            startActivity(new Intent(this, LoanGuide_Details_Activity.class));
        } else if (i == 2) {
            startActivity(new Intent(this, LoanGuide_Details_Activity.class));
        } else if (i == 3) {
            startActivity(new Intent(this, LoanGuide_Details_Activity.class));
        } else if (i == 4) {
            startActivity(new Intent(this, LoanGuide_Details_Activity.class));
        } else if (i == 5) {
            startActivity(new Intent(this, LoanGuide_Details_Activity.class));
        } else if (i == 6) {
            startActivity(new Intent(this, LoanGuide_Details_Activity.class));
        } else if (i == 7) {
            startActivity(new Intent(this, LoanGuide_Details_Activity.class));
        } else if (i == 8) {
            startActivity(new Intent(this, LoanGuide_Details_Activity.class));
        } else if (i == 9) {
            startActivity(new Intent(this, LoanGuide_Details_Activity.class));
        } else if (i == 10) {
            startActivity(new Intent(this, LoanGuide_Details_Activity.class));
        } else if (i == 11) {
            startActivity(new Intent(this, LoanGuide_Details_Activity.class));
        } else if (i == 12) {
            startActivity(new Intent(this, LoanGuide_Details_Activity.class));
        }

    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }

}