package com.example.yournote;

import java.util.HashMap;
import java.util.Map;

public class CardDataMapping {
    public static class Fields{
        public final static String DATE = "date";
        public final static String TITLE = "title";
        public final static String DESCRIPTION = "description";
    }

    public static CardData toCardData(String id, Map<String, Object> doc) {
        CardData answer = new CardData((String) doc.get(Fields.TITLE),
                (String) doc.get(Fields.DESCRIPTION),
                (String) doc.get(Fields.DATE));
        answer.setId(id);
        return answer;
    }

    public static Map<String, Object> toDocument(CardData cardData){
        Map<String, Object> answer = new HashMap<>();
        answer.put(Fields.TITLE, cardData.getNoteName());
        answer.put(Fields.DESCRIPTION, cardData.getNote());
        answer.put(Fields.DATE, cardData.getDates());
        return answer;
    }
}
