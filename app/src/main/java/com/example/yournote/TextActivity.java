package com.example.yournote;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);


        if (savedInstanceState==null){
            TextFragment fragment = new TextFragment();
            fragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }

}