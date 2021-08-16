package com.example.yournote;

public class CardData {
    private String note_name;       // заголовок
    private String note;
    private String dates; // описание

    public CardData(String note_name, String note, String dates){
        this.note_name = note_name;
        this.note=note;
        this.dates=dates;
    }

    public String getDates() {
        return dates;
    }

    public String getNoteName() {
        return note_name;
    }

    public String getNote() {
        return note;
    }

}
