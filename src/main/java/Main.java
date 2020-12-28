import java.lang.String;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {


        Registration.SReg();

        Button btn1 = new Button("OK");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Authorization.input();
            }
        });
        Label lbl1 = new Label("Hi!");


        Label lbl = new Label("Переход с задержкой");


        Pane root = new Pane();
        root.getChildren().add(lbl);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(650);
        stage.show();// отображение окна на экране


        PauseTransition wait = new PauseTransition(Duration.seconds(2));           // Пауза в программе на 2 секунды
        wait.setOnFinished((e) -> {
            /*YOUR METHOD*/
            Menu.Window();                                                         //Открываем форму после паузы
            stage.hide();
        });
        wait.play();

    }
}


