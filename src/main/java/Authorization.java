import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Authorization {

    public static Text txtLog = new Text(), txtPas = new Text();
    public static TextField log= new TextField();
    public static PasswordField pas =  new PasswordField();
    public static Stage stage = new Stage();
    public static void input () {

        Stage stage = new Stage();
        GridPane grid = new GridPane();   //создание сетки для разметки формы
       // grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(120, 60, 60, 60));



        grid.getColumnConstraints().add(new ColumnConstraints(300));
        grid.getRowConstraints().add(new RowConstraints(80));
        grid.getRowConstraints().add(new RowConstraints(20));
        grid.getRowConstraints().add(new RowConstraints(20));

        grid.getRowConstraints().add(new RowConstraints(30));
        grid.getRowConstraints().add(new RowConstraints(40)); //Логин
        grid.getRowConstraints().add(new RowConstraints(10));

        grid.getRowConstraints().add(new RowConstraints(30));

        grid.getRowConstraints().add(new RowConstraints(30));
        grid.getRowConstraints().add(new RowConstraints(40)); //Пароль
        grid.getRowConstraints().add(new RowConstraints(10));

        grid.getRowConstraints().add(new RowConstraints(30));
        grid.getRowConstraints().add(new RowConstraints(50));//Кнопка

        //LABEL "РЕГИСТРАЦИЯ"
        Label rega = new Label("Авторизация");
        rega.setId("welcome-text");
        grid.add(rega, 0, 0);


        //LABEL "ЛОГИН"
        Label login_login = new Label("Логин:");
        login_login.setId("Label");
        grid.add(login_login, 0, 3);

        //EDIT "ВВОД ЛОГИН"
        log.setId("field");
        grid.add(log, 0, 4);



        //LABEL "ПАРОЛЬ"
        Label password_password = new Label("Пароль:");
        password_password.setId("Label"); //для CSS
        grid.add(password_password, 0, 7);//добавляем текст в Grid

        //EDIT "ВВОД ПАРОЛЬ"
        pas.setId("field");
        grid.add(pas, 0, 8);

        HBox box_for_buttons = new HBox(198);


//        //КНОПКА "ВЫЙТИ"
//        Button btnEx = new Button("←");
//        btnEx.setId("btn");
//        box_for_buttons.getChildren().add(btnEx);
//
//
//
//        btnEx.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                Menu.Window();
//                stage.close();
//            }
//        });


        //КНОПКА "ДАЛЕЕ"
        Button btnAuth = new Button("Войти");
        btnAuth.setId("btn");
        box_for_buttons.getChildren().add(btnAuth);
        box_for_buttons.setAlignment(Pos.CENTER);


        btnAuth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AutorizCode.AutorizeME();
            }
        });

        grid.add(box_for_buttons, 0, 11);



        Scene scene = new Scene(grid, 1000, 650); //добавляем Grid в Scene

        stage.setScene(scene); //добавляем scene в stage
        stage.setTitle("Авторизация"); //название форме (как наказывала Ишкушка)
        scene.getStylesheets().add(0, "ForAvtorization.css"); //подключение CSS
        stage.show();                // отображение окна на экране
    }
}
