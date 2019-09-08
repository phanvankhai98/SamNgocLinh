package com.pvkhaicd.samngoclinh.ViewController.Worm;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.WormPagerApdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WormFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    ArrayList<Fragment> data = new ArrayList<>();
    public WormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worm, container, false);
        init(view);

        data.add(new ChildWormFragment());
        data.add(new NewsFragment());
        data.add(new EventFragment());
        viewPager.setAdapter(new WormPagerApdapter(getActivity().getSupportFragmentManager(),getContext(),data));
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    private void init(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
    }

}
