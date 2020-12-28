import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Registration {
 public static ObservableList<String> listEvent = FXCollections.observableArrayList("@gmail.com",
          "@mail.ru",
          "@yandex.ru");
  public static ComboBox<String> EventComboBox = new ComboBox<String>(listEvent);
  public static TextField log1 = new TextField(),
          pass1  = new TextField(),
          name1 = new TextField(),
          surname1 = new TextField(),
          father1 = new TextField(),
          group1 = new TextField(),
          email1 = new TextField();


        private static Stage primaryStage = new Stage();
        public static void SReg() {
            GridPane grid = new GridPane();   //создание сетки для разметки формы
            //grid.setGridLinesVisible(true);  //видна/не видна
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(0);                   //отступы например между Edit и Label по горизонтали
            grid.setVgap(10);                   //отступы например между Edit и Label по вертикали
          grid.setPadding(new Insets(60, 60, 60, 60)); //утсановка отступов от краёв формы

//            //КНОПУЛЕЧКА "РЕГИСТРАЦИЯ"
//            Button avtor = new Button("Регистрация");
//            HBox hbbtn = new HBox(100); //поместить в контейнер HBox, но это больше для удобства
//            avtor.setId("avtor");
//            hbbtn.setAlignment(Pos.BOTTOM_RIGHT);
//            hbbtn.getChildren().add(avtor);
//            grid.add(avtor, 1, 0);

            //ЗАГОЛОВОК "РЕГИСТРАЦИЯ"
            Text scenetitle = new Text("Регистрация");
            scenetitle.setId("welcome-text");   //для CSS
            grid.add(scenetitle, 0, 1, 1, 1); //добавляем текст в Grid
            //i - столбец, i2 - строка, остальное хз))))



            //LABEL "ИМЯ"
            Label name = new Label("Имя:");
            name.setId("Label"); //для CSS
            grid.add(name, 0, 4);//добавляем текст в Grid

            //EDIT "ВВОД ИМЯ"

            name1.setId("field");
            grid.add(name1, 0, 5);



            //LABEL "ФАМИЛИЯ"
            Label surname = new Label("Фамилия:");
            surname.setId("Label");
            grid.add(surname, 0, 7);

            //EDIT "ВВОД ФАМИЛИЯ"

            surname1.setId("field");
            grid.add(surname1, 0, 8);



            //LABEL "ОТЧЕСТВО"
            Label father = new Label("Отчество:");
            father.setId("Label");
            grid.add(father, 0, 10);

            //EDIT "ВВОД ОТЧЕСТВО"

            father1.setId("field");
            grid.add(father1, 0, 11);


            //LABEL "ГРУППА"
            Label group = new Label("Группа:");
            group.setId("Label");
            grid.add(group, 0, 13);

            //EDIT "ГРУППА"

            group1.setId("field");
            grid.add(group1, 0, 14);



            //LABEL "EMAIL"
            Label email = new Label("Электронная почта:");
            email.setId("Label");
            grid.add(email, 0, 16);

            //EDIT "EMAIL"

            email1.setId("field");
            grid.add(email1, 0, 17);


          grid.add(EventComboBox,1,17);

            //LABEL "ЛОГИН"
            Label log = new Label("Логин:");
            log.setId("Label");
            grid.add(log, 0, 19);

            //EDIT "ЛОГИН"

            log1.setId("field");
            grid.add(log1, 0, 20);


            //LABEL "ПАРОЛЬ"
            Label pass = new Label("Пароль:");
            pass.setId("Label");
            grid.add(pass, 0, 22);

            //EDIT "ПАРОЛЬ"

            pass1.setId("field");
            grid.add(pass1, 0, 23);










            //КНОПУЛЕЧКА "→"
            Button arrow = new Button("Загерестрироваться→");
            HBox hbBtn = new HBox(100); //поместить в контейнер HBox, но это больше для удобства
            arrow.setId("arrow");
            hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
            hbBtn.getChildren().add(arrow);
            grid.add(arrow, 1, 26);
          arrow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              RegistrCode.RegistrME();
              name1.clear();
              surname1.clear();
              father1.clear();
              group1.clear();
              email1.clear();
              log1.clear();
              pass1.clear();
            }
          });


            //КНОПУЛЕЧКА "←"
            Button arrow1 = new Button("←");
            HBox hbBtn1 = new HBox(100); //поместить в контейнер HBox, но это больше для удобства
            arrow1.setId("arrow");
            hbBtn1.setAlignment(Pos.BOTTOM_LEFT);
            hbBtn1.getChildren().add(arrow1);
            grid.add(arrow1, 0, 26);


            Scene scene = new Scene(grid, 1000, 650); //добавляем Grid в Scene

            primaryStage.setScene(scene); //добавляем scene в stage
            primaryStage.setTitle("Регистрация"); //название форме (как наказывала Ишкушка)
         //   scene.getStylesheets().add(0, "ForRegistration.css"); //подключение CSS
            primaryStage.show();
        }
    }
