package homework8.fx_graphics;

import homework8.games.Games;
import homework8.games.GuessTheNumber;
import homework8.games.GuessTheWord;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerGuessTheNumber {

    @FXML
    private Button turnButton;

    @FXML
    protected Button newGameButton; //будем обращаться к этому свойству из класса Main

    @FXML
    private TextField textField;

    @FXML
    protected Label gameMessages; //будем обращаться к этому свойству из класса Main

    @FXML
    protected Label greeting;//будем обращаться к этому свойству из класса Main

    @FXML
    protected ComboBox<?> choiceGame;

    protected Games[] games = {new GuessTheNumber(), new GuessTheWord()}; //воспользуемся полиморфизмом


    @FXML
    void newGame() {
        int gameIndex = choiceGame.getSelectionModel().getSelectedIndex();
        games[gameIndex].resetGame();
        turnButton.setDisable(false);
        newGameButton.setDisable(true);
        greeting.setText(games[gameIndex].greeting()); //вывод информации об условиях игры
        gameMessages.setText("");
    }

    @FXML
    void doExit() {
        Platform.exit();
    }


    @FXML
    void turnGame() {
        String message = textField.getText();
        if (!message.isEmpty()) {
            textField.clear();
            int gameIndex = choiceGame.getSelectionModel().getSelectedIndex();
            if (gameIndex == 0) {
                try {
                    int number = Integer.parseInt(message); //перегоняем String в int и обратно. Чтоб в случае чего словить обрабатываемое исключение.
                    message = String.valueOf(number);
                } catch (NumberFormatException e) {
                    gameMessages.setText("Ошибка!");
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Ошибка данных! Введите число!");
                    alert.show();
                    return;
                }
            }
            gameMessages.setText(games[gameIndex].playerTurn(message)); //ход игрока и вывод информации в Label
            if (!games[gameIndex].isGame()) {
                turnButton.setDisable(true);
                newGameButton.setDisable(false);
            }
        }
    }

}
