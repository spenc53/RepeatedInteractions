package players;

import game.Board;
import players.AI.*;

import static players.Player.*;

/**
 * Created by spencer on 11/15/17.
 */
public class AbstractPlayerFactory {

    private AbstractPlayerFactory(){}

    public static Player getPlayer(String type, boolean rowPlayer, Board board)  {
        switch (type){
            case TIT_FOR_TAT:
                return new TitForTatPlayer(rowPlayer, board);
            case RANDOM:
                return new RandomPlayer(rowPlayer, board);
            case FICTITIOUS_PLAY:
                return new FictitiousPlayer(rowPlayer, board);
            case BULLY:
                return new BullyPlayer(rowPlayer, board);
            case MAXI_MIN:
                return new MaximinPlayer(rowPlayer, board);
            case YOUR_ALG:
                return new OurAlgorithmPlayer(rowPlayer, board);
            default:
        }

        return null;
    }
}
