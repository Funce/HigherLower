import java.util.*;

public class HigherLower {

    static Deck deck = new Deck();
    static Tableau tableau = new Tableau();
    static Scanner scanner = new Scanner(System.in);
    static int score = 0;

    public static void main(String[] args) {
        /**
         * So this is higher or lower,
         * Cards are drawn from a deck
         * The first card is flipped over
         * then the user guesses higher or lower
         * if the user guesses higher and the next card is higher than the previous, the
         * user continues and gets a point
         * if the user is wrong, then the game ends and the score is shown
         */

        printWelcome();
        // Draw the first card!
        tableau.addCard(deck.draw());
        Card lastCard = tableau.lastCard();
        Card newCard;
        tableau.printCards();
        String userInput = getUserInput();
        game: while (!userInput.equalsIgnoreCase("quit")) {
            tableau.addCard(deck.draw());
            newCard = tableau.lastCard();
            switch (lastCard.compareTo(newCard)) {
                case -1:
                    if (userInput.equals("-")) {
                        correct();
                    } else {
                        gameOver();
                        break game;
                    }
                    break;
                case 1:
                    if (userInput.equals("+")) {
                        gameOver();
                        break game;
                    } else {
                        correct();
                    }
                    break;
                default:
                    correct();
            }
            tableau.printCards();
            userInput = getUserInput();
        }
        tableau.printFinalCards();
        System.out.println("Your score was: " + score);
    }

    public static void resetGame() {
        deck = new Deck();
        tableau = new Tableau();
    }

    public static void printWelcome() {
        System.out.println("Welcome to Higher Or Lower!");
        System.out.println("We'll flip a card for you, and you have to tell us if the next card is higher or lower!");
        System.out.println("Let's draw the first card!");
    }

    public static String getUserInput() {
        System.out.println("Type '+' for higher, type '-' for lower, and type 'quit' to end the game!");
        return scanner.next();
    }

    public static void correct() {
        System.out.println("You are correct! You get a point!");
        score += 1;
    }

    public static void gameOver() {
        System.out.println("Oh.. that's too bad, you were wrong.");
    }
}
