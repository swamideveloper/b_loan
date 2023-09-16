package com.gopal.fast.vid.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gopal.fast.vid.MainActivity;
import com.gopal.fast.vid.R;
import com.gopal.fast.vid.model.ItemModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<ItemModel> dataList;
    private MainActivity mainActivity;

    public RecyclerViewAdapter(MainActivity mainActivity, List<ItemModel> dataList) {
        this.dataList = dataList;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel item = dataList.get(position);
        holder.textView.setText(item.getName());
        holder.txtamount.setText(item.getAmount());

        Glide.with(mainActivity)
                .load(item.getImageUrl())
                .centerCrop()
                .placeholder(item.getImageUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView, txtamount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            txtamount = itemView.findViewById(R.id.txtamount);
        }
    }
}
