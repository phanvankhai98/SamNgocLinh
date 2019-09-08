package com.pvkhaicd.samngoclinh.ViewController;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Advice.AdviceFragment;
import com.pvkhaicd.samngoclinh.ViewController.Climate.ClimateFragment;
import com.pvkhaicd.samngoclinh.ViewController.Market.MarketFragment;
import com.pvkhaicd.samngoclinh.ViewController.Price.PriceFragment;
import com.pvkhaicd.samngoclinh.ViewController.Question.QuestionFragment;
import com.pvkhaicd.samngoclinh.ViewController.WeatherInfo.WeatherFragment;
import com.pvkhaicd.samngoclinh.ViewController.Worm.WormFragment;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;

    private Map<String, String> mToolbarTitle;
    private static final String TAG_HOME = "home";
    private static final String TAG_WEATHER = "weather";
    private static final String TAG_UPLOAD_IMG = "upload";
    private static final String TAG_FERTILIZER_ADVICE = "fertilizer";
    private static final String TAG_CLIMATE_CHANGE = "climate";
    private static final String TAG_MARKET = "market";
    private static final String TAG_PRICE = "price";
    private static final String TAG_PEST = "pest";
    private static final String TAG_QA = "qa";
    private static final String TAG_QR_CODE = "qr code";
    private String mCurrentTag = TAG_HOME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getToolbarTitle();
    }

    private void initView() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
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
        switch (id) {
            case R.id.nav_weather:
                mCurrentTag = TAG_WEATHER;
                break;
            case R.id.nav_upload:
                mCurrentTag = TAG_UPLOAD_IMG;
                break;
            case R.id.nav_advice:
                mCurrentTag = TAG_FERTILIZER_ADVICE;
                break;
            case R.id.nav_climate:
                mCurrentTag = TAG_CLIMATE_CHANGE;
                break;
            case R.id.nav_price:
                mCurrentTag = TAG_PRICE;
                break;
            case R.id.nav_buy:
                mCurrentTag = TAG_MARKET;
                break;
            case R.id.nav_worm:
                mCurrentTag = TAG_PEST;
                break;
            case R.id.nav_question_answer:
                mCurrentTag = TAG_QA;
                break;
            case R.id.nav_scan_qr:
                mCurrentTag = TAG_QR_CODE;
                break;
            default:
                mCurrentTag = TAG_HOME;
        }
        loadFragment(mCurrentTag);
        return true;
    }

    private void loadFragment(String tag) {
        Fragment fragment = getFragment(tag);
        if (fragment == null) return;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment, tag);
        fragmentTransaction.commit();
        setToolbarTitle();
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    private Fragment getFragment(String tag) {
        Fragment fragment = null;
        switch (tag) {
            case TAG_WEATHER:
                fragment = new WeatherFragment();
                break;
            case TAG_UPLOAD_IMG:
                Toast.makeText(this, "upload anh", Toast.LENGTH_SHORT).show();
                break;
            case TAG_FERTILIZER_ADVICE:
                fragment = new AdviceFragment();
                break;
            case TAG_CLIMATE_CHANGE:
                fragment = new ClimateFragment();
                break;
            case TAG_MARKET:
                fragment = new MarketFragment();
                break;
            case TAG_PRICE:
                fragment = new PriceFragment();
                break;
            case TAG_PEST:
                fragment = new WormFragment();
                break;
            case TAG_QA:
                fragment = new QuestionFragment();
                break;
            case TAG_QR_CODE:
                Toast.makeText(this, "Quet ma QR", Toast.LENGTH_SHORT).show();
                break;
            default:

        }
        return fragment;
    }

    private void getToolbarTitle() {
        mToolbarTitle = new HashMap<>();
        mToolbarTitle.put(TAG_HOME, getResources().getString(R.string.app_name));
        mToolbarTitle.put(TAG_WEATHER, getResources().getString(R.string.weather));
        mToolbarTitle.put(TAG_UPLOAD_IMG, getResources().getString(R.string.upload_image));
        mToolbarTitle.put(TAG_FERTILIZER_ADVICE, getResources().getString(R.string.advice));
        mToolbarTitle.put(TAG_CLIMATE_CHANGE, getResources().getString(R.string.climate));
        mToolbarTitle.put(TAG_PRICE, getResources().getString(R.string.price));
        mToolbarTitle.put(TAG_PEST, getResources().getString(R.string.price));
        mToolbarTitle.put(TAG_QA, getResources().getString(R.string.question));
        mToolbarTitle.put(TAG_QR_CODE, getResources().getString(R.string.scan_QR));
    }

    private void setToolbarTitle() {
        if(mToolbar!=null) mToolbar.setTitle(mToolbarTitle.get(mCurrentTag));
    }
}
