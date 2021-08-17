package com.example.yournote;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.yournote.CardSourceImpl;
import com.example.yournote.CardSource;

public class TextFragment extends Fragment {

    static final String ARG_INDEX = "index";
    private int index;
    CardSource data;

    public static TextFragment newInstance(int index) {
        TextFragment f = new TextFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        TextView textView = view.findViewById(R.id.text);
        TextView textDate = view.findViewById(R.id.date);
        data = new CardSourceImpl (getResources()).init();

        textView.setText(data.getData(index).getNote());
        textDate.setText(data.getData(index).getDates());

        textView.setTextSize(45);
        textDate.setTextSize(30);

        return view;
    }
}