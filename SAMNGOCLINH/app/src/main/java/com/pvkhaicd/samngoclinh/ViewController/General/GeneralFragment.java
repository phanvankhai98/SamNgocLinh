package com.pvkhaicd.samngoclinh.ViewController.General;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.GeneralPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GeneralFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        mTabLayout = view.findViewById(R.id.tab_news);
        mViewPager = view.findViewById(R.id.pager_news);
        //set up pager
        mFragments = new ArrayList<>();
        mFragments.add(new WeatherFragment());
        mFragments.add(new AdviceFragment());
        mFragments.add(new NewsFragment());
        mFragments.add(new PriceFragment());

        String[] title = new String[]{"Thời tiết","Thổ nhưỡng","Tin tức","Giá"};
        mViewPager.setAdapter(new GeneralPagerAdapter(getChildFragmentManager(), getContext(), mFragments,title));
        mTabLayout.setupWithViewPager(mViewPager);
        return view;
    }
}
