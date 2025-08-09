package game;

import game.Constants.Move;
import game.Constants.PlayerType;
import game.Constants.PlayerID;

import game.objects.GameData;

public class PlayGame {

    public void SingleRound(PlayerType player1Type, PlayerType player2Type, PlayerID player1ID, PlayerID player2ID) {
        GameData gameData = new GameData(player1Type, player2Type, player1ID, player2ID);

    }

}
