import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AccountForStudent {
    public static ObservableList<String> listEvent = FXCollections.observableArrayList("@gmail.com",
            "@yandex.ru",
            "@ya.ru",
            "@yandex.com",
            "@yandex.ua",
            "@yandex.kz",
            "@yandex.by",
            "@mail.ru",
            "@list.ru",
            "@inbox.ru",
            "@bk.ru",
            "@yahoo.com",
            "@hotmail.com",
            "@outlook.com",
            "@internet.ru");
    public static ComboBox<String> EventComboBox = new ComboBox<String>(listEvent);
    public static TextField
            pass1  = new PasswordField(),
            name1 = new TextField(),
            surname1 = new TextField(),
            father1 = new TextField(),
            email1 = new TextField();


    private static Stage primaryStage = new Stage();
    public static void WindowStudent(){


        Image av = new Image("Av.png");
        Button btn1 = new Button("", new ImageView(av));
        btn1.setId("buttons");
        btn1.setLayoutX(0);
        btn1.setLayoutY(20);
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Authorization.input();
                primaryStage.hide();
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
                primaryStage.hide();
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
                primaryStage.hide();
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
                primaryStage.hide();
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
                primaryStage.hide();
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



        //LABEL "ФАМИЛИЯ"
        Label surname = new Label("Фамилия:");
        surname.setId("Label");
        surname.setLayoutX(580);
        surname.setLayoutY(80);

        //EDIT "ВВОД ФАМИЛИЯ"
        surname1.setId("field");
        surname1.setLayoutX(580);
        surname1.setLayoutY(100);
        surname1.setText(AutorizCode.surname);


        //LABEL "ИМЯ"
        Label name = new Label("Имя:");
        name.setId("Label");
        name.setLayoutX(580);
        name.setLayoutY(165);

        //EDIT "ВВОД ИМЯ"
        name1.setId("field");
        name1.setLayoutX(580);
        name1.setLayoutY(185);
        name1.setText(AutorizCode.name);




        //LABEL "ОТЧЕСТВО"
        Label father = new Label("Отчество:");
        father.setId("Label");
        father.setLayoutX(580);
        father.setLayoutY(250);


        //EDIT "ВВОД ОТЧЕСТВО"
        father1.setId("field");
        father1.setLayoutX(580);
        father1.setLayoutY(270);
        father1.setText(AutorizCode.second_name);




        //LABEL "ГРУППА"
        Label group = new Label("Группа:");
        group.setId("Label");
        group.setLayoutX(580);
        group.setLayoutY(335);


        //EDIT "ГРУППА"
        cmbox.setId("event");
        cmbox.setLayoutX(580);
        cmbox.setLayoutY(365);




        //LABEL "EMAIL"
        Label email = new Label("Электронная почта:");
        email.setId("Label");
        email.setLayoutX(580);
        email.setLayoutY(430);


        //EDIT "EMAIL"
        email1.setId("field_for_email");
        HBox box = new HBox(5);
        box.getChildren().addAll(email1, EventComboBox);
        EventComboBox.setId("event");
        box.setLayoutX(580);
        box.setLayoutY(450);




        //LABEL "ПАРОЛЬ"
        Label pass = new Label("Пароль:");
        pass.setId("Label");
        pass.setLayoutX(580);
        pass.setLayoutY(515);



        //EDIT "ПАРОЛЬ"
        pass1.setId("field");
        pass1.setLayoutX(580);
        pass1.setLayoutY(535);





        Pane pane = new Pane(btn1, btn2, btn3, btn4, btn5, authorize, registration, maps, eve, shedl,
                surname, surname1, name, name1, father, father1, email, box, group, cmbox, pass, pass1 );
        Scene scene = new Scene(pane, 1000, 650); //добавляем Grid в Scene

        primaryStage.setScene(scene); //добавляем scene в stage
        primaryStage.setTitle("Личный кабинет студента");
        scene.getStylesheets().add(0, "ForStudentForm.css"); //подключение CSS
        primaryStage.show();


    }
}
