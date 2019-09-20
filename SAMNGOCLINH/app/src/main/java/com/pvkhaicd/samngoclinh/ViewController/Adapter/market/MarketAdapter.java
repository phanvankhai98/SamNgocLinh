package com.pvkhaicd.samngoclinh.ViewController.Adapter.market;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pvkhaicd.samngoclinh.Model.MarketItem;
import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.BaseAdapter;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.OnItemClickListener;

import java.util.List;

public class MarketAdapter extends BaseAdapter<MarketItem, MarketAdapter.ViewHolder> {

    OnItemClickListener mOnItemClickListener;

    public MarketAdapter(Context context, List<MarketItem> data) {
        super(context, data);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_market_recycler_view, viewGroup, false);
        return new ViewHolder(view, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindView(getData().get(i));
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        if (mOnItemClickListener == null) mOnItemClickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextViewPhoneNumber;
        private TextView mTextViewWeight;
        private TextView mTextViewCounty;
        private OnItemClickListener mOnItemClickListener;

        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            mTextViewPhoneNumber = itemView.findViewById(R.id.text_phone_number);
            mTextViewWeight = itemView.findViewById(R.id.text_weight);
            mTextViewCounty = itemView.findViewById(R.id.text_county);
            this.mOnItemClickListener = listener;
            itemView.setOnClickListener(this);

        }

        public void bindView(MarketItem item) {
            mTextViewPhoneNumber.setText(item.getBlurPhoneNumber());
            mTextViewWeight.setText(item.getWeight() + " Tan");
            mTextViewCounty.setText(item.getCounty());
        }

        @Override
        public void onClick(View view) {
            mOnItemClickListener.onItemClicked(getAdapterPosition());
        }
    }
}
