import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
            try {

                if (Files.isDirectory(Path.of("C:\\ThemeFolder"))==true && Files.isRegularFile(Path.of("C:\\ThemeFolder\\theme.txt")) ==true){
                    Authorization.input();
                    stage.hide();
                }
                else {
                    Files.createDirectory(Path.of("C:\\ThemeFolder"));
                    Files.createFile(Path.of("C:\\ThemeFolder\\theme.txt"));
                    try(FileWriter writer = new FileWriter("C:\\ThemeFolder\\theme.txt", false))
                    {
                        String th = "1";
                        writer.write(th);

                    } catch (IOException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            Authorization.input();                                                //Открываем форму после паузы
            stage.hide();
        });
        wait.play();
    }
}
