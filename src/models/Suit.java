package models;

public enum Suit {
    HEARTS("♥️"),
    SPADES("♠️"),
    DIAMONDS("♦️"),
    CLUBS("♣️");
    private final String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}