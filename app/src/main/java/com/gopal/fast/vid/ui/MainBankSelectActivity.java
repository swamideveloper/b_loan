package com.gopal.fast.vid.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gopal.fast.vid.R;
import com.gopal.fast.vid.adapters.SelectBankAdapter;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;
import com.gopal.fast.vid.dbutils.DatabaseHelper;
import com.gopal.fast.vid.model.BankModel;

import java.io.IOException;
import java.util.ArrayList;

public class MainBankSelectActivity extends AppCompatActivity {
    RecyclerView rvSelectBank;
    ImageView backImageView;
    private ArrayList<BankModel> bankModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bank_select);

        InterEvent.inter(this);
        NativeAds.banner(this, findViewById(R.id.adsContainer));

        backImageView = findViewById(R.id.backImageView);

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        intiViews();

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        try {
            dbHelper.copyDatabaseFromAssets();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<BankModel> bankModels = dbHelper.getDataFromTable("bank_details", "vLanguage");

        for (BankModel bankModel : bankModels) {
            int iBankDetailsId = bankModel.getIBankDetailsId();
            String bankInfo = "Bank Details: " + "ID: " + iBankDetailsId;
            Log.e("BankInfo", bankInfo);

        }
        SelectBankAdapter selectBankAdapter = new SelectBankAdapter(this, bankModels);
        rvSelectBank.setLayoutManager(new LinearLayoutManager(this));
        rvSelectBank.setAdapter(selectBankAdapter);
    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }

    private void intiViews() {
        rvSelectBank = findViewById(R.id.rvSelectBank);
        bankModels = new ArrayList<>();
    }

}