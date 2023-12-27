import models.Card;
import models.Deck;
import models.Hand;
import services.DeckService;
import services.HandService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        int players = scanner.nextInt();
        int cardsPerPlayer = 36 / players;
        int from = 0;
        int to = from + cardsPerPlayer;
        boolean isLose = false;

        Deck deck = DeckService.getShuffledDeck();
        List<Hand> hands = new ArrayList<>(players);

        for (int i = 0; i < players; i++) {

            List<Card> cards = deck.getCards().subList(from, to);

            from += cardsPerPlayer;
            to += cardsPerPlayer;

            Hand hand = new Hand(cards, i);
            hands.add(hand);
            isLose = HandService.checkLose(hand);
            if (isLose) {
                System.out.println("Player" + hand.getId() + " lost");
                break;
            }
        }

        getInitial(hands);

        int loop = 1;
        while (!isLose) {
            System.out.println("Loop: " + loop);
            loop++;

            HandService.displayHands(hands);

            for (int i = 0; i < hands.size(); i++) {
                Hand hand = hands.get(i);
                Hand handToPull;
                if (i == hands.size() - 1) {
                    handToPull = hands.getFirst();
                } else {
                    handToPull = hands.get(i + 1);
                }
                isLose = getInfo(hand, handToPull);
                if (isLose) break;
            }
            System.out.println();
        }
    }

    private static void getInitial(List<Hand> hands) {
        System.out.println("Initial state: ");
        HandService.displayHands(hands);
        System.out.println("\nRemove duplicates: ");
        for (Hand hand : hands) {
            HandService.removeHandCards(hand);
            HandService.displayCards(hand);
        }
        System.out.println();
    }
    private static boolean getInfo(Hand handTo , Hand handFrom) {
        boolean isLose;
        System.out.println("\nPlayer "  + handTo.getId() + " deck: ");
        HandService.displayCards(handTo);
        System.out.println("\nPlayer "  + handFrom.getId() + " deck: ");
        HandService.displayCards(handFrom);
        System.out.println("\nPlayer " + handTo.getId() + " is pulling from " + handFrom.getId());
        handTo.getCards().add(HandService.randomPull(handFrom));
        System.out.println("\nPlayer "  + handTo.getId() + " deck before removing duplicates: ");
        isLose = HandService.checkLose(handTo);
        HandService.displayCards(handTo);
        System.out.println("\nPlayer "  + handTo.getId() + " deck after removing duplicates: ");
        HandService.removeHandCards(handTo);
        HandService.displayCards(handTo);
        System.out.println("\nPlayer "  + handFrom.getId() + " deck: ");
        HandService.displayCards(handFrom);
        System.out.println("\n");
        if (isLose) {
            System.out.println("Player " + handTo.getId() + " lost");
        }
        return isLose;
    }
}