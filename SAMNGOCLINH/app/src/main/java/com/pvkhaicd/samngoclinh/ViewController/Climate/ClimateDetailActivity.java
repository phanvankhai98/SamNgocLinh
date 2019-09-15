package com.pvkhaicd.samngoclinh.ViewController.Climate;

import android.content.Intent;
import androidx.core.text.HtmlCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.widget.TextView;

import com.pvkhaicd.samngoclinh.Model.Climate;
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
        Climate item = (Climate) intent.getSerializableExtra("data");
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
