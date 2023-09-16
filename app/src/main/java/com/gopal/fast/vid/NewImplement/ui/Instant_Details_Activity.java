package com.gopal.fast.vid.NewImplement.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gopal.fast.vid.NewImplement.MyApplicationClass;
import com.gopal.fast.vid.R;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

public class Instant_Details_Activity extends AppCompatActivity {

    private TextView tvDescription;
    ImageView ivBack;
    TextView id_tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instant_details);

        InterEvent.inter(this);
        NativeAds.banner(this, findViewById(R.id.adsContainer));

        ivBack = findViewById(R.id.id_ivBack);
        id_tvTitle = findViewById(R.id.id_tvTitle);
        id_tvTitle.setText("Instant Loan Detail");
        ivBack.setOnClickListener(v -> onBackPressed());

        tvDescription = (TextView) findViewById(R.id.tvDescription);

        tvDescription.setText(MyApplicationClass.instantLoan.getDescription());


    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }

}