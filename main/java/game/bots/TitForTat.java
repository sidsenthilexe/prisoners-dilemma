package game.bots;

import game.objects.GamePoints;

public class TitForTat {

    public static int move(GamePoints points) {
        return points.getPlayer1Move(points.getPlayer1Size()-1);
    }

}
