package players;

import game.Board;
import players.AI.FictitiousPlayer;
import players.AI.RandomPlayer;
import players.AI.TitForTatPlayer;
import players.AI.BullyPlayer;

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
                break;
            case YOUR_ALG:
                break;
            default:
        }

        return null;
    }
}
