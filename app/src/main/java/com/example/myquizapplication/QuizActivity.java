package com.example.myquizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueBtn;
    private Button mFalseBtn;
    private TextView mTextViewQuestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        findViews();
        setListeners();

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
                Toast toast = Toast.makeText(QuizActivity.this, R.string.true_toast, Toast.LENGTH_SHORT
                );
                toast.getView().setBackgroundColor(Color.GREEN);

                //setting toast text size (i made it bigger)
                ViewGroup group = (ViewGroup) toast.getView();
                TextView messageTextView = (TextView) group.getChildAt(0);
                messageTextView.setTextSize(30);

                /*Toast toastx = new Toast(QuizMainActivity.this);
                ImageView viewx = new ImageView(QuizMainActivity.this);
                viewx.setImageResource(R.drawable.true_toast_img);
                toast.setView(viewx);*/

                toast.show();
                mTextViewQuestion.setTextColor(Color.rgb(0,255,0));
            }
        });
        mFalseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast toast = Toast.makeText(QuizActivity.this, R.string.false_toast, Toast.LENGTH_SHORT
                );
                toast.setGravity(48,0,0);
                toast.getView().setBackgroundColor(Color.RED);
                ViewGroup group = (ViewGroup) toast.getView();
                TextView messageTextView = (TextView) group.getChildAt(0);
                messageTextView.setTextSize(30);

                /*Toast toastx = new Toast(QuizMainActivity.this);
                ImageView viewx = new ImageView(QuizMainActivity.this);
                viewx.setImageResource(R.drawable.false_toast_img);
                toast.setView(viewx);*/
                toast.show();
                mTextViewQuestion.setTextColor(Color.rgb(255,0,0));
            }
        });
    }

    private void findViews() {
        mFalseBtn = findViewById(R.id.false_btn);
        mTrueBtn = findViewById(R.id.true_btn);
        mTextViewQuestion = findViewById(R.id.question_txt);
    }
}