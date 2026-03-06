package mn.icode;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Ex5 extends Application{
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
 public void start(Stage stage) {

        String[] texts = {"Нэр:", "Нууц үг:"};
        Label[] labels = new Label[2];

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new Label(texts[i]);
        }

        TextField[] fields = {
                new TextField(),
                new PasswordField()
        };

        Button loginBtn = new Button("Нэвтрэх");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        for (int i = 0; i < 2; i++) {
            grid.add(labels[i], 0, i);  
            grid.add(fields[i], 1, i);   
        }

        grid.add(loginBtn, 1, 2); 

        Scene scene = new Scene(grid, 300, 200);
        stage.setScene(scene);
        stage.setTitle("ex5");
        stage.show();
    }
}
