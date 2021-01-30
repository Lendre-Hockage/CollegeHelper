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

public class AccountForSuperAdmin {
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
    public static Label
            name1 = new Label(),
            surname1 = new Label(),
            father1 = new Label(),
            email1 = new Label();


    public static Stage primaryStage = new Stage();

    public static void WindowAdmin(){

        AccountForStudent.usertype=3;
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
        surname.setLayoutY(130);

        //EDIT "ВВОД ФАМИЛИЯ"
        surname1.setId("field");
        surname1.setLayoutX(580);
        surname1.setLayoutY(150);
        surname1.setText(AutorizCode.surname);



        //LABEL "ИМЯ"
        Label name = new Label("Имя:");
        name.setId("Label");
        name.setLayoutX(580);
        name.setLayoutY(230);

        //EDIT "ВВОД ИМЯ"
        name1.setId("field");
        name1.setLayoutX(580);
        name1.setLayoutY(250);
        name1.setText(AutorizCode.name);




        //LABEL "ОТЧЕСТВО"
        Label father = new Label("Отчество:");
        father.setId("Label");
        father.setLayoutX(580);
        father.setLayoutY(330);


        //EDIT "ВВОД ОТЧЕСТВО"
        father1.setId("field");
        father1.setLayoutX(580);
        father1.setLayoutY(350);
        father1.setText(AutorizCode.second_name);



        //LABEL "EMAIL"
        Label email = new Label("Электронная почта:");
        email.setId("Label");
        email.setLayoutX(580);
        email.setLayoutY(430);


        //EDIT "EMAIL"
        email1.setId("field");
        email1.setLayoutX(580);
        email1.setLayoutY(450);




//        //LABEL "ПАРОЛЬ"
//        Label pass = new Label("Пароль:");
//        pass.setId("Label");
//        pass.setLayoutX(580);
//        pass.setLayoutY(455);
//
//
//
//        //EDIT "ПАРОЛЬ"
//        pass1.setId("field");
//        pass1.setLayoutX(580);
//        pass1.setLayoutY(475);


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
                EditData.EditPrepAndSup();
                primaryStage.hide();

            }
        });



        Pane pane = new Pane(StandartMenu.btn1,  StandartMenu.btn5, StandartMenu.btn4,  StandartMenu.btn6, StandartMenu.btn7,
                themes, StandartMenu.authorize, StandartMenu.eve, StandartMenu.ex, StandartMenu.shedl,  StandartMenu.reg_teach,
                surname, surname1, name, name1, father, father1, email, email1, edit, photo);
        scene = new Scene(pane, 1000, 650); //добавляем Grid в Scene

        primaryStage.setScene(scene); //добавляем scene в stage
        primaryStage.setTitle("Личный кабинет супер-админа");
        primaryStage.setResizable(false);
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\ThemeFolder\\theme.txt")))
        {
            String th = reader.readLine();

            if (th.equals("1")){
                scene.getStylesheets().add("ForAdminForm.css");
            }
            else {
                scene.getStylesheets().add("ForAdminFormGREY.css");
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        //scene.getStylesheets().add(0, "ForAdminForm.css"); //подключение CSS
        primaryStage.show();

        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try(FileWriter writer = new FileWriter("C:\\ThemeFolder\\theme.txt", false))
                {
                    String th = "1";
                    writer.write(th);
                    scene.getStylesheets().remove("ForAdminFormGREY.css");
                    scene.getStylesheets().add("ForAdminForm.css");
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
                    scene.getStylesheets().remove("ForAdminForm.css");
                    scene.getStylesheets().add("ForAdminFormGREY.css");
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        });
    }
}
