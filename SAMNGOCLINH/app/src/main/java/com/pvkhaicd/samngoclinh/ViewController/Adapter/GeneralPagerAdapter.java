package com.pvkhaicd.samngoclinh.ViewController.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class GeneralPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private List<Fragment> mFragments;
    private String[] mTitle;

    public GeneralPagerAdapter(@NonNull FragmentManager fm, Context context, List<Fragment> fragments, String[] title) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
        mFragments = fragments;
        mTitle = title;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);

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

