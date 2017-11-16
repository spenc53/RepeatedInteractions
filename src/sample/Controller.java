package sample;

import game.Board;
import game.Play;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static players.Player.TYPES;


public class Controller implements Initializable{




    @FXML
    private Label countLabel;

    @FXML private ComboBox player1;
    @FXML private ComboBox player2;
    @FXML private ComboBox board;
    @FXML private TextField numRound;


    @FXML
    public void play(){
        String player1Type = player1.getValue().toString();
        String player2Type = player2.getValue().toString();
        String boardType = board.getValue().toString();
        int roundsToPlay = Integer.parseInt(numRound.getText());


        Play play = new Play(player1Type, player2Type, boardType, roundsToPlay);
        double scores[] = play.playGame();

        countLabel.setText("player1 (" + player1Type + "): " + scores[0] + "\nplayer2 (" + player2Type + ") : " + scores[1]);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        player1.getItems().removeAll();
        player1.getItems().addAll( TYPES);
        player1.getSelectionModel().select(0);

        player2.getItems().removeAll();
        player2.getItems().addAll( TYPES);
        player2.getSelectionModel().select(0);

        board.getItems().removeAll();
        board.getItems().addAll(Board.BOARD_TYPES);
        board.getSelectionModel().select(0);

        numRound.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    numRound.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}
