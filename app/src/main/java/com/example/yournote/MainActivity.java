package com.example.yournote;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private final Publisher publisher = new Publisher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initToolbar();
        FragmentManager fragmentManager= getSupportFragmentManager();
        Navigation navigation = new Navigation(fragmentManager);
        navigation.addFragment(SocialNetworkFragment.newInstance(), false);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public Publisher getPublisher() {
        return publisher;
    }
}