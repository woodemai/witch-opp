package Model;

import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        for (short a = 0; a <= 3; a++) {
            for (short b = 0; b <= 8; b++) {
                cards.add(new Card(Suit.values()[a], Rank.values()[b]));
            }
        }
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
}
