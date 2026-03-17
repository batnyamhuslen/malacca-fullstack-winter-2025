package org.openjfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    TextField display = new TextField();

    double num1 = 0;
    String operator = "";

    @Override
    public void start(Stage stage) {

        display.setEditable(false);
        display.setPrefHeight(80);

    
        String[][] buttons = {
                {"1","2","3","+"},
                {"4","5","6","-"},
                {"7","8","9","*"},
                {"0","C","=","/"}
        };

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().add(display);

        for (String[] row : buttons) {

            HBox hbox = new HBox(10);
            hbox.getStyleClass().add("button-number");
           
            for (String text : row) {

                Button btn = new Button(text);
                btn.setPrefWidth(50);
                btn.setOnAction(e -> handleButton(text));
                hbox.getChildren().add(btn);
            }

            root.getChildren().add(hbox);
        }
        root.setStyle("-fx-background-color: purple;");
        Scene scene = new Scene(root,250,250);
        // scene.getStylesheets().add("css/style.css");
        // System.out.println(App.class.getResource("css/style.css"));
        // scene.getStylesheets().add();
        // URL stylesheet = App.class.getResource("/org/openjfx/resources/css/style.css");
        // scene.getStylesheets().add(stylesheet.toString());
        
        stage.setTitle("JavaFX Calculator");
        stage.setScene(scene);
        stage.show();
    }

    private void handleButton(String value) {

        switch(value) {

            case "+":
            case "-":
            case "*":
            case "/":
                num1 = Double.parseDouble(display.getText());
                operator = value;
                display.clear();
                break;

            case "=":
                double num2 = Double.parseDouble(display.getText());
                double result = 0;

                switch(operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": result = num1 / num2; break;
                }

                display.setText(String.valueOf(result));
                break;

            case "C":
                display.clear();
                break;

            default:
                display.appendText(value);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}