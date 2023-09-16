package com.gopal.fast.vid.NewImplement.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.gopal.fast.vid.R;

import java.util.ArrayList;

public class bankHolidayAdapter extends RecyclerView.Adapter<bankHolidayAdapter.holder> {
    Activity activity;
    ArrayList<bankHolidayModel> arrayList;

    public bankHolidayAdapter(ArrayList<bankHolidayModel> arrayList, Activity activity) {
        this.arrayList = arrayList;
        this.activity = activity;
    }

    @Override
    public int getItemViewType(int i) {
        return this.arrayList.get(i) != null ? 1 : 0;
    }

    @Override
    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from;
        int i2;
        if (i == 0) {
            from = LayoutInflater.from(viewGroup.getContext());
            i2 = R.layout.native_ad_view;
        } else if (i != 1) {
            return new holder(null);
        } else {
            from = LayoutInflater.from(viewGroup.getContext());
            i2 = R.layout.bank_holiday_row;
        }
        return new holder(from.inflate(i2, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(holder holder, int position) {
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 0) {
        } else if (itemViewType == 1) {
            holder.monthname.setText(this.arrayList.get(position).getMonth());
            holder.eventdate.setText(this.arrayList.get(position).getday());
            holder.eventname.setText(this.arrayList.get(position).getOccupation());
        }
    }

    @Override
    public int getItemCount() {
        return this.arrayList.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        TextView eventdate;
        TextView eventname;
        TextView monthname;
        FrameLayout native_container;
        ImageView native_space_img;

        public holder(View itemView) {
            super(itemView);
            this.native_container = (FrameLayout) itemView.findViewById(R.id.native_container);
            this.native_space_img = (ImageView) itemView.findViewById(R.id.native_space_img);
            this.monthname = (TextView) itemView.findViewById(R.id.txt_month);
            this.eventdate = (TextView) itemView.findViewById(R.id.txt_eventDate);
            this.eventname = (TextView) itemView.findViewById(R.id.txt_eventName);
        }
    }
}
