package players;

/**
 * Created by spencer on 11/15/17.
 */
public class PlayerNotFoundException extends Exception {
    public PlayerNotFoundException(String type) {
        super("Player " + type + " is not a valid type");
    }
}
