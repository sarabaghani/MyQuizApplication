package com.example.myquizapplication.controller.activity;

import androidx.fragment.app.Fragment;

import com.example.myquizapplication.controller.fragment.CheatFragment;

public class CheatActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return new CheatFragment();
    }}

    /*public static final String EXTRA_IS_CHEAT = " com.example.myquizapplication.isCheat";
        private boolean mIsAnsTrue;
        private TextView mTextViewAnswer;
        private Button mButtonShowAns;
    */
    //singleFragmentActivity extended.
   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        FragmentManager fragmentManager = getSupportFragmentManager();
        CheatFragment cheatFragment = new CheatFragment();
        Fragment fragment = fragmentManager.findFragmentById(R.id.cheat_container);
        if (fragment == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.cheat_container, cheatFragment)
                    .commit();
        }*/
       /* Intent startIntent = getIntent();
        mIsAnsTrue = startIntent.getBooleanExtra(QuizActivity.EXTRA_QUESTION_ANSWER,
                false);
        findViews();
        setListeners();
    }*/

   /* private void setListeners() {
        mButtonShowAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mIsAnsTrue)
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
        setResult(RESULT_OK , data);
    }

    private void findViews() {
        mTextViewAnswer = findViewById(R.id.textView_answer);
        mButtonShowAns = findViewById(R.id.show_ans_btn);
    }
*/

//    }}