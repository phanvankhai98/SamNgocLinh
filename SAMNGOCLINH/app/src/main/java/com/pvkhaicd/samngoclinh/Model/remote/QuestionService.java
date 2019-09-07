package com.pvkhaicd.samngoclinh.Model.remote;

import com.pvkhaicd.samngoclinh.Model.pojo.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface QuestionService {

    @GET("questions")
    Call<List<Question>> getQuestions();

    @GET("questions")
    Call<Question> getQuestionDetail(@Path("id") int id);
}
