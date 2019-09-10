package com.pvkhaicd.samngoclinh.Network;

import com.pvkhaicd.samngoclinh.Model.ClimateNews;
import com.pvkhaicd.samngoclinh.Model.WormNewsEvent.WormNews;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("climatenews")
    Call<ClimateNews> getClimateNews();

    @GET("wormnews")
    Call<WormNews> getWormNews();
}