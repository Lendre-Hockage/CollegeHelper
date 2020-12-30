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
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Date;

public class Schedule {
    //объявление массива!!!!!!!!! для внесения расписания
    public static TextField[] txt = new TextField[30];

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

    //объявление массива для отображения расписания
    public static Text[] showtxt = new Text[30];
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


    public static void Window () {
        Stage stage = new Stage();
        BackgroundImage bgI = new BackgroundImage(new Image("BackForMap.jpeg",1000,650,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        FlowPane pane = new FlowPane(Orientation.HORIZONTAL, 25, 20);
        pane.setLayoutX(160);
        pane.setLayoutY(245);
        ToggleGroup toggleGroup = new ToggleGroup();

        Text welcome_text = new Text("Расписание и изменения расписания");
        welcome_text.setId("welcome-text");
        welcome_text.setLayoutX(40);
        welcome_text.setLayoutY(140);

        Text instruction = new Text ("1. Выберите вашу группу в раскрывающемся списке\n\n2. Выберите \"Основное расписание\" или \"Изменения в расписании\"");
        instruction.setId("welcome-text2");
        instruction.setLayoutX(40);
        instruction.setLayoutY(175);

        RadioButton main_sched = new RadioButton("Основное расписание");
        main_sched.setId("floors");
        RadioButton change_sched = new RadioButton("Изменения в расписании");
        change_sched.setId("floors");

        main_sched.setToggleGroup(toggleGroup);
        change_sched.setToggleGroup(toggleGroup);

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





        Text lbl0 = new Text("");
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



        GridPane grid2 = new GridPane();
        grid2.setLayoutX(50);
        grid2.setLayoutY(150);

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

        pane.getChildren().addAll(main_sched, change_sched);

        main_sched.setOnAction(event -> {



            grid.add(lbl0, 0, 0);
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








            showScendule.showLessons();
            int k=0;

            for (int q=1; q<6; q++){
                for (int j=1; j<7; j++) {

                    grid.add(showtxt[k], q, j);
                    k++;
                }
            }

            pane.getChildren().clear();
            pane.getChildren().addAll(main_sched, change_sched, grid);
        });
        change_sched.setOnAction(event -> {


            grid2.add(lbl0, 0, 0);
            grid2.add(lbl1, 0, 1); //0-столбец 1-строка
            grid2.add(lbl2, 0, 2);
            grid2.add(lbl3, 0, 3);
            grid2.add(lbl4, 0, 4);
            grid2.add(lbl5, 0, 5);
            grid2.add(lbl6, 0, 6);

            //добавление текста с расписанием
            for (int i=0; i<30; i++) {
                Text text = new Text();
                showtxt[i] = text;
            }
            int k=0;

            for (int q=1; q<6; q++){
                for (int j=1; j<7; j++) {
                    grid2.add(showtxt[k], q, j);
                    grid.add(showtxt[k], q, j);
                    k++;
                }
            }

            pane.getChildren().clear();
            pane.getChildren().addAll(main_sched, change_sched, grid2);
        });

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

        Button ext = new Button("←");
        ext.setId("btn");
        ext.setLayoutY(550);    // установка положения надписи по оси Y
        ext.setLayoutX(450);   // установка положения надписи по оси X
        ext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Menu.Window();
                stage.close();
            }
        });


        EventComboBox1.setLayoutX(40);
        EventComboBox1.setLayoutY(245);
        EventComboBox1.setId("event");

        Pane group = new Pane(pane, btn, EventComboBox1, ext, welcome_text, instruction);
        group.setBackground(new Background(bgI));
        Scene scene = new Scene(group, 1000,650);
        stage.setScene(scene);
        scene.getStylesheets().add(0, "ForSchedule.css");
        stage.show();

    }











    public static void createSchedule(){
        Stage stage = new Stage();
        FlowPane pane = new FlowPane(Orientation.HORIZONTAL, 25, 20);
        pane.setLayoutX(140);
        pane.setLayoutY(225);
        BackgroundImage bgI = new BackgroundImage(new Image("BackForMap.jpeg",1000,650,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        Text welcome_text = new Text("Обновление основного и изменённого расписаний");
        welcome_text.setId("welcome-text1");
        welcome_text.setLayoutX(20);
        welcome_text.setLayoutY(140);

        Text instruction = new Text ("1. Выберите группу в раскрывающемся списке, для которой необходимо внести изменения\n\n2. Выберите место для внесения изменений \"Основное расписание\" или \"Изменения в расписании\"");
        instruction.setId("welcome-text2");
        instruction.setLayoutX(20);
        instruction.setLayoutY(175);

        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton main_sched = new RadioButton("Основное расписание");
        main_sched.setId("floors");
        RadioButton change_sched = new RadioButton("Изменения в расписании");
        change_sched.setId("floors");



        main_sched.setToggleGroup(toggleGroup);
        change_sched.setToggleGroup(toggleGroup);

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


        Text lbl0 = new Text("");
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

        grid.add(lbl0, 0, 0);
        grid.add(lbl1, 0, 1); //0-столбец 1-строка
        grid.add(lbl2, 0, 2);
        grid.add(lbl3, 0, 3);
        grid.add(lbl4, 0, 4);
        grid.add(lbl5, 0, 5);
        grid.add(lbl6, 0, 6);

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
        grid2.setLayoutY(150);

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

        grid2.add(lbl0, 0, 0);
        grid2.add(lbl1, 0, 1); //0-столбец 1-строка
        grid2.add(lbl2, 0, 2);
        grid2.add(lbl3, 0, 3);
        grid2.add(lbl4, 0, 4);
        grid2.add(lbl5, 0, 5);
        grid2.add(lbl6, 0, 6);
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
        pane.getChildren().addAll(main_sched, change_sched);


        main_sched.setOnAction(event -> {
            pane.getChildren().clear();

            //добавление эдитов элегатно и красиво. советую каждому,
            //кто сейчас этот комментарий читает, разобраться, как оно работает.
            //даже не советую, а настаиваю. объявление массива смотрите глобально

            pane.getChildren().addAll(main_sched,change_sched, grid);
        });
        change_sched.setOnAction(event -> {




            pane.getChildren().clear();
            pane.getChildren().addAll(main_sched,change_sched, grid2);
        });



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
            }
        });

        Pane root = new Pane(pane, EventComboBox, btn, instruction, welcome_text, ext);
        root.setBackground(new Background(bgI));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("ForSchedule.css"); //подключение CSS

        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(650);
        stage.show();
    }
}