import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Date;
import java.util.concurrent.Flow;

public class Schedule {
    //объявление массива!!!!!!!!! для внесения расписания
    public static TextField[] txt = new TextField[30]; //основное
    public static TextField[] txt1 = new TextField[12]; //изменения
    public static int select; //проверка выбора что вносить
    //объявление выпадающего списка. глобально, потому что в addSchendule
    //название группы читается в бд
    public static ObservableList<String> listEvent = FXCollections.observableArrayList("1-ИС",
            "1-СП",
            "1-СА",
            "2-ТМС",
            "2-TO",
            "2-CA",
            "3-ИС",
            "3-ПСО1",
            "3-ПСО2",
            "4-ПР1");

    public static  ComboBox<String> EventComboBox = new ComboBox<String>(listEvent);

    //объявление массива для отображения расписания и изменений(2)
    public static Text[] showtxt = new Text[30];
    public static Text[] showtxt2 = new Text[12];
    //выпадающий список для отображения расписания
    public static ObservableList<String> listEvent1 = FXCollections.observableArrayList("1-ИС",
            "1-СП",
            "1-СА",
            "2-ТМС",
            "2-TO",
            "2-CA",
            "3-ИС",
            "3-ПСО1",
            "3-ПСО2",
            "4-ПР1");

    public static  ComboBox<String> EventComboBox1 = new ComboBox<String>(listEvent1);

    //дата глобально, потому что она нужна для изменений
    public static Date date = new Date();
    public static String dat = String.valueOf(date);
    public static String[] words = dat.split(" ");

    //проверка на понедельник для изменений
    public static int monday_check;


    public static void Window () { //Окно расписания
        Stage stage = new Stage();
        BackgroundImage bgI = new BackgroundImage(new Image("BackForShed.png",1000,650,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        FlowPane pane = new FlowPane(Orientation.HORIZONTAL, 25, 20);
        FlowPane pane2 = new FlowPane(Orientation.HORIZONTAL, 25, 20);
        pane.setLayoutX(250);
        pane.setLayoutY(45);
        pane2.setLayoutX(375);
        pane2.setLayoutY(355);

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
        Button btn2 = new Button("", new ImageView(reg)); //Переход к регистрации
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


        Pane pane1 = new Pane(btn1, btn2, btn3, btn4, btn5, authorize, registration, maps, eve, shedl);


        GridPane grid = new GridPane();
        grid.setLayoutX(50);
        grid.setLayoutY(150);
        grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(30));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));



        Text lbl1 = new Text("1");
        Text lbl2 = new Text("2");
        Text lbl3 = new Text("3");
        Text lbl4 = new Text("4");
        Text lbl5 = new Text("5");
        Text lbl6 = new Text("6");


        Text lbl11 = new Text("Понедельник");
        Text lbl21 = new Text("Вторник");
        Text lbl31 = new Text("Среда");
        Text lbl41 = new Text("Четверг");
        Text lbl51 = new Text("Пятница");




        grid.add(lbl1, 0, 1); //0-столбец 1-строка
        grid.add(lbl2, 0, 2);
        grid.add(lbl3, 0, 3);
        grid.add(lbl4, 0, 4);
        grid.add(lbl5, 0, 5);
        grid.add(lbl6, 0, 6);

        grid.add(lbl11, 1, 0);
        grid.add(lbl21, 2, 0); //0-столбец 1-строка
        grid.add(lbl31, 3, 0);
        grid.add(lbl41, 4, 0);
        grid.add(lbl51, 5, 0);



        GridPane grid2 = new GridPane();
        grid2.setLayoutX(50);
        grid2.setLayoutY(350);

