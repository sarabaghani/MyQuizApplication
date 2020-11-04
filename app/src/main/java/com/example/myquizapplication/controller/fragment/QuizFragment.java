package com.example.myquizapplication.controller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myquizapplication.controller.activity.CheatActivity;
import com.example.myquizapplication.controller.activity.SettingActivity;
import com.example.myquizapplication.models.Question;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myquizapplication.R;
import com.example.myquizapplication.repository.QuizRepository;


public class QuizFragment extends Fragment {

    public static final String TAG = "QuizActivityTag";
    public static final int REQUEST_CODE_CHEAT = 0;
    public static final int REQUEST_CODE_SETTING = 1;
    private static final String BUNDLE_KEY_MY_CURRENT_INDEX = "my current index : ";
    private static final String BUNDLE_KEY_MY_SCORE = "myScore";
    private static final String BUNDLE_KEY_ANSWERED_LIST = "answeredList";
    public static final String BUNDLE_FONT_SIZE = "bundle font size";
    public static final String BUNDLE_BACKGROUND = "bundle background";
    public static final String MAIN_LAYOUT_VISIBILITY = "main layout visibility";
    public static final String GAMEOVER_LAYOUT_VISIBILITY = "gameover layout visibility";
    public static final String EXTRA_QUESTION_ANSWER = "com.example.myquizapplication.QuestionAnswer";
    public static final String BUNDLE_MAIN_BACKGROUND = "bundle main background";
    public static final String BUNDLE_MAIN_FONT_SIZE = "bundle main font size";
    public static final String BUNDLE_IS_CHEAT = "bundle is cheat";

    private ImageButton mTrueBtn;
    private ImageButton mFalseBtn;
    private TextView mTextViewQuestion;
    private Button mButtonNext;
    private Button mButtonPrev;
    private ImageButton mButtonFirst;
    private ImageButton mButtonLast;
    ArrayList<Integer> mAnsweredList = new ArrayList<Integer>();
    private TextView mScoreBoard;
    private TextView mUserScore;
    private ImageButton mButtonReset;
    ViewGroup gameOverLay;
    ViewGroup mainLay;
    private int mainVisibility;
    private int gameVisibility;
    private int mScore = 0;
    private Button mButtonCheat;
    private ImageButton mButtonSetting;
    private boolean mIsCheater = false;
    //setting
    private int mFontSize;//=20
    private int mFontSize2;
    private String mBackColor;//= "#C4B7DC"
    private String mBackColor2;
    //recently added and get in on create
    private QuizRepository mRepository;
    private List<Question> mQuestions;
    private int mIndex = 0;
   /* private Question[] mQuestions = {
            new Question(R.string.question_australia, false),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, true),
            new Question(R.string.question_americas, false),
            new Question(R.string.question_asia, false),
    };*/
   //above comment:array mQuestions replaced with list mQuestions gotten from repository.



    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepository = QuizRepository.getInstance();
        mIndex = getActivity().getIntent().getIntExtra(ListFragment.EXTRA_QUESTION_INDEX,0);
        mQuestions = mRepository.getQuestions();
       /* if (savedInstanceState != null) {
//            mIndex= savedInstanceState.getInt(BUNDLE_KEY_MY_CURRENT_INDEX);
            mIndex = savedInstanceState.getInt(BUNDLE_KEY_MY_CURRENT_INDEX, 0);
            mScore = savedInstanceState.getInt(BUNDLE_KEY_MY_SCORE);
            mAnsweredList = savedInstanceState.getIntegerArrayList(BUNDLE_KEY_ANSWERED_LIST);
            mBackColor2 = savedInstanceState.getString(BUNDLE_BACKGROUND);
            mFontSize2 = savedInstanceState.getInt(BUNDLE_FONT_SIZE);
            mFontSize = savedInstanceState.getInt(BUNDLE_MAIN_FONT_SIZE);
            mBackColor = savedInstanceState.getString(BUNDLE_MAIN_BACKGROUND);
            mIsCheater = savedInstanceState.getBoolean(BUNDLE_IS_CHEAT);

        }*/

