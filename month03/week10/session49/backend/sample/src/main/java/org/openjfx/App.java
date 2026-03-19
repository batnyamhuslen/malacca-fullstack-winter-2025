package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
       Label garchig = new Label("javaFx");
       Button tovch = new Button("click me");

       tovch.setOnAction(e-> System.out.println("Clicked!"));

       Vbox layout = new Vbox(10,garchig, tovch);
       Scene dvr = new Scene(layout, 400,300);

        stage.setTitle("Hello JavaFX");
        stage.setScene(дүр);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}