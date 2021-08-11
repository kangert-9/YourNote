package com.example.yournote;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class NoteFragment extends Fragment {

    //private boolean isLand;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initList(view);
    }

    private void initList(View view) {

        LinearLayout linearLayout = (LinearLayout) view;

        String[] notes = getResources().getStringArray(R.array.note_names);

        for (int i = 0; i < notes.length; i++) {
            TextView textView = new TextView(getContext());
            textView.setText(notes[i]);
            textView.setTextSize(30);
            final int index = i;

            textView.setOnClickListener(v -> {
                showText(index);
            });

            linearLayout.addView(textView);
        }
    }

    private void showText (int index) {
//        if(isLand){
//            showTextLand(index);
//        } else {
            showTextPort(index);
      //  }

    }

//    private void showTextLand(int index) {
        //TextFragment fragment = new TextFragment().newInstance(index);
//    }

    private void showTextPort (int index) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), TextActivity.class);
        intent.putExtra(TextFragment.ARG_INDEX, index);
        startActivity(intent);
    }
}