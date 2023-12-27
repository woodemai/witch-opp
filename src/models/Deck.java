package models;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        for (Rank rank  : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
