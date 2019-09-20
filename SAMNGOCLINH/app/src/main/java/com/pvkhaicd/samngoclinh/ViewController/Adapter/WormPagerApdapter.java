package com.pvkhaicd.samngoclinh.ViewController.Adapter;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class WormPagerApdapter extends FragmentStatePagerAdapter {
    String title[] = {"SÂU BỆNH","TIN TỨC","SỰ KIỆN"};
    Context context;
    ArrayList<Fragment> data;

    public WormPagerApdapter(FragmentManager fm, Context context, ArrayList<Fragment> data) {
        super(fm);
        this.context = context;
        this.data = data;
    }

    public WormPagerApdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return data.get(i);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    void setAdapter(ArrayList data){
        this.data = data;
        notifyDataSetChanged();
    }
}
