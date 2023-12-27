package Model;

public class Card {
    private Rank eRank;
    private Suit eSuit;

    public Card(Suit suit, Rank rank) {
        this.eRank = rank;
        this.eSuit = suit;
    }
    public Rank getRank() {
        return eRank;
    }
    public Suit getSuit() {
        return eSuit;
    }

    @Override
    public boolean equals(Object obj){
        Card card = (Card) obj;
        return (card.eSuit == this.eSuit);
    }
}