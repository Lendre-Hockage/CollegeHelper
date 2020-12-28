import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class StudentProfile {


    public static Text FI = new Text(), group = new Text(), FIO_cur = new Text();


     public static void Profile () {
         Stage stage = new Stage();
         boolean flag = true;

         Text prof = new Text("Мой профиль");
         prof.setLayoutY(40);    // установка положения надписи по оси Y
         prof.setLayoutX(20);   // установка положения надписи по оси X
         prof.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 30));

         Text chert = new Text("____________________________________________________________________________________________________________________________________________");
         chert.setY(50);
         chert.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 30));

         FI.setX(20);
         FI.setY(120);
         FI.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
         FI.setText(AutorizCode.name + " " + AutorizCode.surname);

         group.setX(20);
         group.setY(140);
         group.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
         group.setText(AutorizCode.group_name);

         FIO_cur.setX(20);
         FIO_cur.setY(160);
         FIO_cur.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 10));
         FIO_cur.setText("Сначала определи - потом буду");

         Button btn1 = new Button("Maps");
         btn1.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent actionEvent) {
                 Maps.Map();
             }
         });
         btn1.setLayoutX(300);
         btn1.setLayoutY(80);
         btn1.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));

         Button btn2 = new Button("Events");
         btn2.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent actionEvent) {
                 Events.Window();
             }
         });
         btn2.setLayoutX(300);
         btn2.setLayoutY(120);
         btn2.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));

         Button btn3 = new Button("Schedule");
         btn3.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent actionEvent) {
                 Schedule.Window();
             }
         });
         btn3.setLayoutX(300);
         btn3.setLayoutY(160);
         btn3.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));

         RadioButton showSched = new RadioButton("Показать мой список предметов");
         showSched.setLayoutX(450);
         showSched.setLayoutY(80);

         showSched.setOnAction(event -> {
            /* grid2.add(lbl0, 0, 0);
             grid2.add(lbl1, 0, 1); //0-столбец 1-строка
             grid2.add(lbl2, 0, 2);
             grid2.add(lbl3, 0, 3);
             grid2.add(lbl4, 0, 4);
             grid2.add(lbl5, 0, 5);
             grid2.add(lbl6, 0, 6);

             pane.getChildren().clear();
             pane.getChildren().addAll(showSched, grid2);*/
         });

         Text time = new Text();
         time.setX(400);
         time.setY(400);


         //time.setText(String.valueOf(date.getHours()) + ":" + String.valueOf(date.getMinutes()) + ":" + String.valueOf(date.getSeconds()));

         //time.setText(date.toString());

         Button res = new Button("Обновить");
         res.setLayoutX(300);
         res.setLayoutY(300);

         res.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 Date date = new Date();
                 time.setText(String.valueOf(date.getHours()) + ":" + String.valueOf(date.getMinutes()) + ":" + String.valueOf(date.getSeconds()));
             }
         });

         Pane root = new Pane();
         root.getChildren().addAll(prof, FI, FIO_cur, group, chert, btn1, btn2, btn3, showSched, time, res);
         Scene scene = new Scene(root);

         stage.setScene(scene);
         stage.setTitle("Профиль"); // установка заголовка
         stage.setWidth(1000);
         stage.setHeight(650);
         stage.show();                   // отображение окна на экране
     }


//    Что должно быть:
//    Возможность добавить фото профиля ??? Для начала слишком сложно
//    Список предметов (разворачивающийся)
//    Отображение системного времени справа-снизу
//    Отображение событий для текущего студента

}

