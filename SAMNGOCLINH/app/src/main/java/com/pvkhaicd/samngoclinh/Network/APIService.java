package com.pvkhaicd.samngoclinh.Network;

import com.pvkhaicd.samngoclinh.Model.ClimateNews;
import com.pvkhaicd.samngoclinh.Model.MarketItem;
import com.pvkhaicd.samngoclinh.Model.Question;
import com.pvkhaicd.samngoclinh.Model.Weather.WeatherData;
import com.pvkhaicd.samngoclinh.Model.WormNewsEvent.WormNews;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface APIService {
    @GET("climatenews")
    Call<ClimateNews> getClimateNews();

    @GET("wormnews")
    Call<WormNews> getWormNews();

    @GET("questions")
    Call<List<Question>> getQuestions();

    @GET("questions")
    Call<Question> getQuestionDetail(@Path("id") int id);

    @GET("purchase_items")
    Call<List<MarketItem>> getMarketItems();

    @GET("purchase_items")
    Call<MarketItem> getMarketItem(@Path("id") int id);

    @POST("purchase_items")
    Call<MarketItem> postMarketItem(@Body MarketItem item);

    interface WeatherService {
        @GET("weather")
        Call<WeatherData> getWeatherData(@Query("lat") double lat, @Query("lon") double lon, @Query("APPID") String api_key);
    }

}