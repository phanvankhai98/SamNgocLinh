package com.pvkhaicd.samngoclinh.ViewController.Climate;

import android.content.Intent;
import android.support.v4.text.HtmlCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.pvkhaicd.samngoclinh.Model.ClimateNews;
import com.pvkhaicd.samngoclinh.R;

public class ClimateDetailActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_climate_detail);

        init();
        configToolbar();
        Intent intent = getIntent();
        ClimateNews  item = (ClimateNews) intent.getSerializableExtra("data");
        textView.setText(HtmlCompat.fromHtml(item.getContent(),0) );
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    
    private void configToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    private void init() {
        textView = findViewById(R.id.tv_content);
        toolbar = findViewById(R.id.toolbar);
    }
}
