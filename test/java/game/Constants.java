package game;

public final class Constants {

    public enum Move {
        COOPERATE,
        DEFECT
    }

    public enum PlayerType {
        PLAYER,
        BOT
    }

    public enum PlayerID {
        PLAYER,
        TIT_FOR_TAT,
        ALWAYS_COOPERATE,
        ALWAYS_DEFECT,
        TIT_FOR_TWO_TATS,
        RANDOM
    }

    public static final class Points {
        public static int TIE_BOTH_COOPERATE = 3;
        public static int WIN_VS_COOPERATE = 5;
        public static int LOSE_VS_DEFECT = 0;
        public static int TIE_BOTH_DEFECT = 1;
    }

}
