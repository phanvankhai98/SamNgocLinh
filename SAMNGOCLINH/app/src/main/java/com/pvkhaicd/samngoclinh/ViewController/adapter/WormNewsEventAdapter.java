package com.pvkhaicd.samngoclinh.ViewController.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pvkhaicd.samngoclinh.Model.WormNewsEvent.Worm;
import com.pvkhaicd.samngoclinh.R;

import java.util.List;

public class WormNewsEventAdapter extends BaseAdapter {

    List<Worm> data;
    Context context;

    public WormNewsEventAdapter(List<Worm> data, Context context) {
        this.data = data;
        this.context = context;
    }
    public void setData(List data){
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_worm_news_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = convertView.findViewById(R.id.tv_title);
            viewHolder.tvDate = convertView.findViewById(R.id.tv_date);

            convertView.setTag(viewHolder);
        }
        else viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.tvTitle.setText(data.get(position).getTitle());
        viewHolder.tvDate.setText(data.get(position).getDate());

        return convertView;
    }

    public class ViewHolder {
        TextView tvTitle, tvDate;
    }
}
