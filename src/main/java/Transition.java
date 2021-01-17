import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Transition {
    public static Stage stage = new Stage();
    public static void trans(){
        Label lbl = new Label("Переход с задержкой");


        Pane root = new Pane();
        root.getChildren().add(lbl);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(650);
        stage.show();// отображение окна на экране


        PauseTransition wait = new PauseTransition(Duration.seconds(0));           // Пауза в программе на 2 секунды
        wait.setOnFinished((e) -> {
            /*YOUR METHOD*/
            Authorization.input();                                                //Открываем форму после паузы
            stage.hide();
        });
        wait.play();
    }
}
