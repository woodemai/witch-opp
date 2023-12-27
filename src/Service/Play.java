package Service;
import Model.Card;
import Model.Deck;
import Model.Hand;

import java.util.ArrayList;

import java.util.Scanner;
public class Play {
    public static boolean play() {

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int players = scn.nextInt();
        while (true) {
            Deck deck = new Deck();
            DeckService.shuffleDeck(deck);

            Hand hand = new Hand(deck, 36 / players);
            ArrayList<Hand> hands = new ArrayList<>();
            for (int i = 0; i < players - 1; i++) {
                Hand hand1 = new Hand(deck, 36 / players);
                hands.add(hand1);
            }
            System.out.println("\nYour hand:");
            HandService.displayCards(hand);
            for (int i = 0; i < players - 1; i++) {
                System.out.println("\nHand player " + i + ": ");
                HandService.displayCards(hands.get(i));
            }
            System.out.println("\n");
            HandService.cardDesign(hand);
            System.out.println("\n");
            HandService.displayCards(hand);

            return false;
        }
    }
}