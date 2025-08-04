package game.bots;

import game.objects.GamePoints;

public class BotMoves {

    public static int TitForTat(GamePoints points, int playerNumber) {
        if (playerNumber == 2) {
            int playerLastMove;
            if (points.getPlayer1Size() > 0) {
                playerLastMove = points.getPlayer1Move(points.getPlayer1Size());
            } else {
                playerLastMove = 3;
            }

            if (DidPlayerDefect(playerLastMove)) {
                return 2;
            } else {
                return 1;
            }
        } else {
            int playerLastMove;
            if (points.getPlayer2Size() > 0) {
                playerLastMove = points.getPlayer2Move(points.getPlayer2Size());
            } else {
                playerLastMove = 3;
            }

            if (DidPlayerDefect(playerLastMove)) {
                return 2;
            } else {
                return 1;
            }
        }
    }

    public static int AlwaysDefect() {
        return 2;
    }

    public static int AlwaysCooperate() {
        return 1;
    }

    public static int TitForTwoTats(GamePoints points, int playerNumber) {
        if (playerNumber == 2) {
            boolean enoughMoves;
            int playerMove1 = 3;
            int playerMove2 = 3;

            if (points.getPlayer1Size() < 2) {
                enoughMoves = false;
            } else {
                enoughMoves = true;
                playerMove1 = points.getPlayer1Move(points.getPlayer1Size());
                playerMove2 = points.getPlayer1Move((points.getPlayer1Size() - 1));
            }

            if (enoughMoves && DidPlayerDefect(playerMove1) && DidPlayerDefect(playerMove2)) {
                return 2;
            } else {
                return 1;
            }
        } else {
            boolean enoughMoves;
            int playerMove1 = 3;
            int playerMove2 = 3;

            if (points.getPlayer2Size() < 2) {
                enoughMoves = false;
            } else {
                enoughMoves = true;
                playerMove1 = points.getPlayer1Move(points.getPlayer1Size());
                playerMove2 = points.getPlayer1Move((points.getPlayer1Size()-1));
            }

            if (enoughMoves && DidPlayerDefect(playerMove1) && DidPlayerDefect(playerMove2)) {
                return 2;
            } else {
                return 1;
            }
        }
    }

    private static boolean DidPlayerDefect(int playerMove) {
        return switch (playerMove) {
            case 5, 1 -> true;
            default -> false;
        };
    }

}
