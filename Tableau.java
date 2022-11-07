import java.util.ArrayList;
import java.util.List;

public class Tableau {
    private List<Card> Cards = new ArrayList<>();

    public void addCard(Card card) {
        Cards.add(card);
    }

    public void printCards() {
        // Top level
        System.out.println("|" + "-".repeat(Cards.size() * 5 + 6) + "|");

        System.out.print("| ");
        for (Card card : Cards) {
            System.out.print(card.showCard() + " ");
        }
        // And the "next" card
        System.out.print(new Card("?", "?").showCard() + " |\n");

        // Bottom level
        System.out.println("|" + "-".repeat(Cards.size() * 5 + 6) + "|");
    }

    public void printFinalCards() {
        // Top level
        System.out.println("|" + "-".repeat(Cards.size() * 5 + 1) + "|");

        System.out.print("| ");
        for (Card card : Cards) {
            System.out.print(card.showCard() + " ");
        }
        System.out.print("|\n");

        // Bottom level
        System.out.println("|" + "-".repeat(Cards.size() * 5 + 1) + "|");
    }

    public Card lastCard() {
        return Cards.get(Cards.size() - 1);
    }
}
