package com.gopal.fast.vid.NewImplement.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gopal.fast.vid.R;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class bankHolidayActivity extends AppCompatActivity {
    bankHolidayAdapter adapter;
    ArrayList<String> arrayList;
    bankDatabase database;
    ArrayList<bankHolidayModel> rlArraylist;
    ArrayList<bankHolidayModel> rlArraylist1;
    Spinner sp_bankholiday;
    RecyclerView rl_bankOpen;
    TextView txt_bankOpen;
    RelativeLayout cardview1;
    LinearLayout cardview_bankiopen;
    ImageView backImageView;

    public static String cbmqs_326_326_t() {
        return new SimpleDateFormat("dd MMM yy", Locale.getDefault()).format(Calendar.getInstance().getTime());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_holiday);

        InterEvent.inter(this);
        NativeAds.banner(this, findViewById(R.id.adsContainer));

        sp_bankholiday = findViewById(R.id.sp_bankholiday);
        rl_bankOpen = findViewById(R.id.rl_bankOpen);
        txt_bankOpen = findViewById(R.id.txt_bankOpen);
        cardview1 = findViewById(R.id.cardview1);
        cardview_bankiopen = findViewById(R.id.cardview_bankiopen);
        backImageView = findViewById(R.id.backImageView);

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        database = new bankDatabase(this);
        arrayList = new ArrayList<>();
        arrayList = this.database.getBankNameForSpinner();
        sp_bankholiday.setAdapter((SpinnerAdapter) new ArrayAdapter(this, 17367043, this.arrayList));
        sp_bankholiday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i1, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(R.color.black);
                bankHolidayActivity.this.rlArraylist = new ArrayList<>();
                bankHolidayActivity.this.rlArraylist1 = new ArrayList<>();
                bankHolidayActivity BankHolidayActivity = bankHolidayActivity.this;
                BankHolidayActivity.rlArraylist = BankHolidayActivity.database.getOpenBankDetails(sp_bankholiday.getSelectedItem().toString());
                int i = 2;
                for (int i2 = 0; i2 < bankHolidayActivity.this.rlArraylist.size(); i2++) {
                    if (i2 % i == 0 && i2 != 0) {
                        bankHolidayActivity.this.rlArraylist1.add(null);
                        i += 6;
                    }
                    bankHolidayActivity.this.rlArraylist1.add(bankHolidayActivity.this.rlArraylist.get(i2));
                }
                bankHolidayActivity BankHolidayActivity2 = bankHolidayActivity.this;
                BankHolidayActivity2.adapter = new bankHolidayAdapter(BankHolidayActivity2.rlArraylist1, bankHolidayActivity.this);
                rl_bankOpen.setLayoutManager(new LinearLayoutManager(bankHolidayActivity.this));
                rl_bankOpen.setAdapter(bankHolidayActivity.this.adapter);
            }
        });

        TextView textView = txt_bankOpen;
        textView.setText("Bank Open:" + cbmqs_326_326_t());
        rlArraylist = new ArrayList<>();
        rlArraylist1 = new ArrayList<>();
        rlArraylist = database.getOpenBankDetails(sp_bankholiday.getSelectedItem().toString());
        int i = 2;
        for (int i2 = 0; i2 < this.rlArraylist.size(); i2++) {
            if (i2 % i == 0 && i2 != 0) {
                this.rlArraylist1.add(null);
                i += 6;
            }
            this.rlArraylist1.add(this.rlArraylist.get(i2));
        }
        this.adapter = new bankHolidayAdapter(this.rlArraylist1, this);
        rl_bankOpen.setLayoutManager(new LinearLayoutManager(this));
        rl_bankOpen.setAdapter(this.adapter);
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
