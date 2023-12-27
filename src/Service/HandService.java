package Service;

import Model.*;

import java.util.*;

import static Model.Rank.*;

public class HandService {
    public static void replaceCards(Hand hand, List<Integer> replaceIndices, Deck deck) {
        for (int index : replaceIndices) {
            hand.getCards().set(index, DeckService.drawFromDeck(deck));
        }
    }

    public static void cardDesign(Hand hand) {
        ArrayList<Card> cards = hand.getCards();
        Map<Rank, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (card.getRank() == Six) {
                if (!map.containsKey(Six)) {
                    map.put(Six, new ArrayList<>());
                }
                map.get(Six).add(i);

            } else if (card.getRank() == Seven) {
                if (!map.containsKey(Seven)) {
                    map.put(Seven, new ArrayList<>());
                }
                map.get(Seven).add(i);
            } else if (card.getRank() == Eight) {
                if (!map.containsKey(Eight)) {
                    map.put(Eight, new ArrayList<>());
                }
                map.get(Eight).add(i);
            } else if (card.getRank() == Nine) {
                if (!map.containsKey(Nine)) {
                    map.put(Nine, new ArrayList<>());
                }
                map.get(Nine).add(i);
            } else if (card.getRank() == Ten) {
                if (!map.containsKey(Ten)) {
                    map.put(Ten, new ArrayList<>());
                }
                map.get(Ten).add(i);
            } else if (card.getRank() == Jack) {
                if (!map.containsKey(Jack)) {
                    map.put(Jack, new ArrayList<>());
                }
                map.get(Jack).add(i);
            } else if (card.getRank() == Queen && card.getSuit() != Suit.SPADES) {
                if (!map.containsKey(Queen)) {
                    map.put(Queen, new ArrayList<>());
                }
                map.get(Queen).add(i);
            } else if (card.getRank() == King) {
                if (!map.containsKey(King)) {
                    map.put(King, new ArrayList<>());
                }
                map.get(King).add(i);
            } else if (card.getRank() == Ace) {
                if (!map.containsKey(Ace)) {
                    map.put(Ace, new ArrayList<>());
                }
                map.get(Ace).add(i);
            }

        }
        System.out.println("Removing cards from hand: ");
        for (Map.Entry<Rank, List<Integer>> entry : map.entrySet()) {
            int k = entry.getValue().size() % 2;
            int numberOfDuplicates = entry.getValue().size() - k;
            if (numberOfDuplicates >= 2) {
                if (numberOfDuplicates == 3) {
                    for (int i = 0; i < numberOfDuplicates - 1; i++) {
                        System.out.print(entry.getKey() + " " + cards.get(entry.getValue().get(i)).getSuit().getSymbol());
                        cards.remove(new Card(cards.get(entry.getValue().get(i)).getSuit(), entry.getKey()));
                        numberOfDuplicates--;
                        i--;
                    }
                } else if (numberOfDuplicates == 4 || numberOfDuplicates == 2) {
                    for (int i = 0; i < numberOfDuplicates; i++) {
                        System.out.print(entry.getKey() + " " + cards.get(entry.getValue().get(i)).getSuit().getSymbol());
                        cards.remove(new Card(cards.get(entry.getValue().get(i)).getSuit(), entry.getKey()));
                        numberOfDuplicates--;
                        i--;
                    }
                }
            }
        }
        hand.setCards(cards);
    }

    static void displayCards(Hand hand) {
        for (int x = 0; x < hand.getCards().size(); x++)
            System.out.printf("%-16s\t\n", hand.getCards().get(x).getRank() + " " + hand.getCards().get(x).getSuit().getSymbol());

        System.out.printf("\n");
    }

    public static ArrayList<Card> distribution(Deck deck, int numberOfPlayers) {
        ArrayList<Card> cards = new ArrayList<Card>();
        for (int x = 0; x < numberOfPlayers; x++) {
            cards.add(DeckService.drawFromDeck(deck));
        }
        return cards;
    }

    //рандомно вытягиваем карты
    public static ArrayList<Card> randomPull(Hand hand, int numberOfCardsToPull) {
        ArrayList<Card> cards = hand.getCards();
        ArrayList<Card> pulledCards = new ArrayList<>();
        Random random = new Random();

        System.out.println("Randomly pulling " + numberOfCardsToPull + " cards from hand:");
        for (int i = 0; i < numberOfCardsToPull; i++) {
            int randomIndex = random.nextInt(cards.size());
            pulledCards.add(cards.get(randomIndex));
            System.out.print(cards.get(randomIndex).getRank() + " " + cards.get(randomIndex).getSuit());
            cards.remove(randomIndex);
        }

        return pulledCards;
    }

}
