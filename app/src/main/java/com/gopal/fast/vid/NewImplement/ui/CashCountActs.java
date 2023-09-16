package com.gopal.fast.vid.NewImplement.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gopal.fast.vid.R;
import com.gopal.fast.vid.NewImplement.Utils;
import com.gopal.fast.vid.ads.InterEvent;
import com.gopal.fast.vid.ads.NativeAds;

public class CashCountActs extends AppCompatActivity {
    TextView editext;
    TextView editext10;
    TextView editext100;
    TextView editext20;
    TextView editext200;
    TextView editext50;
    TextView editext500;
    int i10;
    int i100;
    int i20;
    int i200;
    int i2000;
    int i50;
    int i500;
    ImageView imgadd;
    ImageView imgadd10;
    ImageView imgadd100;
    ImageView imgadd20;
    ImageView imgadd200;
    ImageView imgadd50;
    ImageView imgadd500;
    ImageView backImageView;
//    TextView imgcopy;
    ImageView imgminus;
    ImageView imgminus10;
    ImageView imgminus100;
    ImageView imgminus20;
    ImageView imgminus200;
    ImageView imgminus50;
    ImageView imgminus500;
//    TextView imgshare;
    int numberOfTaps = 0;
    int numberOfTaps10 = 0;
    int numberOfTaps100 = 0;
    int numberOfTaps20 = 0;
    int numberOfTaps200 = 0;
    int numberOfTaps50 = 0;
    int numberOfTaps500 = 0;
    ProgressDialog progressBar;
    TextView setvalue;
    TextView setvalue10;
    TextView setvalue100;
    TextView setvalue20;
    TextView setvalue200;
    TextView setvalue50;
    TextView setvalue500;
    TextWatcher textWatcher;
    int total;
    TextView totalsum;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_cash_count);

        InterEvent.inter(this);
        NativeAds.banner(this,findViewById(R.id.adsContainer));

        totalsum = (TextView) findViewById(R.id.totalsum);
        imgadd = (ImageView) findViewById(R.id.imgadd);
        imgminus = (ImageView) findViewById(R.id.imgminus);
        editext = (TextView) findViewById(R.id.editext);
        setvalue = (TextView) findViewById(R.id.setvalue);
        imgadd500 = (ImageView) findViewById(R.id.imgadd500);
        imgminus500 = (ImageView) findViewById(R.id.imgminus500);
        editext500 = (TextView) findViewById(R.id.editext500);
        setvalue500 = (TextView) findViewById(R.id.setvalue500);
        imgadd200 = (ImageView) findViewById(R.id.imgadd200);
        imgminus200 = (ImageView) findViewById(R.id.imgminus200);
        editext200 = (TextView) findViewById(R.id.editext200);
        setvalue200 = (TextView) findViewById(R.id.setvalue200);
        imgadd100 = (ImageView) findViewById(R.id.imgadd100);
        imgminus100 = (ImageView) findViewById(R.id.imgminus100);
        editext100 = (TextView) findViewById(R.id.editext100);
        setvalue100 = (TextView) findViewById(R.id.setvalue100);
        imgadd50 = (ImageView) findViewById(R.id.imgadd50);
        imgminus50 = (ImageView) findViewById(R.id.imgminus50);
        editext50 = (TextView) findViewById(R.id.editext50);
        setvalue50 = (TextView) findViewById(R.id.setvalue50);
        imgadd20 = (ImageView) findViewById(R.id.imgadd20);
        imgminus20 = (ImageView) findViewById(R.id.imgminus20);
        editext20 = (TextView) findViewById(R.id.editext20);
        setvalue20 = (TextView) findViewById(R.id.setvalue20);
        imgadd10 = (ImageView) findViewById(R.id.imgadd10);
        imgminus10 = (ImageView) findViewById(R.id.imgminus10);
        editext10 = (TextView) findViewById(R.id.editext10);
        setvalue10 = (TextView) findViewById(R.id.setvalue10);
