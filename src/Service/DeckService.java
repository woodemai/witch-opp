package Service;

import Model.Card;
import Model.Deck;

import java.util.Random;
import java.util.ArrayList;

public class DeckService {
    static void shuffleDeck(Deck deck) {
        ArrayList<Card> cards = deck.getCards();
        int index1, index2;
        Random generator = new Random();
        Card temp;
        int size = cards.size();
        for (short i = 0; i < 36; i++) {
            index1 = generator.nextInt(size);
            index2 = generator.nextInt(size);
            temp = cards.get(index2);
            cards.set(index2, cards.get(index1));
            cards.set(index1, temp);
        }
    }

    public static Card drawFromDeck(Deck deck) {
        return deck.getCards().remove(deck.getCards().size() - 1);
    }
}