import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EditData {
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
    public static TextField log1 = new TextField(),
            pass1  = new TextField(),
            pass2 = new TextField(),
            name1 = new TextField(),
            surname1 = new TextField(),
            father1 = new TextField(),
            email1 = new TextField();
    public static PasswordField pass11 = new PasswordField(), pass22 = new PasswordField();
    public static int isOpen = 0, isOpen2 = 0; //0 если пароль точками, 1 если виден


    public static Stage primaryStage = new Stage();
    public static void EditStudent(){

        GridPane grid = new GridPane();   //создание сетки для разметки формы
        //   grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(70);
        grid.setPadding(new Insets(220, 167, 0, 167));

        grid.getColumnConstraints().add(new ColumnConstraints(300));
        grid.getColumnConstraints().add(new ColumnConstraints(300));



        grid.getRowConstraints().add(new RowConstraints(30));
        grid.getRowConstraints().add(new RowConstraints(40)); //Фамилия
        grid.getRowConstraints().add(new RowConstraints(10));

        grid.getRowConstraints().add(new RowConstraints(30));
        grid.getRowConstraints().add(new RowConstraints(40)); //Имя
        grid.getRowConstraints().add(new RowConstraints(10));

        grid.getRowConstraints().add(new RowConstraints(30));
        grid.getRowConstraints().add(new RowConstraints(40)); //Отчество
        grid.getRowConstraints().add(new RowConstraints(10));

        grid.getRowConstraints().add(new RowConstraints(30));
        grid.getRowConstraints().add(new RowConstraints(40)); //Группа


        //ЗАГОЛОВОК "РЕГИСТРАЦИЯ"
        Label re = new Label("Изменение данных");
        re.setId("welcome-text");   //для CSS
        re.setLayoutX(290);
        re.setLayoutY(142);


        //LABEL "ФАМИЛИЯ"
        Label surname = new Label("Фамилия:");
        surname.setId("Label");
        grid.add(surname, 0, 0);

        //EDIT "ВВОД ФАМИЛИЯ"
        surname1.setId("field");
        grid.add(surname1, 0, 1);
        surname1.setText(AutorizCode.surname);



        //LABEL "ИМЯ"
        Label name = new Label("Имя:");
        name.setId("Label");
        grid.add(name, 0, 3);

        //EDIT "ВВОД ИМЯ"
        name1.setId("field");
        grid.add(name1, 0, 4);
        name1.setText(AutorizCode.name);



        //LABEL "ОТЧЕСТВО"
        Label father = new Label("Отчество:");
        father.setId("Label");
        grid.add(father, 0, 6);

        //EDIT "ВВОД ОТЧЕСТВО"
        father1.setId("field");
        grid.add(father1, 0, 7);
        father1.setText(AutorizCode.second_name);



        //LABEL "ГРУППА"
        Label group = new Label("Группа:");
        group.setId("Label");
        grid.add(group, 0, 9);

        //EDIT "ГРУППА"
        cmbox.setId("event");
        grid.add(cmbox, 0, 10);



        //LABEL "EMAIL"
        Label email = new Label("Электронная почта:");
        email.setId("Label");
        grid.add(email, 1, 0);

        //EDIT "EMAIL"
        email1.setId("field");
        HBox box = new HBox(5);
        box.getChildren().addAll(email1, EventComboBox);
        EventComboBox.setId("event");
        grid.add(box,1,1);



        //LABEL "ЛОГИН"
        Label log = new Label("Логин:");
        log.setId("Label");
        grid.add(log, 1, 3);

        //EDIT "ЛОГИН"
        log1.setId("field");
        grid.add(log1, 1, 4);



        //LABEL "ПАРОЛЬ"
        Label pass = new Label("Пароль:");
        pass.setId("Label");
        grid.add(pass, 1, 6);

        //EDIT "ПАРОЛЬ"
        pass1.setId("field");
        pass11.setId("field");
        grid.add(pass11, 1, 7);



        //LABEL "ПАРОЛЬ ПОВТОР"
        Label pass_pov = new Label("Повторите пароль:");
        pass_pov.setId("Label");
        grid.add(pass_pov, 1, 9);

        //EDIT "ПАРОЛЬ ПОВТОР"
        pass2.setId("field");
        pass22.setId("field");
        grid.add(pass22, 1, 10);



        Image close = new Image("CloseEye1.png");
        Button close_eye = new Button("", new ImageView(close));
        close_eye.setId("eye");
        close_eye.setLayoutX(790);
        close_eye.setLayoutY(410);

        Image open = new Image("OpenEye1.png");
        Button open_eye = new Button("", new ImageView(open));
        open_eye.setId("eye");
        open_eye.setLayoutX(790);
        open_eye.setLayoutY(410);

        Image close1 = new Image("CloseEye1.png");
        Button close_eye1 = new Button("", new ImageView(close1));
        close_eye1.setId("eye");
        close_eye1.setLayoutX(790);
        close_eye1.setLayoutY(490);

        Image open1 = new Image("OpenEye1.png");
        Button open_eye1 = new Button("", new ImageView(open1));
        open_eye1.setId("eye");
        open_eye1.setLayoutX(790);
        open_eye1.setLayoutY(490);

        Button back = new Button("← Назад");
        back.setId("buttons");
        back.setLayoutX(340);
        back.setLayoutY(555);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AccountForStudent.WindowStudent();
                primaryStage.hide();
            }
        });

        Button save = new Button("Сохранить");
        save.setId("buttons");
        save.setLayoutX(520);
        save.setLayoutY(555);
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Pane without_other_enter = new Pane(grid, open_eye, open_eye1, back, re, save);


        close_eye.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isOpen = 0;
                pass11.setText(pass1.getText());
                pass1.setText(pass11.getText());
                grid.getChildren().remove(pass1);
                grid.add(pass11, 1,7);
                without_other_enter.getChildren().remove(close_eye);
                without_other_enter.getChildren().add(open_eye);
            }
        });

        open_eye.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isOpen = 1;
                pass1.setText(pass11.getText());
                pass11.setText(pass1.getText());
                grid.getChildren().remove(pass11);
                grid.add(pass1, 1,7);
                without_other_enter.getChildren().remove(open_eye);
                without_other_enter.getChildren().add(close_eye);
            }
        });

        close_eye1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isOpen2 = 0;
                pass22.setText(pass2.getText());
                pass2.setText(pass22.getText());
                grid.getChildren().remove(pass2);
                grid.add(pass22, 1,10);
                without_other_enter.getChildren().remove(close_eye1);
                without_other_enter.getChildren().add(open_eye1);
            }
        });

        open_eye1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isOpen2 = 1;
                pass2.setText(pass22.getText());
                pass22.setText(pass2.getText());
                grid.getChildren().remove(pass22);
                grid.add(pass2, 1,10);
                without_other_enter.getChildren().remove(open_eye1);
                without_other_enter.getChildren().add(close_eye1);
            }
        });

        Scene scene = new Scene(without_other_enter, 1000, 650); //добавляем Grid в Scene
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\ThemeFolder\\theme.txt")))
        {
            String th = reader.readLine();

            if (th.equals("1")){
                scene.getStylesheets().add("ForEditLichki.css");
            }
            else {
                scene.getStylesheets().add("ForEditLichkiGREY.css");
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        } //подключение CSS
        //scene.getStylesheets().add("ForEditLichkiGREY.css");
        primaryStage.setScene(scene); //добавляем scene в stage
        primaryStage.setTitle("Изменение данных в личном кабинете студента");//название форме (как наказывала Ишкушка)
        primaryStage.setResizable(false);
        primaryStage.show();
    }