//        imgcopy = (TextView) findViewById(R.id.imgcopy);
//        imgshare = (TextView) findViewById(R.id.imgshare);
        backImageView = (ImageView) findViewById(R.id.backImageView);

        backImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Utils.gclick++;
                if (Utils.gclick % Utils.click == 0) {
                    ironfullscreen(1);
                } else {
                    click(1);
                }
            }
        });

        TextWatcher r2 = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                CashCountActs VBCashCountActs = CashCountActs.this;
                VBCashCountActs.total = Integer.parseInt(VBCashCountActs.setvalue.getText().toString()) + Integer.parseInt(setvalue500.getText().toString()) + Integer.parseInt(setvalue200.getText().toString()) + Integer.parseInt(setvalue100.getText().toString()) + Integer.parseInt(setvalue50.getText().toString()) + Integer.parseInt(setvalue20.getText().toString()) + Integer.parseInt(setvalue10.getText().toString());
                TextView textView = totalsum;
                textView.setText("Total :" + total);
            }
        };

        textWatcher = r2;
        setvalue.addTextChangedListener(r2);
        setvalue500.addTextChangedListener(this.textWatcher);
        setvalue200.addTextChangedListener(this.textWatcher);
        setvalue100.addTextChangedListener(this.textWatcher);
        setvalue50.addTextChangedListener(this.textWatcher);
        setvalue20.addTextChangedListener(this.textWatcher);
        setvalue10.addTextChangedListener(this.textWatcher);

//        imgcopy.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                ((ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("Cash", totalsum.getText().toString()));
//                Toast.makeText(getApplicationContext(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
//            }
//        });

