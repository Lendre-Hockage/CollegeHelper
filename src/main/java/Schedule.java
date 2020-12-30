import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Date;

public class Schedule {
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

            pane.getChildren().clear();
            pane.getChildren().addAll(main_sched, change_sched, grid, grid2);
        });
        change_sched.setOnAction(event -> {
            grid2.add(lbl0, 0, 0);
            grid2.add(lbl1, 0, 1); //0-столбец 1-строка
            grid2.add(lbl2, 0, 2);
            grid2.add(lbl3, 0, 3);
            grid2.add(lbl4, 0, 4);
            grid2.add(lbl5, 0, 5);
            grid2.add(lbl6, 0, 6);

            pane.getChildren().clear();
            pane.getChildren().addAll(main_sched, change_sched,grid, grid2);
        });

        Button btn = new Button("Создать расписание");
        btn.setId("btn");
        btn.setLayoutY(100);    // установка положения надписи по оси Y
        btn.setLayoutX(50);   // установка положения надписи по оси X
        btn.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createSchedule();
            }
        });
        Group group = new Group(pane, btn);
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

        GridPane grid2 = new GridPane();

        grid2.setLayoutX(50);
        grid2.setLayoutY(150);

        grid2.setGridLinesVisible(true);
        grid2.getColumnConstraints().add(new ColumnConstraints(100));
        grid2.getColumnConstraints().add(new ColumnConstraints(250));
        grid2.getColumnConstraints().add(new ColumnConstraints(50));
        grid2.getColumnConstraints().add(new ColumnConstraints(250));

        pane.getChildren().addAll(main_sched, change_sched);

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        TextField tf5 = new TextField();
        TextField tf6 = new TextField();
        TextField tf7 = new TextField();
        TextField tf8 = new TextField();
        TextField tf9 = new TextField();
        TextField tf10 = new TextField();
        TextField tf11 = new TextField();
        TextField tf12 = new TextField();
        TextField tf13 = new TextField();
        TextField tf14 = new TextField();
        TextField tf15 = new TextField();
        TextField tf16 = new TextField();
        TextField tf17 = new TextField();
        TextField tf18 = new TextField();
        TextField tf19 = new TextField();
        TextField tf20 = new TextField();
        TextField tf21 = new TextField();
        TextField tf22 = new TextField();
        TextField tf23 = new TextField();
        TextField tf24 = new TextField();
        TextField tf25 = new TextField();
        TextField tf26 = new TextField();
        TextField tf27 = new TextField();
        TextField tf28 = new TextField();
        TextField tf29 = new TextField();
        TextField tf30 = new TextField();

        main_sched.setOnAction(event -> {
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

            grid.add(tf1, 1, 1);
            grid.add(tf2, 1, 2);
            grid.add(tf3, 1, 3);
            grid.add(tf4, 1, 4);
            grid.add(tf5, 1, 5);
            grid.add(tf6, 1, 6);

            grid.add(tf7, 2, 1);
            grid.add(tf8, 2, 2);
            grid.add(tf9, 2, 3);
            grid.add(tf10, 2, 4);
            grid.add(tf11, 2, 5);
            grid.add(tf12, 2, 6);

            grid.add(tf13, 3, 1);
            grid.add(tf14, 3, 2);
            grid.add(tf15, 3, 3);
            grid.add(tf16, 3, 4);
            grid.add(tf17, 3, 5);
            grid.add(tf18, 3, 6);

            grid.add(tf19, 4, 1);
            grid.add(tf20, 4, 2);
            grid.add(tf21, 4, 3);
            grid.add(tf22, 4, 4);
            grid.add(tf23, 4, 5);
            grid.add(tf24, 4, 6);

            grid.add(tf25, 5, 1);
            grid.add(tf26, 5, 2);
            grid.add(tf27, 5, 3);
            grid.add(tf28, 5, 4);
            grid.add(tf29, 5, 5);
            grid.add(tf30, 5, 6);

            pane.getChildren().clear();
            pane.getChildren().addAll(main_sched,change_sched, grid);
        });
        change_sched.setOnAction(event -> {
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

            pane.getChildren().clear();
            pane.getChildren().addAll(main_sched,change_sched, grid2);
        });

        ObservableList<String> listEvent = FXCollections.observableArrayList("1-ИС",
                "1-СП",
                "1-СА",
                "2-ТМС",
                "2-TO",
                "2-CA",
                "3-ИС",
                "3-ПСО1",
                "3-ПСО2",
                "4-ПР1");
        ComboBox<String> EventComboBox = new ComboBox<String>(listEvent);
        EventComboBox.setLayoutX(250);
        EventComboBox.setLayoutY(5);

        Group gr = new Group(pane, EventComboBox);
        Scene scene = new Scene(gr);

        stage.setScene(scene);
        stage.setWidth(1500);
        stage.setHeight(650);
        stage.show();
    }
}