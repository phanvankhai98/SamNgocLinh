package com.pvkhaicd.samngoclinh.ViewController.Market;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;
import com.pvkhaicd.samngoclinh.Model.MarketItem;
import com.pvkhaicd.samngoclinh.Network.APIService;
import com.pvkhaicd.samngoclinh.Network.RetrofitClient;
import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.splash.SessionManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarketPostScreen extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextInputLayout mEditTextWeight;
    private TextInputLayout mEditTextAddress;
    private TextInputLayout mEditTextCounty;
    private TextInputLayout mEditTextCost;
    private Button mButtonPost;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_post_screen);
        final Intent intent = getIntent();
        String title;
        int pageType = intent.getIntExtra(MarketHolderFragment.PAGE_TYPE, 1);
        if (pageType == 1) {
            title = getResources().getString(R.string.button_title_purchase);
        } else title = getResources().getString(R.string.button_title_sell);
        initView(title);

        mButtonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MarketItem item = createPostItem();
                if (item != null) {
                    APIService service = RetrofitClient.getClient().create(APIService.class);
                    service.postMarketItem(item).enqueue(new Callback<MarketItem>() {
                        @Override
                        public void onResponse(Call<MarketItem> call, Response<MarketItem> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(MarketPostScreen.this, "Ok", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<MarketItem> call, Throwable t) {
                            Toast.makeText(MarketPostScreen.this, "Fail", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    private void initView(String title) {
        mToolbar = findViewById(R.id.toolbar_post);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(title);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mEditTextWeight = findViewById(R.id.text_input_weight);
        mEditTextAddress = findViewById(R.id.text_input_address);
        mEditTextCounty = findViewById(R.id.text_input_county);
        mEditTextCost = findViewById(R.id.text_input_cost);
        mButtonPost = findViewById(R.id.button_post);
    }

    private MarketItem createPostItem() {
        String weight = mEditTextWeight.getEditText().getText().toString();
        String address = mEditTextAddress.getEditText().getText().toString();
        String county = mEditTextCounty.getEditText().getText().toString();
        String cost = mEditTextCost.getEditText().getText().toString();
        if (weight.length() == 0) {
            mEditTextWeight.setError(getResources().getString(R.string.error_input));
            return null;
        }
        if (address.length() == 0) {
            mEditTextWeight.setError(getResources().getString(R.string.error_input));
            return null;
        }
        if (county.length() == 0) {
            mEditTextWeight.setError(getResources().getString(R.string.error_input));
            return null;
        }
        //user information
        SessionManager manager = new SessionManager(this);
        HashMap<String, String> user = manager.getUserDetail();
        String userName = user.get(SessionManager.KEY_NAME);
        String phone = user.get(SessionManager.KEY_PHONE_NUMBER);

        // clear text input form
        mEditTextWeight.getEditText().setText("");
        mEditTextAddress.getEditText().setText("");
        mEditTextCost.getEditText().setText("");
        mEditTextCounty.getEditText().setText("");
        mEditTextCost.clearFocus();
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        return new MarketItem(phone, weight, cost, address, timeStamp, county, userName);
    }
}
