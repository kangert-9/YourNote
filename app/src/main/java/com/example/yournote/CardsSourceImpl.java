package com.example.yournote;

import android.content.res.Resources;
import android.content.res.TypedArray;

import com.example.yournote.CardData;
import com.example.yournote.CardSource;
import com.example.yournote.R;

import java.util.ArrayList;
import java.util.List;

class CardSourceImpl implements CardSource {
    private List<CardData> dataSource;
    private Resources resources;

    public CardSourceImpl(Resources resources) {
        dataSource = new ArrayList<>(5);
        this.resources = resources;
    }

    public CardSourceImpl init(){
        String[] titles = resources.getStringArray(R.array.note_names);
        String[] descriptions = resources.getStringArray(R.array.notes);
        String[] dates = resources.getStringArray(R.array.dates);
        for (int i = 0; i < descriptions.length; i++) {
            dataSource.add(new CardData(titles[i], descriptions[i], dates[i]));
        }
        return this;
    }


    @Override
    public CardData getData(int position) {
        return dataSource.get(position);
    }

    public int size(){
        return dataSource.size();
    }
}
