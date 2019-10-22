package com.pvkhaicd.samngoclinh.ViewController.Handbook;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.GeneralPagerAdapter;
import com.pvkhaicd.samngoclinh.ViewController.Climate.ClimateFragment;
import com.pvkhaicd.samngoclinh.ViewController.General.AdviceFragment;
import com.pvkhaicd.samngoclinh.ViewController.General.NewsFragment;
import com.pvkhaicd.samngoclinh.ViewController.General.PriceFragment;
import com.pvkhaicd.samngoclinh.ViewController.General.WeatherFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HandbookFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;

    public HandbookFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_handbook, container, false);
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        mTabLayout = view.findViewById(R.id.tab_news);
        mViewPager = view.findViewById(R.id.pager_news);
        //set up pager
        mFragments = new ArrayList<>();
        mFragments.add(new AcknowledgeFragment());
        mFragments.add(new AcknowledgeFragment());
        mFragments.add(new ClimateFragment());
        String[] title = new String[]{"Kiến thức", "Chính sách", "Tài liệu"};
        mViewPager.setAdapter(new GeneralPagerAdapter(getChildFragmentManager(), getContext(), mFragments, title));
        mTabLayout.setupWithViewPager(mViewPager);
        return view;
    }

}