public static void EditPrepAndSup(){
    GridPane grid = new GridPane();   //создание сетки для разметки формы
     //  grid.setGridLinesVisible(true);
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(70);
    grid.setPadding(new Insets(220, 167, 0, 167));

    grid.getColumnConstraints().add(new ColumnConstraints(300));
    grid.getColumnConstraints().add(new ColumnConstraints(300));



    grid.getRowConstraints().add(new RowConstraints(30));
    grid.getRowConstraints().add(new RowConstraints(40)); //Фамилия
    grid.getRowConstraints().add(new RowConstraints(10));

    grid.getRowConstraints().add(new RowConstraints(30));
    grid.getRowConstraints().add(new RowConstraints(40)); //Имя
    grid.getRowConstraints().add(new RowConstraints(10));

    grid.getRowConstraints().add(new RowConstraints(30));
    grid.getRowConstraints().add(new RowConstraints(40)); //Отчество
    grid.getRowConstraints().add(new RowConstraints(10));

    grid.getRowConstraints().add(new RowConstraints(30));
    grid.getRowConstraints().add(new RowConstraints(40)); //Группа



    //ЗАГОЛОВОК "РЕГИСТРАЦИЯ"
    Label re = new Label("Изменение данных");
    re.setId("welcome-text");   //для CSS
    re.setLayoutX(290);
    re.setLayoutY(142);


    //LABEL "ФАМИЛИЯ"
    Label surname = new Label("Фамилия:");
    surname.setId("Label");
    grid.add(surname, 0, 0);

    //EDIT "ВВОД ФАМИЛИЯ"
    surname1.setId("field");
    grid.add(surname1, 0, 1);


    //LABEL "ИМЯ"
    Label name = new Label("Имя:");
    name.setId("Label"); //для CSS
    grid.add(name, 0, 3);//добавляем текст в Grid

    //EDIT "ВВОД ИМЯ"
    name1.setId("field");
    grid.add(name1, 0, 4);



    //LABEL "ОТЧЕСТВО"
    Label father = new Label("Отчество:");
    father.setId("Label");
    grid.add(father, 0, 6);

    //EDIT "ВВОД ОТЧЕСТВО"
    father1.setId("field");
    grid.add(father1, 0, 7);


    //LABEL "EMAIL"
    Label email = new Label("Электронная почта:");
    email.setId("Label");
    grid.add(email, 1, 0);

    //EDIT "EMAIL"
    email1.setId("field");
    HBox box = new HBox(5);
    box.getChildren().addAll(email1, EventComboBox);
    EventComboBox.setId("event");
    grid.add(box,1,1);


    //LABEL "ЛОГИН"
    Label log = new Label("Логин:");
    log.setId("Label");
    grid.add(log, 1, 3);

    //EDIT "ЛОГИН"
    log1.setId("field");
    grid.add(log1, 1, 4);


    //LABEL "ПАРОЛЬ"
    Label pass = new Label("Пароль:");
    pass.setId("Label");
    grid.add(pass, 1, 6);

    //EDIT "ПАРОЛЬ"
    pass1.setId("field");
    pass11.setId("field");
    grid.add(pass11, 1, 7);



    //LABEL "ПАРОЛЬ ПОВТОР"
    Label pass_pov = new Label("Повторите пароль:");
    pass_pov.setId("Label");
    grid.add(pass_pov, 1, 9);

    //EDIT "ПАРОЛЬ ПОВТОР"
    pass2.setId("field");
    pass22.setId("field");
    grid.add(pass22, 1, 10);



    Image close = new Image("CloseEye1.png");
    Button close_eye = new Button("", new ImageView(close));
    close_eye.setId("eye");
    close_eye.setLayoutX(790);
    close_eye.setLayoutY(410);

    Image open = new Image("OpenEye1.png");
    Button open_eye = new Button("", new ImageView(open));
    open_eye.setId("eye");
    open_eye.setLayoutX(790);
    open_eye.setLayoutY(410);

    Image close1 = new Image("CloseEye1.png");
    Button close_eye1 = new Button("", new ImageView(close1));
    close_eye1.setId("eye");
    close_eye1.setLayoutX(790);
    close_eye1.setLayoutY(490);

    Image open1 = new Image("OpenEye1.png");
    Button open_eye1 = new Button("", new ImageView(open1));
    open_eye1.setId("eye");
    open_eye1.setLayoutX(790);
    open_eye1.setLayoutY(490);

    Button back = new Button("← Назад");
    back.setId("buttons");
    back.setLayoutX(310);
    back.setLayoutY(555);
    back.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            AccountForStudent.WindowStudent();
            primaryStage.hide();
        }
    });

    Button save = new Button("Сохранить");
    save.setId("buttons");
    save.setLayoutX(500);
    save.setLayoutY(555);
    save.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

        }
    });


    Pane without_other_enter = new Pane(grid, open_eye, open_eye1, back, re, save);


    close_eye.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            isOpen = 0;
            pass11.setText(pass1.getText());
            pass1.setText(pass11.getText());
            grid.getChildren().remove(pass1);
            grid.add(pass11, 1,7);
            without_other_enter.getChildren().remove(close_eye);
            without_other_enter.getChildren().add(open_eye);
        }
    });

    open_eye.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            isOpen = 1;
            pass1.setText(pass11.getText());
            pass11.setText(pass1.getText());
            grid.getChildren().remove(pass11);
            grid.add(pass1, 1,7);
            without_other_enter.getChildren().remove(open_eye);
            without_other_enter.getChildren().add(close_eye);
        }
    });

    close_eye1.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            isOpen2 = 0;
            pass22.setText(pass2.getText());
            pass2.setText(pass22.getText());
            grid.getChildren().remove(pass2);
            grid.add(pass22, 1,10);
            without_other_enter.getChildren().remove(close_eye1);
            without_other_enter.getChildren().add(open_eye1);
        }
    });

    open_eye1.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            isOpen2 = 1;
            pass2.setText(pass22.getText());
            pass22.setText(pass2.getText());
            grid.getChildren().remove(pass22);
            grid.add(pass2, 1,10);
            without_other_enter.getChildren().remove(open_eye1);
            without_other_enter.getChildren().add(close_eye1);
        }
    });

    Scene scene = new Scene(without_other_enter, 1000, 650); //добавляем Grid в Scene
    try(BufferedReader reader = new BufferedReader(new FileReader("C:\\ThemeFolder\\theme.txt")))
    {
        String th = reader.readLine();

        if (th.equals("1")){
            scene.getStylesheets().add("ForEditLichki.css");
        }
        else {
            scene.getStylesheets().add("ForEditLichkiGREY.css");
        }
    }
    catch (IOException e)
    {
        System.out.println(e.getMessage());
    }
    primaryStage.setScene(scene); //добавляем scene в stage
    primaryStage.setTitle("Изменение данных в личном кабинете...."); //название форме (как наказывала Ишкушка)
    primaryStage.setResizable(false);
    primaryStage.show();

}
}
