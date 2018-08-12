import java.util.Random;
import java.util.Scanner;

public class Lesson11 {
    public static void main(String args[]){
        //So the computer is going to choose a number between 1 and 1000
        //The computer is going to allow the player to try and guess the number 15 times?
        //When the player gets the number right, the game offers to let the player play again and congratulates the player
        //If the player didn't guess it, the computer encourages the player to try again and lets them play again.

        Random rand = new Random();
        int secret = Math.abs( rand.nextInt()%1000 )+1;
        String playerGuessTemp ="";
        int playerGuess = -1;
        boolean choice = true;
        boolean allDigits = true;
        int guessesRemaining = 25;
        int counter = 0;
        boolean correct = false;
        Scanner scan = new Scanner(System.in);

        //Sentinel loop
        /*
        int counter = 0;
        while (true){
            secret = Math.abs( rand.nextInt()%1000 )+1; //ALMOST EVERYTHING is 0-indexed.  That means if you say 10, it means the number 0-9
            System.out.println(secret);
            if(secret == 0){
                break;
            }
            counter++;
        }
        System.out.println("It took: " + counter + " tries to find the number 0");
        */

        //Player is a jerk. Going to try to enter letters, symbols and numbers
        while(choice){

            while(!correct && guessesRemaining > 0) {
                do {
                    playerGuess = -1;
                    if (counter == 0) {
                        System.out.println("Please guess a number between 1 and 1000");
                        playerGuessTemp = scan.nextLine();

                        //For each letter in the string playerGuessTemp
                        for (int i = 0; i < playerGuessTemp.length(); i++) {
                            //Check to see if the current letter (charAt(i)) is not a digit
                            if (!Character.isDigit(playerGuessTemp.charAt(i))) {
                                //If so we set allDigits to false
                                allDigits = false;

                                //And exit our for loop
                                break;
                            }
                        }
                    } else { // If it's not our first time through
                        System.out.println("Invalid guess: " + playerGuessTemp + " -- Please guess a value between 1 and 1000");
                        playerGuessTemp = scan.nextLine();
                        for (int i = 0; i < playerGuessTemp.length(); i++) {
                            if (!Character.isDigit(playerGuessTemp.charAt(i))) {
                                allDigits = false;
                                break;
                            }
                        }
                    }
                    if (allDigits) {
                        playerGuess = Integer.parseInt(playerGuessTemp);
                    }
                    allDigits = true;
                    counter++;
                } while (playerGuess < 1 || playerGuess > 1000);
                counter = 0;
                guessesRemaining -= 1;
                if (playerGuess > secret) {
                    System.out.println("Your guess is too high, try again");
                    correct = false;
                } else if (playerGuess < secret) {
                    System.out.println("Your guess is too low, try again");
                    correct = false;
                } else {//Correct
                    System.out.println("Congratulations you guess the correct number");
                    correct = true;
                }
            }
            String playAgain = "";
            if (correct) {
                System.out.println("Would you like to play again? Y/N");
                playAgain = scan.nextLine();
                if (playAgain.equalsIgnoreCase("y")) {
                    correct = true;
                    choice = true;
                } else {
                    System.out.println("We're sorry to see you go");
                    choice = false;
                }
            } else {
                System.out.println("Dont give up! play again? Y/N");
                playAgain = scan.nextLine();
                if (playAgain.equalsIgnoreCase("y")) {
                    correct = true;
                    choice = true;
                } else {
                    System.out.println("We're sorry to see you go, LOSER!");
                    choice = false;
                }
            }
        }

    }
}