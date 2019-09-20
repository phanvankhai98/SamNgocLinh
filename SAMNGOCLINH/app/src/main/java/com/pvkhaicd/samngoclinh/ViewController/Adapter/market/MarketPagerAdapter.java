package com.pvkhaicd.samngoclinh.ViewController.Adapter.market;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.pvkhaicd.samngoclinh.R;

import java.util.List;

public class MarketPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private List<Fragment> mFragments;
    private String[] mTitle;

    public MarketPagerAdapter(FragmentManager fm, Context context, List<Fragment> fragments) {
        super(fm);
        mContext = context;
        mFragments = fragments;
        mTitle = new String[]{mContext.getResources().getString(R.string.title_purchase),
                mContext.getResources().getString(R.string.title_sell)};
    }

    public MarketPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}
