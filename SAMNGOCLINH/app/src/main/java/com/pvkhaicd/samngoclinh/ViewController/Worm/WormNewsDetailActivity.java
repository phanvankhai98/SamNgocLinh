package com.pvkhaicd.samngoclinh.ViewController.Worm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.text.HtmlCompat;

import com.pvkhaicd.samngoclinh.Model.WormNewsEvent.Worm;
import com.pvkhaicd.samngoclinh.R;

public class WormNewsDetailActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_climate_detail);

        init();
        configToolbar();
        Intent intent = getIntent();
        Worm item = (Worm) intent.getSerializableExtra("data");
        textView.setText(HtmlCompat.fromHtml(item.getContent(), 0));
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
