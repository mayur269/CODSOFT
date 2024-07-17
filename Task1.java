import java.util.Random;
import java.util.Scanner;

//NumberGame 
public class Task1{

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        boolean playAgain = true;
        int rounds = 0;
        int totalScore = 0;

        while (playAgain) {
            
            int number = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempt = 10;

            System.out.println("Welcome to the number guessing game : ");
            System.out.println("Guessed the number between 1 to 100 : ");

            while (attempts < maxAttempt) {
                System.out.print("enter the guesed number : ");
                int guesedNum = sc.nextInt();

                attempts += 1;

                if(guesedNum == number) {
                    System.out.println("Congratulations! YOu guessed the number in " + attempts + " attempts.");
                    break;
                } else if(guesedNum < number) {
                    System.out.println("Try again. The number is higher than your guessed number.");
                } else {
                    System.out.println("Try again. The number is lower than your guessed number.");
                }

                if(attempts == maxAttempt) {
                    System.out.println("Ohh !!! Your Attempts are over.");
                }

            } 
             
            if(attempts == 1) {
                System.out.println("Your score is 100.");
                totalScore += 100;
            } else if(attempts <= 2) {
                System.out.println("Your score is 90");
                totalScore += 90;
            } else if(attempts <= 3) {
                System.out.println("Your score is 80");
                totalScore += 80;
            } else if (attempts <= 4) {
                System.out.println("Your score is 70");
                totalScore += 70;
            } else if(attempts <= 5){
                System.out.println("Your score is 60");
                totalScore += 60;
            } else if(attempts <= 6){
                System.out.println("Your score is 50");
                totalScore += 50;
            } else if(attempts <= 8){
                System.out.println("Your score is 40");
                totalScore += 40;
            } else if(attempts <= 9){
                System.out.println("Your score is 30");
                totalScore += 30;
            } else{
                System.out.println("Your score is 20");
                totalScore += 20;
            }

            rounds ++;
            System.out.println("Do you want to play another round? (yes/no): ");
            String response = sc.next();
            if(!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game Over !");
        System.out.println("You played " + rounds + " rounds with a total score of " + totalScore + ".");
        sc.close();
    }
}