package com.gopal.fast.vid.NewImplement.ui;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gopal.fast.vid.R;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

public class ActBankInformation extends AppCompatActivity {
    private static final String TAG = "ActBankInformation";

    private LinearLayout cvDial;

    public int f46i = 0;
    private ImageView imgIcon;
    ProgressDialog progressDialog;
    private TextView tvName;
    private TextView tvNumber;
    ImageView backImageView;
    String b_name, b_number;
    Integer b_img;

    private boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_bank_information);

        InterEvent.inter(this);
        NativeAds.nativeads(this,findViewById(R.id.adsContainer));

        Intent intent = getIntent();
        b_img = intent.getIntExtra("image", 0);
        b_name = intent.getStringExtra("NAME");
        b_number = intent.getStringExtra("number");

        progressDialog = new ProgressDialog(this);
        if (isOnline()) {
            progressDialog.setTitle("Loading Data");
            progressDialog.setMessage("Please Wait a second");
            progressDialog.hide();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ActBankInformation.this.progressDialog.isShowing();
                    ActBankInformation.this.progressDialog.dismiss();
                }
            }, 3000);

        }

        imgIcon = (ImageView) findViewById(R.id.imgIcon);
        cvDial = (LinearLayout) findViewById(R.id.cvDial);
        tvName = (TextView) findViewById(R.id.tvName);
        tvNumber = (TextView) findViewById(R.id.tvNumber);
        backImageView = findViewById(R.id.backImageView);
        imgIcon.setImageResource(b_img);
        tvName.setText(b_name);
        tvNumber.setText(b_number);

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        cvDial.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((ClipboardManager) ActBankInformation.this.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("Bank Balance Check Number :", ActBankInformation.this.tvNumber.getText().toString()));
                Toast.makeText(ActBankInformation.this.getApplicationContext(), "Number Copied to clipboard... Please dial number in your dial pad", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }
}
