package mn.icode;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex4 extends Application{
    public static void main(String[] args) {
        launch(args);
    }

   @Override
    public void start(Stage stage) {

        Label numberLabel = new Label("KHUSLEN");
        numberLabel.setStyle("-fx-font-size: 24px;");

        Button redButton = new Button("Red");
        Button greenButton = new Button("Green");
        Button blueButton = new Button("Blue");

        redButton.setOnAction(e -> {
            numberLabel.setStyle("-fx-font-size: 24px; -fx-background-color: red;");
        });

        greenButton.setOnAction(e -> {
            numberLabel.setStyle("-fx-font-size: 24px; -fx-background-color: green;");
        });

        blueButton.setOnAction(e -> {
            numberLabel.setStyle("-fx-font-size: 24px; -fx-background-color: blue;");
        });

        HBox buttons = new HBox(10, redButton, greenButton, blueButton);
        VBox layout = new VBox(20, numberLabel, buttons);

        stage.setScene(new Scene(layout, 300, 300));
        stage.setTitle("ex4");
        stage.show();
    }


}
