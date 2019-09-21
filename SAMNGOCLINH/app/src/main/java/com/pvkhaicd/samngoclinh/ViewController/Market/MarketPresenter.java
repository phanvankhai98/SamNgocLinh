package com.pvkhaicd.samngoclinh.ViewController.Market;

import com.pvkhaicd.samngoclinh.Model.MarketItem;
import com.pvkhaicd.samngoclinh.Network.APIService;
import com.pvkhaicd.samngoclinh.Network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarketPresenter implements MarketContact.Presenter {

    private MarketContact.View mView;
    private APIService mAPIService;

    public MarketPresenter(MarketContact.View view) {
        mView = view;
        mAPIService = RetrofitClient.getClient().create(APIService.class);
    }

    @Override
    public void getPurchaseList() {
        mAPIService.getMarketItems().enqueue(new Callback<List<MarketItem>>() {
            @Override
            public void onResponse(Call<List<MarketItem>> call, Response<List<MarketItem>> response) {
                if (response.isSuccessful()) {
                    mView.showPurchaseList(response.body());
                } else mView.showGetListError(null);
            }

            @Override
            public void onFailure(Call<List<MarketItem>> call, Throwable t) {
                mView.showGetListError(t.getMessage());
            }
        });
    }

    @Override
    public void getSellList() {
        mAPIService.getMarketItems().enqueue(new Callback<List<MarketItem>>() {
            @Override
            public void onResponse(Call<List<MarketItem>> call, Response<List<MarketItem>> response) {
                if (response.isSuccessful()) {
                    mView.showSellList(response.body());
                } else mView.showGetListError(null);
            }

            @Override
            public void onFailure(Call<List<MarketItem>> call, Throwable t) {
                mView.showGetListError(t.getMessage());
            }
        });
    }
}
