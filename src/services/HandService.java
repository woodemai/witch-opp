package services;

import models.*;

import java.util.*;

public class HandService {

    private static boolean checkCardRank(Card card, Rank rank) {
        if (rank == Rank.QUEEN && card.getSuit() == Suit.SPADES) {
            return false;
        }
        return card.getRank() == rank;
    }

    public static void removeHandCards(Hand hand) {
        List<Card> cards = new ArrayList<>(hand.getCards());
        Map<Rank, List<Card>> map = new HashMap<>();
        for (Rank rank : Rank.values()) {
            List<Card> rankCards = cards.stream().filter(card -> checkCardRank(card, rank)).toList();
            map.put(rank, rankCards);
        }
        List<Card> cardsToRemove = new ArrayList<>();
        for (Map.Entry<Rank, List<Card>> entry : map.entrySet()) {
            List<Card> rankCards = entry.getValue();
            if(rankCards.size() >= 2) {
                cardsToRemove.addAll(rankCards.subList(0, 2));
            }
        }
        cards.removeAll(cardsToRemove);
        hand.setCards(cards);
    }

    public static void displayCards(Hand hand) {
        List<Card> cards = new ArrayList<>(hand.getCards());
        for (Card card : cards) {
            System.out.print(card.getRank() + " " + card.getSuit().getSymbol() + " | ");
        }
        System.out.println();
    }

    public static void displayHands(List<Hand> hands) {
        for (int i = 0; i < hands.size(); i++) {
            if (i == 0) {
                System.out.println("Your hand: ");
            } else {
                System.out.println("Hand player " + i + ": ");
            }
            HandService.displayCards(hands.get(i));
        }
        System.out.println("\n");
    }


    //рандомно вытягиваем карту
    public static Card randomPull(Hand hand) {
        List<Card> cards = hand.getCards();
        int size = cards.size();
        Random random = new Random();
        int index = random.nextInt(size);
        Card card = cards.get(index);
        cards.remove(index);
        return card;
    }

    public static boolean checkLose(Hand hand) {
        List<Card> cards = new ArrayList<>(hand.getCards());
        int numberOfQueens = 0;
        boolean containsSpadesQueen = false;
        for (Card card : cards) {
            if (card.getRank() == Rank.QUEEN) {
                numberOfQueens++;
                if(card.getSuit() == Suit.SPADES) {
                    containsSpadesQueen = true;
                }
            }
        }
        return numberOfQueens > 1 && containsSpadesQueen;
    }

}
