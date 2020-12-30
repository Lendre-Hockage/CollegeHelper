import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Date;

public class Schedule {

    //объявление эдитов для колхозного способа.
    //можно удалять
    /*
    //пн
    public static TextField tf1 = new TextField(),
    tf2 = new TextField(), tf3 = new TextField(),
    tf4 = new TextField(), tf5 = new TextField(), tf6 = new TextField();
    //вт
    public static TextField tf7 = new TextField(),
    tf8 = new TextField(), tf9 = new TextField(),
    tf10 = new TextField(), tf11 = new TextField(),
    tf12 = new TextField();
    //ср
   public static TextField tf13 = new TextField(), tf14 = new TextField(),
    tf15 = new TextField(), tf16 = new TextField(),
    tf17 = new TextField(), tf18 = new TextField();
    //чт
    public static TextField tf19 = new TextField(),
    tf20 = new TextField(),
    tf21 = new TextField(),
    tf22 = new TextField(),
    tf23 = new TextField(),
    tf24 = new TextField();
    //пн
    public static TextField tf25 = new TextField(),
     tf26 = new TextField(),
     tf27 = new TextField(),
    tf28 = new TextField(),
   tf29 = new TextField(),
    tf30 = new TextField(); */

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
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 0, 10);
        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton main_sched = new RadioButton("Основное расписание");
        RadioButton change_sched = new RadioButton("Изменения в расписании");

        main_sched.setToggleGroup(toggleGroup);
        change_sched.setToggleGroup(toggleGroup);

        GridPane grid = new GridPane();
        grid.setLayoutX(50);
        grid.setLayoutY(150);
        grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(200));

        Text lbl0 = new Text("День недели");
        Text lbl1 = new Text("1");
        Text lbl2 = new Text("2");
        Text lbl3 = new Text("3");
        Text lbl4 = new Text("4");
        Text lbl5 = new Text("5");
        Text lbl6 = new Text("6");

        GridPane grid2 = new GridPane();

        grid2.setLayoutX(50);
        grid2.setLayoutY(150);

        grid2.setGridLinesVisible(true);
        grid2.getColumnConstraints().add(new ColumnConstraints(100));
        grid2.getColumnConstraints().add(new ColumnConstraints(250));
        grid2.getColumnConstraints().add(new ColumnConstraints(50));
        grid2.getColumnConstraints().add(new ColumnConstraints(250));

        pane.getChildren().addAll(main_sched, change_sched);

        main_sched.setOnAction(event -> {



            grid.add(lbl0, 0, 0);
            grid.add(lbl1, 0, 1); //0-столбец 1-строка
            grid.add(lbl2, 0, 2);
            grid.add(lbl3, 0, 3);
            grid.add(lbl4, 0, 4);
            grid.add(lbl5, 0, 5);
            grid.add(lbl6, 0, 6);


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

        Button btn = new Button("Создать расписание");
        btn.setId("btn");
        btn.setLayoutY(250);    // установка положения надписи по оси Y
        btn.setLayoutX(50);   // установка положения надписи по оси X
        btn.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createSchedule();
            }
        });


        EventComboBox1.setLayoutX(250);
        EventComboBox1.setLayoutY(5);

        Group group = new Group(pane, btn, EventComboBox1);
        Scene scene = new Scene(group);



        stage.setScene(scene);
        stage.setWidth(1500);
        stage.setHeight(650);
        stage.show();
    }

    public static void createSchedule(){
        Stage stage = new Stage();
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 0, 10);
        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton main_sched = new RadioButton("Основное расписание");
        RadioButton change_sched = new RadioButton("Изменения в расписании");

        main_sched.setToggleGroup(toggleGroup);
        change_sched.setToggleGroup(toggleGroup);

        GridPane grid = new GridPane();
        grid.setLayoutX(50);
        grid.setLayoutY(150);
        grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(200));


        Text lbl0 = new Text("День недели");
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
        grid2.getColumnConstraints().add(new ColumnConstraints(100));
        grid2.getColumnConstraints().add(new ColumnConstraints(250));
        grid2.getColumnConstraints().add(new ColumnConstraints(50));
        grid2.getColumnConstraints().add(new ColumnConstraints(250));

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
            //добавление обозначений дней недели

            //добавление эдитов элегатно и красиво. советую каждому,
            //кто сейчас этот комментарий читает, разобраться, как оно работает.
            //даже не советую, а настаиваю. объявление массива смотрите глобально

            pane.getChildren().addAll(main_sched,change_sched, grid);
        });
        change_sched.setOnAction(event -> {




            pane.getChildren().clear();
            pane.getChildren().addAll(main_sched,change_sched, grid2);
        });



        EventComboBox.setLayoutX(250);
        EventComboBox.setLayoutY(5);

        Button btn = new Button("ок");
        btn.setId("btn");
        btn.setLayoutY(250);    // установка положения надписи по оси Y
        btn.setLayoutX(50);   // установка положения надписи по оси X
        btn.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addSchendule.addLessons();
            }
        });

        Group gr = new Group(pane, EventComboBox, btn);
        Scene scene = new Scene(gr);

        stage.setScene(scene);
        stage.setWidth(1500);
        stage.setHeight(650);
        stage.show();
    }
}