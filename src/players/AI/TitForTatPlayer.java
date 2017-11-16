package players.AI;

import game.Board;
import players.Player;

/**
 * Created by spencer on 11/15/17.
 */
public class TitForTatPlayer extends Player {
    public TitForTatPlayer(boolean rowPlayer, Board board) {
        super(rowPlayer, board);
    }

    @Override
    public int getMove(int move) {
        if(move == -1) return 0;
        return move;
    }
}
