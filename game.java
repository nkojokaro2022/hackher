import java.util.Scanner;
import java.util.Random;

//nextInt(upperbound) generates random numbers in the range 0 to upperbound-1.

public class game {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        Random rand = new Random();
        // asks user what their name is
        System.out.print("What is your name?\n");
        String name = kb.nextLine();
        // welcomes the user to the game and explains the rules
        System.out.println("Hello " + name + "! Welcome to the game ADD GUE$$!\n");
        System.out.println(
                "Here are the rules:\n ⋆｡ﾟ☁︎｡⋆｡ ﾟ☾ ﾟ｡⋆ \nYou will guess a number in between 0 and 2. If you are correct, your guess will be added to you total winnings.");
        System.out.println(
                "If you are wrong, you will lose all your money.\nAfter you guess, you will have the choice to end the game with your winnings or keep trying for more money.");
        System.out.println("Between guesses, the interval of possible guesses will double. Good luck!\n");

        Boolean guess = true; // if their guess is correct
        Boolean play = true; // if they wanna keep going

        int interval = 2;
        int num = rand.nextInt(interval + 1);
        int user;
        int winnings = 0;
        String keepPlaying = "y";

        while (guess && play) {
            System.out.println("Your balance is currently at $" + winnings + ".00.\nGuess a number between 0 and "
                    + interval + ".");
            user = kb.nextInt();

            if (user != num) {
                guess = false;
                System.out.println("Your guess is incorrect. Game over. ˙◠˙");
                System.out.println("Thank you for playing! ヾ( ˃ᴗ˂ )◞ • *✰");
                break;
            } else {
                System.out.println("Correct! The money will be added to your balance. (˵ •̀ ᴗ - ˵ ) ✧\n");
                winnings += num;
            }

            interval *= 2;
            num = rand.nextInt(interval + 1);

            System.out.println("\nWould you like to keep playing? Enter y to continue or n to stop: \n");
            kb.nextLine();
            keepPlaying = kb.nextLine();

            if (keepPlaying.trim().toLowerCase().equals("y")) {
                System.out.println("Good choice! You currently have $" + winnings + ".00.\n");
            } else {
                System.out.println("You have ended with $" + winnings + ".00. Good game!");
                System.out.println("Thank you for playing! ヾ( ˃ᴗ˂ )◞ • *✰");
                play = false;
            }
        }

        kb.close();

    }
}