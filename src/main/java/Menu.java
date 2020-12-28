import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu {

   /* public static void TestAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("CurrentLogin" + autorizeme.CurrentLogin + "CurrentPassword"+ autorizeme.CurrentPassword + "CurrentType"+autorizeme.CurrentType);

        alert.showAndWait();
    } */

    public static void DatabaseFail() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Database connection is failed.");
        alert.showAndWait();
    }


    public static void Alert1() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");
        alert.setContentText("Авторизация выполнена успешно. \n Ваше имя: " + AutorizCode.surname
        + " " + AutorizCode.name + " " + AutorizCode.second_name + ". \n Ваша группа: " + AutorizCode.group_name + ". \n " +
                "Ваш e-mail: " + AutorizCode.email); alert.showAndWait();

        alert.setHeaderText(null);

        }





    public static void Alert2() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Такого логина нет среди зарегистрированных.");

        alert.showAndWait();
    }

    public static void Alert3() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Пароли не совпадают.");

        alert.showAndWait();
    }

    public static void Alert4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Пользователь с таким логином уже существует.");

        alert.showAndWait();
    }

    public static void Alert5() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Регистрация выполнена успешно.");

        alert.showAndWait();
    }

    public static void Alert6() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Пароль не может быть пустым.");

        alert.showAndWait();
    }

    public static void Alert7() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Выберите тип пользователя.");

        alert.showAndWait();
    }

    public static void Alert8() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Неверный пароль.");

        alert.showAndWait();
    }

    public static void Alert9() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Логин не может быть пустым.");

        alert.showAndWait();
    }

    public static void Alert10() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Логин не может содержать пробелы.");

        alert.showAndWait();
    }

    public static void Alert11() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Пароль не может содержать пробелы.");

        alert.showAndWait();
    }

    public static void Alert12() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Имя/Фамилия/Отчество должно быть написано русскими букавками");

        alert.showAndWait();
    }

    public static void Alert13() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Нужно ввести только часть почты только до @");

        alert.showAndWait();
    }

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
