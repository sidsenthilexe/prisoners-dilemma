import game.BotVsBot;
import game.HumanVsBot;
import game.LocalMultiplayer;

import static game.Constants.HELP;
import static game.Constants.BOTS_LIST;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int chosenOption;

        System.out.println("Welcome to the Prisoner's Dilemma game!");

        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("[1] Display game help\n[2] Play Local Multiplayer\n[3] Play against bots\n[4] Bot vs Bot Games\n[5] Exit");
            chosenOption = scan.nextInt();

            switch (chosenOption) {
                case 1:

                    System.out.println(HELP);
                    break;

                case 2:

                    System.out.println("[1] Play Single Round\n[2] Play Multiple Rounds");
                    chosenOption = scan.nextInt();

                    if (chosenOption == 1) {
                        LocalMultiplayer.playRound();
                    } else {
                        System.out.println("Enter number of rounds to be played");
                        chosenOption = scan.nextInt();
                        LocalMultiplayer.playMultipleRounds(chosenOption);
                    }

                    break;

                case 3:
                    System.out.println("Select bot to play against\n[1] Tit for Tat\n[2] Always Defect\n[3] Always Cooperate\n[4] Tit for Two Tats");
                    int botNumber = scan.nextInt();

                    System.out.println("[1] Play Single Round\n[2] Play Multiple Rounds");
                    chosenOption = scan.nextInt();

                    if (chosenOption == 1) {
                        HumanVsBot.playRound(botNumber);
                    } else {
                        System.out.println("Enter number of rounds to be played");
                        chosenOption = scan.nextInt();
                        HumanVsBot.playMultipleRounds(chosenOption, botNumber);
                    }

                    break;

                case 4:

                    System.out.println("Select bot 1\n" + BOTS_LIST);
                    int bot1 = scan.nextInt();

                    System.out.println("Select bot 2\n" + BOTS_LIST);
                    int bot2 = scan.nextInt();

                    System.out.println("[1] Run Single Round\n[2] Run Multiple Rounds");
                    chosenOption = scan.nextInt();

                    if(chosenOption == 1) {
                        BotVsBot.playRound(bot1, bot2);
                    } else {
                        System.out.println("Enter number of rounds to be played");
                        chosenOption = scan.nextInt();
                        BotVsBot.playMultipleRounds(chosenOption, bot1, bot2);
                    }

                    break;

                case 5:

                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;

            }

        } while (chosenOption != 3);
    }
}
