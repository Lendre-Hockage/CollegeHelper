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
    //public static TextField date = new TextField();
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
public static TextArea textArea = new TextArea();
    public static void Window() {
        Pane pane2 = new Pane();
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
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


        EventComboBox.setOnAction(event -> {
            ShowEvent.show();
        });

      //  Text someText = new Text();
       // someText.setText("some text\nsome text\nsome text\nsome text\nsome text\nsome text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2some text2\nsome text\nsome text\nsome text\nsome text\nsome text\nsome text\nsome text\n");

      //  Text text2 = new Text("sdghfgjhgfgdf");

        gridPane.setVisible(true);
       // gridPane.add(text2, 0, 0);                                  //Добавили gridPane в ScrollPane, чтобы листалось
       // gridPane.add(someText, 0, 3);                               //Не отображаются пустые строки

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
