package com.pvkhaicd.samngoclinh.Network;

import com.pvkhaicd.samngoclinh.Model.ClimateN;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    @GET("wormnews")
    Call<ClimateN> getClimateNews();
}