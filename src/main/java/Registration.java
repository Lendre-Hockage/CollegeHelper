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
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
  public static TextField log1 = new TextField(),
          pass1  = new PasswordField(),
          pass2 = new PasswordField(),
          name1 = new TextField(),
          surname1 = new TextField(),
          father1 = new TextField(),
          group1 = new TextField(),
          email1 = new TextField();


        private static Stage primaryStage = new Stage();
        public static void SReg() {
            GridPane grid = new GridPane();   //создание сетки для разметки формы
         //   grid.setGridLinesVisible(true);
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(70);
            grid.setPadding(new Insets(230, 167, 0, 167));

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



//            //КНОПУЛЕЧКА "РЕГИСТРАЦИЯ"
//            Button avtor = new Button("Регистрация");
//            HBox hbbtn = new HBox(100); //поместить в контейнер HBox, но это больше для удобства
//            avtor.setId("avtor");
//            hbbtn.setAlignment(Pos.BOTTOM_RIGHT);
//            hbbtn.getChildren().add(avtor);
//            grid.add(avtor, 1, 0);

          //ЗАГОЛОВОК "РЕГИСТРАЦИЯ"
          Label re = new Label("Регистрация");
          HBox for_name = new HBox();
          for_name.setAlignment(Pos.BASELINE_CENTER);
          for_name.getChildren().add(re);
          re.setId("welcome-text");   //для CSS
          re.setLayoutX(365);
          re.setLayoutY(153);


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
          group1.setId("field");
          grid.add(group1, 0, 10);



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
          grid.add(pass1, 1, 7);

          //LABEL "ПАРОЛЬ ПОВТОР"
          Label pass_pov = new Label("Повторите пароль:");
          pass_pov.setId("Label");
          grid.add(pass_pov, 1, 9);

          //EDIT "ПАРОЛЬ ПОВТОР"
          pass2.setId("field");
          grid.add(pass2, 1, 10);

            //КНОПУЛЕЧКА "→"

          Button arrow = new Button("Зарегистрироваться");
          arrow.setId("buttons");
          arrow.setLayoutX(375);
          arrow.setLayoutY(562);
          arrow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              RegistrCode.RegistrME();
            }
          });

//            //КНОПУЛЕЧКА "←"
//          Button arrow1 = new Button("←");
//          HBox hbBtn1 = new HBox(100); //поместить в контейнер HBox, но это больше для удобства
//          arrow1.setId("buttons");
//          hbBtn1.setAlignment(Pos.BOTTOM_LEFT);
//          hbBtn1.getChildren().add(arrow1);
//          grid.add(arrow1, 0, 12);
//          arrow1.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//              name1.clear();
//              surname1.clear();
//              father1.clear();
//              group1.clear();
//              email1.clear();
//              log1.clear();
//              pass1.clear();
//              pass2.clear();
//              Menu.Window();
//              primaryStage.close();
//            }
//          });

            Pane without_other_enter = new Pane(grid, re, arrow);
            Scene scene = new Scene(without_other_enter, 1000, 650); //добавляем Grid в Scene

            primaryStage.setScene(scene); //добавляем scene в stage
            primaryStage.setTitle("Регистрация"); //название форме (как наказывала Ишкушка)
            scene.getStylesheets().add(0, "ForRegistration.css"); //подключение CSS
            primaryStage.show();
        }
    }
