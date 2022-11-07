public class Card implements Comparable<Card> {
    private String face;
    private String suit;

    public static String[] suits = { "C", "D", "H", "S" };
    public static String[] faces = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" };

    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    public String getFace() {
        return face;
    }

    public String showCard() {
        return "[" + face + suit + "]";
    }

    public int compareTo(Card card) {
        if (indexOf(card.suit, suits) > indexOf(suit, suits)) {
            return 1;
        } else if (indexOf(card.suit, suits) < indexOf(suit, suits)) {
            return -1;
        }
        return 0;
    }

    private int indexOf(String search, String[] arrayStrings) {
        for (int i = 0; i < arrayStrings.length; i++) {
            if (arrayStrings[i].equals(search)) {
                return i;
            }
        }
        return -1;// not found
    }
}
