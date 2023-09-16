package com.gopal.fast.vid.NewImplement.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gopal.fast.vid.NewImplement.model.Gixxer_ConstDecimal;
import com.gopal.fast.vid.R;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

public class Sip_calc extends AppCompatActivity {

    LinearLayout calculate;
    TextView interestAns;
    EditText investAmount;
    TextView knowMore;
    TextView maturityValue;
    TextView monthToggle;
    boolean monthlyToggleBoolean = true;
    EditText rateOfInterest;
    LinearLayout reset;
    EditText tenure;
    TextView totalAns;
    TextView yourFirstInvestment;
    ImageView backImageView;
    String CURRENCY_SELECTED = "$";

    private void intialize() {
        this.reset = (LinearLayout) findViewById(R.id.reset);
        this.calculate = (LinearLayout) findViewById(R.id.calculate);
        this.investAmount = (EditText) findViewById(R.id.investAmount);
        this.rateOfInterest = (EditText) findViewById(R.id.rateOfInterest);
        this.tenure = (EditText) findViewById(R.id.tenure);
        this.maturityValue = (TextView) findViewById(R.id.maturityValue);
        this.interestAns = (TextView) findViewById(R.id.interestAns);
        this.totalAns = (TextView) findViewById(R.id.totalAns);
        this.monthToggle = (TextView) findViewById(R.id.month);

    }

    public void calculate() {
        double d;
        if (this.monthlyToggleBoolean) {
            d = Double.parseDouble(this.tenure.getText().toString());
        } else {
            d = Double.parseDouble(this.tenure.getText().toString()) * 12.0d;
        }
        double parseDouble = Double.parseDouble(this.investAmount.getText().toString());
        double parseDouble2 = Double.parseDouble(this.rateOfInterest.getText().toString()) / 1200.0d;
        double d2 = parseDouble2 + 1.0d;
        double pow = (((Math.pow(d2, d) - 1.0d) * parseDouble) * d2) / parseDouble2;
        double d3 = parseDouble * d;
        Gixxer_ConstDecimal constDecimal = new Gixxer_ConstDecimal();
        TextView textView = this.interestAns;
        textView.setText(constDecimal.round(pow - d3) + " " + CURRENCY_SELECTED);
        TextView textView2 = this.totalAns;
        textView2.setText(constDecimal.round(d3) + " " + CURRENCY_SELECTED);
        TextView textView3 = this.maturityValue;
        textView3.setText(constDecimal.round(pow) + " " + CURRENCY_SELECTED);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sip_calc);

        InterEvent.inter(this);
        NativeAds.banner(this,findViewById(R.id.adsContainer));


        intialize();
        backImageView = findViewById(R.id.backImageView);
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        monthToggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (monthlyToggleBoolean) {
                    monthlyToggleBoolean = false;
                    monthToggle.setText("Yearly");
                    return;
                }
                monthlyToggleBoolean = true;
                monthToggle.setText("Monthly");
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                investAmount.setText("");
                rateOfInterest.setText("");
                totalAns.setText("");
                maturityValue.setText("");
                interestAns.setText("");
                monthToggle.setText("Months");
                monthlyToggleBoolean = true;
                tenure.setText("");
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (investAmount.getText().toString().isEmpty() || rateOfInterest.getText().toString().isEmpty() || tenure.getText().toString().isEmpty()) {
                    Toast.makeText(Sip_calc.this, "Enter all the * values", Toast.LENGTH_SHORT).show();
                } else if (Double.parseDouble(rateOfInterest.getText().toString()) > 50.0d) {
                    Toast.makeText(Sip_calc.this, "Interest should be less than 50%", Toast.LENGTH_SHORT).show();
                } else {
                    calculate();
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }

}