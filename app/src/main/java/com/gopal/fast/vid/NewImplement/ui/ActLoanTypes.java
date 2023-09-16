package com.gopal.fast.vid.NewImplement.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.gopal.fast.vid.NewImplement.MyApplicationClass;
import com.gopal.fast.vid.NewImplement.Utils;
import com.gopal.fast.vid.NewImplement.model.LoanType;
import com.gopal.fast.vid.R;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

public class ActLoanTypes extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ActLoanTypes";

    public int f46i = 0;
    private LinearLayout imgAutoLoan;
    private LinearLayout imgBusinessLoan;
    private LinearLayout imgHomeLoan;
    private ImageView imgMortgages;
    private ImageView imgPaydayLoan;
    private LinearLayout imgPersonalLoan;
    private ImageView imgSmallBusiness;
    private LinearLayout imgStudentLoan;
    private LinearLayout imgGoldLoan;
    ImageView backImageView;
    ProgressDialog progressBar;
    ProgressDialog progressDialog;

    private boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_loan_types);

        InterEvent.inter(this);
        NativeAds.nativeads(this, findViewById(R.id.adsContainer));


        progressDialog = new ProgressDialog(this);
        if (isOnline()) {
            progressDialog.setTitle("Loading Data");
            progressDialog.setMessage("Please Wait a second");
            progressDialog.hide();

            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ActLoanTypes.this.progressDialog.isShowing();
                    ActLoanTypes.this.progressDialog.dismiss();
                }
            }, 3000);



        }

        imgPersonalLoan = (LinearLayout) findViewById(R.id.imgPersonalLoan);
        imgAutoLoan = (LinearLayout) findViewById(R.id.imgAutoLoan);
        imgHomeLoan = (LinearLayout) findViewById(R.id.imgHomeLoan);
        imgBusinessLoan = (LinearLayout) findViewById(R.id.imgBusinessLoan);
        imgStudentLoan = (LinearLayout) findViewById(R.id.imgStudentLoan);
        imgMortgages = (ImageView) findViewById(R.id.imgMortgages);
        imgGoldLoan = (LinearLayout) findViewById(R.id.imgGoldLoan);
        imgPaydayLoan = (ImageView) findViewById(R.id.imgPaydayLoan);
        imgSmallBusiness = (ImageView) findViewById(R.id.imgSmallBusiness);
        backImageView = findViewById(R.id.backImageView);

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        imgPersonalLoan.setOnClickListener(this);
        imgGoldLoan.setOnClickListener(this);
        imgAutoLoan.setOnClickListener(this);
        imgHomeLoan.setOnClickListener(this);
        imgBusinessLoan.setOnClickListener(this);
        imgStudentLoan.setOnClickListener(this);
        imgMortgages.setOnClickListener(this);
        imgPaydayLoan.setOnClickListener(this);
        imgSmallBusiness.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgAutoLoan:
                Utils.gclick++;
                if (Utils.gclick % Utils.click == 0) {
                    MyApplicationClass.loanType = LoanType.AUTO_LOAN;
                    ironfullscreen(2);
                    return;
                }
                MyApplicationClass.loanType = LoanType.AUTO_LOAN;
                click(2);
                return;
            case R.id.imgBusinessLoan:
                Utils.gclick++;
                if (Utils.gclick % Utils.click == 0) {
                    MyApplicationClass.loanType = LoanType.BUSINESS_LOAN;
                    ironfullscreen(4);
                    return;
                }
                MyApplicationClass.loanType = LoanType.BUSINESS_LOAN;
                click(4);
                return;
            case R.id.imgHomeLoan:
                Utils.gclick++;
                if (Utils.gclick % Utils.click == 0) {
                    MyApplicationClass.loanType = LoanType.HOME_LOAN;
                    ironfullscreen(3);
                    return;
                }
                MyApplicationClass.loanType = LoanType.HOME_LOAN;
                click(3);
                return;

            case R.id.imgMortgages:
                Utils.gclick++;
                if (Utils.gclick % Utils.click == 0) {
                    MyApplicationClass.loanType = LoanType.MORTGAGES;
                    ironfullscreen(6);
                    return;
                }
                MyApplicationClass.loanType = LoanType.MORTGAGES;
                click(6);
                return;
            case R.id.imgPaydayLoan:
                Utils.gclick++;
                if (Utils.gclick % Utils.click == 0) {
                    MyApplicationClass.loanType = LoanType.PAYDAY_LOAN;
                    ironfullscreen(7);
                    return;
                }
                MyApplicationClass.loanType = LoanType.PAYDAY_LOAN;
                click(7);
                return;
            case R.id.imgPersonalLoan:
                Utils.gclick++;
                if (Utils.gclick % Utils.click == 0) {
                    MyApplicationClass.loanType = LoanType.PERSONAL_LOAN;
                    ironfullscreen(1);
                    return;
                }
                MyApplicationClass.loanType = LoanType.PERSONAL_LOAN;
                click(1);
                return;
            case R.id.imgSmallBusiness:
                Utils.gclick++;
                if (Utils.gclick % Utils.click == 0) {
                    MyApplicationClass.loanType = LoanType.SMALL_BUSINESS;
                    ironfullscreen(8);
                    return;
                }
                MyApplicationClass.loanType = LoanType.SMALL_BUSINESS;
                click(8);
                return;
            case R.id.imgGoldLoan:
                Utils.gclick++;
                if (Utils.gclick % Utils.click == 0) {
                    MyApplicationClass.loanType = LoanType.GOLD_LOAN;
                    ironfullscreen(9);
                    return;
                }
                MyApplicationClass.loanType = LoanType.GOLD_LOAN;
                click(9);
                return;
            case R.id.imgStudentLoan:
                Utils.gclick++;
                if (Utils.gclick % Utils.click == 0) {
                    MyApplicationClass.loanType = LoanType.STUDENT_LOAN;
                    ironfullscreen(5);
                    return;
                }
                MyApplicationClass.loanType = LoanType.STUDENT_LOAN;
                click(5);
                return;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void ironfullscreen(final int i) {
        ProgressDialog progressDialog2 = new ProgressDialog(this);
        this.progressBar = progressDialog2;
        progressDialog2.setCancelable(false);
        this.progressBar.setMessage("Ads Loading ...");
        this.progressBar.setProgressStyle(0);
        this.progressBar.show();
        ActLoanTypes.this.progressBar.dismiss();
        ActLoanTypes.this.click(i);
    }

    public void click(int i) {
        if (i == 1) {
            startActivity(new Intent(this, ActLoanDetails.class));

        } else if (i == 2) {
            startActivity(new Intent(this, ActLoanDetails.class));

        } else if (i == 3) {
            startActivity(new Intent(this, ActLoanDetails.class));

        } else if (i == 4) {
            startActivity(new Intent(this, ActLoanDetails.class));

        } else if (i == 5) {
            startActivity(new Intent(this, ActLoanDetails.class));

        } else if (i == 6) {
            startActivity(new Intent(this, ActLoanDetails.class));

        } else if (i == 7) {
            startActivity(new Intent(this, ActLoanDetails.class));

        } else if (i == 8) {
            startActivity(new Intent(this, ActLoanDetails.class));

        } else if (i == 9) {
            startActivity(new Intent(this, ActLoanDetails.class));
        }
    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }
}
