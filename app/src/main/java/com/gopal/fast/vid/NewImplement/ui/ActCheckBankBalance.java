package com.gopal.fast.vid.NewImplement.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gopal.fast.vid.NewImplement.adapter.HP_BankListAdapter;
import com.gopal.fast.vid.NewImplement.model.BankDetails;
import com.gopal.fast.vid.R;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

import java.util.ArrayList;
import java.util.Iterator;

public class ActCheckBankBalance extends AppCompatActivity {

    private static final String TAG = "ActCheckBankBalance";

    public Activity activity;
    public ArrayList<BankDetails> bankDetails = new ArrayList<>();
    HP_BankListAdapter VBBankListAdapter;
//    private EditText etSearch;
    public int f46i = 0;
    ImageView backImageView;
    public RecyclerView recyclerView;
    TextView tv_nodata;
    ProgressDialog progressDialog;

    private boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_check_bank_balance);

        InterEvent.inter(this);
        NativeAds.banner(this,findViewById(R.id.adsContainer));


        progressDialog = new ProgressDialog(this);
        if (isOnline()) {
            progressDialog.setTitle("Loading Data");
            progressDialog.setMessage("Please Wait a second");
            progressDialog.hide();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ActCheckBankBalance.this.progressDialog.isShowing();
                    ActCheckBankBalance.this.progressDialog.dismiss();
                }
            }, 3000);
        }

        activity = this;
//        etSearch = (EditText) findViewById(R.id.etSearch);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        tv_nodata = findViewById(R.id.tv_nodata);
        backImageView = findViewById(R.id.backImageView);
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        getWindow().setSoftInputMode(2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        bankDetails = new ArrayList<>();
        bankDetails.add(new BankDetails(R.drawable.ic_allahabad_bank, "Allahabad\nBank", "Allahabad Bank", "+91 9224150150"));
        bankDetails.add(new BankDetails(R.drawable.ic_andhra_bank, "Andhra\nBank", "Andhra Bank", "+91 9223011300"));
        bankDetails.add(new BankDetails(R.drawable.ic_bank_of_india, "Bank Of\nIndia", "Bank Of India", "+91 9015135135"));
        bankDetails.add(new BankDetails(R.drawable.ic_canara_bank, "Canara\nBank", "Canara Bank", "+91 9015483483"));
        bankDetails.add(new BankDetails(R.drawable.ic_central_bank_of_india, "Central\nBank", "Central Bank Of India", "+91 9555244442"));
        bankDetails.add(new BankDetails(R.drawable.ic_federal_bank, "Federal\nBank", "Federal Bank", "+91 8431900900"));
        bankDetails.add(new BankDetails(R.drawable.ic_hdfc_bank, "HDFC\nBank", "HDFC Bank", "18002703333"));
        bankDetails.add(new BankDetails(R.drawable.ic_icici_bank, "AXIS\nBank", "AXIS Bank", "18604195555"));
        bankDetails.add(new BankDetails(R.drawable.ic_idbi_bank, "IDBI\nBank", "IDBI Bank", "18008431122"));
        bankDetails.add(new BankDetails(R.drawable.ic_indian_bank, "Indian\nBank", "Indian Bank", "+91 9289592895"));
        bankDetails.add(new BankDetails(R.drawable.ic_indusind_bank, "Maharashtra\nBank", "Maharashtra Bank", "18002334526"));
        bankDetails.add(new BankDetails(R.drawable.ic_kotak_mahindra_bank, "Kotak\nBank", "Kotak Mahindra Bank", "18002740110"));
        bankDetails.add(new BankDetails(R.drawable.ic_punjab_national_bank, "Punjab\nBank", "Punjab National Bank", "18001802223"));
        bankDetails.add(new BankDetails(R.drawable.ic_rbl_bank, "SBI\nBank", "SBI Bank", "18001234"));
        bankDetails.add(new BankDetails(R.drawable.ic_saraswat_bank, "Saraswat\nBank", "Saraswat Co-operative Bank", "9223040000"));
        bankDetails.add(new BankDetails(R.drawable.ic_uco_bank, "UCO\nBank", "UCO Bank", "+91 9278792787"));
        bankDetails.add(new BankDetails(R.drawable.ic_union_bank, "Union\nBank", "Union Bank Of India", "+91 9223008586"));
        bankDetails.add(new BankDetails(R.drawable.ic_yes_bank, "Yes\nBank", "Yes Bank", "+91 9223920000"));
        HP_BankListAdapter VBBankListAdapter2 = new HP_BankListAdapter(this.activity, this.bankDetails);
        VBBankListAdapter = VBBankListAdapter2;
        recyclerView.setAdapter(VBBankListAdapter2);

//        etSearch.addTextChangedListener(new TextWatcher() {
//            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
//            }
//
//            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
//                if (charSequence.length() == 0) {
//                    tv_nodata.setVisibility(View.VISIBLE);
//                    recyclerView.setVisibility(View.GONE);
//                    VBBankListAdapter.notifyDataSetChanged();
//                } else {
//                    tv_nodata.setVisibility(View.GONE);
//                    recyclerView.setVisibility(View.VISIBLE);
//                }
//                VBBankListAdapter.notifyDataSetChanged();
//            }
//
//            public void afterTextChanged(Editable editable) {
//                filter(editable.toString());
//                if (VBBankListAdapter.getItemCount() == 0) {
//                    tv_nodata.setVisibility(View.VISIBLE);
//                } else {
//                    tv_nodata.setVisibility(View.GONE);
//                }
//            }
//        });


    }

    private void filter(String str) {
        ArrayList<BankDetails> arrayList = new ArrayList<>();
        Iterator<BankDetails> it = bankDetails.iterator();
        while (it.hasNext()) {
            BankDetails next = it.next();
            if (next.getName().toLowerCase().startsWith(str.toLowerCase())) {
                arrayList.add(next);
            }
        }

        if (str.isEmpty()) {
            tv_nodata.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            VBBankListAdapter = new HP_BankListAdapter(activity, bankDetails);
            recyclerView.setAdapter(VBBankListAdapter);
            VBBankListAdapter.notifyDataSetChanged();
        } else {
            tv_nodata.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        VBBankListAdapter.filterList(arrayList);
        VBBankListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }
}