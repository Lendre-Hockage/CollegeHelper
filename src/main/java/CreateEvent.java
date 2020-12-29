import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CreateEvent {
    public static void Window() {
        Stage stage = new Stage();
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
        GridPane gridPane = new GridPane();
        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setPrefViewportHeight(150);
        scrollPane.setPrefViewportWidth(900);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

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

        ObservableList<String> groups = FXCollections.observableArrayList("Все группы",
                "1й курс",
                "2й курс",
                "3й курс",
                "4й курс",
                "1-ТО",
                "1-ИС1",
                "1-СА",
                "2-СП",
                "2-БД",
                "3-ИС",
                "3-ТМС",
                "4-ТО",
                "4-ПР1");
        ComboBox<String> chooseGroup = new ComboBox<String>(groups);
        chooseGroup.setOnAction(event -> {
            switch (chooseGroup.getValue()) {
                case "Все группы": break;        //Действия при выборе соответствующего эл-та списка
                case "1й курс":  break;
                case "2й курс": break;
                case "3й курс": break;
                case "4й курс": break;
                case "1-ТО": break;
                case "1-ИС1": break;
                case "1-СА": break;
                case "2-СП": break;
                case "2-БД": break;
                case "3-ИС": break;
                case "3-ТМС":  break;
                case "4-ТО": break;
                case "4-ПР1": break;
                default: {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("А группа-то, оказывается, не выбрана...");
                    alert.setContentText("Пожалуйста, проверьте, выбрана ли группа?");
                    alert.showAndWait();}
                break;
            }
        });

        Button addEv = new Button("Создать событие");
        addEv.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        addEv.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (chooseGroup.getValue() == ""){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Ой... Здесь что-то не так");
                    alert.setContentText("Пожалуйста, выберите группы, для которых предназначено это событие!");
                    alert.showAndWait();
                } else Messages.Message(chooseGroup.getValue());
            }
        });

        scrollPane.setContent(gridPane);
        pane.getChildren().addAll(EventComboBox, lbl, scrollPane, addEv, chooseGroup);
        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(650);
        stage.show();
    }
}
