package com.gopal.fast.vid.NewImplement.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gopal.fast.vid.NewImplement.MyApplicationClass;
import com.gopal.fast.vid.R;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

public class ActLoanDetails extends AppCompatActivity {
    private static final String TAG = "ActLoanDetails";

    public Activity activity;
//    private LinearLayout btnApplyForLoan;

    public int f46i = 0;

    public Intent intent;
    ProgressDialog progressBar;
    ProgressDialog progressDialog;
    private TextView tvDescription;
    private TextView tvName, tvTitle;
    ImageView ivBack;

    private boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_loan_details);

        InterEvent.inter(this);
        NativeAds.banner(this, findViewById(R.id.adsContainer));


        progressDialog = new ProgressDialog(this);
        if (isOnline()) {
            progressDialog.setTitle("Loading Data");
            progressDialog.setMessage("Please Wait a second");
            progressDialog.hide();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ActLoanDetails.this.progressDialog.isShowing();
                    ActLoanDetails.this.progressDialog.dismiss();
                }
            }, 3000);
        }


        activity = this;
        tvTitle = findViewById(R.id.id_tvTitle);
        ivBack = findViewById(R.id.id_ivBack);
        ivBack.setOnClickListener(v -> onBackPressed());
        tvTitle.setText(R.string.personal_loan);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
//        btnApplyForLoan = (LinearLayout) findViewById(R.id.btnApplyForLoan);
        TextView textView = this.tvTitle;
        if (!MyApplicationClass.loanType.getName().equals("")) {
            textView.setText(MyApplicationClass.loanType.getName() + " Information");
        }

        tvDescription.setText(MyApplicationClass.loanType.getDescription());

//        btnApplyForLoan.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Utils.gclick++;
//                if (Utils.gclick % Utils.click == 0) {
//                    ActLoanDetails.this.ironfullscreen(1);
//                } else {
//                    ActLoanDetails.this.click(1);
//                }
//            }
//        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void ironfullscreen(final int i) {
        ProgressDialog progressDialog2 = new ProgressDialog(this);
        progressBar = progressDialog2;
        progressDialog2.setCancelable(false);
        progressBar.setMessage("Ads Loading ...");
        progressBar.setProgressStyle(0);
        progressBar.show();

        ActLoanDetails.this.progressBar.dismiss();
        ActLoanDetails.this.click(i);
    }

    public void click(int i) {
        if (i == 1) {
        }
    }

    @Override
    public void onBackPressed() {
       InterEvent.back(this);
    }
}
