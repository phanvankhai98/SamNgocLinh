package com.pvkhaicd.samngoclinh.ViewController.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.pvkhaicd.samngoclinh.Model.pojo.Question;
import com.pvkhaicd.samngoclinh.R;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends BaseAdapter<Question, QuestionAdapter.ViewHolder> implements Filterable {

    private List<Question> mQuestionsFullList;
    private OnItemClickListener mOnItemClickListener;
    private Filter mQuestionFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Question> filteredQuestion = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredQuestion.addAll(mQuestionsFullList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Question question : mQuestionsFullList) {
                    if (question.getQuestion().toLowerCase().contains(filterPattern)
                            || question.getPublisher().toLowerCase().contains(filterPattern)
                            || question.getDate().toLowerCase().contains(filterPattern)) {
                        filteredQuestion.add(question);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredQuestion;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            setData((List<Question>) results.values);
        }
    };

    public QuestionAdapter(Context context, List<Question> data) {
        super(context, data);
        mQuestionsFullList = new ArrayList<>(data);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_question_recycler_view, viewGroup, false);
        return new ViewHolder(view, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindView(getData().get(i));
    }

    @Override
    public Filter getFilter() {
        return mQuestionFilter;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextQuestionTitle;
        private TextView mTextQuestionStatus;
        private TextView mTextDateTime;
        private TextView mTextPublisher;
        //listener
        private OnItemClickListener mOnItemClickListener;

        ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            mTextQuestionTitle = itemView.findViewById(R.id.text_question_title);
            mTextQuestionStatus = itemView.findViewById(R.id.text_question_status);
            mTextDateTime = itemView.findViewById(R.id.text_date_time);
            mTextPublisher = itemView.findViewById(R.id.text_publisher);
            this.mOnItemClickListener = listener;
            itemView.setOnClickListener(this);
        }

        private void bindView(Question item) {
            mTextQuestionTitle.setText(item.getQuestion());
            if (item.isAnswered()) {
                mTextQuestionStatus.setText(R.string.question_status_true);
            } else mTextQuestionStatus.setText(R.string.question_status_false);
            mTextDateTime.setText(item.getDate());
            mTextPublisher.setText(item.getPublisher());
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null)
                mOnItemClickListener.onItemClicked(getAdapterPosition());
        }
    }
}
