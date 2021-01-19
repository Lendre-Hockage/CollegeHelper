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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AccountForTeacher {

    public static Scene scene;
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

    public static void WindowTeacher(){
        AccountForStudent.usertype=2;
        Image av = new Image("LichKab.png");
        Button btn1 = new Button("", new ImageView(av));
        btn1.setId("buttons");
        btn1.setLayoutX(0);
        btn1.setLayoutY(20);
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AccountForTeacher.WindowTeacher();

            }
        });


        Image map = new Image("Map.png");
        Button btn3 = new Button("", new ImageView(map));
        btn3.setId("buttons");
        btn3.setLayoutX(0);
        btn3.setLayoutY(137);
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
        btn4.setLayoutY(254);
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AddEvent.delEv();
                Events.EventsForPrepAndSuperadm();
                primaryStage.hide();
            }
        });


        Image shed = new Image("Shed.png");
        Button btn5 = new Button("", new ImageView(shed));
        btn5.setId("buttons");
        btn5.setLayoutX(0);
        btn5.setLayoutY(371);
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Schedule.shedForPrepod();
                primaryStage.hide();
            }
        });

        Image exit = new Image("Exit.png");
        Button btn6 = new Button("", new ImageView(exit));
        btn6.setId("buttons");
        btn6.setLayoutX(0);
        btn6.setLayoutY(538);
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Authorization.input();
                primaryStage.hide();
            }
        });

        Label ex = new Label("Выход");
        ex.setId("labels");
        ex.setLayoutX(65);
        ex.setLayoutY(599);


        Label authorize = new Label("Личный кабинет");
        authorize.setId("labels");
        authorize.setLayoutX(25);
        authorize.setLayoutY(83);

        Label maps = new Label("Карта корпусов");
        maps.setId("labels");
        maps.setLayoutX(30);
        maps.setLayoutY(197);

        Label eve = new Label("События");
        eve.setId("labels");
        eve.setLayoutX(53);
        eve.setLayoutY(315);

        Label shedl = new Label("Расписание");
        shedl.setId("labels");
        shedl.setLayoutX(40);
        shedl.setLayoutY(432);




        //LABEL "ФАМИЛИЯ"
        Label surname = new Label("Фамилия:");
        surname.setId("Label");
        surname.setLayoutX(580);
        surname.setLayoutY(100);

        //EDIT "ВВОД ФАМИЛИЯ"
        surname1.setId("field");
        surname1.setLayoutX(580);
        surname1.setLayoutY(120);
        surname1.setText(AutorizCode.surname);



        //LABEL "ИМЯ"
        Label name = new Label("Имя:");
        name.setId("Label");
        name.setLayoutX(580);
        name.setLayoutY(185);

        //EDIT "ВВОД ИМЯ"
        name1.setId("field");
        name1.setLayoutX(580);
        name1.setLayoutY(205);
        name1.setText(AutorizCode.name);




        //LABEL "ОТЧЕСТВО"
        Label father = new Label("Отчество:");
        father.setId("Label");
        father.setLayoutX(580);
        father.setLayoutY(270);


        //EDIT "ВВОД ОТЧЕСТВО"
        father1.setId("field");
        father1.setLayoutX(580);
        father1.setLayoutY(290);
        father1.setText(AutorizCode.second_name);


        //LABEL "EMAIL"
        Label email = new Label("Электронная почта:");
        email.setId("Label");
        email.setLayoutX(580);
        email.setLayoutY(370);


        //EDIT "EMAIL"
        email1.setId("field_for_email");
        HBox box = new HBox(5);
        box.getChildren().addAll(email1, EventComboBox);
        EventComboBox.setId("event");
        box.setLayoutX(580);
        box.setLayoutY(390);




        //LABEL "ПАРОЛЬ"
        Label pass = new Label("Пароль:");
        pass.setId("Label");
        pass.setLayoutX(580);
        pass.setLayoutY(455);



        //EDIT "ПАРОЛЬ"
        pass1.setId("field");
        pass1.setLayoutX(580);
        pass1.setLayoutY(475);

        Image blue_green = new Image("BlueGreen.png");
        Button btn8 = new Button("", new ImageView(blue_green));
        btn8.setId("colors");


        Image grey_white = new Image("GreyWhite.png");
        Button btn9 = new Button("", new ImageView(grey_white));
        btn9.setId("colors");


        HBox themes = new HBox(0);
        themes.getChildren().addAll(btn8, btn9);
        themes.setLayoutX(432);
        themes.setLayoutY(425);






        Pane pane = new Pane(btn1, btn3, btn4, btn5, btn6, themes, authorize, maps, eve, shedl, ex,
                surname, surname1, name, name1, father, father1, email, box, pass, pass1 );
        scene = new Scene(pane, 1000, 650); //добавляем Grid в Scene

        primaryStage.setScene(scene); //добавляем scene в stage
        primaryStage.setTitle("Личный кабинет Карателя смертных");
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\ThemeFolder\\theme.txt")))
        {
            String th = reader.readLine();

            if (th.equals("1")){
                scene.getStylesheets().add("ForTeacherForm.css");
            }
            else {
                scene.getStylesheets().add("ForTeacherFormGREY.css");
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        //scene.getStylesheets().add(0, "ForTeacherForm.css"); //подключение CSS
        primaryStage.show();

        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try(FileWriter writer = new FileWriter("C:\\ThemeFolder\\theme.txt", false))
                {
                    String th = "1";
                    writer.write(th);
                    scene.getStylesheets().remove("ForTeacherFormGREY.css");
                    scene.getStylesheets().add("ForTeacherForm.css");
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        });

        btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try(FileWriter writer = new FileWriter("C:\\ThemeFolder\\theme.txt", false))
                {
                    String th = "2";
                    writer.write(th);
                    scene.getStylesheets().remove("ForTeacherForm.css");
                    scene.getStylesheets().add("ForTeacherFormGREY.css");
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        });
    }
}
