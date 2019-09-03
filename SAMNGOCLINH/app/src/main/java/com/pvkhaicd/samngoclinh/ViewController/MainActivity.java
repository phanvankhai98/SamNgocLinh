package com.pvkhaicd.samngoclinh.ViewController;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Advice.AdviceFragment;
import com.pvkhaicd.samngoclinh.ViewController.Climate.ClimateFragment;
import com.pvkhaicd.samngoclinh.ViewController.Market.MarketFragment;
import com.pvkhaicd.samngoclinh.ViewController.Price.PriceFragment;
import com.pvkhaicd.samngoclinh.ViewController.Question.QuestionFragment;
import com.pvkhaicd.samngoclinh.ViewController.WeatherInfo.WeatherFragment;
import com.pvkhaicd.samngoclinh.ViewController.Worm.WormFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment;
        if (id == R.id.nav_weather) {
            fragment = new WeatherFragment();
            displaySelectedFragment(fragment);
        } else if (id == R.id.nav_upload) {
            Toast.makeText(this, "upload anh", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_advice) {
            fragment = new AdviceFragment();
            displaySelectedFragment(fragment);
        } else if (id == R.id.nav_climate) {
            fragment = new ClimateFragment();
            displaySelectedFragment(fragment);
        } else if (id == R.id.nav_price) {
            fragment = new PriceFragment();
            displaySelectedFragment(fragment);
        } else if (id == R.id.nav_buy) {
            fragment = new MarketFragment();
            displaySelectedFragment(fragment);
        } else if (id == R.id.nav_worm) {
            fragment = new WormFragment();
            displaySelectedFragment(fragment);
        } else if (id == R.id.nav_question_answer) {
            fragment = new QuestionFragment();
            displaySelectedFragment(fragment);
        } else if (id == R.id.nav_scan_qr) {
            Toast.makeText(this, "Quet ma QR", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void displaySelectedFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }
}
