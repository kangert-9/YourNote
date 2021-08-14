package com.example.yournote;

public class CardData {
    private String description;       // заголовок
    private String dates; // описание

    public CardData(String description, String dates){
        this.description = description;
        this.dates=dates;
    }

    public String getDates() {
        return dates;
    }

    public String getDescription() {
        return description;
    }

}
