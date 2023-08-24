import java.util.Scanner;
import java.util.Random;

public class Number {
    private static final int MAX_NUMBER = 1;
    private static final int MIN_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;
        System.out.println("Welcome to the Number Guessing game!");
        while (playAgain) {
            int targetNumber = random.nextInt(MAX_NUMBER) + 1;
            System.out.println("/nI've picked a number between 1 to 100(Inclusive) Can you guess it?");
            int attempts = 0;
            while (attempts < MAX_ATTEMPTS) {
                System.out.println("Enter your Guess:");
                int userGuess = scanner.nextInt();
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! you guessed the correct number.");
                    score += MAX_ATTEMPTS - attempts;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again");
                } else {
                    System.out.println("Too High. Try again");
                }
                attempts++;
            }
            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Your current score: " + score);
                System.out.println("Do you want to play again?(yes/no)");
                String playAgainResponse = scanner.next().toLowerCase();
                playAgain = playAgainResponse.equals("Yes");
            }
            System.out.println("/n Thankyou for playing the game!Your final score is:+score");
            scanner.close();
        }
    }
}