//        imgshare.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setAction("android.intent.action.SEND");
//                intent.putExtra("android.intent.extra.TEXT", "Cash Amount: " + totalsum.getText().toString());
//                intent.setType("text/plain");
//                startActivity(Intent.createChooser(intent, "Send to..."));
//            }
//        });

        imgadd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CashCountActs VBCashCountActs = CashCountActs.this;
                VBCashCountActs.numberOfTaps = Integer.parseInt(VBCashCountActs.editext.getText().toString()) + 1;
                TextView editText = editext;
                editText.setText("" + numberOfTaps);
            }
        });

        imgminus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CashCountActs VBCashCountActs = CashCountActs.this;
                VBCashCountActs.numberOfTaps = Integer.parseInt(VBCashCountActs.editext.getText().toString()) - 1;
                TextView editText = editext;
                editText.setText("" + numberOfTaps);
            }
        });

        editext.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    i2000 = Integer.parseInt(editext.getText().toString()) * 2000;
                    TextView textView = setvalue;
                    textView.setText("" + i2000);
                } catch (NumberFormatException unused) {
                }
            }
        });

        imgadd500.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CashCountActs VBCashCountActs = CashCountActs.this;
                VBCashCountActs.numberOfTaps500 = Integer.parseInt(VBCashCountActs.editext500.getText().toString()) + 1;
                TextView editText = editext500;
                editText.setText("" + numberOfTaps500);
            }
        });

        imgminus500.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CashCountActs VBCashCountActs = CashCountActs.this;
                VBCashCountActs.numberOfTaps500 = Integer.parseInt(VBCashCountActs.editext500.getText().toString()) - 1;
                TextView editText = editext500;
                editText.setText("" + numberOfTaps500);
            }
        });

        editext500.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    i500 = Integer.parseInt(editext500.getText().toString()) * 500;
                    TextView textView = setvalue500;
                    textView.setText("" + i500);
                } catch (NumberFormatException unused) {
                }
            }
        });

        imgadd200.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CashCountActs VBCashCountActs = CashCountActs.this;
                VBCashCountActs.numberOfTaps200 = Integer.parseInt(VBCashCountActs.editext200.getText().toString()) + 1;
                TextView editText = editext200;
                editText.setText("" + numberOfTaps200);
            }
        });

        imgminus200.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CashCountActs VBCashCountActs = CashCountActs.this;
                VBCashCountActs.numberOfTaps200 = Integer.parseInt(VBCashCountActs.editext200.getText().toString()) - 1;
                TextView editText = editext200;
                editText.setText("" + numberOfTaps200);
            }
        });

        editext200.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    i200 = Integer.parseInt(editext200.getText().toString()) * 200;
                    TextView textView = setvalue200;
                    textView.setText("" + i200);
                } catch (NumberFormatException unused) {
                }
            }
        });

        imgadd100.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CashCountActs VBCashCountActs = CashCountActs.this;
                VBCashCountActs.numberOfTaps100 = Integer.parseInt(VBCashCountActs.editext100.getText().toString()) + 1;
                TextView editText = editext100;
                editText.setText("" + numberOfTaps100);
            }
        });

        imgminus100.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CashCountActs VBCashCountActs = CashCountActs.this;
                VBCashCountActs.numberOfTaps100 = Integer.parseInt(VBCashCountActs.editext100.getText().toString()) - 1;
                TextView editText = editext100;
                editText.setText("" + numberOfTaps100);
            }
        });

        editext100.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    i100 = Integer.parseInt(editext100.getText().toString()) * 100;
                    TextView textView = setvalue100;
                    textView.setText("" + i100);
                } catch (NumberFormatException unused) {
                }
            }
        });

        imgadd50.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CashCountActs VBCashCountActs = CashCountActs.this;
                VBCashCountActs.numberOfTaps50 = Integer.parseInt(VBCashCountActs.editext50.getText().toString()) + 1;
                TextView editText = editext50;
                editText.setText("" + numberOfTaps50);
            }
        });

        imgminus50.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CashCountActs VBCashCountActs = CashCountActs.this;
                VBCashCountActs.numberOfTaps50 = Integer.parseInt(VBCashCountActs.editext50.getText().toString()) - 1;
                TextView editText = editext50;
                editText.setText("" + numberOfTaps50);
            }
        });

        editext50.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    i50 = Integer.parseInt(editext50.getText().toString()) * 50;
                    TextView textView = setvalue50;
                    textView.setText("" + i50);
                } catch (NumberFormatException unused) {
                }
            }
        });

        imgadd20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CashCountActs VBCashCountActs = CashCountActs.this;
                VBCashCountActs.numberOfTaps20 = Integer.parseInt(VBCashCountActs.editext20.getText().toString()) + 1;
                TextView editText = editext20;
                editText.setText("" + numberOfTaps20);
            }
        });

        imgminus20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CashCountActs VBCashCountActs = CashCountActs.this;
                VBCashCountActs.numberOfTaps20 = Integer.parseInt(VBCashCountActs.editext20.getText().toString()) - 1;
                TextView editText = editext20;
                editText.setText("" + numberOfTaps20);
            }
        });

        editext20.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    i20 = Integer.parseInt(editext20.getText().toString()) * 20;
                    TextView textView = setvalue20;
                    textView.setText("" + i20);
                } catch (NumberFormatException unused) {
                }
            }
        });

        imgadd10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CashCountActs VBCashCountActs = CashCountActs.this;
                VBCashCountActs.numberOfTaps10 = Integer.parseInt(VBCashCountActs.editext10.getText().toString()) + 1;
                TextView editText = editext10;
                editText.setText("" + numberOfTaps10);
            }
        });

        imgminus10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CashCountActs VBCashCountActs = CashCountActs.this;
                VBCashCountActs.numberOfTaps10 = Integer.parseInt(VBCashCountActs.editext10.getText().toString()) - 1;
                TextView editText = editext10;
                editText.setText("" + numberOfTaps10);
            }
        });

        editext10.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    i10 = Integer.parseInt(editext10.getText().toString()) * 10;
                    TextView textView = setvalue10;
                    textView.setText("" + i10);
                } catch (NumberFormatException unused) {
                }
            }
        });

    }

    private void ironfullscreen(final int i) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressBar = progressDialog;
        progressDialog.setCancelable(false);
        progressBar.setMessage("Ads Loading ...");
        progressBar.setProgressStyle(0);
        progressBar.show();
        progressBar.dismiss();
        click(i);
    }

    public void click(int i) {
        if (i == 1) {
            onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        InterEvent.back(this);
    }
}
