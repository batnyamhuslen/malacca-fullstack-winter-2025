package mn.icode;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex01 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label text = new Label("hello");
        Button button = new Button("click me");

        button.setOnAction(e -> text.setText("Thank you"));

        VBox layout = new VBox(10, text,button);
        stage.setScene(new Scene(layout));
        stage.setTitle("exercise");
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
