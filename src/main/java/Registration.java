import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Registration {
 public static ObservableList<String> listEvent = FXCollections.observableArrayList("@gmail.com",
          "@yandex.ru",
          "@ya.ru",
          "@yandex.com",
          "@yandex.ua",
          "@yandex.kz",
          "@yandex.by",
          "@mail.ru",
          "@list.ru",
          "@inbox.ru",
          "@bk.ru",
          "@yahoo.com",
          "@hotmail.com",
          "@outlook.com",
          "@internet.ru");
  public static ComboBox<String> EventComboBox = new ComboBox<String>(listEvent);
  public static ComboBox<String> cmbox = new ComboBox<String>(Schedule.listEvent);
  public static TextField log1 = new TextField(),
          pass1  = new TextField(),
          pass2 = new TextField(),
          name1 = new TextField(),
          surname1 = new TextField(),
          father1 = new TextField(),
          group1 = new TextField(),
          email1 = new TextField();
public static PasswordField pass11 = new PasswordField(), pass22 = new PasswordField();

        private static Stage primaryStage = new Stage();
        public static void SReg() {
            GridPane grid = new GridPane();   //создание сетки для разметки формы
         //   grid.setGridLinesVisible(true);
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(70);
            grid.setPadding(new Insets(220, 167, 0, 167));

          grid.getColumnConstraints().add(new ColumnConstraints(300));
          grid.getColumnConstraints().add(new ColumnConstraints(300));



          grid.getRowConstraints().add(new RowConstraints(30));
          grid.getRowConstraints().add(new RowConstraints(40)); //Фамилия
          grid.getRowConstraints().add(new RowConstraints(10));

          grid.getRowConstraints().add(new RowConstraints(30));
          grid.getRowConstraints().add(new RowConstraints(40)); //Имя
          grid.getRowConstraints().add(new RowConstraints(10));

          grid.getRowConstraints().add(new RowConstraints(30));
          grid.getRowConstraints().add(new RowConstraints(40)); //Отчество
          grid.getRowConstraints().add(new RowConstraints(10));

          grid.getRowConstraints().add(new RowConstraints(30));
          grid.getRowConstraints().add(new RowConstraints(40)); //Группа


          //ЗАГОЛОВОК "РЕГИСТРАЦИЯ"
          Label re = new Label("Регистрация");
          HBox for_name = new HBox();
          for_name.setAlignment(Pos.BASELINE_CENTER);
          for_name.getChildren().add(re);
          re.setId("welcome-text");   //для CSS
          re.setLayoutX(365);
          re.setLayoutY(145);


          //LABEL "ФАМИЛИЯ"
          Label surname = new Label("Фамилия:");
          surname.setId("Label");
          grid.add(surname, 0, 0);

          //EDIT "ВВОД ФАМИЛИЯ"
          surname1.setId("field");
          grid.add(surname1, 0, 1);


          //LABEL "ИМЯ"
          Label name = new Label("Имя:");
          name.setId("Label"); //для CSS
          grid.add(name, 0, 3);//добавляем текст в Grid

          //EDIT "ВВОД ИМЯ"
          name1.setId("field");
          grid.add(name1, 0, 4);



          //LABEL "ОТЧЕСТВО"
          Label father = new Label("Отчество:");
          father.setId("Label");
          grid.add(father, 0, 6);

          //EDIT "ВВОД ОТЧЕСТВО"
          father1.setId("field");
          grid.add(father1, 0, 7);



          //LABEL "ГРУППА"
          Label group = new Label("Группа:");
          group.setId("Label");
          grid.add(group, 0, 9);

          //EDIT "ГРУППА"
          //group1.setId("field");
          cmbox.setId("event");
          grid.add(cmbox, 0, 10);



          //LABEL "EMAIL"
          Label email = new Label("Электронная почта:");
          email.setId("Label");
          grid.add(email, 1, 0);

          //EDIT "EMAIL"
          email1.setId("field");
          HBox box = new HBox(5);
          box.getChildren().addAll(email1, EventComboBox);
          EventComboBox.setId("event");
          grid.add(box,1,1);


          //LABEL "ЛОГИН"
          Label log = new Label("Логин:");
          log.setId("Label");
          grid.add(log, 1, 3);

          //EDIT "ЛОГИН"
          log1.setId("field");
          grid.add(log1, 1, 4);

          //LABEL "ПАРОЛЬ"
          Label pass = new Label("Пароль:");
          pass.setId("Label");
          grid.add(pass, 1, 6);

          //EDIT "ПАРОЛЬ"
          pass1.setId("field");
          pass11.setId("field");
          grid.add(pass11, 1, 7);

          Image close = new Image("CloseEye1.png");
          Button close_eye = new Button("", new ImageView(close));
          close_eye.setId("eye");
          close_eye.setLayoutX(790);
          close_eye.setLayoutY(410);




          Image open = new Image("OpenEye1.png");
          Button open_eye = new Button("", new ImageView(open));
          open_eye.setId("eye");
          open_eye.setLayoutX(790);
          open_eye.setLayoutY(410);



          //LABEL "ПАРОЛЬ ПОВТОР"
          Label pass_pov = new Label("Повторите пароль:");
          pass_pov.setId("Label");
          grid.add(pass_pov, 1, 9);

          //EDIT "ПАРОЛЬ ПОВТОР"
          pass2.setId("field");
          pass22.setId("field");
          grid.add(pass22, 1, 10);

          Image close1 = new Image("CloseEye1.png");
          Button close_eye1 = new Button("", new ImageView(close));
          close_eye1.setId("eye");
          close_eye1.setLayoutX(790);
          close_eye1.setLayoutY(490);




          Image open1 = new Image("OpenEye1.png");
          Button open_eye1 = new Button("", new ImageView(open1));
          open_eye1.setId("eye");
          open_eye1.setLayoutX(790);
          open_eye1.setLayoutY(490);




          //КНОПУЛЕЧКА "→"
          Button arrow = new Button("Зарегистрироваться");
          arrow.setId("buttons");
          arrow.setLayoutX(375);
          arrow.setLayoutY(555);
          arrow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

              RegistrCode.RegistrME();

            }
          });


          //КНОПУЛЕЧКА "АВТОРИЗАЦИЯ"
          Button av = new Button("Авторизация");
          av.setId("lets_go");
          av.setLayoutX(680);
          av.setLayoutY(100);
          av.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              Authorization.input();
              primaryStage.hide();
            }
          });


            Pane without_other_enter = new Pane(grid, re, arrow, av, open_eye, open_eye1);

          close_eye.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              pass11.setText(pass1.getText());
              grid.getChildren().remove(pass1);
              grid.add(pass11, 1,7);
              without_other_enter.getChildren().remove(close_eye);
              without_other_enter.getChildren().add(open_eye);
            }
          });

          open_eye.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              pass1.setText(pass11.getText());
              grid.getChildren().remove(pass11);
              grid.add(pass1, 1,7);
              without_other_enter.getChildren().remove(open_eye);
              without_other_enter.getChildren().add(close_eye);
            }
          });

          close_eye1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              pass22.setText(pass2.getText());
              grid.getChildren().remove(pass2);
              grid.add(pass22, 1,10);
              without_other_enter.getChildren().remove(close_eye1);
              without_other_enter.getChildren().add(open_eye1);
            }
          });

          open_eye1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              pass2.setText(pass22.getText());
              grid.getChildren().remove(pass22);
              grid.add(pass2, 1,10);
              without_other_enter.getChildren().remove(open_eye1);
              without_other_enter.getChildren().add(close_eye1);
            }
          });

            Scene scene = new Scene(without_other_enter, 1000, 650); //добавляем Grid в Scene

            primaryStage.setScene(scene); //добавляем scene в stage
            primaryStage.setTitle("Регистрация");//название форме (как наказывала Ишкушка)
          try(BufferedReader reader = new BufferedReader(new FileReader("C:\\ThemeFolder\\theme.txt")))
          {
            String th = reader.readLine();

            if (th.equals("1")){
              scene.getStylesheets().add("ForRegistration.css");
            }
            else {
              scene.getStylesheets().add("ForRegistrationGREY.css");
            }
          }
          catch (IOException e)
          {
            System.out.println(e.getMessage());
          }
            //scene.getStylesheets().add(0, "ForRegistration.css"); //подключение CSS
            primaryStage.show();
        }
    }
