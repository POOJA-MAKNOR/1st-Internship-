//CODSOFT - Task 1
//NUMBER GAME

import java.util.Scanner;
public class NumberGame {
    public static void main(String args[]) {
        System.out.println("!!!!!NUMBER GUESSING GAME!!!!!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name:");
        String name = sc.nextLine();
        int chances = 6;
        int finals = 0;
        boolean playAgain = true;

        System.out.println("Welcome " + name + " !!!");
        System.out.println("In this game you have to guess a number in between 1 to 100");
        System.out.println("You have about " + chances + " chances to win the game");

        while (playAgain) {
            int rand = getrandN(1, 100);
            boolean guess = false;
            for (int i = 0; i < chances; i++) {
                System.out.println("This is your chance no. " + (i + 1) + " , Enter your number :");
                int user = sc.nextInt();
                if (user == rand) {
                    guess = true;
                    finals += 1;
                    System.out.println("Congrats " + name + " !!! You won the game !!");
                    break;
                } else if (user > rand) {
                    System.out.println("Too high");
                    System.out.println("-----------------------------------------------------");
                } else {
                    System.out.println("Too Low");
                    System.out.println("-----------------------------------------------------");
                }
            }
            if (guess == false) {
                System.out.println("Sorry " + name + " , You lost the chances .\n" + "The number is : " + rand);
            }
            System.out.println("**********************************************************");
            System.out.println("Do you want to play again(y/n)");
            String a = sc.next();
            playAgain = a.equalsIgnoreCase("y");
        }
        System.out.println("That's it " + name + " ,Hope you enjoyed it !");
        System.out.println("Here is your Score :" + finals);
    }

    public static int getrandN(int min, int max)
    {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
