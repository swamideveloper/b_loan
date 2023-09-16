package com.gopal.fast.vid.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.gopal.fast.vid.NewImplement.ui.bankHolidayActivity;
import com.gopal.fast.vid.R;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;
import com.gopal.fast.vid.dbutils.DatabaseHelper;

import java.io.IOException;
import java.util.ArrayList;

public class CheckBalanceActivity extends AppCompatActivity {
    LinearLayout lv_check_bank_ballence, lv_get_mini_statement, lv_call_customer_care, lv_is_bank_open_today;
    DatabaseHelper dbHelper;
    ArrayList<String> bankName;
    ImageView backImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbank_balance);

        InterEvent.inter(this);
        NativeAds.nativeads(this,findViewById(R.id.adsContainer));

        backImageView = findViewById(R.id.backImageView);
        intiViews();

        int iBankDetailsId = getIntent().getIntExtra("BANK_DETAILS_ID", 0);
        bankName = dbHelper.getBankContactDetailByID("bank_details", "iBankDetailsId", iBankDetailsId);
        Log.e("TAG", "onCreate: " + bankName.get(0));
        Log.e("TAG", "onCreate: " + bankName.get(1));
        Log.e("TAG", "onCreate: " + bankName.get(2));
        onClick();

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }

    private void onClick() {
        lv_check_bank_ballence.setOnClickListener(tt -> {
            try {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:" + bankName.get(0)));
                startActivity(intent);
            } catch (Exception e9) {
                e9.getMessage();
            }
        });

        lv_get_mini_statement.setOnClickListener(tt -> {
            try {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:" + bankName.get(1)));
                startActivity(intent);
            } catch (Exception e9) {
                e9.getMessage();
            }
        });

        lv_call_customer_care.setOnClickListener(tt -> {
            try {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:" + bankName.get(2)));
                startActivity(intent);
            } catch (Exception e9) {
                e9.getMessage();
            }
        });

    }

    private void intiViews() {
        dbHelper = new DatabaseHelper(this);

        try {
            dbHelper.copyDatabaseFromAssets();
        } catch (IOException e) {
            e.printStackTrace();
        }
        lv_check_bank_ballence = findViewById(R.id.lv_check_bank_ballence);
        lv_get_mini_statement = findViewById(R.id.lv_get_mini_statement);
        lv_call_customer_care = findViewById(R.id.lv_call_customer_care);
        lv_is_bank_open_today = findViewById(R.id.lv_is_bank_open_today);

        lv_is_bank_open_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CheckBalanceActivity.this, bankHolidayActivity.class));
            }
        });

    }

}