package com.pvkhaicd.samngoclinh.ViewController.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pvkhaicd.samngoclinh.Model.Home;
import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.HomeAdapter;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.OnItemClickListener;
import com.pvkhaicd.samngoclinh.ViewController.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements OnItemClickListener {

    private OnHomeItemClickListener mOnHomeItemClickListener;
    private RecyclerView mRecyclerViewHome;
    private HomeAdapter mHomeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerViewHome = view.findViewById(R.id.recycler_home);
        mHomeAdapter = new HomeAdapter(getContext(), createListHome());
        mRecyclerViewHome.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRecyclerViewHome.setAdapter(mHomeAdapter);
        mHomeAdapter.setOnItemClickListener(this);
        return view;
    }

    public void setOnHomeItemClickListener(OnHomeItemClickListener onHomeItemClickListener) {
        mOnHomeItemClickListener = onHomeItemClickListener;
    }

    private List<Home> createListHome() {
        List<Home> homes = new ArrayList<>();
        homes.add(new Home(MainActivity.TAG_WEATHER, getResources().getString(R.string.weather), R.mipmap.weather));
        homes.add(new Home(MainActivity.TAG_UPLOAD_IMG, getResources().getString(R.string.upload_image), R.mipmap.upload));
        homes.add(new Home(MainActivity.TAG_FERTILIZER_ADVICE, getResources().getString(R.string.advice), R.mipmap.advice));
        homes.add(new Home(MainActivity.TAG_CLIMATE_CHANGE, getResources().getString(R.string.climate), R.mipmap.climate));
        homes.add(new Home(MainActivity.TAG_PRICE, getResources().getString(R.string.price), R.mipmap.price_tag));
        homes.add(new Home(MainActivity.TAG_MARKET, getResources().getString(R.string.market), R.mipmap.market));
        homes.add(new Home(MainActivity.TAG_PEST, getResources().getString(R.string.worm), R.mipmap.worm));
        homes.add(new Home(MainActivity.TAG_QR_CODE, getResources().getString(R.string.scan_QR), R.mipmap.qr_scan));
        homes.add(new Home(MainActivity.TAG_QA, getResources().getString(R.string.question), R.mipmap.question));
        return homes;
    }

    @Override
    public void onItemClicked(int position) {
        if(mHomeAdapter!=null) {
            Home home = mHomeAdapter.getData().get(position);
            if(mOnHomeItemClickListener!=null) mOnHomeItemClickListener.onHomeItemClick(home.getTagName());
        }
    }
}
