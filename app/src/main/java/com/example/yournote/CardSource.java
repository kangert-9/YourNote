package com.example.yournote;

public interface CardSource {
    CardData getCardData(int position);
    int size();
    void deleteCardData(int position);
    void updateCardData(int position, CardData data);
    void addCardData(CardData data);
    void clearCardData();
}
