import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> Cards = new ArrayList<>();

    public Deck() {
        for (String suit : Card.suits) {
            for (String face : Card.faces) {
                Cards.add(new Card(face, suit));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(Cards);
    }

    public Card draw() {
        return Cards.remove(0);
    }
}
