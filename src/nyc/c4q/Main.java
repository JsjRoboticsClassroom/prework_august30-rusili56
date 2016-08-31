package nyc.c4q;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean notDone = true;

        while (notDone){
            Hangman hangman = new Hangman();
            while (hangman.getMisses() < 5) {
                hangman.printCurrentWord();
                hangman.promptPlayer("Enter a letter: ");
                hangman.readLetter();
                hangman.checkLetter();
                if (hangman.guessedSuccessfully()) {
                    break;
                }
                System.out.println(Drawing.get(hangman.getMisses()));
                System.out.println("Misses -> " + hangman.getMisses());
            }
            if (hangman.guessedSuccessfully()) {
                System.out.println("Success");
            } else {
                System.out.println("The answer was " + hangman.getSecretWord());
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want to play again? (Yes/No)");
            String userAnswer = scanner.next().toLowerCase();

            boolean inputCheck = false;
            while (inputCheck == false) {
                if (userAnswer.equalsIgnoreCase("Yes") || userAnswer.equalsIgnoreCase("Y")) {
                    notDone = true;
                    inputCheck = true;
                } else if (userAnswer.equalsIgnoreCase("No") || userAnswer.equalsIgnoreCase("N")) {
                    notDone = false;
                    inputCheck = true;
                } else {
                    System.out.println("Please try again");
                }
            }
        }

    }
}
