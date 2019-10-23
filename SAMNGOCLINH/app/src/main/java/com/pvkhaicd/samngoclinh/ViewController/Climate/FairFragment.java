package com.pvkhaicd.samngoclinh.ViewController.Climate;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.GeneralPagerAdapter;
import com.pvkhaicd.samngoclinh.ViewController.General.PriceFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FairFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;
    public FairFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fair, container, false);
        mTabLayout = view.findViewById(R.id.tab_news);
        mViewPager = view.findViewById(R.id.pager_news);
        mFragments = new ArrayList<>();

        mFragments.add(new ListFairFragment());
        mFragments.add(new RegisterFragment());
        mFragments.add(new ProductFragment());

        String[] title = new String[]{"Hội chợ sâm","Tham gia","Sản Phẩm"};
        mViewPager.setAdapter(new GeneralPagerAdapter(getChildFragmentManager(), getContext(), mFragments,title));
        mTabLayout.setupWithViewPager(mViewPager);
        return  view;
    }

}
