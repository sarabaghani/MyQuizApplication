package com.example.myquizapplication.controller.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myquizapplication.R;
import com.example.myquizapplication.controller.activity.QuizActivity;


public class CheatFragment extends Fragment {
    public static final String EXTRA_IS_CHEAT = " com.example.myquizapplication.isCheat";
    private boolean mIsAnsTrue;
    private TextView mTextViewAnswer;
    private Button mButtonShowAns;


    public CheatFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cheat, container, false);

        Intent startIntent = getActivity().getIntent();
        mIsAnsTrue = startIntent.getBooleanExtra(QuizActivity.EXTRA_QUESTION_ANSWER,
                false);
        findViews(view);
        setListeners();

        return view;

    }

    private void setListeners() {
        mButtonShowAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mIsAnsTrue)
                    mTextViewAnswer.setText(R.string.button_true);
                else
                    mTextViewAnswer.setText(R.string.button_false);
                cheatReport(true);
            }
        });
    }

    private void cheatReport(boolean isCheat) {
        Intent data = new Intent();
        data.putExtra(EXTRA_IS_CHEAT, isCheat);
        getActivity().setResult(Activity.RESULT_OK, data);
    }

    private void findViews(View view) {
        mTextViewAnswer = view.findViewById(R.id.textView_answer);
        mButtonShowAns = view.findViewById(R.id.show_ans_btn);
    }

}