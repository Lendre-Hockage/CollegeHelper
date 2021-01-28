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
    public static TextField
            pass1  = new PasswordField(),
            name1 = new TextField(),
            surname1 = new TextField(),
            father1 = new TextField(),
            email1 = new TextField();


    public static Stage primaryStage = new Stage();
    public static void WindowStudent(){
        AccountForStudent.usertype=1;
        StandartMenu.showMenu();

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





        Pane pane = new Pane(StandartMenu.btn1, StandartMenu.btn3, StandartMenu.btn5, StandartMenu.btn4,  StandartMenu.btn6,
                StandartMenu.authorize, StandartMenu.eve, StandartMenu.ex, StandartMenu.shedl, StandartMenu.maps,
                themes, surname, surname1, name, name1, father, father1, email, box, group, cmbox, pass, pass1 );

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
