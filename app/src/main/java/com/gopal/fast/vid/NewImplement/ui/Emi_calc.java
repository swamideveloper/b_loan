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

public class Emi_calc extends AppCompatActivity {

    LinearLayout calculate;
    TextView emiText;
    TextView interestAns;
    EditText investAmount;
    TextView monthToggle;
    boolean monthlyToggleBoolean = true;
    EditText rateOfInterest;
    LinearLayout reset;
    EditText tenure;
    TextView totalAns;
    ImageView backImageView;
    String CURRENCY_SELECTED = "$";

    private void intialize() {
        this.reset = (LinearLayout) findViewById(R.id.reset);
        this.calculate = (LinearLayout) findViewById(R.id.calculate);
        this.investAmount = (EditText) findViewById(R.id.investAmount);
        this.rateOfInterest = (EditText) findViewById(R.id.rateOfInterest);
        this.tenure = (EditText) findViewById(R.id.tenure);
        this.emiText = (TextView) findViewById(R.id.emi);
        this.interestAns = (TextView) findViewById(R.id.interestAns);
        this.totalAns = (TextView) findViewById(R.id.totalPayement);
        this.monthToggle = (TextView) findViewById(R.id.month);
        backImageView = findViewById(R.id.backImageView);

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

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
        double d2 = parseDouble * parseDouble2;
        double d3 = parseDouble2 + 1.0d;
        double pow = ((d2 / (1.0d - Math.pow(d3, -d))) * d) - parseDouble;
        double pow2 = Math.pow(d3, d);
        double d4 = (d2 * pow2) / (pow2 - 1.0d);
        Gixxer_ConstDecimal constDecimal = new Gixxer_ConstDecimal();

        TextView textView2 = this.interestAns;
        textView2.setText(constDecimal.round(pow) + " " + CURRENCY_SELECTED);
        TextView textView3 = this.totalAns;
        textView3.setText(constDecimal.round(pow + parseDouble) + " " + CURRENCY_SELECTED);
        TextView textView4 = this.emiText;
        textView4.setText(constDecimal.round(d4) + " " + CURRENCY_SELECTED);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emi_calc);

        InterEvent.inter(this);
        NativeAds.banner(this,findViewById(R.id.adsContainer));


        intialize();

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
                monthToggle.setText("Months");
                monthlyToggleBoolean = true;
                tenure.setText("");
                emiText.setText("");
                interestAns.setText("");
                totalAns.setText("");
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (investAmount.getText().toString().isEmpty() || rateOfInterest.getText().toString().isEmpty() || tenure.getText().toString().isEmpty()) {
                    Toast.makeText(Emi_calc.this, "Enter all the * values", Toast.LENGTH_SHORT).show();
                } else if (Double.parseDouble(rateOfInterest.getText().toString()) > 50.0d) {
                    Toast.makeText(Emi_calc.this, "Interest should be less than 50%", Toast.LENGTH_SHORT).show();
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