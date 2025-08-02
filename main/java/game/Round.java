package game;

import game.objects.GamePoints;

public class Round {
    public static void play(int player1Move, int player2Move, GamePoints gamePoints) {

        if (player1Move == 1 && player2Move == 1) {

            gamePoints.addPlayerMoves(3, 3);

        } else if (player1Move == 1 && player2Move == 2) {

            gamePoints.addPlayerMoves(0, 5);

        } else if (player1Move == 2 && player2Move == 1) {

            gamePoints.addPlayerMoves(5, 0);

        } else if (player1Move == 2 && player2Move == 2) {

            gamePoints.addPlayerMoves(1, 1);

        }

    }
}
