package Model;

import Service.HandService;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;


    public Hand(Deck deck, int  numberOfPlayers) {
        this.cards = HandService.distribution(deck,  numberOfPlayers);
    }

    public ArrayList<Card> getCards() {return cards;}

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

}

