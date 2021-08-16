package com.example.yournote;

public interface CardSource {
    CardData getData(int position);
    int size();
}
