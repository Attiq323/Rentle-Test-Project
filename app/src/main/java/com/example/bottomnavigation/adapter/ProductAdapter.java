package com.example.bottomnavigation.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.example.bottomnavigation.R;
import com.example.bottomnavigation.listener.ClickListener;

import java.util.ArrayList;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.NewItemViewHolder> {
    private Context mContext;
    private ClickListener listener;

//    public DealAdapter(Context mContext, ArrayList<ProductsModelClass> mNewItemList) {
//        this.mContext = mContext;
//        this.mNewItemList = mNewItemList;
//    }


    public ProductAdapter(Context context) {
        this.mContext = context;
    }

    public void setClickListener(ClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_items_layout, null);
        return new ProductAdapter.NewItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewItemViewHolder holder, int position) {

        holder.mItemLayout.setOnClickListener(view -> {
            listener.onClick(position);
        });
    }

    @Override
    public int getItemCount() {
         return 5;
    }

    class NewItemViewHolder extends RecyclerView.ViewHolder {
        TextView mOrderLocation_txtv,mOrderTotalPrice_txtv;
        RelativeLayout mMainLayout;
        RelativeLayout mItemLayout;

        public NewItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemLayout = itemView.findViewById(R.id.main_layout);
        }
    }

}