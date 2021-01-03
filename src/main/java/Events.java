import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Events {
    public static ComboBox<String> box = new ComboBox<String>(Schedule.listEvent);
    public static void Window() {
        Stage stage = new Stage();
        Pane pane2 = new Pane();
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
        GridPane gridPane = new GridPane();
        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setPrefViewportHeight(150);
        scrollPane.setPrefViewportWidth(900);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        Button ext = new Button("Выход");
        ext.setId("btn");
        ext.setLayoutY(550);    // установка положения надписи по оси Y
        ext.setLayoutX(850);   // установка положения надписи по оси X
        ext.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        ext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Menu.Window();
                stage.close();
            }
        });

        Button add = new Button("Добавить");
        add.setId("btn");
        add.setLayoutY(500);    // установка положения надписи по оси Y
        add.setLayoutX(320);   // установка положения надписи по оси X
        add.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Add();
                stage.close();
            }
        });

        Label lbl = new Label("OK");

        ObservableList<String> listEvent = FXCollections.observableArrayList("Самостоятельные работы",
                "Контрольные работы",
                "Мероприятия от колледжа",
                "Другое");
        ComboBox<String> EventComboBox = new ComboBox<String>(listEvent);
        EventComboBox.setOnAction(event -> {
            switch (EventComboBox.getValue()) {
                case "Самостоятельные работы": lbl.setText("yes1"); break;        //Действия при выборе соответствующего эл-та списка
                case "Контрольные работы": lbl.setText("yes2"); break;
                case "Мероприятия от колледжа": lbl.setText("yes3"); break;
                case "Другое": lbl.setText("yes4"); break;
                default: lbl.setText("not found"); break;
            }
        });

        Text someText = new Text();
        someText.setText("some text\nsome text\nsome text\nsome text\nsome text\nsome text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2\nsome text\nsome text\nsome text\nsome text\nsome text\nsome text\nsome text\n");

        Text text2 = new Text("sdghfgjhgfgdf");

        gridPane.setVisible(true);
        gridPane.add(text2, 0, 0);                                  //Добавили gridPane в ScrollPane, чтобы листалось
        gridPane.add(someText, 0, 3);                               //Не отображаются пустые строки

        scrollPane.setContent(gridPane);

        pane.getChildren().addAll(EventComboBox, lbl, scrollPane, add);
        pane2.getChildren().addAll(pane, ext);

        Scene scene = new Scene(pane2);

        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(650);
        stage.show();
    }
    public static void Add(){
        Stage stage = new Stage();
        HBox for_edits = new HBox(10);
        TextField date = new TextField();
        TextField event = new TextField();
        TextField description =  new TextField();


        for_edits.getChildren().addAll(box, date, event, description);
        for_edits.setLayoutX(200);
        for_edits.setLayoutY(270);

        HBox for_labels = new HBox(130);
        Label gr = new Label("Группа");
        Label date1 = new Label("Дата");
        Label event1 = new Label("Событие");
        Label description1 =  new Label("Описание");

        for_labels.getChildren().addAll(gr, date1, event1, description1);
        for_labels.setLayoutX(200);
        for_labels.setLayoutY(240);

        Button add = new Button("Добавить событие");
        add.setLayoutX(730);
        add.setLayoutY(320);

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
