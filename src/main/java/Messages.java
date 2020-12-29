import javafx.scene.control.Alert;

public class Messages {
    public static void Message(String group){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Успешно!");
        alert.setContentText("Событие было отправлено следующим группам: " + group);
        alert.showAndWait();
    }
}
