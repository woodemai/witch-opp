package models;

import java.util.Objects;

public class Card {
    private final Rank rank;
    private final Suit suit;


    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }
    public Rank getRank() {
        return rank;
    }
    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}