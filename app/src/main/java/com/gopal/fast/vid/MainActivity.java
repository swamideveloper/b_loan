package com.gopal.fast.vid;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.gopal.fast.vid.NewImplement.ui.ActCheckBankBalance;
import com.gopal.fast.vid.NewImplement.ui.ActLoanTypes;
import com.gopal.fast.vid.NewImplement.ui.CashCountActs;
import com.gopal.fast.vid.NewImplement.ui.AdharCard_Activity;
import com.gopal.fast.vid.NewImplement.ui.Calculator_MainActivity;
import com.gopal.fast.vid.NewImplement.ui.EPF_Service_Activity;
import com.gopal.fast.vid.NewImplement.ui.InstantLoan_Activity;
import com.gopal.fast.vid.NewImplement.ui.LoanGuide_Activity;
import com.gopal.fast.vid.NewImplement.ui.PanCard_Activity;
import com.gopal.fast.vid.NewImplement.ui.bankHolidayActivity;
import com.gopal.fast.vid.adapters.RecyclerViewAdapter;
import com.gopal.fast.vid.dbutils.DatabaseHelper;
import com.gopal.fast.vid.model.ItemModel;
import com.gopal.fast.vid.ui.CheckBalanceActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tv_bank_name;
    TextView rl_check_bank_balance;
    private RecyclerViewAdapter adapter;
    private List<ItemModel> dataList = new ArrayList<>();
    DatabaseHelper dbHelper;
    private RecyclerView recyclerView;
    double longitude;
    double latitude;
//    TextView id_tvTitle;
    int scrollCount = 0;
    ImageView bankbalance;
    LinearLayout bankholidayLinearLayout;
    LinearLayout cashcounter, calculator, loantype, loanguide, adharloan, pancard, instantloan, epfsrvice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InterEvent.inter(this);
        NativeAds.nativeads(this, findViewById(R.id.adsContainer));

        bankholidayLinearLayout = findViewById(R.id.bankholidayLinearLayout);

        bankholidayLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, bankHolidayActivity.class));
            }
        });

        intiViews();
        int iBankDetailsId = getIntent().getIntExtra("BANK_DETAILS_ID", 0);
        String bankName = dbHelper.getBankDetailByID("bank_details", "iBankDetailsId", iBankDetailsId);
        tv_bank_name.setText(bankName);
        rl_check_bank_balance.setOnClickListener(tt -> {
            startActivity(new Intent(MainActivity.this, CheckBalanceActivity.class).putExtra("BANK_DETAILS_ID", iBankDetailsId));
        });
        findViewById(R.id.id_ivBack).setOnClickListener(tt -> {
            onBackPressed();
        });
