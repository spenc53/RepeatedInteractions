package players.AI;

import game.Board;
import players.Player;

import java.util.Random;

/**
 * Created by spencer on 11/15/17.
 */

public class RandomPlayer extends Player {
    private Random random;

    public RandomPlayer(boolean rowPlayer, Board board) {
        super(rowPlayer, board);
        random = new Random();
    }

    @Override
    public int getMove(int move) {
        return random.nextInt(2);
    }


}
