package mn.icode;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex02 extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        TextField input = new TextField();
        Button button = new Button("Print");
        Label output = new Label("text will be here");

        button.setOnAction(e-> output.setText(input.getText()));

        VBox layout = new VBox(10, input,button,output);
        stage.setScene(new Scene(layout, 250, 250));
        stage.setTitle("exer2");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
 