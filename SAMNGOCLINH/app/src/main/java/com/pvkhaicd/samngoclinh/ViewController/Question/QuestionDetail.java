package com.pvkhaicd.samngoclinh.ViewController.Question;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.Model.pojo.Question;

public class QuestionDetail extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView mTextQuestionTitle;
    private ImageView mImageQuesion;
    private TextView mTextAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);
        initView();

        Intent intent = getIntent();
        Question question = intent.getParcelableExtra("Question");
        if (question != null) setData(question);

    }

    void initView() {
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.question);
        mTextQuestionTitle = findViewById(R.id.text_question_title);
        mImageQuesion = findViewById(R.id.image_question);
        mTextAnswer = findViewById(R.id.text_answer);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    void setData(Question question) {
        mTextQuestionTitle.setText(question.getQuestion());
        if (question.isAnswered()) mTextAnswer.setText(question.getAnswer());
    }
}
