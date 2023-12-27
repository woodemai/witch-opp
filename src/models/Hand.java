package models;

import java.util.List;

public class Hand {
    private List<Card> cards;
    private final int id;

    public Hand(List<Card> cards, int id) {
        this.cards = cards;
        this.id = id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getId() {
        return id;
    }
}