        Log.d(TAG, "saved state: " + savedInstanceState);
        Log.d(TAG, "i'm on create!");
//        setContentView(R.layout.activity_quiz); //this one should be the first thing to do in onCreate method!!!!
//        findViews();
   /*     setListeners();
        updateQuestion();
        displayGameoverLayout();
        gameoverContents();
        if (savedInstanceState == null)
            mFontSize = 20;
        mFontSize2 = mFontSize;
        mTextViewQuestion.setTextSize(mFontSize);
        if (savedInstanceState == null)
            mBackColor = "#C4B7DC";
        mBackColor2 = mBackColor;
        mainLay.setBackgroundColor(Color.parseColor(mBackColor));*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt(BUNDLE_KEY_MY_CURRENT_INDEX);
//            mIndex = savedInstanceState.getInt(BUNDLE_KEY_MY_CURRENT_INDEX, 0);
            mScore = savedInstanceState.getInt(BUNDLE_KEY_MY_SCORE);
            mAnsweredList = savedInstanceState.getIntegerArrayList(BUNDLE_KEY_ANSWERED_LIST);
            mBackColor2 = savedInstanceState.getString(BUNDLE_BACKGROUND);
            mFontSize2 = savedInstanceState.getInt(BUNDLE_FONT_SIZE);
            mFontSize = savedInstanceState.getInt(BUNDLE_MAIN_FONT_SIZE);
            mBackColor = savedInstanceState.getString(BUNDLE_MAIN_BACKGROUND);
            mIsCheater = savedInstanceState.getBoolean(BUNDLE_IS_CHEAT);

        }
        findViews(view);
        setListeners();
        updateQuestion();
        displayGameoverLayout();
        gameoverContents();
        if (savedInstanceState == null) {
            mFontSize = 20;
            mFontSize2 = mFontSize;
            mTextViewQuestion.setTextSize(mFontSize);
        }
        if (savedInstanceState == null) {
            mBackColor = "#C4B7DC";
            mBackColor2 = mBackColor;
            mainLay.setBackgroundColor(Color.parseColor(mBackColor));
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "i'm on resume! ");
        mainLay.setBackgroundColor(Color.parseColor(mBackColor2));
        mTextViewQuestion.setTextSize(mFontSize2);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //alave bar chizhayi k khode os save karde dar bala, ma ham mitavanim be an ezafe konim:
        outState.putInt(BUNDLE_KEY_MY_CURRENT_INDEX, mIndex);
        outState.putInt(BUNDLE_KEY_MY_SCORE, mScore);
        outState.putIntegerArrayList(BUNDLE_KEY_ANSWERED_LIST, mAnsweredList);
        outState.putInt(BUNDLE_FONT_SIZE, mFontSize2);
        outState.putString(BUNDLE_BACKGROUND, mBackColor2);
        outState.putInt(BUNDLE_MAIN_FONT_SIZE, mFontSize);
        outState.putString(BUNDLE_MAIN_BACKGROUND, mBackColor);
        outState.putBoolean(BUNDLE_IS_CHEAT, mIsCheater);

        Log.d(TAG, "onSavedInstanceState: " + mIndex);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK || data == null)
            return;

        if (requestCode == REQUEST_CODE_CHEAT) {
            mIsCheater = data.getBooleanExtra(CheatFragment.EXTRA_IS_CHEAT, false);
        }
        if (requestCode == REQUEST_CODE_SETTING) {
            mFontSize = data.getIntExtra(SettingActivity.EXTRA_SIZE, 0);
            if (mFontSize != 0)
                mFontSize2 = mFontSize;
            mBackColor = data.getStringExtra(SettingActivity.EXTRA_BACK);
            if (mBackColor != null)
                mBackColor2 = mBackColor;
            mTrueBtn.setVisibility(data.getIntExtra(SettingActivity.EXTRA_TRUE_STATUS, 0));
            mFalseBtn.setVisibility(data.getIntExtra(SettingActivity.EXTRA_FALSE_STATUS, 0));
            mButtonPrev.setVisibility(data.getIntExtra(SettingActivity.EXTRA_PREV_STATUS, 0));
            mButtonNext.setVisibility(data.getIntExtra(SettingActivity.EXTRA_NEXT_STATUS, 0));
            mButtonFirst.setVisibility(data.getIntExtra(SettingActivity.EXTRA_FIRST_STATUS, 0));
            mButtonLast.setVisibility(data.getIntExtra(SettingActivity.EXTRA_LAST_STATUS, 0));
            mButtonCheat.setVisibility(data.getIntExtra(SettingActivity.EXTRA_CHEAT_STATUS, 0));
        }
//        mainLay.setBackgroundColor(Color.parseColor(mBackColor));
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
                mIndex = mIndex % mQuestions.size();
                updateQuestion();
            }
        });
        mButtonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndex = mIndex - 1;
                mIndex = (mIndex + mQuestions.size()) % mQuestions.size();
/*                if (mIndex < 0)
                    mIndex = mQuestions.length - 1;*/
                updateQuestion();
            }
        });
        mButtonLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndex = mQuestions.size() - 1;
                updateQuestion();
            }
        });
        mButtonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndex = 0;
                updateQuestion();
            }
        });
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameOverLay.setVisibility(View.GONE);
                mainLay.setVisibility(View.VISIBLE);
                mScore = 0;
                mAnsweredList.clear();
                mIndex = 0;
                updateQuestion();
                mTrueBtn.setEnabled(true);
                mFalseBtn.setEnabled(true);
                //layout background color review : (3 ways)
