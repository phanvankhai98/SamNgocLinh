package com.pvkhaicd.samngoclinh.Network;

import com.pvkhaicd.samngoclinh.Model.ClimateNews;
import com.pvkhaicd.samngoclinh.Model.WormNewsEvent.WormNews;
import com.pvkhaicd.samngoclinh.Model.Question;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface APIService {
    @GET("climatenews")
    Call<ClimateNews> getClimateNews();

    @GET("wormnews")
    Call<WormNews> getWormNews();

    @GET("questions")
    Call<List<Question>> getQuestions();

    @GET("questions")
    Call<Question> getQuestionDetail(@Path("id") int id);
}