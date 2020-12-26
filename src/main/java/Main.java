import java.lang.String;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button btn1 = new Button("OK");
        Label lbl1 = new Label("Hi!");
        Pane root = new Pane();
        root.getChildren().addAll(btn1, lbl1);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main menu"); // установка заголовка
        stage.setWidth(1000);
        stage.setHeight(450);
        stage.show();                   // отображение окна на экране
    }

    public static String retString(){
        return "HelloWorld!";
    }
}
