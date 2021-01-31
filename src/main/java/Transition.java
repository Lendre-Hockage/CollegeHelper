import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Transition {
    public static Stage stage = new Stage();
    public static String CurrentLogin="" , CurrentPassword="";
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

                if (Files.isDirectory(Path.of("C:\\ThemeFolder"))== true && Files.isRegularFile(Path.of("C:\\ThemeFolder\\theme.txt")) ==true){
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
                    Authorization.input();                                                //Открываем форму после паузы
                    stage.hide();
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


            try(BufferedReader reader = new BufferedReader(new FileReader("C:\\ThemeFolder\\Auth.txt"))) {
                String th = reader.readLine();

                int space;
                if (th ==null){
                    Menu.Alert18();
                }
                for (int i=0; i<2; i++) {
                    space =  th.indexOf(" "); //ищем первый пробел в строке
                    switch (i) {
                        case 0: //если это первая итерация,
                            CurrentLogin = th.substring(0, space); //записываем в текущий логин строку от начала до пробела
                            break;
                        case 1: //если это вторая итерация,
                            CurrentPassword = th.substring(0, space);
                            CurrentPassword=RegistrCode.byteArrayToHexString(RegistrCode.computeHash(CurrentPassword));//записываем в текущий пароль строку от начала до пробела
                            break;
                    }

                }
                //добавить сравненние с бд

            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        wait.play();
    }
}
