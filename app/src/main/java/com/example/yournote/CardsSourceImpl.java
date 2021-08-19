package com.example.yournote;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

class CardSourceImpl implements CardSource {
    private final List<CardData> dataSource;
    private final Resources resources;

    public CardSourceImpl(Resources resources) {
        dataSource = new ArrayList<>(4);
        this.resources = resources;
    }


    public CardSourceImpl init(CardsSourceResponse cardsSourceResponse){
        String[] titles = resources.getStringArray(R.array.note_names);
        String[] descriptions = resources.getStringArray(R.array.notes);
        String[] dates = resources.getStringArray(R.array.dates);
        for (int i = 0; i < descriptions.length; i++) {
            dataSource.add(new CardData(titles[i], descriptions[i], dates[i]));
        }
        if (cardsSourceResponse != null){
            cardsSourceResponse.initialized(this);
        }
        return this;
    }

    @Override
    public CardData getCardData(int position) {
        return dataSource.get(position);
    }

    public int size(){
        return dataSource.size();
    }

    @Override
    public void deleteCardData(int position) {
        dataSource.remove(position);
    }

    @Override
    public void updateCardData(int position, CardData data) {
        dataSource.set(position, data);
    }

    @Override
    public void addCardData(CardData data) {
        dataSource.add(data);
    }

    @Override
    public void clearCardData() {
        dataSource.clear();
    }
}
