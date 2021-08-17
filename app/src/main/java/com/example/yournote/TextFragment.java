package com.example.yournote;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yournote.CardSourceImpl;
import com.example.yournote.CardSource;

public class TextFragment extends Fragment {

    static final String ARG_INDEX = "index";
    private int index;
    CardSource data;
    CardData card;

    public static TextFragment newInstance(CardData card) {
        TextFragment f = new TextFragment();

        Bundle args = new Bundle();
        args.putParcelable(ARG_INDEX, (Parcelable) card);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            card = getArguments().getParcelable(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        TextView textTitle = view.findViewById(R.id.title);
        EditText textView = view.findViewById(R.id.text);
        EditText textDate = view.findViewById(R.id.date);

        textTitle.setText(card.getNoteName());
        textView.setText(card.getNote());
        textDate.setText(card.getDates());

        textView.setTextSize(45);
        textDate.setTextSize(30);

        Button button = view.findViewById(R.id.save);
        button.setOnClickListener(v -> {
            saveCard(card);
        });

        return view;
    }

    public void saveCard(CardData card) {
        EditText et = getView().findViewById(R.id.text);
        card.setNote(et.getText().toString());

        EditText tet = getView().findViewById(R.id.date);
        card.setDates(tet.getText().toString());
//todo
//        Intent intent = new Intent();
//        intent.setClass(getActivity(), ContentActivity.class);
//        intent.putExtra(SocialNetworkFragment.ARG_INDEX, (Parcelable) card);
//        startActivity(intent);
        Toast.makeText(getContext(), "Изменения сохранены", Toast.LENGTH_LONG).show();
    }

}