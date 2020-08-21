package com.example.myquizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueBtn;
    private Button mFalseBtn;
    private TextView mTextViewQuestion;
    private Button mButtonNext;
    private Button mButtonPrev;

    private int mScore=0;

    private int mIndex = 0;
    private Question[] mQuestions = {
            new Question(R.string.question_australia, false),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, true),
            new Question(R.string.question_americas, false),
            new Question(R.string.question_asia, false),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        findViews();
        setListeners();

        updateQuestion();


/*        //making view by code manually
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(Gravity.CENTER);
        TextView textView = new TextView(this);
        textView.setText("Hello im sara");
        textView.setTextSize(30);
        textView.setTextColor(Color.rgb(238,130,238));
        linearLayout.addView(textView);
        setContentView(linearLayout);*/
    }

    private void setListeners() {
        mTrueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAns(true);
                /*Toast toast = Toast.makeText(QuizActivity.this, R.string.true_toast, Toast.LENGTH_SHORT
                );
                toast.getView().setBackgroundColor(Color.GREEN);

                //setting toast text size (i made it bigger)
                ViewGroup group = (ViewGroup) toast.getView();
                TextView messageTextView = (TextView) group.getChildAt(0);
                messageTextView.setTextSize(30);*/

                /*Toast toastx = new Toast(QuizMainActivity.this);
                ImageView viewx = new ImageView(QuizMainActivity.this);
                viewx.setImageResource(R.drawable.true_toast_img);
                toast.setView(viewx);*/

//                toast.show();
//                mTextViewQuestion.setTextColor(Color.rgb(0, 255, 0));
            }
        });
        mFalseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
checkAns(false);
               /* Toast toast = Toast.makeText(QuizActivity.this, R.string.false_toast, Toast.LENGTH_SHORT
                );
                toast.setGravity(48, 0, 0);
                toast.getView().setBackgroundColor(Color.RED);
                ViewGroup group = (ViewGroup) toast.getView();
                TextView messageTextView = (TextView) group.getChildAt(0);
                messageTextView.setTextSize(30);*/

                /*Toast toastx = new Toast(QuizMainActivity.this);
                ImageView viewx = new ImageView(QuizMainActivity.this);
                viewx.setImageResource(R.drawable.false_toast_img);
                toast.setView(viewx);*/
//                toast.show();
//                mTextViewQuestion.setTextColor(Color.rgb(255, 0, 0));
            }
        });
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndex += 1;
                mIndex = mIndex % mQuestions.length;
                updateQuestion();
            }
        });
        mButtonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndex = mIndex - 1;
                if (mIndex < 0)
                    mIndex = mQuestions.length - 1;
                updateQuestion();
            }
        });
    }

    private void checkAns(boolean userPressed) {
        if (mQuestions[mIndex].isAns()==userPressed) {
            Toast toast = Toast.makeText(QuizActivity.this, R.string.true_toast, Toast.LENGTH_SHORT
            );
            toast.show();
            mScore+=1;
            Toast score=Toast.makeText(QuizActivity.this, "your score is: "+mScore, Toast.LENGTH_LONG);
            score.setGravity(48,0,0);
            score.show();
        }
        else {
            Toast toast = Toast.makeText(QuizActivity.this, R.string.false_toast, Toast.LENGTH_SHORT
            );
            toast.show();
        }
    }

    private void updateQuestion() {
        int questionTxtResId = mQuestions[mIndex].getQuesResId();
        mTextViewQuestion.setText(questionTxtResId);
    }

    private void findViews() {
        mFalseBtn = findViewById(R.id.false_btn);
        mTrueBtn = findViewById(R.id.true_btn);
        mTextViewQuestion = findViewById(R.id.question_txt);
        mButtonNext = findViewById(R.id.next_btn);
        mButtonPrev = findViewById(R.id.prev_btn);
    }
}