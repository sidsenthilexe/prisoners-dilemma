package game.objects;
import java.util.ArrayList;

public class GameData {
    private int round;

    public enum Move {
        COOPERATE,
        DEFECT
    }
    private ArrayList<Move> player1Moves;
    private ArrayList<Move> player2Moves;

    private ArrayList<Integer> player1Points;
    private ArrayList<Integer> player2Points;

    public enum PlayerTypes {
        PLAYER,
        BOT
    }
    private PlayerTypes player1Type;
    private PlayerTypes player2Type;

    public enum Outcome {
        PLAYER_1_WIN,
        PLAYER_2_WIN,
        DRAW
    }
    private Outcome outcome;

    public GameData(PlayerTypes player1Type, PlayerTypes player2Type) {
        this.player1Type = player1Type;
        this.player2Type = player2Type;

        player1Moves = new ArrayList<>();
        player2Moves = new ArrayList<>();

        player1Points = new ArrayList<>();
        player2Points = new ArrayList<>();
    }

    public void Move(Move player1Move, Move player2Move) {
        player1Moves.add(player1Move);
        player2Moves.add(player2Move);
    }



}
