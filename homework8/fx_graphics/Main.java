package homework8.fx_graphics;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("guessTheNumber.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Угадай число и слово");
        primaryStage.setScene(new Scene(root));

        ControllerGuessTheNumber myController = (ControllerGuessTheNumber)loader.getController();
        myController.greeting.setText(myController.games[0].greeting()); //выводим информацию по условиям игры
        myController.gameMessages.setText("");
        myController.newGameButton.setDisable(true);


        ObservableList games = FXCollections.observableArrayList("Угадай число", "Угадай слово");
        myController.choiceGame.setItems(games);
        myController.choiceGame.getSelectionModel().select(0);

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
