import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int numberOfAttempts = 5; // You can change this to limit the number of attempts
        int score = 0;
        
        boolean playAgain = true;
        
        while (playAgain) {
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("Welcome to Guess the Number!");
            System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + numberOfAttempts + " attempts to guess it.");
            System.out.println("Let's begin!");
            
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            while (attempts < numberOfAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += numberOfAttempts - attempts + 1; // Giving points based on the number of attempts
                    guessedCorrectly = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was " + randomNumber + ".");
            }
            
            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thanks for playing Guess the Number!");
        scanner.close();
    }
}
