package com.example.myquizapplication.controller.activity;

import androidx.fragment.app.Fragment;

import com.example.myquizapplication.controller.fragment.ListFragment;

public class ListActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new ListFragment();
    }


}