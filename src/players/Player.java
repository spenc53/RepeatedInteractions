package players;

import game.Board;

import java.util.Random;

/**
 * Created by spencer on 11/15/17.
 */
public abstract class Player {
    public static final String TIT_FOR_TAT = "Tit-for-tat";
    public static final String FICTITIOUS_PLAY = "Fictitious Play";
    public static final String MAXI_MIN = "MaxiMin";
    public static final String RANDOM = "Random";
    public static final String YOUR_ALG = "Our Algorithm";
    public static final String BULLY = "Bully";
    public static final String[] TYPES = {TIT_FOR_TAT, BULLY, FICTITIOUS_PLAY, MAXI_MIN, RANDOM, YOUR_ALG};

    protected boolean rowPlayer;
    protected Board board;

    public Player(boolean rowPlayer, Board board){
        this.rowPlayer = rowPlayer;
        this.board = board;
    }

    public abstract int getMove(int move);

}
