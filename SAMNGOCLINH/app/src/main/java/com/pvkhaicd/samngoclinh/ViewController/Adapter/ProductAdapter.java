package com.pvkhaicd.samngoclinh.ViewController.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pvkhaicd.samngoclinh.Model.Product;
import com.pvkhaicd.samngoclinh.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    ArrayList<Product> data;
    Context context;

    public ProductAdapter(ArrayList<Product> data, Context context) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.item_product_layout,parent,false);

        ImageView img = convertView.findViewById(R.id.img);
        TextView tv = convertView.findViewById(R.id.tv);

        Product product = data.get(position);
        tv.setText(product.getTitle());


        return convertView;
    }
}
