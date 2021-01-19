import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Events {
    public static DatePicker datePicker = new DatePicker();
    public static TextField description =  new TextField();
    public static ComboBox<String> box = new ComboBox<String>(Schedule.listEvent);
    public static ObservableList<String> listEvent = FXCollections.observableArrayList("Самостоятельные работы",
            "Контрольные работы",
            "Мероприятия от колледжа",
            "Другое");
    public static ComboBox<String> EventComboBox = new ComboBox<String>(listEvent);
    public static ObservableList<String> course = FXCollections.observableArrayList("1",
            "2",
            "3",
            "4");
    public static ComboBox<String> CourseBox = new ComboBox<String>(course);
    public static Text[] evShow = new Text[500];
    public static Stage stage = new Stage();
    public static GridPane gridPane = new GridPane();
    public static  ScrollPane scrollPane = new ScrollPane();
    public static TextArea textArea = new TextArea();




    public static void Window() {
        Pane pane2 = new Pane();
        HBox pane = new HBox(10);

        scrollPane.setPrefViewportHeight(213);
        scrollPane.setPrefViewportWidth(420);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);


        Image av = new Image("LichKab.png");
        Button btn1 = new Button("", new ImageView(av));
        btn1.setId("buttons");
        btn1.setLayoutX(0);
        btn1.setLayoutY(20);
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                switch (AccountForStudent.usertype) {
                    case 1: AccountForStudent.WindowStudent(); break;
                    case 2: AccountForTeacher.WindowTeacher(); break;
                    case 3: AccountForSuperAdmin.WindowAdmin(); break;
                    default: Menu.Alert18();
                }

                stage.hide();
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
                stage.hide();
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
                Events.Window();
                stage.hide();
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
                Schedule.Window();
                stage.hide();
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
                stage.hide();
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


        Pane pane1 = new Pane(btn1, btn3, btn4, btn5, btn6, authorize, maps, eve, shedl, ex);


//        Button add = new Button("Добавить");
//        add.setId("btn");
//        add.setLayoutY(500);    // установка положения надписи по оси Y
//        add.setLayoutX(320);   // установка положения надписи по оси X
//        add.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
//        add.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                Add();
//                stage.close();
//            }
//        });


 //так надо. не ломать
        for (int i=0; i<500; i++) {
            Text text = new Text();
            Events.evShow[i] = text;
        }

        int q=0;
        int k=1;

        for (int i=1; i<500; i++) {
            gridPane.add(evShow[i], k, q);
            k++;
            if (i%24==0) { q=q+1; k=1;} }



        EventComboBox.setOnAction(event -> {  gridPane.getChildren().clear(); //очищаем грид от предыдущего
            ShowEvent.show();

           int w=0;
           int a=1;
                for (int i=1; i<500; i++) { //отображаем 500 элементов потому что это объём массива
                    gridPane.add(evShow[i], a, w);
                    a++;
                    if (i%24==0) { w=w+1; a=1;} }  //каждые 6 элементов=столбец бд. всего столбцов 4, поэтому
                                                // каждые 24 элемента надо переносить строку


        });


        gridPane.setVisible(true);

        scrollPane.setContent(gridPane);

        pane.getChildren().addAll(EventComboBox, scrollPane);
        EventComboBox.setId("event");
        pane.setLayoutX(250);
        pane.setLayoutY(240);
        pane2.getChildren().addAll(pane, pane1);

        Scene scene = new Scene(pane2, 1000, 650);
        stage.setTitle("Просмотр событий");
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\ThemeFolder\\theme.txt")))
        {
            String th = reader.readLine();

            if (th.equals("1")){
                scene.getStylesheets().add("ForEventsStudent.css");
            }
            else {
                scene.getStylesheets().add("ForEventsStudentGREY.css");
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        //scene.getStylesheets().add("ForEventsStudent.css"); //подключение CSS
        stage.setScene(scene);
        stage.show();
    }







    public static void EventsForPrepAndSuperadm() {
        Pane pane2 = new Pane();
        HBox pane = new HBox(10);

        scrollPane.setPrefViewportHeight(213);
        scrollPane.setPrefViewportWidth(420);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);


        Image av = new Image("LichKab.png");
        Button btn1 = new Button("", new ImageView(av));
        btn1.setId("buttons");
        btn1.setLayoutX(0);
        btn1.setLayoutY(20);
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                switch (AccountForStudent.usertype) {
                    case 1: AccountForStudent.WindowStudent(); break;
                    case 2: AccountForTeacher.WindowTeacher(); break;
                    case 3: AccountForSuperAdmin.WindowAdmin(); break;
                    default: Menu.Alert18();
                }

                stage.hide();
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
                stage.hide();
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
                Events.Window();
                stage.hide();
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
                stage.hide();
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
                stage.hide();
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


        Pane pane1 = new Pane(btn1, btn3, btn4, btn5, btn6, authorize, maps, eve, shedl, ex);


        Button add = new Button("Добавить");
        add.setId("btn");
        add.setLayoutY(455);    // установка положения надписи по оси Y
        add.setLayoutX(763);   // установка положения надписи по оси X
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Add();
                stage.close();
            }
        });


        //так надо. не ломать
        for (int i=0; i<500; i++) {
            Text text = new Text();
            Events.evShow[i] = text;
        }

        int q=0;
        int k=1;

        for (int i=1; i<500; i++) {
            gridPane.add(evShow[i], k, q);
            k++;
            if (i%24==0) { q=q+1; k=1;} }



        EventComboBox.setOnAction(event -> {  gridPane.getChildren().clear(); //очищаем грид от предыдущего
            ShowEvent.show();

            int w=0;
            int a=1;
            for (int i=1; i<500; i++) { //отображаем 500 элементов потому что это объём массива
                gridPane.add(evShow[i], a, w);
                a++;
                if (i%24==0) { w=w+1; a=1;} }  //каждые 6 элементов=столбец бд. всего столбцов 4, поэтому
            // каждые 24 элемента надо переносить строку


        });


        gridPane.setVisible(true);

        scrollPane.setContent(gridPane);

        pane.getChildren().addAll(EventComboBox, scrollPane);
        EventComboBox.setId("event");
        pane.setLayoutX(250);
        pane.setLayoutY(208);
        pane2.getChildren().addAll(pane, pane1, add);

        Scene scene = new Scene(pane2, 1000, 650);
        stage.setTitle("Просмотр событий");
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\ThemeFolder\\theme.txt")))
        {
            String th = reader.readLine();

            if (th.equals("1")){
                scene.getStylesheets().add("ForEventsPrepAdm.css");
            }
            else {
                scene.getStylesheets().add("ForEventsPrepAdmGREY.css");
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        //scene.getStylesheets().add("ForEventsPrepAdm.css"); //подключение CSS
        stage.setScene(scene);
        stage.show();

    }






    public static void Add(){
        Stage stage = new Stage();
        HBox for_edits = new HBox(10);

        for_edits.getChildren().addAll(CourseBox ,EventComboBox ,box, datePicker, description);
        for_edits.setLayoutX(150);
        for_edits.setLayoutY(270);

        HBox for_labels = new HBox(100);
        Label cour = new Label("Курс");
        Label name = new Label("Событие");
        Label gr = new Label("Группа");
        Label date1 = new Label("Дата");

        Label description1 =  new Label("Описание");

        for_labels.getChildren().addAll(cour ,name ,gr ,date1 , description1);
        for_labels.setLayoutX(170);
        for_labels.setLayoutY(240);

        Button add = new Button("Добавить событие");
        add.setLayoutX(730);
        add.setLayoutY(320);
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AddEvent.addEv();
            }
        });

        Button back = new Button("<-");
        back.setLayoutX(50);
        back.setLayoutY(50);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Window();
                stage.close();
            }
        });

        Pane without_other_enter = new Pane(for_edits, for_labels, add, back);
        Scene scene = new Scene(without_other_enter, 1000, 650); //добавляем Grid в Scene
        stage.setScene(scene); //добавляем scene в stage
        stage.setTitle("Регистрация"); //название форме (как наказывала Ишкушка)
        scene.getStylesheets().add(0, "ForRegistration.css"); //подключение CSS
        stage.show();

    }
}
