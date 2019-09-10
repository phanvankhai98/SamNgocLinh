package com.pvkhaicd.samngoclinh.ViewController.Question;

import com.pvkhaicd.samngoclinh.Model.Question;
import com.pvkhaicd.samngoclinh.Network.APIService;
import com.pvkhaicd.samngoclinh.Network.RetrofitClient;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionPresenter implements QuestionContact.Presenter {

    private APIService mService;
    private QuestionContact.View mView;

    public QuestionPresenter(QuestionContact.View view) {
        mService = RetrofitClient.getClient().create(APIService.class);
        mView = view;
    }

    @Override
    public void getQuestions() {
        mService.getQuestions().enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                if(response.isSuccessful()){
                    mView.showQuestions(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                mView.showGetQuestionsFail(t.getMessage());
            }
        });
    }
}
