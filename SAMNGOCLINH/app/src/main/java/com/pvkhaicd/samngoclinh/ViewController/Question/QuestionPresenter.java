package com.pvkhaicd.samngoclinh.ViewController.Question;

import com.pvkhaicd.samngoclinh.Model.pojo.Question;
import com.pvkhaicd.samngoclinh.Model.remote.QuestionService;
import com.pvkhaicd.samngoclinh.Model.remote.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionPresenter implements QuestionContact.Presenter {

    private QuestionService mService;
    private QuestionContact.View mView;

    public QuestionPresenter(QuestionContact.View view) {
        mService = RetrofitClient.getClient().create(QuestionService.class);
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
