package com.example.myquizapplication;

public class Question {
    private String mTxt;
    private boolean mAns;
    private int mQuesResId;

    public Question() {
    }

    public Question(int quesResId,boolean ans) {
        mAns = ans;
        mQuesResId = quesResId;
    }

    public boolean isAns() {
        return mAns;
    }

    public void setAns(boolean ans) {
        mAns = ans;
    }

    public int getQuesResId() {
        return mQuesResId;
    }

    public void setQuesResId(int quesResId) {
        mQuesResId = quesResId;
    }

}
