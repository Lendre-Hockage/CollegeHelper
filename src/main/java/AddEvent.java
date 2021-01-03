import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddEvent  {
    public static void Add(){

        HBox for_edits = new HBox(10);
        TextField date = new TextField();
        TextField event = new TextField();
        TextField description =  new TextField();

        for_edits.getChildren().addAll(date, event, description);
        for_edits.setLayoutX(400);
        for_edits.setLayoutY(270);

        HBox for_labels = new HBox(130);
        Label date1 = new Label("Дата");
        Label event1 = new Label("Событие");
        Label description1 =  new Label("Описание");

        for_labels.getChildren().addAll(date1, event1, description1);
        for_labels.setLayoutX(400);
        for_labels.setLayoutY(240);

        Button add = new Button("Добавить событие");
        add.setLayoutX(730);
        add.setLayoutY(320);

        Pane without_other_enter = new Pane(for_edits, for_labels, add);
        Scene scene = new Scene(without_other_enter, 1000, 650); //добавляем Grid в Scene
        Stage stage = new Stage();
        stage.setScene(scene); //добавляем scene в stage
        stage.setTitle("Регистрация"); //название форме (как наказывала Ишкушка)
        scene.getStylesheets().add(0, "ForRegistration.css"); //подключение CSS
        stage.show();



    }
}
