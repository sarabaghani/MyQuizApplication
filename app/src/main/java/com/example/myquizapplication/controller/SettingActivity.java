package com.example.myquizapplication.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myquizapplication.R;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {
    /*    public static final String EXTRA_SMALL_SIZE = "com.example.myquizapplication.small size";
        public static final String EXTRA_MEDIUM_SIZE = "com.example.myquizapplication.medium size";
        public static final String EXTRA_LARGE_SIZE = "com.example.myquizapplication.lareg size";
        public static final String EXTRA_DEFAULT_SIZE = "com.example.myquizapplication.default size";*/
    public static final String EXTRA_SIZE = "com.example.myquizapplication.size";
    public static final String EXTRA_BACK = "com.example.myquizapplication.redBack";
    public static final String EXTRA_TRUE_STATUS = "extra true status";
    public static final String EXTRA_FALSE_STATUS = "extra false status";
    public static final String EXTRA_PREV_STATUS = "extra prev status";
    public static final String EXTRA_NEXT_STATUS = "extra next status";
    public static final String EXTRA_FIRST_STATUS = "extra first status";
    public static final String EXTRA_LAST_STATUS = "extra last status";
    public static final String EXTRA_CHEAT_STATUS = "extra cheat status";
    public static final String EXTRA_HIDDEN_LIST = "extra hidden list";
    private int mSize; //= 0
    private String mBackColorHex;//= "#C4B7DC"

    private Button mButtonSave;
    private Button mButtonDiscard;

    //font size:
    private RadioButton mRadioButtonMedium;
    private RadioButton mRadioButtonSmall;
    private RadioButton mRadioButtonDefault;
    private RadioButton mRadioButtonLarge;
    //colors:
    private ImageButton mButtonLRed;
    private ImageButton mButtonLGreen;
    private ImageButton mButtonLBlue;
    private ImageButton mButtonWhite;
    private ImageButton mButtonDefaultColor;
    private ImageButton mButtonYellow;

    //hide/show:
    private RadioButton mRadioButtonhtrue;
    private RadioButton mRadioButtonhfalse;
    private RadioButton mRadioButtonhnext;
    private RadioButton mRadioButtonhprev;
    private RadioButton mRadioButtonhfirst;
    private RadioButton mRadioButtonhlast;
    private RadioButton mRadioButtonhcheat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        findViews();
        setListeners();
    }

    private void setListeners() {
        // font size listeners:
        mRadioButtonSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
                mSize = 14;
                /*intent.putExtra(EXTRA_SIZE, mSize);
//                intent.putExtra(EXTRA_SMALL_SIZE, 14);
                setResult(RESULT_OK, intent);*/
                puttingInExtra();
            }
        });

        mRadioButtonMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
                mSize = 18;
               /* intent.putExtra(EXTRA_SIZE, mSize);
//                intent.putExtra(EXTRA_MEDIUM_SIZE, 18);
                setResult(-1, intent);*/
                puttingInExtra();
            }
        });
        mRadioButtonLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
                mSize = 26;
                /*intent.putExtra(EXTRA_SIZE, mSize);
//                intent.putExtra(EXTRA_LARGE_SIZE, 26);
                setResult(-1, intent);*/
                puttingInExtra();
            }
        });
        mRadioButtonDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
                mSize = 20;
                /*intent.putExtra(EXTRA_SIZE, mSize);
//                intent.putExtra(EXTRA_DEFAULT_SIZE, 20);
                setResult(-1, intent);*/
                puttingInExtra();
            }
        });

        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                puttingInExtra();
                finish();
            }
        });
        mButtonDiscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSize = 0;
                mBackColorHex = null;
                puttingInExtra();
                finish();
            }
        });

        //colors:
        mButtonLRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
                mBackColorHex = "#ff8c9f";
                /*intent.putExtra(EXTRA_BACK, mBackColorHex);
                setResult(-1, intent);*/
                puttingInExtra();
            }
        });
        mButtonLGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
                mBackColorHex = "#6ceb8e";
                /*intent.putExtra(EXTRA_BACK, mBackColorHex);
                setResult(-1, intent);*/
                puttingInExtra();
            }
        });
        mButtonLBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
                mBackColorHex = "#4bdff2";
                /*intent.putExtra(EXTRA_BACK, mBackColorHex);
                setResult(-1, intent);*/
                puttingInExtra();
            }
        });
        mButtonWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
                mBackColorHex = "#FFFFFF";
                /*intent.putExtra(EXTRA_BACK, mBackColorHex);
                setResult(-1, intent);*/
                puttingInExtra();
            }
        });
        mButtonDefaultColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
                mBackColorHex = "#C4B7DC";
                /*intent.putExtra(EXTRA_BACK, mBackColorHex);
                setResult(-1, intent);*/
                puttingInExtra();
            }
        });
        mButtonYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
                mBackColorHex = "#f5bd31";
                /*intent.putExtra(EXTRA_BACK, mBackColorHex);
                setResult(-1, intent);*/
                puttingInExtra();
            }
        });

    }


    private void puttingInExtra() {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_SIZE, mSize);
        intent.putExtra(EXTRA_BACK, mBackColorHex);
        hideOrShowView(intent);
        setResult(-1, intent);
    }

    private void hideOrShowView(Intent intent) {
        if(mRadioButtonhtrue.isChecked())
        intent.putExtra(EXTRA_TRUE_STATUS, View.INVISIBLE);
        else
            intent.putExtra(EXTRA_TRUE_STATUS,View.VISIBLE);
        if(mRadioButtonhfalse.isChecked())
            intent.putExtra(EXTRA_FALSE_STATUS,View.INVISIBLE);
        else
            intent.putExtra(EXTRA_FALSE_STATUS,View.VISIBLE);
        if(mRadioButtonhprev.isChecked())
            intent.putExtra(EXTRA_PREV_STATUS,View.INVISIBLE);
        else
            intent.putExtra(EXTRA_PREV_STATUS,View.VISIBLE);
        if(mRadioButtonhnext.isChecked())
            intent.putExtra(EXTRA_NEXT_STATUS,View.INVISIBLE);
        else
            intent.putExtra(EXTRA_NEXT_STATUS,View.VISIBLE);
        if(mRadioButtonhfirst.isChecked())
            intent.putExtra(EXTRA_FIRST_STATUS,View.INVISIBLE);
        else
            intent.putExtra(EXTRA_FIRST_STATUS,View.VISIBLE);
        if(mRadioButtonhlast.isChecked())
            intent.putExtra(EXTRA_LAST_STATUS,View.INVISIBLE);
        else
            intent.putExtra(EXTRA_LAST_STATUS,View.VISIBLE);
        if(mRadioButtonhcheat.isChecked())
            intent.putExtra(EXTRA_CHEAT_STATUS,View.INVISIBLE);
        else
            intent.putExtra(EXTRA_CHEAT_STATUS,View.VISIBLE);
    }


    private void findViews() {
        //font size:
        mRadioButtonLarge = findViewById(R.id.radio_btn_size_large);
        mRadioButtonDefault = findViewById(R.id.radio_btn_size_default);
        mRadioButtonSmall = findViewById(R.id.radio_btn_size_small);
        mRadioButtonMedium = findViewById(R.id.radio_btn_size_medium);
        mButtonDiscard = findViewById(R.id.discard_btn);
        mButtonSave = findViewById(R.id.save_btn);

        //colors :
        mButtonLRed = findViewById(R.id.light_red_back);
        mButtonLGreen = findViewById(R.id.light_green_back);
        mButtonLBlue = findViewById(R.id.light_blue_back);
        mButtonWhite = findViewById(R.id.white_back);
        mButtonDefaultColor = findViewById(R.id.default_back);
        mButtonYellow = findViewById(R.id.yellow_back);

        //hidden/shown buttons:
        mRadioButtonhcheat = findViewById(R.id.cheat_hide);
        mRadioButtonhtrue = findViewById(R.id.true_hide);
        mRadioButtonhfalse = findViewById(R.id.false_hide);
        mRadioButtonhnext = findViewById(R.id.next_hide);
        mRadioButtonhfirst = findViewById(R.id.first_hide);
        mRadioButtonhprev = findViewById(R.id.prev_hide);
        mRadioButtonhlast = findViewById(R.id.last_hide);
    }
}