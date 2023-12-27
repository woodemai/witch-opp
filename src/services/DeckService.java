package services;

import models.Card;
import models.Deck;

import java.util.Collections;
import java.util.List;

public class DeckService {

    public static Deck getShuffledDeck() {
        Deck deck = new Deck();
        List<Card> cards = deck.getCards();
        Collections.shuffle(cards);
        deck.setCards(cards);
        return deck;
    }
}