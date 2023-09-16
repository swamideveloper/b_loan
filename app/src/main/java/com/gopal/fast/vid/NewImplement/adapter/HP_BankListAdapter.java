package com.gopal.fast.vid.NewImplement.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gopal.fast.vid.NewImplement.model.BankDetails;
import com.gopal.fast.vid.NewImplement.ui.ActBankInformation;
import com.gopal.fast.vid.R;

import java.util.ArrayList;

public class HP_BankListAdapter extends RecyclerView.Adapter<HP_BankListAdapter.ViewHolder> {
    private int ITEM_DATA = 0;
    public Context activity;
    private ArrayList<BankDetails> list;

    public HP_BankListAdapter(Activity activity2, ArrayList<BankDetails> arrayList) {
        this.activity = activity2;
        this.list = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_bank_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BankDetails bankDetails = this.list.get(position);
        Glide.with(this.activity).load(bankDetails.getImage()).apply(new RequestOptions().error(R.mipmap.ic_launcher)).thumbnail(Glide.with(this.activity).load(R.mipmap.ic_launcher)).into(holder.imgIcon);
        holder.tvName.setText(bankDetails.getTitle());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("TAG--cc", "onClick: " + "click");
                Intent intent = new Intent(activity.getApplicationContext(), ActBankInformation.class);
                intent.putExtra("image", bankDetails.getImage());
                intent.putExtra("NAME", bankDetails.getName());
                intent.putExtra("number", bankDetails.getNumber());
                activity.startActivity(intent);
            }
        });
    }

    public void filterList(ArrayList<BankDetails> arrayList) {
        this.list = arrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    @Override
    public int getItemViewType(int i) {
        return this.ITEM_DATA;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgIcon;
        public LinearLayout linearLayout;
        public TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            this.imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
            this.tvName = (TextView) itemView.findViewById(R.id.tvName);
        }
    }
}