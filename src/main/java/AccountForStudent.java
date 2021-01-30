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

import java.io.*;

public class AccountForStudent {
    public static int usertype = 1;
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
    public static ComboBox<String> cmbox = new ComboBox<String>(Schedule.listEvent1);
    public static Label
            pass1  = new Label(),
            name1 = new Label(),
            surname1 = new Label(),
            father1 = new Label(),
            email1 = new Label(),
            group2 = new Label();


    public static Stage primaryStage = new Stage();
    public static void WindowStudent(){
        AccountForStudent.usertype=1;
        StandartMenu.showMenu();

        Image ph = new Image("Plus.png");
        Button photo = new Button("", new ImageView(ph));
        photo.setId("bu");
        photo.setLayoutX(326);
        photo.setLayoutY(99);
        photo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });


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
        name.setLayoutY(180);

        //EDIT "ВВОД ИМЯ"
        name1.setId("field");
        name1.setLayoutX(580);
        name1.setLayoutY(200);
        name1.setText(AutorizCode.name);




        //LABEL "ОТЧЕСТВО"
        Label father = new Label("Отчество:");
        father.setId("Label");
        father.setLayoutX(580);
        father.setLayoutY(280);


        //EDIT "ВВОД ОТЧЕСТВО"
        father1.setId("field");
        father1.setLayoutX(580);
        father1.setLayoutY(300);
        father1.setText(AutorizCode.second_name);




        //LABEL "ГРУППА"
        Label group = new Label("Группа:");
        group.setId("Label");
        group.setLayoutX(580);
        group.setLayoutY(380);


        //EDIT "ГРУППА"
        group2.setId("field");
        group2.setLayoutX(580);
        group2.setLayoutY(400);




        //LABEL "EMAIL"
        Label email = new Label("Электронная почта:");
        email.setId("Label");
        email.setLayoutX(580);
        email.setLayoutY(480);


        //EDIT "EMAIL"
        email1.setId("field");
        email1.setLayoutX(580);
        email1.setLayoutY(500);


        //БЛОК НАСТРОЙКИ

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

        Button edit = new Button("");
        edit.setId("ed");
        edit.setLayoutX(260);
        edit.setLayoutY(472);
        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                EditData.EditStudent();
                primaryStage.hide();

            }
        });





        Pane pane = new Pane(StandartMenu.btn1, StandartMenu.btn3, StandartMenu.btn5, StandartMenu.btn4,  StandartMenu.btn6,
                StandartMenu.authorize, StandartMenu.eve, StandartMenu.ex, StandartMenu.shedl, StandartMenu.maps,
                photo, themes, surname, surname1, name, name1, father, father1, email, email1, group, group2, edit);

        scene = new Scene(pane, 1000, 650); //добавляем Grid в Scene

        primaryStage.setScene(scene);
        //добавляем scene в stage
        primaryStage.setTitle("Личный кабинет студента");
        primaryStage.setResizable(false);
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\ThemeFolder\\theme.txt")))
        {
            String th = reader.readLine();

            if (th.equals("1")){
                scene.getStylesheets().add("ForStudentForm.css");
            }
            else {
                scene.getStylesheets().add("ForStudentFormGREY.css");
            }
        }
        catch (IOException e)
        {
        System.out.println(e.getMessage());
        }
        //scene.getStylesheets().add("ForStudentForm.css");//подключение CSS

        primaryStage.show();

        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try(FileWriter writer = new FileWriter("C:\\ThemeFolder\\theme.txt", false))
                {
                    String th = "1";
                    writer.write(th);
                    scene.getStylesheets().remove("ForStudentFormGREY.css");
                    scene.getStylesheets().add("ForStudentForm.css");
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
                    scene.getStylesheets().remove("ForStudentForm.css");
                    scene.getStylesheets().add("ForStudentFormGREY.css");
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        });

    }
}
