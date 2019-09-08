package com.pvkhaicd.samngoclinh.ViewController.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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
}
