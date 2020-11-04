package com.example.myquizapplication.controller.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myquizapplication.R;
import com.example.myquizapplication.controller.activity.QuizActivity;
import com.example.myquizapplication.models.Question;
import com.example.myquizapplication.repository.QuizRepository;

import java.util.List;


public class ListFragment extends Fragment {

    public static final String EXTRA_QUESTION_INDEX = "extra question index";
    private QuizRepository mRepository;
    private RecyclerView mRecyclerView;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepository = QuizRepository.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        findViews(view);
        initViews();
        return view;

    }

    private void initViews() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<Question> questions = mRepository.getQuestions();
        QuestionAdapter questionAdapter = new QuestionAdapter(questions);
        mRecyclerView.setAdapter(questionAdapter);

    }

    private void findViews(View view) {
        mRecyclerView = view.findViewById(R.id.rv_question_list);
    }

    private class QuestionHolder extends RecyclerView.ViewHolder {

        private Question mQuestion;
        private TextView mTextViewQues;
        private CheckBox mCheckBoxAns;

        public void bindQuestions(Question question) {
            mCheckBoxAns.setChecked(question.isAns());
            mTextViewQues.setText(question.getQuesResId());
            mCheckBoxAns.setEnabled(false);
            mQuestion = question;
        }

        public QuestionHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewQues = itemView.findViewById(R.id.question_row_txtv);
            mCheckBoxAns = itemView.findViewById(R.id.answer_row_chkbx);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), QuizActivity.class);
                    intent.putExtra(EXTRA_QUESTION_INDEX, mRepository.getQuestions().indexOf(mQuestion));
                    startActivity(intent);
                }
            });
        }
    }

    private class QuestionAdapter extends RecyclerView.Adapter<QuestionHolder> {
        private List<Question> mQuestions;

        public List<Question> getQuestions() {
            return mQuestions;
        }

        public void setQuestions(List<Question> questions) {
            mQuestions = questions;
        }

        public QuestionAdapter(List<Question> questions) {
            mQuestions = questions;
        }

        @NonNull
        @Override
        public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.row_items, parent, false);
            QuestionHolder questionHolder = new QuestionHolder(view);
            return questionHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull QuestionHolder holder, int position) {

            Question question = mQuestions.get(position);
            holder.bindQuestions(question);
        }

        @Override
        public int getItemCount() {
            return mQuestions.size();
        }
    }
}