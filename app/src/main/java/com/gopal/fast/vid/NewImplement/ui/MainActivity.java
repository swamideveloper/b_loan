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

public class MainActivity extends AppCompatActivity {

    LinearLayout cashcounter, calculator, loantype, loanguide, adharloan, pancard, instantloan, epfsrvice;
    ImageView bankbalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InterEvent.inter(this);
        NativeAds.nativeads(this, findViewById(R.id.adsContainer));

        cashcounter = findViewById(R.id.cashcounter);
        bankbalance = findViewById(R.id.bankbalance);
        calculator = findViewById(R.id.calculator);
        loantype = findViewById(R.id.loantype);
        loanguide = findViewById(R.id.loanguide);
        adharloan = findViewById(R.id.adharloan);
        pancard = findViewById(R.id.pancard);
        instantloan = findViewById(R.id.instantloan);
        epfsrvice = findViewById(R.id.epfsrvice);

        cashcounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CashCountActs.class));
            }
        });

        bankbalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActCheckBankBalance.class));
            }
        });

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Calculator_MainActivity.class));
            }
        });

        loantype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActLoanTypes.class));
            }
        });

        loanguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoanGuide_Activity.class));
            }
        });

        adharloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdharCard_Activity.class));
            }
        });

        pancard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PanCard_Activity.class));
            }
        });

        instantloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InstantLoan_Activity.class));
            }
        });

        epfsrvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EPF_Service_Activity.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }

}