import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class DiceGame12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int wins = 0;
        int losses = 0;
        boolean playing = true;
        
        System.out.println("Welcome to dice game 12! You must roll 1-3 dice and try to get the sum of 12...");
        
        while (playing) {
            int sum = 0;
            HashSet<Integer> rolledDice = new HashSet<>();
            
            for (int i = 0; i < 3; i++) {
                int diceChoice;
                while (true) {
                    System.out.print("Enter which dice you want to roll [1,2,3] (exit with q): ");
                    String input = scanner.next();
                    
                    if (input.equalsIgnoreCase("q")) {
                        playing = false;
                        break;
                    }
                    
                    try {
                        diceChoice = Integer.parseInt(input);
                        if (diceChoice < 1 || diceChoice > 3) {
                            System.out.println("Sorry, that is an invalid entry. Try again. Valid entries are 1, 2, 3, and q");
                        } else if (rolledDice.contains(diceChoice)) {
                            System.out.println("Sorry, you have already rolled that dice. Try again.");
                        } else {
                            rolledDice.add(diceChoice);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Enter a number between 1-3 or 'q' to quit.");
                    }
                }
                
                if (!playing) break;
                
                int diceRoll = random.nextInt(6) + 1;
                sum += diceRoll;
                System.out.println("Rolled: " + diceRoll + " | Current sum: " + sum);
            }
            
            if (!playing) break;
            
            if (sum == 12) {
                wins++;
                System.out.println("You won!!");
            } else if (sum > 12) {
                losses++;
                System.out.println("You lost!!");
            } else {
                System.out.println("You neither won nor lost. Next round!");
            }
            
            System.out.println("#win: " + wins + " #loss: " + losses);
        }
        
        System.out.println("Game Over!");
        System.out.println("Final Score - Wins: " + wins + " | Losses: " + losses);
        scanner.close();
    }
}
