package com.example.yournote;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.stream.Stream;

public class CardData implements Parcelable {
    private String id;
    private String note_name;
    private String note;
    private String dates;

    public CardData(String note_name, String note, String dates){
        this.note_name = note_name;
        this.note=note;
        this.dates=dates;
    }

    protected CardData(Parcel in) {
        note_name = in.readString();
        note = in.readString();
        dates = in.readString();
    }

    public static final Creator<CardData> CREATOR = new Creator<CardData>() {
        @Override
        public CardData createFromParcel(Parcel in) {
            return new CardData(in);
        }

        @Override
        public CardData[] newArray(int size) {
            return new CardData[size];
        }
    };

    public CardData(String note_name, String note, Date toDate) {
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

    public void setNote_name(String name){
        this.note_name=name;
    }

    public void setNote(String note){
        this.note=note;
    }

    public void setDates(String date){
        this.dates=date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public Stream<Parcelable> stream() {
        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(note_name);
        dest.writeString(note);
        dest.writeString(dates);
    }
}
