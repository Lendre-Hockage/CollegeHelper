import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {


        Label lbl = new Label("Переход с задержкой");

        Pane root = new Pane();
        root.getChildren().add(lbl);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(650);
        stage.show();

        PauseTransition wait = new PauseTransition(Duration.seconds(0));           // Пауза в программе на 2 секунды
        wait.setOnFinished((e) -> {
            /*YOUR METHOD*/
            //Menu.Window();                                                         //Открываем форму после паузы
            Authorization.input();
            stage.hide();
        });
        wait.play();

    }
}
