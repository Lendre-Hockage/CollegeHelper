import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Authorization {

    public static Text txtLog = new Text(), txtPas = new Text();
    public static TextField log= new TextField();
    public static TextField pas =  new TextField();
    public static Stage stage = new Stage();
    public static void input () {

        GridPane grid = new GridPane();   //создание сетки для разметки формы
        //grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(188, 250, 60, 348));



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

        Image close = new Image("CloseEye1.png");
        Button close_eye = new Button("", new ImageView(close));
        close_eye.setId("eye");
        close_eye.setLayoutX(600);
        close_eye.setLayoutY(445);
        close_eye.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });



        Image open = new Image("OpenEye1.png");
        Button open_eye = new Button("", new ImageView(open));
        open_eye.setId("eye");
//        open_eye.setLayoutX(600);
//        open_eye.setLayoutY(447);
        open_eye.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });


        HBox box_for_buttons = new HBox(198);
        Button btnAuth = new Button("Войти");
        btnAuth.setId("btn");
        box_for_buttons.getChildren().add(btnAuth);
        box_for_buttons.setAlignment(Pos.CENTER);
        grid.add(box_for_buttons, 0, 11);

        btnAuth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                AutorizCode.AutorizeME();

            }
        });


        //КНОПУЛЕЧКА "РЕГИСТРАЦИЯ"
        Button reg = new Button("Регистрация");
        reg.setId("lets_go");
        reg.setLayoutX(560);
        reg.setLayoutY(125);
        reg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Registration.SReg();
                stage.hide();
            }
        });



        AnchorPane pane = new AnchorPane(grid, reg, close_eye);
        Scene scene = new Scene(pane, 1000, 650); //добавляем Grid в Scene
        stage.setScene(scene); //добавляем scene в stage
        stage.setTitle("Авторизация"); //название форме (как наказывала Ишкушка)
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\ThemeFolder\\theme.txt")))
        {
            String th = reader.readLine();

            if (th.equals("1")){
                scene.getStylesheets().add("ForAvtorization.css");
            }
            else {
                scene.getStylesheets().add("ForAvtorizationGREY.css");
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        } //подключение CSS
        stage.show();                // отображение окна на экране
    }
}
