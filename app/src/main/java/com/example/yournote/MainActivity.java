package com.example.yournote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Navigation navigation;
    private final Publisher publisher = new Publisher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = new Navigation(getSupportFragmentManager());
        //initToolbar();
        // TODO: 19.08.2021  
        //getNavigation().addFragment(StartFragment.newInstance(), false);
    }
// TODO: 19.08.2021  
//    private void initToolbar() {
//     Toolbar toolbar = findViewById(R.id.toolbar);
//    setSupportActionBar(toolbar);
//    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//    getSupportActionBar().setHomeButtonEnabled(true);
//    }
    @Override
    public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public Publisher getPublisher() {
        return publisher;
    }
    
}
