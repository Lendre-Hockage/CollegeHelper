import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.lang.String;

import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class Maps {
    public static void map(){
        Stage stage = new Stage();

        int floor = 1;

        String flr = Integer.toString(floor);

        Button top = new Button("Higher" /* Здесь также можно присобачить иконку стрелки вверх для красоты */);
        top.setId("btn");
        top.setLayoutY(265);    // установка положения надписи по оси Y
        top.setLayoutX(420);   // установка положения надписи по оси X
        top.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        top.setOnAction(new EventHandler<ActionEvent>() {
            @Override
                public void handle(ActionEvent event) {
                    if (floor<4){

                }
                else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "You're already on the top floor : )", ButtonType.OK);
                    alert.setTitle("It seems that... there's nowhere higher to go");
                    alert.showAndWait();
                    }
            }
        });

        Button lower = new Button("Lower" /* Здесь также можно присобачить иконку стрелки вниз для красоты */);
        lower.setId("btn");
        lower.setLayoutY(285);    // установка положения надписи по оси Y
        lower.setLayoutX(420);   // установка положения надписи по оси X
        lower.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        lower.setOnAction(new EventHandler<ActionEvent>() {
            @Override
                public void handle(ActionEvent event) {
                    if (floor > 1) {

                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "You're already on the bottom floor : )", ButtonType.OK);
                        alert.setTitle("It seems that... there's nowhere lower to go");
                        alert.showAndWait();
                    }
            }
        });

        Text text = new Text();
        text.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        text.setLayoutX(10);
        text.setLayoutY(10);
        text.setText(flr);

        }
    }
}



