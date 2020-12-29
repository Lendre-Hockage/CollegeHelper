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

    public static void Window() {
        GridPane grid = new GridPane();


        grid.setHgap(0);
        grid.setPadding(new Insets(130, 20, 30, 30));
        // grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(930));
        grid.getRowConstraints().add(new RowConstraints(70));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(80));
        grid.getRowConstraints().add(new RowConstraints(150));
        grid.getRowConstraints().add(new RowConstraints(30));

        Label Hello = new Label("ГЛАВНОЕ МЕНЮ");
        Hello.setAlignment(Pos.CENTER);
        Hello.setId("Hello");
        grid.add(Hello, 0, 0);

        Label Hello2 = new Label("Выберите действие");
        Hello2.setId("Hello2");
        grid.add(Hello2, 0, 1);


        HBox gorizont_buttons = new HBox();
        gorizont_buttons.setAlignment(Pos.CENTER);
        gorizont_buttons.setSpacing(50);



        Image av = new Image("Av.png");
        Button btn1 = new Button("", new ImageView(av));
        btn1.setId("buttons");
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
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Events.Window();
                stage.hide();
            }
        });


        Image shed = new Image("Shed.png");
        Button btn5 = new Button("", new ImageView(shed));
        btn5.setId("buttons");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Schedule.Window();
                stage.hide();
            }
        });

        gorizont_buttons.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);
        grid.add(gorizont_buttons, 0, 3);


        HBox gorizont_labels = new HBox();
        gorizont_labels.setAlignment(Pos.CENTER);
        gorizont_labels.setSpacing(70);

        Label authorize = new Label("Авторизация");
        authorize.setId("labels");

        Label registration = new Label("Регистрация");
        registration.setId("labels");

        Label maps = new Label("Карта корпусов");
        maps.setId("labels");

        Label eve = new Label("События");
        eve.setId("labels");

        Label shedl = new Label("Расписание");
        shedl.setId("labels");

        gorizont_labels.getChildren().addAll(authorize, registration, maps, eve, shedl);
        grid.add(gorizont_labels, 0, 4);


        Scene scene = new Scene(grid, 1000, 650); //добавляем Grid в Scene

        stage.setScene(scene); //добавляем scene в stage
        stage.setTitle("Главное меню");
        scene.getStylesheets().add(0, "ForMenu.css"); //подключение CSS
        stage.show();

    }
}