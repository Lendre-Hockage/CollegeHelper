import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu {
    public static void Window() {
        Stage stage = new Stage();

        Button btn1 = new Button("Auth");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Authorization.input();
            }
        });
        btn1.setLayoutX(10);
        btn1.setLayoutY(10);

        Button btn2 = new Button("Regist");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Registration.SReg();
            }
        });
        btn2.setLayoutX(10);
        btn2.setLayoutY(30);

        Button btn3 = new Button("Maps");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Maps.Map();
            }
        });
        btn3.setLayoutX(10);
        btn3.setLayoutY(50);

        Button btn4 = new Button("Events");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Events.Window();
            }
        });
        btn4.setLayoutX(10);
        btn4.setLayoutY(70);

        Button btn5 = new Button("Schedule");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Schedule.Window();
            }
        });
        btn5.setLayoutX(10);
        btn5.setLayoutY(90);

        Pane root = new Pane();
        root.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Main menu"); // установка заголовка
        stage.setWidth(1000);
        stage.setHeight(650);
        stage.show();                   // отображение окна на экране
    }
}
