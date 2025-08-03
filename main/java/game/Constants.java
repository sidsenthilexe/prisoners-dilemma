package game;

import game.objects.GamePoints;

public final class Constants {

    private Constants() {}

    public static final String PLAY_PROMPT = "[1] Cooperate\n[2] Defect";

    public static String DISPLAY_END_POINTS(GamePoints points) {
        if (points.getWinner() != 0) {
            return "Player " + points.getWinner()  + " wins with " + points.getWinnerScore() + " points\nPlayer " + points.getLoser() + " lost with " + points.getLoserScore() + " points";
        } else {
            return "The game was tied at " + points.getWinnerScore() + " points";
        }
    }

}
