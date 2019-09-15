package com.pvkhaicd.samngoclinh.ViewController.Question;


import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.OnItemClickListener;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.QuestionAdapter;
import com.pvkhaicd.samngoclinh.Model.pojo.Question;

import java.util.List;

public class QuestionFragment extends Fragment implements QuestionContact.View {

    private RecyclerView mRecyclerViewQuestions;
    private QuestionAdapter mQuestionAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // setup presenter
        QuestionPresenter questionPresenter = new QuestionPresenter(this);
        questionPresenter.getQuestions();

        mRecyclerViewQuestions = view.findViewById(R.id.recycler_questions);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_question_screen, menu);
        MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (mQuestionAdapter != null) mQuestionAdapter.getFilter().filter(s);
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showQuestions(List<Question> questions) {
        mQuestionAdapter = new QuestionAdapter(getContext(), questions);
        mRecyclerViewQuestions.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerViewQuestions.setAdapter(mQuestionAdapter);
        mQuestionAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClicked(int position) {
                Question question = mQuestionAdapter.getData().get(position);
                Intent intent = new Intent(getContext(), QuestionDetail.class);
                intent.putExtra("Question", question);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showGetQuestionsFail(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
