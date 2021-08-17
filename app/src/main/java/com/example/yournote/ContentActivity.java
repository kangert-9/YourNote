package com.example.yournote;

import static com.example.yournote.SocialNetworkFragment.ARG_INDEX;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class ContentActivity extends AppCompatActivity {
    CardData newCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
//todo
        //if (savedInstanceState==null){
            addFragment(SocialNetworkFragment.newInstance());
//        } else {
//            SocialNetworkFragment fragment = new SocialNetworkFragment();
//            Bundle args = new Bundle();
//            args.putParcelable(ARG_INDEX, newCard);
//            //fragment.setArguments(getIntent().getExtras());
//            fragment.onSaveInstanceState(args);
//        }
    }


    private void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.notes, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}