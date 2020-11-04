package com.example.myquizapplication.repository;

import com.example.myquizapplication.R;
import com.example.myquizapplication.models.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizRepository {
    private static QuizRepository sInstance;
    private List<Question> mQuestions;

    private QuizRepository() {
        mQuestions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mQuestions.add(new Question(R.string.question_australia, false));
            mQuestions.add(new Question(R.string.question_oceans, true));
            mQuestions.add(new Question(R.string.question_mideast, false));
            mQuestions.add(new Question(R.string.question_africa, true));
            mQuestions.add(new Question(R.string.question_americas, false));
            mQuestions.add(new Question(R.string.question_asia, false));
        }

    }

    public static void setInstance(QuizRepository instance) {
        sInstance = instance;
    }

    public List<Question> getQuestions() {
        return mQuestions;
    }

    public void setQuestions(List<Question> questions) {
        mQuestions = questions;
    }

    public static QuizRepository getInstance() {
        if (sInstance == null) {
            sInstance = new QuizRepository();
        }
        return sInstance;
    }
}
