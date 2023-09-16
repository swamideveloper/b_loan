package com.gopal.fast.vid.NewImplement.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.gopal.fast.vid.R;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

public class Calculator_MainActivity extends AppCompatActivity {

    LinearLayout sipcalc, emicalc, gstcalc;
    ImageView backImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);

        InterEvent.inter(this);
        NativeAds.nativeads(this,findViewById(R.id.adsContainer));


        sipcalc = findViewById(R.id.sipcalc);
        emicalc = findViewById(R.id.emicalc);
        gstcalc = findViewById(R.id.gstcalc);
        backImageView = findViewById(R.id.backImageView);

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        gstcalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Calculator_MainActivity.this, GSTCalculationActivity.class));
            }
        });

        sipcalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Calculator_MainActivity.this, Sip_calc.class));
            }
        });

        emicalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Calculator_MainActivity.this, Emi_calc.class));
            }
        });


    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }

}