import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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
    public static Stage stage = new Stage();
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

    public static void Alert14() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Расписание успешно добавлено.");

        alert.showAndWait();
    }

    public static void Alert15() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Выберите группу.");

        alert.showAndWait();
    }
    public static void Alert16() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Событие добавлено");

        alert.showAndWait();
    }
    public static void Alert17() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Указанная дата раньше текущей");

        alert.showAndWait();
    }

    public static void Window() {


//        Label Hello = new Label("ГЛАВНОЕ МЕНЮ");
//        Hello.setAlignment(Pos.CENTER);
//        Hello.setId("Hello");



        VBox vertical_buttons = new VBox();
        vertical_buttons.setAlignment(Pos.CENTER);
        vertical_buttons.setSpacing(50);



        Image av = new Image("Av.png");
        Button btn1 = new Button("", new ImageView(av));
        btn1.setId("buttons");
        btn1.setLayoutX(0);
        btn1.setLayoutY(20);
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Authorization.input();
                stage.hide();
            }
        });

       Image reg = new Image("Reg.png");
        Button btn2 = new Button("", new ImageView(reg));
        btn2.setId("buttons");
        btn2.setLayoutX(0);
        btn2.setLayoutY(137);
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Registration.SReg();
                stage.hide();
            }
        });


        Image map = new Image("Map.png");
        Button btn3 = new Button("", new ImageView(map));
        btn3.setId("buttons");
        btn3.setLayoutX(0);
        btn3.setLayoutY(254);
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Maps.Map();
                stage.hide();
            }
        });


        Image ev = new Image("Ev.png");
        Button btn4 = new Button("", new ImageView(ev));
        btn4.setId("buttons");
        btn4.setLayoutX(0);
        btn4.setLayoutY(371);
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AddEvent.delEv();
                Events.Window();
                stage.hide();
            }
        });


        Image shed = new Image("Shed.png");
        Button btn5 = new Button("", new ImageView(shed));
        btn5.setId("buttons");
        btn5.setLayoutX(0);
        btn5.setLayoutY(488);
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Schedule.Window();
                stage.hide();
            }
        });


        Label authorize = new Label("Авторизация");
        authorize.setId("labels");
        authorize.setLayoutX(35);
        authorize.setLayoutY(83);

        Label registration = new Label("Регистрация");
        registration.setId("labels");
        registration.setLayoutX(40);
        registration.setLayoutY(197);

        Label maps = new Label("Карта корпусов");
        maps.setId("labels");
        maps.setLayoutX(30);
        maps.setLayoutY(315);

        Label eve = new Label("События");
        eve.setId("labels");
        eve.setLayoutX(53);
        eve.setLayoutY(432);

        Label shedl = new Label("Расписание");
        shedl.setId("labels");
        shedl.setLayoutX(40);
        shedl.setLayoutY(549);


        Pane pane = new Pane(btn1, btn2, btn3, btn4, btn5, authorize, registration, maps, eve, shedl);
        Scene scene = new Scene(pane, 1000, 650); //добавляем Grid в Scene

        stage.setScene(scene); //добавляем scene в stage
        stage.setTitle("Личный кабинет");
        scene.getStylesheets().add(0, "ForMenu.css"); //подключение CSS
        stage.show();

    }
}