//                mainLay.setBackgroundColor(656454521);
//                int greenColorValue = Color.parseColor("#00ff00")
//                mainLay.setBackgroundColor(Color.parseColor("#00ff00"));
            }
        });
        mButtonCheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CheatActivity.class
                );
                intent.putExtra(EXTRA_QUESTION_ANSWER, mQuestions.get(mIndex).isAns());
//                startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE_CHEAT);
            }
        });
        mButtonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SettingActivity.class
                );
                startActivityForResult(intent, REQUEST_CODE_SETTING);
            }

        });
    }

    private void checkAns(boolean userPressed) {
        if (mIsCheater)
            Toast.makeText(getActivity(), R.string.cheat_warner, Toast.LENGTH_SHORT).show();
        else {
            if (mQuestions.get(mIndex).isAns() == userPressed) {
                Toast toast = Toast.makeText(getActivity(), R.string.true_toast, Toast.LENGTH_SHORT
                );
                toast.show();
                mScore += 1;
                Toast score = Toast.makeText(getActivity(), "your score is: " + mScore, Toast.LENGTH_LONG);
                score.setGravity(60, 0, 0);
                score.getView().setBackgroundColor(Color.rgb(146, 110, 174));
                score.show();
            } else {
                Toast toast = Toast.makeText(getActivity(), R.string.false_toast, Toast.LENGTH_SHORT
                );
                toast.show();
            }
        }
        mFalseBtn.setEnabled(false);
        mTrueBtn.setEnabled(false);
        mAnsweredList.add(mIndex);
        gameoverContents();
        displayGameoverLayout();
    }

    private void gameoverContents() {
        mScoreBoard.setText(R.string.final_score);
        mUserScore.setText((String.valueOf(mScore)));
    }

    private void displayGameoverLayout() {
        if (mAnsweredList.size() == mQuestions.size()) {
            gameOverLay.setVisibility(View.VISIBLE);
            mainLay.setVisibility(View.GONE);
        } else {
            gameOverLay.setVisibility(View.GONE);
        }
    }

    private void updateQuestion() {
        int questionTxtResId = mQuestions.get(mIndex).getQuesResId();
        mTextViewQuestion.setText(questionTxtResId);
        if (mAnsweredList.contains(mIndex)) {
            mFalseBtn.setEnabled(false);
            mTrueBtn.setEnabled(false);
        } else {
            mTrueBtn.setEnabled(true);
            mFalseBtn.setEnabled(true);
        }
        mIsCheater = false;
    }

    private void findViews(View view) {
        mFalseBtn = view.findViewById(R.id.false_btn);
        mTrueBtn = view.findViewById(R.id.true_btn);
        mTextViewQuestion = view.findViewById(R.id.question_txt);
        mButtonNext = view.findViewById(R.id.next_btn);
        mButtonPrev = view.findViewById(R.id.prev_btn);
        mButtonFirst = view.findViewById(R.id.first_btn);
        mButtonLast = view.findViewById(R.id.last_btn);
        mScoreBoard = view.findViewById(R.id.score_board);
        mUserScore = view.findViewById(R.id.user_score);
        mButtonReset = view.findViewById(R.id.reset_btn);
        mainLay = view.findViewById(R.id.main_layout);
        gameOverLay = view.findViewById(R.id.game_over_lay);
        mButtonCheat = view.findViewById(R.id.cheat_btn);
        mButtonSetting = view.findViewById(R.id.setting_btn);
    }
}