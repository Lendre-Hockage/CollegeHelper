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
    public static Text someText = new Text(" ");
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
    public static  ScrollPane scrollPane = new ScrollPane();
public static TextArea textArea = new TextArea();
    public static void Window() {
        Pane pane2 = new Pane();
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);

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
                switch (AccountForStudent.usertype) {
                    case 1: AccountForStudent.WindowStudent(); break;
                    case 2: AccountForTeacher.WindowTeacher(); break;
                    case 3: AccountForSuperAdmin.WindowAdmin(); break;
                    default: Menu.Alert18();
                }

                stage.hide();
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
