package com.gopal.fast.vid.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gopal.fast.vid.MainActivity;
import com.gopal.fast.vid.R;
import com.gopal.fast.vid.model.BankModel;
import com.gopal.fast.vid.ui.MainBankSelectActivity;

import java.util.ArrayList;

public class SelectBankAdapter extends RecyclerView.Adapter<SelectBankAdapter.DataHolder> {
    MainBankSelectActivity mainBankSelectActivity;
    ArrayList<BankModel> bankModels;

    public SelectBankAdapter(MainBankSelectActivity mainBankSelectActivity, ArrayList<BankModel> bankModels) {
        this.mainBankSelectActivity = mainBankSelectActivity;
        this.bankModels = bankModels;

    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bank, parent, false);
        return new SelectBankAdapter.DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        BankModel bankModel = bankModels.get(position);
        holder.textViewBankName.setText(bankModel.getVName());
        holder.itemView.setOnClickListener(v -> {
            mainBankSelectActivity.startActivity(new Intent(mainBankSelectActivity, MainActivity.class).putExtra("BANK_DETAILS_ID", bankModel.getIBankDetailsId()));
        });
    }

    @Override
    public int getItemCount() {
        return bankModels.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {
        TextView textViewBankName;

        public DataHolder(@NonNull View itemView) {
            super(itemView);
            textViewBankName = itemView.findViewById(R.id.textViewBankName);
        }
    }
}
