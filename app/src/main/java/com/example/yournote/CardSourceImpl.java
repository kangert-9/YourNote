package com.example.yournote;

import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

public class CardsSourceImpl {
    private List<CardData> dataSource;
    private Resources resources;

    public CardsSourceImpl(Resources resources) {
        dataSource = new ArrayList<>(5);
        this.resources = resources;
    }

    public CardsSourceImpl init(){
        String[] descriptions = resources.getStringArray(R.array.notes);
        String[] dates = resources.getStringArray(R.array.dates);
        for (int i = 0; i < descriptions.length; i++) {
            dataSource.add(new CardData(descriptions[i], dates[i]));
        }
        return this;
    }

//    private int[] getImageArray(){
//        TypedArray pictures = resources.obtainTypedArray(R.array.pictures);
//        int length = pictures.length();
//        int[] answer = new int[length];
//        for(int i = 0; i < length; i++){
//            answer[i] = pictures.getResourceId(i, 0);
//        }
//        return answer;
//    }
    public CardData getCardData(int position) {
        return dataSource.get(position);
    }

    public int size(){
        return dataSource.size();
    }
}
