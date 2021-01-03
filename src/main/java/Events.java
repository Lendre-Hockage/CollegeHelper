import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Events {
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
                AddEvent.Add();
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
}
