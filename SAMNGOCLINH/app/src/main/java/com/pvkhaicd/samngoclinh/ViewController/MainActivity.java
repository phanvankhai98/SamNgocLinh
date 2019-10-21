package com.pvkhaicd.samngoclinh.ViewController;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Climate.ClimateFragment;
import com.pvkhaicd.samngoclinh.ViewController.General.GeneralFragment;
import com.pvkhaicd.samngoclinh.ViewController.General.PriceFragment;
import com.pvkhaicd.samngoclinh.ViewController.Handbook.HandbookFragment;
import com.pvkhaicd.samngoclinh.ViewController.Home.HomeFragment;
import com.pvkhaicd.samngoclinh.ViewController.Home.OnHomeItemClickListener;
import com.pvkhaicd.samngoclinh.ViewController.Market.MarketFragment;
import com.pvkhaicd.samngoclinh.ViewController.Question.QuestionFragment;
import com.pvkhaicd.samngoclinh.ViewController.UploadImage.UploadImageFragment;
import com.pvkhaicd.samngoclinh.ViewController.Worm.WormFragment;
import com.pvkhaicd.samngoclinh.ViewController.splash.SessionManager;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnHomeItemClickListener {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;

    private Map<String, String> mToolbarTitle;
    public static final String TAG_HOME = "home";
    public static final String TAG_NEWS = "weather";
    public static final String TAG_FAIR = "upload";
    public static final String TAG_ADVICE = "fertilizer";
    public static final String TAG_DIAGNOSIS = "climate";
    public static final String TAG_QUESTION = "market";
    public static final String TAG_SOURCE = "price";
    public static final String TAG_PEST = "pest";
    public static final String TAG_QA = "qa";
    public static final String TAG_QR_CODE = "qr code";
    private String mCurrentTag = TAG_HOME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getToolbarTitle();
        setToolbarTitle();

        loadFragment(mCurrentTag);
    }

    private void initView() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setItemIconTintList(null);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
        setUpUserData();
    }

    @Override
    public void onBackPressed() {
        if (!mCurrentTag.equals(TAG_HOME)) {
            mCurrentTag = TAG_HOME;
            loadFragment(mCurrentTag);
            return;
        }
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
                mCurrentTag = TAG_NEWS;
                break;
            case R.id.nav_upload:
                mCurrentTag = TAG_FAIR;
                break;
            case R.id.nav_advice:
                mCurrentTag = TAG_ADVICE;
                break;
            case R.id.nav_climate:
                mCurrentTag = TAG_DIAGNOSIS;
                break;
            case R.id.nav_price:
                mCurrentTag = TAG_SOURCE;
                break;
            case R.id.nav_question_answer:
                mCurrentTag = TAG_QA;
                break;
            case R.id.nav_logout:
                handlerLogout();
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
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        fragmentTransaction.replace(R.id.frame, fragment, tag);
        fragmentTransaction.commit();
        setToolbarTitle();
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    private Fragment getFragment(String tag) {
        Fragment fragment = null;
        switch (tag) {
            case TAG_NEWS:
                fragment = new GeneralFragment();
                break;
            case TAG_FAIR:
                fragment = new UploadImageFragment();
                break;
            case TAG_ADVICE:
                fragment = new HandbookFragment();
                break;
            case TAG_DIAGNOSIS:
                fragment = new ClimateFragment();
                break;
            case TAG_QUESTION:
                fragment = new MarketFragment();
                break;
            case TAG_SOURCE:
                fragment = new PriceFragment();
                break;
            case TAG_PEST:
                fragment = new WormFragment();
                break;
            case TAG_QA:
                fragment = new QuestionFragment();
                break;
            case TAG_QR_CODE:
                startActivity(new Intent(getApplicationContext(), QRScanActivity.class));
                Toast.makeText(MainActivity.this, "Quet ma QR", Toast.LENGTH_SHORT).show();
                break;
            default:
                fragment = new HomeFragment();

        }
        return fragment;
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof HomeFragment) {
            HomeFragment homeFragment = (HomeFragment) fragment;
            homeFragment.setOnHomeItemClickListener(this);
        }
    }

    private void getToolbarTitle() {
        mToolbarTitle = new HashMap<>();
        mToolbarTitle.put(TAG_HOME, getResources().getString(R.string.app_name));
        mToolbarTitle.put(TAG_QUESTION, getResources().getString(R.string.market));
        mToolbarTitle.put(TAG_NEWS, getResources().getString(R.string.news));
        mToolbarTitle.put(TAG_FAIR, getResources().getString(R.string.fair));
        mToolbarTitle.put(TAG_ADVICE, getResources().getString(R.string.advice));
        mToolbarTitle.put(TAG_DIAGNOSIS, getResources().getString(R.string.diagnosis));
        mToolbarTitle.put(TAG_SOURCE, getResources().getString(R.string.source));
        mToolbarTitle.put(TAG_PEST, getResources().getString(R.string.source));
        mToolbarTitle.put(TAG_QA, getResources().getString(R.string.question));
        mToolbarTitle.put(TAG_QR_CODE, getResources().getString(R.string.scan_QR));
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(null);
        TextView title = mToolbar.findViewById(R.id.title);
        title.setText(mToolbarTitle.get(mCurrentTag));
    }

    private void setUpUserData() {
        TextView text_name, text_phone;
        View headerView = mNavigationView.getHeaderView(0);
        text_name = headerView.findViewById(R.id.title_nav_name);
        text_phone = headerView.findViewById(R.id.title_nav_phone_number);
        SessionManager manager = new SessionManager(this);
        HashMap<String, String> userDetail = manager.getUserDetail();
        if (userDetail.size() > 0) {
            String user = userDetail.get(SessionManager.KEY_NAME);
            String phone = userDetail.get(SessionManager.KEY_PHONE_NUMBER);
            if (user == null || user.length() == 0 || phone == null || phone.length() == 0) {
                manager.logoutUser();
            }

            text_name.setText(user);
            text_phone.setText(phone);
        }
    }

    private void handlerLogout() {
        SessionManager manager = new SessionManager(this);
        manager.logoutUser();
    }

    @Override
    public void onHomeItemClick(String tag) {
        mCurrentTag = tag;
        loadFragment(tag);
    }

}
