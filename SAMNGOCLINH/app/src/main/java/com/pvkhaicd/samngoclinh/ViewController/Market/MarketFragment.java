package com.pvkhaicd.samngoclinh.ViewController.Market;


import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.pvkhaicd.samngoclinh.Model.MarketItem;
import com.pvkhaicd.samngoclinh.Network.APIService;
import com.pvkhaicd.samngoclinh.Network.RetrofitClient;
import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.WormPagerApdapter;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.market.MarketPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarketFragment extends Fragment {

    TabLayout mTabLayout;
    ViewPager mViewPager;
    ArrayList<Fragment> mFragments;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_market, container, false);
        mTabLayout = view.findViewById(R.id.tab_layout_market);
        mViewPager = view.findViewById(R.id.view_pager_market);
        mFragments = new ArrayList<>();
        //setup pager
        mFragments.add(MarketHolderFragment.getInstance(MarketHolderFragment.PURCHASE_PAGE));
        mFragments.add(MarketHolderFragment.getInstance(MarketHolderFragment.SELL_PAGE));
        mViewPager.setAdapter(new MarketPagerAdapter(getChildFragmentManager(),getContext(),mFragments));
        mTabLayout.setupWithViewPager(mViewPager);
        return view;
    }

}
