package mn.icode;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label text = new Label("click me");
        Button button = new Button("Click");

        VBox layout = new VBox(10, text, button);
        Scene scene = new Scene(layout, 200, 200);

        stage.setTitle("Small WIndow");
        stage.setScene(scene);
        stage.show();
    }
}
