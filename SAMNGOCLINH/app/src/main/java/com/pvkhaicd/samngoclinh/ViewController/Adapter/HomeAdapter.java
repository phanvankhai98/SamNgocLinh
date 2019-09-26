package com.pvkhaicd.samngoclinh.ViewController.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pvkhaicd.samngoclinh.Model.Home;
import com.pvkhaicd.samngoclinh.R;

import java.util.List;
import java.util.Map;

public class HomeAdapter extends BaseAdapter<Home, HomeAdapter.MyHolder> {

    private OnItemClickListener mOnItemClickListener;


    public HomeAdapter(Context context, List<Home> data) {
        super(context, data);
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_home_items, parent, false);
        return new MyHolder(view, mOnItemClickListener);
    }


    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.bindView(getData().get(position));
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageView;
        private TextView mTextView;
        private OnItemClickListener mOnItemClickListener;

        public MyHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.icon_home);
            mTextView = itemView.findViewById(R.id.text_title);
            mOnItemClickListener = listener;

            itemView.setOnClickListener(this);
        }

        public void bindView(Home item) {
            mImageView.setImageResource(item.getIconSource());
            mTextView.setText(item.getTitle());
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null)
                mOnItemClickListener.onItemClicked(getAdapterPosition());
        }
    }
}