        grid2.setGridLinesVisible(true);
        grid2.getColumnConstraints().add(new ColumnConstraints(30));
        grid2.getColumnConstraints().add(new ColumnConstraints(130));
        grid2.getColumnConstraints().add(new ColumnConstraints(80));
        grid2.getColumnConstraints().add(new ColumnConstraints(130));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));

        Date date = new Date();
        String dat = String.valueOf(date);
        String[] words = dat.split(" ");
        Label fDay = new Label();
        Label sDay = new Label();

        switch (words[0]){
            case "Mon":{fDay.setText("Понедельник"); sDay.setText("Вторник");break;}
            case "Tue":{fDay.setText("Вторник"); sDay.setText("Среда");break;}
            case "Wed":{fDay.setText("Среда"); sDay.setText("Четверг");break;}
            case "Thu":{fDay.setText("Четверг"); sDay.setText("Пятница");break;}
            case "Fri":{fDay.setText("Пятница"); sDay.setText("Понедельник");break;}
            case "Sat":{fDay.setText("Выходной"); sDay.setText("Понедельник");break;}
            case "Sun":{fDay.setText("Выходной"); sDay.setText("Понедельник");break;}
            default:{ Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Эм... Походу считано неправильное время");
                alert.setContentText("Событие было отправлено следующим группам: ");
                alert.showAndWait();
            }
        }

        grid2.add(fDay, 1, 0);
        grid2.add(sDay, 3, 0);

        grid2.add(lbl1, 0, 1); //0-столбец 1-строка
        grid2.add(lbl2, 0, 2);
        grid2.add(lbl3, 0, 3);
        grid2.add(lbl4, 0, 4);
        grid2.add(lbl5, 0, 5);
        grid2.add(lbl6, 0, 6);


            EventComboBox1.setValue(AutorizCode.group_name);

            //добавление текста с расписанием
            for (int i = 0; i < 30; i++) {
                Text text = new Text();
                showtxt[i] = text;
            }
            int p = 0;

            for (int q = 1; q < 6; q++) {
                for (int j = 1; j < 7; j++) {
                    grid2.add(showtxt[p], q, j);
                    grid.add(showtxt[p], q, j);
                    p++;
                }
            }


            if (EventComboBox1.getValue() == null) {
                Menu.Alert15();
            } else {
                showScendule.showLessons();

                int k = 0;

                for (int q = 1; q < 6; q++) {
                    for (int j = 1; j < 7; j++) {

                        grid.add(showtxt[k], q, j);
                        k++;
                    }
                }
                pane.getChildren().clear();
                pane.getChildren().addAll(grid);

                int o = 0;

                showChanges.showChanges();

                for (int j = 1; j < 7; j++) {

                    grid2.add(showtxt2[o], 1, j);
                    o++;
                }

                for (int j = 1; j < 7; j++) {

                    grid2.add(showtxt2[o], 3, j);
                    o++;
                }


                pane2.getChildren().clear();
                pane2.getChildren().addAll(grid2);
            }

        Button btn = new Button("+");
        btn.setId("btn");
        btn.setLayoutY(550);    // установка положения надписи по оси Y
        btn.setLayoutX(550);   // установка положения надписи по оси X
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createSchedule();
                stage.close();
            }
        });


        EventComboBox1.setLayoutX(40);
        EventComboBox1.setLayoutY(245);
        EventComboBox1.setId("event");

        Pane group = new Pane(pane1, pane, pane2, btn, EventComboBox1);
        group.setBackground(new Background(bgI));
        Scene scene = new Scene(group, 1000,650);
        stage.setScene(scene);
        scene.getStylesheets().add(0, "ForSchedule.css");
        stage.show();

    }

    public static void shedForPrepod(){
        Stage stage = new Stage();
        BackgroundImage bgI = new BackgroundImage(new Image("BackForShed.png",1000,650,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        FlowPane pane = new FlowPane(Orientation.HORIZONTAL, 25, 20);
        FlowPane pane2 = new FlowPane(Orientation.HORIZONTAL, 25, 20);
        pane.setLayoutX(250);
        pane.setLayoutY(45);
        pane2.setLayoutX(250);
        pane2.setLayoutY(345);

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


        Pane pane1 = new Pane(btn1, btn2, btn3, btn4, btn5, authorize, registration, maps, eve, shedl);

        GridPane grid = new GridPane();
        grid.setLayoutX(50);
        grid.setLayoutY(150);
        grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(30));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));



        Text lbl1 = new Text("1");
        Text lbl2 = new Text("2");
        Text lbl3 = new Text("3");
        Text lbl4 = new Text("4");
        Text lbl5 = new Text("5");
        Text lbl6 = new Text("6");


        Text lbl11 = new Text("Понедельник");
        Text lbl21 = new Text("Вторник");
        Text lbl31 = new Text("Среда");
        Text lbl41 = new Text("Четверг");
        Text lbl51 = new Text("Пятница");




        grid.add(lbl1, 0, 1); //0-столбец 1-строка
        grid.add(lbl2, 0, 2);
        grid.add(lbl3, 0, 3);
        grid.add(lbl4, 0, 4);
        grid.add(lbl5, 0, 5);
        grid.add(lbl6, 0, 6);

        grid.add(lbl11, 1, 0);
        grid.add(lbl21, 2, 0); //0-столбец 1-строка
        grid.add(lbl31, 3, 0);
        grid.add(lbl41, 4, 0);
        grid.add(lbl51, 5, 0);



        GridPane grid2 = new GridPane();
        grid2.setLayoutX(50);
        grid2.setLayoutY(150);

        grid2.setGridLinesVisible(true);
        grid2.getColumnConstraints().add(new ColumnConstraints(30));
        grid2.getColumnConstraints().add(new ColumnConstraints(130));
        grid2.getColumnConstraints().add(new ColumnConstraints(80));
        grid2.getColumnConstraints().add(new ColumnConstraints(130));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));

        Date date = new Date();
        String dat = String.valueOf(date);
        String[] words = dat.split(" ");
        Label fDay = new Label();
        Label sDay = new Label();

        switch (words[0]){
            case "Mon":{fDay.setText("Понедельник"); sDay.setText("Вторник");break;}
            case "Tue":{fDay.setText("Вторник"); sDay.setText("Среда");break;}
            case "Wed":{fDay.setText("Среда"); sDay.setText("Четверг");break;}
            case "Thu":{fDay.setText("Четверг"); sDay.setText("Пятница");break;}
            case "Fri":{fDay.setText("Пятница"); sDay.setText("Понедельник");break;}
            case "Sat":{fDay.setText("Выходной"); sDay.setText("Понедельник");break;}
            case "Sun":{fDay.setText("Выходной"); sDay.setText("Понедельник");break;}
            default:{ Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Эм... Походу считано неправильное время");
                alert.setContentText("Событие было отправлено следующим группам: ");
                alert.showAndWait();
            }
        }

        grid2.add(fDay, 1, 0);
        grid2.add(sDay, 3, 0);

        grid2.add(lbl1, 0, 1); //0-столбец 1-строка
        grid2.add(lbl2, 0, 2);
        grid2.add(lbl3, 0, 3);
        grid2.add(lbl4, 0, 4);
        grid2.add(lbl5, 0, 5);
        grid2.add(lbl6, 0, 6);

        EventComboBox1.setOnAction(event -> {
                switch (Schedule.EventComboBox1.getValue()) {
                case "1-ИС": Schedule.showSFP(grid, grid2, pane, pane2);break;        //Действия при выборе соответствующего эл-та списка
                case "1-СП": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "1-СА": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "2-ТМС": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "2-ТО": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "2-СА": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "3-ИС": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "3-ПСО1": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "3-ПСО2": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "4-ПР1": Schedule.showSFP(grid, grid2, pane, pane2);break;
            }
        });


        EventComboBox1.setLayoutX(40);
        EventComboBox1.setLayoutY(245);
        EventComboBox1.setId("event");

        Pane group = new Pane(pane1, pane, pane2, EventComboBox1);
        group.setBackground(new Background(bgI));
        Scene scene = new Scene(group, 1000,650);
        stage.setScene(scene);
        scene.getStylesheets().add(0, "ForSchedule.css");
        stage.show();
    }
    public static void showSFP(GridPane grid, GridPane grid2, FlowPane pane, FlowPane pane2){
        //добавление текста с расписанием
        for (int i=0; i<30; i++) {
            Text text = new Text();
            showtxt[i] = text;
        }
        int p=0;

        for (int q=1; q<6; q++){
            for (int j=1; j<7; j++) {
                grid2.add(showtxt[p], q, j);
                grid.add(showtxt[p], q, j);
                p++;
            }
        }


        if (EventComboBox1.getValue()==null) {Menu.Alert15();}
        else {
            showScendule.showLessons();

            int k=0;

            for (int q=1; q<6; q++){
                for (int j=1; j<7; j++) {

                    grid.add(showtxt[k], q, j);
                    k++;
                }
            }
            pane.getChildren().clear();
            pane.getChildren().addAll(grid);

            showChanges.showChanges();

            int o=0;

            for (int j=1; j<7; j++) {

                grid2.add(showtxt2[o], 1, j);
                o++;
            }

            for (int j=1; j<7; j++) {

                grid2.add(showtxt2[o], 3, j);
                o++;
            }

            pane2.getChildren().clear();
            pane2.getChildren().addAll(grid2);
        }

    }


    public static void createSchedule(){
        Stage stage = new Stage();
        BackgroundImage bgI = new BackgroundImage(new Image("BackForShed.png",1000,650,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        FlowPane pane = new FlowPane(Orientation.HORIZONTAL, 25, 20);
        FlowPane pane2 = new FlowPane(Orientation.HORIZONTAL, 25, 20);
        pane.setLayoutX(250);
        pane.setLayoutY(45);
        pane2.setLayoutX(375);
        pane2.setLayoutY(355);

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
        Button btn2 = new Button("", new ImageView(reg)); //Переход к регистрации
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


        Pane pane1 = new Pane(btn1, btn2, btn3, btn4, btn5, authorize, registration, maps, eve, shedl);


        Text welcome_text = new Text("Обновление основного и изменённого расписаний");
        welcome_text.setId("welcome-text1");
        welcome_text.setLayoutX(20);
        welcome_text.setLayoutY(140);

        Text instruction = new Text ("1. Выберите группу в раскрывающемся списке, для которой необходимо внести изменения\n\n2. Выберите место для внесения изменений \"Основное расписание\" или \"Изменения в расписании\"");
        instruction.setId("welcome-text2");
        instruction.setLayoutX(20);
        instruction.setLayoutY(175);


        GridPane grid = new GridPane();
        grid.setLayoutX(50);
        grid.setLayoutY(150);
        grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(30));
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getRowConstraints().add(new RowConstraints(35));
        grid.getRowConstraints().add(new RowConstraints(35));
        grid.getRowConstraints().add(new RowConstraints(35));
        grid.getRowConstraints().add(new RowConstraints(35));
        grid.getRowConstraints().add(new RowConstraints(35));
        grid.getRowConstraints().add(new RowConstraints(35));
        grid.getRowConstraints().add(new RowConstraints(35));


        Text lbl1 = new Text("1");
        Text lbl2 = new Text("2");
        Text lbl3 = new Text("3");
        Text lbl4 = new Text("4");
        Text lbl5 = new Text("5");
        Text lbl6 = new Text("6");
        Text lb1 = new Text("Понедельник");
        Text lb2 = new Text("Вторник");
        Text lb3 = new Text("Среда");
        Text lb4 = new Text("Четверг");
        Text lb5 = new Text("Пятница");


        grid.add(lb1, 1, 0);
        grid.add(lb2, 2, 0);
        grid.add(lb3, 3, 0);
        grid.add(lb4, 4, 0);
        grid.add(lb5, 5, 0);

        for (int i=0; i<30; i++) {
            TextField textField = new TextField();
            txt[i] = textField;
        }
        int k=0;

        for (int q=1; q<6; q++){
            for (int j=1; j<7; j++) {
                grid.add(txt[k], q, j);
                k++;
            }
        }

        GridPane grid2 = new GridPane();

        grid2.setLayoutX(50);
        grid2.setLayoutY(350);

        grid2.setGridLinesVisible(true);
        grid2.getColumnConstraints().add(new ColumnConstraints(30));
        grid2.getColumnConstraints().add(new ColumnConstraints(150));
        grid2.getColumnConstraints().add(new ColumnConstraints(80));
        grid2.getColumnConstraints().add(new ColumnConstraints(150));
        grid2.getRowConstraints().add(new RowConstraints(35));
        grid2.getRowConstraints().add(new RowConstraints(35));
        grid2.getRowConstraints().add(new RowConstraints(35));
        grid2.getRowConstraints().add(new RowConstraints(35));
        grid2.getRowConstraints().add(new RowConstraints(35));
        grid2.getRowConstraints().add(new RowConstraints(35));
        grid2.getRowConstraints().add(new RowConstraints(35));

        for (int i=0; i<12; i++) {
            TextField textField = new TextField();
            txt1[i] = textField;
        }
        int P=0;

        for (int q=1; q<4; q+=2){
            for (int j=1; j<7; j++) {
                grid2.add(txt1[P], q, j);
                P++;
            }
        }

        Date date = new Date();
        String dat = String.valueOf(date);
        String[] words = dat.split(" ");
        Label fDay = new Label();
        Label sDay = new Label();

        switch (words[0]){
            case "Mon":{fDay.setText("Понедельник"); sDay.setText("Вторник");break;}
            case "Tue":{fDay.setText("Вторник"); sDay.setText("Среда");break;}
            case "Wed":{fDay.setText("Среда"); sDay.setText("Четверг");break;}
            case "Thu":{fDay.setText("Четверг"); sDay.setText("Пятница");break;}
            case "Fri":{fDay.setText("Пятница"); sDay.setText("Понедельник");break;}
            default:{ Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Эм... Походу считано неправильное время");
                alert.setContentText("Событие было отправлено следующим группам: ");
                alert.showAndWait();
            }
        }

        grid2.add(fDay, 1, 0);
        grid2.add(sDay, 3, 0);

            pane.getChildren().clear();

            grid.add(lbl1, 0, 1); //0-столбец 1-строка
            grid.add(lbl2, 0, 2);
            grid.add(lbl3, 0, 3);
            grid.add(lbl4, 0, 4);
            grid.add(lbl5, 0, 5);
            grid.add(lbl6, 0, 6);

            pane.getChildren().addAll(grid);

            grid2.add(lbl1, 0, 1); //0-столбец 1-строка
            grid2.add(lbl2, 0, 2);
            grid2.add(lbl3, 0, 3);
            grid2.add(lbl4, 0, 4);
            grid2.add(lbl5, 0, 5);
            grid2.add(lbl6, 0, 6);


            pane2.getChildren().clear();
            pane2.getChildren().addAll(grid2);


        EventComboBox.setLayoutX(20);
        EventComboBox.setLayoutY(225);
        EventComboBox.setId("event");

        Button ext = new Button("←");
        ext.setId("btn");
        ext.setLayoutY(530);    // установка положения надписи по оси Y
        ext.setLayoutX(450);   // установка положения надписи по оси X
        ext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Schedule.Window();
                stage.close();
            }
        });

        Button btn = new Button("✓");
        btn.setId("btn");
        btn.setLayoutY(530);    // установка положения надписи по оси Y
        btn.setLayoutX(550);   // установка положения надписи по оси X

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addSchendule.addLessons();
                addChanges.addChanges();
            }
        });

        Pane root = new Pane(pane2, pane,pane1, EventComboBox, btn, instruction, welcome_text, ext);

        root.setBackground(new Background(bgI));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("ForSchedule.css"); //подключение CSS

        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(650);
        stage.show();
    }
}