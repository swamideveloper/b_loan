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
import com.gopal.fast.vid.NewImplement.model.EPFService;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

public class EPF_Service_Activity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout epf1, epf2, epf3, epf4, epf5, epf6;
    ImageView backImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.epf_service);


        InterEvent.inter(this);
        NativeAds.banner(this,findViewById(R.id.adsContainer));


        backImageView = findViewById(R.id.backImageView);
        epf1 = findViewById(R.id.epf1);
        epf2 = findViewById(R.id.epf2);
        epf3 = findViewById(R.id.epf3);
        epf4 = findViewById(R.id.epf4);
        epf5 = findViewById(R.id.epf5);
        epf6 = findViewById(R.id.epf6);

        epf2.setOnClickListener(this);
        epf3.setOnClickListener(this);
        epf4.setOnClickListener(this);
        epf5.setOnClickListener(this);
        epf6.setOnClickListener(this);

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.epf1:
                Log.e("JKHdi", "onClick: 111");
                Utils.gclick++;
                MyApplicationClass.epfService = EPFService.epf1;
                click(1);
                return;
            case R.id.epf2:
                Log.e("JKHdi", "onClick: 222");
                Utils.gclick++;
                MyApplicationClass.epfService = EPFService.epf2;
                click(2);
                return;
            case R.id.epf3:
                Log.e("JKHdi", "onClick: 33");
                Utils.gclick++;
                MyApplicationClass.epfService = EPFService.epf3;
                click(3);
                return;
            case R.id.epf4:
                Utils.gclick++;
                MyApplicationClass.epfService = EPFService.epf4;
                click(4);
                return;
            case R.id.epf5:
                Utils.gclick++;
                MyApplicationClass.epfService = EPFService.epf5;
                click(5);
                return;
            case R.id.epf6:
                Utils.gclick++;
                MyApplicationClass.epfService = EPFService.epf6;
                click(6);
                return;
        }
    }

    public void click(int i) {
        if (i == 1) {
            startActivity(new Intent(this, EPFService_Details_Activity.class));
        } else if (i == 2) {
            startActivity(new Intent(this, EPFService_Details_Activity.class));
        } else if (i == 3) {
            startActivity(new Intent(this, EPFService_Details_Activity.class));
        } else if (i == 4) {
            startActivity(new Intent(this, EPFService_Details_Activity.class));
        } else if (i == 5) {
            startActivity(new Intent(this, EPFService_Details_Activity.class));
        } else if (i == 6) {
            startActivity(new Intent(this, EPFService_Details_Activity.class));
        }

    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }

}