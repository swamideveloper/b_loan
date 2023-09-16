package com.gopal.fast.vid;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class privacyPolice extends AppCompatActivity {
    TextView okTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy_act);

        okTextView = findViewById(R.id.okTextView);

        okTextView.setOnClickListener(new SingleClickListener() {
            @Override
            public void performClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
