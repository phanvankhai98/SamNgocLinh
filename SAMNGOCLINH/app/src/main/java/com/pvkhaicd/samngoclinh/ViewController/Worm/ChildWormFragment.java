package com.pvkhaicd.samngoclinh.ViewController.Worm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pvkhaicd.samngoclinh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildWormFragment extends Fragment {


    public ChildWormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false);
    }

}
