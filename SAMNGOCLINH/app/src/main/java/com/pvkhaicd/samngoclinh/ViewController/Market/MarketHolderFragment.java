package com.pvkhaicd.samngoclinh.ViewController.Market;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pvkhaicd.samngoclinh.Model.MarketItem;
import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.OnItemClickListener;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.market.MarketAdapter;

import java.util.List;

public class MarketHolderFragment extends Fragment implements MarketContact.View, OnItemClickListener, View.OnClickListener {

    public static final String PAGE_TYPE = "page_type";
    public static final int PURCHASE_PAGE = 1;
    public static final int SELL_PAGE = 2;
    private int mPageType = 1;

    public static MarketHolderFragment getInstance(int pageType) {
        MarketHolderFragment marketHolderFragment = new MarketHolderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PAGE_TYPE, pageType);
        marketHolderFragment.setArguments(bundle);
        return marketHolderFragment;
    }

    RecyclerView mRecyclerView;
    Button mButton;
    MarketAdapter mMarketAdapter;
    private MarketContact.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_market_pagger, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_market);
        mButton = view.findViewById(R.id.button_market);
        mPageType = getArguments().getInt(PAGE_TYPE);
        mPresenter = new MarketPresenter(this);
        startGetContent();
        mButton.setOnClickListener(this);
        return view;
    }

    private void startGetContent() {
        if (mPageType == PURCHASE_PAGE) {
            mButton.setText(getResources().getString(R.string.button_title_purchase));
            mPresenter.getPurchaseList();
        } else {
            mButton.setText(getResources().getString(R.string.button_title_sell));
            mPresenter.getSellList();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        startGetContent();
    }

    @Override
    public void showPurchaseList(List<MarketItem> items) {
        mMarketAdapter = new MarketAdapter(getContext(), items);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mMarketAdapter);
        mMarketAdapter.setOnItemClickListener(this);
    }

    @Override
    public void showSellList(List<MarketItem> items) {
        mMarketAdapter = new MarketAdapter(getContext(), items);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mMarketAdapter);
        mMarketAdapter.setOnItemClickListener(this);
    }

    @Override
    public void showGetListError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClicked(int position) {
        if (mMarketAdapter != null) {
            Intent intent = new Intent(getContext(), MarketDetail.class);
            intent.putExtra("market", mMarketAdapter.getData().get(position));
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), MarketPostScreen.class);
        intent.putExtra(PAGE_TYPE, mPageType);
        startActivity(intent);
    }
}
