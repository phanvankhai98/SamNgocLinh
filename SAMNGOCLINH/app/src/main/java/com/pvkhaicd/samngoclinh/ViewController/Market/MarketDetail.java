package com.pvkhaicd.samngoclinh.ViewController.Market;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.pvkhaicd.samngoclinh.Model.MarketItem;
import com.pvkhaicd.samngoclinh.R;

public class MarketDetail extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView mTextPhoneNumber;
    private TextView mTextWeight;
    private TextView mTextAddress;
    private TextView mTextViewTime;
    private TextView mTextViewCost;
    private TextView mTextViewCounty;
    private TextView mTextViewPublisher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_detail);
        initView();
        Intent intent = getIntent();
        MarketItem item = intent.getParcelableExtra("market");
        if (item != null) {
            setData(item);
        }
    }

    private void initView() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setTitle(R.string.market);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mTextPhoneNumber = findViewById(R.id.text_phone_number);
        mTextWeight = findViewById(R.id.text_weight);
        mTextAddress = findViewById(R.id.text_address);
        mTextViewTime = findViewById(R.id.text_time);
        mTextViewCost = findViewById(R.id.text_cost);
        mTextViewCounty = findViewById(R.id.text_county);
        mTextViewPublisher = findViewById(R.id.text_publisher);
    }

    private void setData(MarketItem item) {
        mTextPhoneNumber.setText(item.getPhoneNumber());
        mTextWeight.setText(item.getWeight());
        mTextViewCost.setText(item.getCost());
        mTextAddress.setText(item.getAddress());
        mTextViewTime.setText(item.getTime());
        mTextViewCounty.setText(item.getCounty());
        mTextViewPublisher.setText(item.getPublisher());
    }
}
