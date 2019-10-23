package com.pvkhaicd.samngoclinh.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pvkhaicd.samngoclinh.R;

import java.util.ArrayList;
import java.util.Random;

public class MessageAdapter extends BaseAdapter {
    ArrayList<String> data;
    Context context;
    String recive = "Đây là hệ thống trả lời tự động.Chúc bạn có một ngày tốt lành";

    public MessageAdapter(ArrayList<String> data, Context context) {
        this.data = data;
        this.context = context;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item_message_layout,parent,false);
        TextView textView1 = convertView.findViewById(R.id.tv1);
        TextView textView2 = convertView.findViewById(R.id.tv2);
        textView1.setText(data.get(position));

        Random rand = new Random();
        int n = rand.nextInt(3);
        textView2.setText(recive);


        return convertView;
    }
}
