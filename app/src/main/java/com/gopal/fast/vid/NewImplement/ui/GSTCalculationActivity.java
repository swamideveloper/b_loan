package com.gopal.fast.vid.NewImplement.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gopal.fast.vid.R;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

public class GSTCalculationActivity extends AppCompatActivity {

    double final_gst_price;
    double final_origibnal_price;
    double float_add_remove;
    float float_amount;
    float float_rate_of_gst;
    String str_amount;
    String str_rate_of_gst;
    LinearLayout ll_addgst;
    LinearLayout ll_subtractgst;
    LinearLayout ll_main;
    EditText amount;
    EditText rate_of_gst;
    ImageView iv_add;
    ImageView iv_substract;
    ImageView backImageView;
    TextView txt_gst_price;
    TextView txt_original_price;
    TextView txt_net_price;
    TextView clk_reset;
    TextView txt_add;
    TextView txt_substract;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gst_calculation);

        InterEvent.inter(this);
        NativeAds.banner(this,findViewById(R.id.adsContainer));


        ll_addgst = findViewById(R.id.ll_addgst);
        amount = findViewById(R.id.amount);
        rate_of_gst = findViewById(R.id.rate_of_gst);
        iv_add = findViewById(R.id.iv_add);
        iv_substract = findViewById(R.id.iv_substract);
        txt_gst_price = findViewById(R.id.txt_gst_price);
        txt_original_price = findViewById(R.id.txt_original_price);
        txt_net_price = findViewById(R.id.txt_net_price);
        ll_main = findViewById(R.id.ll_main);
        ll_subtractgst = findViewById(R.id.ll_subtractgst);
        clk_reset = findViewById(R.id.clk_reset);
        txt_add = findViewById(R.id.txt_add);
        txt_substract = findViewById(R.id.txt_substract);
        backImageView = findViewById(R.id.backImageView);

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ll_addgst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GSTCalculationActivity GstCalculationActivity = GSTCalculationActivity.this;
                GstCalculationActivity.str_amount = GstCalculationActivity.amount.getText().toString().trim();
                GSTCalculationActivity GstCalculationActivity2 = GSTCalculationActivity.this;
                GstCalculationActivity2.str_rate_of_gst = GstCalculationActivity2.rate_of_gst.getText().toString().trim();
                if (str_amount.equals("")) {
                    amount.setError("Please Enter Amount");
                } else if (str_rate_of_gst.equals("")) {
                    rate_of_gst.setError("Please Enter Rate Of GST");
                } else {
                    GSTCalculationActivity GstCalculationActivity3 = GSTCalculationActivity.this;
                    GstCalculationActivity3.float_amount = Float.parseFloat(GstCalculationActivity3.str_amount);
                    GSTCalculationActivity GstCalculationActivity4 = GSTCalculationActivity.this;
                    GstCalculationActivity4.float_rate_of_gst = Float.parseFloat(GstCalculationActivity4.str_rate_of_gst);
                    GSTCalculationActivity GstCalculationActivity5 = GSTCalculationActivity.this;
                    GstCalculationActivity5.final_gst_price = (GstCalculationActivity5.float_rate_of_gst * float_amount) / 100.0f;
                    GSTCalculationActivity GstCalculationActivity6 = GSTCalculationActivity.this;
                    GstCalculationActivity6.float_add_remove = GstCalculationActivity6.final_gst_price + float_amount;
                    GSTCalculationActivity GstCalculationActivity7 = GSTCalculationActivity.this;
                    GstCalculationActivity7.final_origibnal_price = GstCalculationActivity7.float_amount;
                    iv_add.setImageResource(R.drawable.radioselect);
                    iv_substract.setImageResource(R.drawable.radiounselect);
                    txt_gst_price.setText(String.format("%.2f", Double.valueOf(final_gst_price)));
                    txt_original_price.setText(String.format("%.2f", Double.valueOf(final_origibnal_price)));
                    txt_net_price.setText(String.format("%.2f", Double.valueOf(float_add_remove)));
                    ll_main.setVisibility(View.VISIBLE);
                }
            }
        });

        ll_subtractgst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GSTCalculationActivity GstCalculationActivity = GSTCalculationActivity.this;
                GstCalculationActivity.str_amount = GstCalculationActivity.amount.getText().toString().trim();
                GSTCalculationActivity GstCalculationActivity2 = GSTCalculationActivity.this;
                GstCalculationActivity2.str_rate_of_gst = GstCalculationActivity2.rate_of_gst.getText().toString().trim();
                if (str_amount.equals("")) {
                    amount.setError("Please Enter Amount");
                } else if (str_rate_of_gst.equals("")) {
                    rate_of_gst.setError("Please Enter Rate Of GST");
                } else {
                    GSTCalculationActivity GstCalculationActivity3 = GSTCalculationActivity.this;
                    GstCalculationActivity3.float_amount = Float.parseFloat(GstCalculationActivity3.str_amount);
                    GSTCalculationActivity GstCalculationActivity4 = GSTCalculationActivity.this;
                    GstCalculationActivity4.float_rate_of_gst = Float.parseFloat(GstCalculationActivity4.str_rate_of_gst);
                    GSTCalculationActivity GstCalculationActivity5 = GSTCalculationActivity.this;
                    GstCalculationActivity5.final_gst_price = (GstCalculationActivity5.float_rate_of_gst * float_amount) / 100.0f;
                    GSTCalculationActivity GstCalculationActivity6 = GSTCalculationActivity.this;
                    GstCalculationActivity6.float_add_remove = GstCalculationActivity6.float_amount - final_gst_price;
                    GSTCalculationActivity GstCalculationActivity7 = GSTCalculationActivity.this;
                    GstCalculationActivity7.final_origibnal_price = GstCalculationActivity7.float_amount;
                    iv_add.setImageResource(R.drawable.radiounselect);
                    iv_substract.setImageResource(R.drawable.radioselect);
                    txt_gst_price.setText(String.format("%.2f", Double.valueOf(final_gst_price)));
                    txt_original_price.setText(String.format("%.2f", Double.valueOf(final_origibnal_price)));
                    txt_net_price.setText(String.format("%.2f", Double.valueOf(float_add_remove)));
                    ll_main.setVisibility(View.VISIBLE);
                }
            }
        });

        clk_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount.getText().clear();
                rate_of_gst.getText().clear();
                ll_main.setVisibility(View.GONE);
            }
        });


    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