//        id_tvTitle.setText("Check Balance");
        autoScrollRV();

        findViewById(R.id.atm).setOnClickListener(tt -> {
            All_location("ATM");
        });
        findViewById(R.id.bank).setOnClickListener(tt -> {
            All_location("Bank");
        });
        onBtnClick();
    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }

    private void onBtnClick() {
        cashcounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CashCountActs.class));
            }
        });

        bankbalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActCheckBankBalance.class));
            }
        });

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Calculator_MainActivity.class));
            }
        });

        loantype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActLoanTypes.class));
            }
        });

        loanguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoanGuide_Activity.class));
            }
        });

        adharloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdharCard_Activity.class));
            }
        });

        pancard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PanCard_Activity.class));
            }
        });

        instantloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InstantLoan_Activity.class));
            }
        });

        epfsrvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EPF_Service_Activity.class));
            }
        });

    }

    private void All_location(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/" + str + "/@" + latitude + "," + longitude + "")));
    }

    private void autoScrollRV() {
        recyclerView = findViewById(R.id.rv_loandisbrment);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        dataList.add(new ItemModel("Michael", R.drawable.men1, "10,000"));
        dataList.add(new ItemModel("Mary", R.drawable.women1, "30,000"));
        dataList.add(new ItemModel("David", R.drawable.men2, "70,000"));
        dataList.add(new ItemModel("John", R.drawable.men3, "50,000"));
        dataList.add(new ItemModel("Patricia", R.drawable.women2, "90,000"));
        dataList.add(new ItemModel("Robert", R.drawable.men4, "80,000"));
        dataList.add(new ItemModel("Jennifer", R.drawable.women3, "16,000"));
        dataList.add(new ItemModel("James", R.drawable.men5, "78,000"));
        dataList.add(new ItemModel("Linda", R.drawable.women4, "45,000"));
        dataList.add(new ItemModel("Jari", R.drawable.men6, "87,000"));
        dataList.add(new ItemModel("William", R.drawable.men7, "34,000"));
        dataList.add(new ItemModel("Linda", R.drawable.women5, "67,000"));
        dataList.add(new ItemModel("Richard", R.drawable.men8, "72,000"));
        dataList.add(new ItemModel("Barbara", R.drawable.women6, "99,000"));
        dataList.add(new ItemModel("Charles", R.drawable.men9, "79,000"));
        dataList.add(new ItemModel("Susan", R.drawable.women7, "66,000"));
        dataList.add(new ItemModel("Daniel", R.drawable.men10, "36,000"));
        dataList.add(new ItemModel("Thomas", R.drawable.men11, "25,000"));
        dataList.add(new ItemModel("Jessica", R.drawable.women8, "41,000"));
        dataList.add(new ItemModel("Matthew", R.drawable.men12, "39,000"));
        dataList.add(new ItemModel("Sarah", R.drawable.women9, "59,000"));
        dataList.add(new ItemModel("Christopher", R.drawable.men13, "85,000"));
        dataList.add(new ItemModel("Andrew", R.drawable.men14, "65,000"));
        dataList.add(new ItemModel("Karen", R.drawable.women10, "42,000"));

        adapter = new RecyclerViewAdapter(this, dataList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            } else {
            }
        }
    }

    private static final int PERMISSION_REQUEST_CODE = 123;

    private void getLocation() {
        FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
            if (location != null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            } else {
            }
        }).addOnFailureListener(this, e -> {
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter = new RecyclerViewAdapter(this, dataList);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this) {
            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller smoothScroller = new LinearSmoothScroller(MainActivity.this) {
                    private static final float SPEED = 3500f;

                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return SPEED / displayMetrics.densityDpi;
                    }
                };
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }
        };
        autoScrollAnother();
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(1000);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setAdapter(adapter);
    }

    public void autoScrollAnother() {
        scrollCount = 0;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                recyclerView.smoothScrollToPosition((scrollCount++));
                if (scrollCount == dataList.size() - 4) {
                    dataList.addAll(dataList);
                    adapter.notifyDataSetChanged();
                }
                handler.postDelayed(this, 2000);
            }
        };
        handler.postDelayed(runnable, 2000);
    }

    private void intiViews() {
        tv_bank_name = findViewById(R.id.tv_bank_name);
        rl_check_bank_balance = findViewById(R.id.rl_check_bank_balance);
//        id_tvTitle = findViewById(R.id.id_tvTitle);
        dbHelper = new DatabaseHelper(this);

        cashcounter = findViewById(R.id.cashcounter);
        bankbalance = findViewById(R.id.bankbalance);
        calculator = findViewById(R.id.calculator);
        loantype = findViewById(R.id.loantype);
        loanguide = findViewById(R.id.loanguide);
        adharloan = findViewById(R.id.adharloan);
        pancard = findViewById(R.id.pancard);
        instantloan = findViewById(R.id.instantloan);
        epfsrvice = findViewById(R.id.epfsrvice);

        try {
            dbHelper.copyDatabaseFromAssets();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        recyclerView.removeCallbacks(null);
    }

    public void loanApplyNow(View view) {
        startActivity(new Intent(MainActivity.this, ActLoanTypes.class));
    }

}