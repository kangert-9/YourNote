package com.example.yournote;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class TextFragment extends Fragment {

    static final String ARG_INDEX = "index";
    CardData card;
    private Publisher publisher;

    public static TextFragment newInstance(CardData card) {
        TextFragment f = new TextFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_INDEX, (Parcelable) card);
        f.setArguments(args);
        return f;
    }

    public static TextFragment newInstance() {
        TextFragment fragment = new TextFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            card = getArguments().getParcelable(ARG_INDEX);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MainActivity activity = (MainActivity)context;
        publisher = activity.getPublisher();
    }

    @Override
    public void onDetach() {
        publisher = null;
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        TextView textTitle = view.findViewById(R.id.title);
        EditText textView = view.findViewById(R.id.text);
        EditText textDate = view.findViewById(R.id.date);

        if (card != null) {
            textTitle.setText(card.getNoteName());
            textView.setText(card.getNote());
            textDate.setText(card.getDates());

            textView.setTextSize(45);
            textDate.setTextSize(30);
        }
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        card = collectCardData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        publisher.notifySingle(card);
    }

    private CardData collectCardData(){
        String title = this.getView().findViewById(R.id.title).toString();
        String description = this.getView().findViewById(R.id.text).toString();
        String date = this.getView().findViewById(R.id.date).toString();

        return new CardData(title, description, date);
    }

}