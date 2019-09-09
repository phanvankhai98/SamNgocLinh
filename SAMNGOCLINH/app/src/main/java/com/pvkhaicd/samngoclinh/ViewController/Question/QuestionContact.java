package com.pvkhaicd.samngoclinh.ViewController.Question;

import com.pvkhaicd.samngoclinh.Model.pojo.Question;

import java.util.List;

public interface QuestionContact {
    interface Presenter {
        void getQuestions();
    }

    interface View {
        void showQuestions(List<Question> questions);

        void showGetQuestionsFail(String message);
    }
}
