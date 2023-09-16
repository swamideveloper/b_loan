package com.gopal.fast.vid.NewImplement.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gopal.fast.vid.NewImplement.MyApplicationClass;
import com.gopal.fast.vid.R;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

public class PanGuide_Details_Activity extends AppCompatActivity {

    private TextView tvDescription;
    ImageView backImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pan_guide_details);

        InterEvent.inter(this);
        NativeAds.banner(this,findViewById(R.id.adsContainer));


        backImageView = findViewById(R.id.backImageView);
        tvDescription = (TextView) findViewById(R.id.tvDescription);

        tvDescription.setText(MyApplicationClass.panGuide.getDescription());

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

}