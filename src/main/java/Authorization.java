import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Authorization {

    public static Text txtLog = new Text(), txtPas = new Text();
    public static TextField log= new TextField();
    public static PasswordField pas =  new PasswordField();

    public static void input () {
        Stage stage = new Stage();
        Text auth = new Text("Authorization: ");
        auth.setLayoutY(80);    // установка положения надписи по оси Y
        auth.setLayoutX(400);   // установка положения надписи по оси X
        auth.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 30));

        /*Text txtLog = new Text("");
        txtLog.setLayoutY(140);    // установка положения надписи по оси Y
        txtLog.setLayoutX(370);   // установка положения надписи по оси X
        txtLog.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        */

        log.setLayoutX(360);
        log.setLayoutY(115);
        log.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        //   @Override


        /*Text txtPas = new Text("");
        txtPas.setLayoutY(190);    // установка положения надписи по оси Y
        txtPas.setLayoutX(370);   // установка положения надписи по оси X
        txtPas.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));*/

        pas.setLayoutX(360);
        pas.setLayoutY(165);
        pas.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));


        Button btnAuth = new Button("    Log in     ");
        btnAuth.setId("btn");
        btnAuth.setLayoutY(220);    // установка положения надписи по оси Y
        btnAuth.setLayoutX(420);   // установка положения надписи по оси X
        btnAuth.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        btnAuth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (log.getText().equals("123") && pas.getText().equals("123")){
                    SuperAdminProfile.Profile();
                }
                else AutorizCode.AutorizeME();
            }
        });

        Button reg = new Button("You have no account? Register here!");
        reg.setLayoutY(270);    // установка положения надписи по оси Y
        reg.setLayoutX(320);   // установка положения надписи по оси X
        reg.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        reg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Registration.SReg();
            }
        });


        Button btnEx = new Button("      Exit       ");
        btnEx.setId("btn");
        btnEx.setLayoutY(320);    // установка положения надписи по оси Y
        btnEx.setLayoutX(420);   // установка положения надписи по оси X
        btnEx.setFont(Font.font("times new roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        btnEx.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });

        Pane root = new Pane(auth, log, txtLog, pas, txtPas, btnAuth, btnEx, reg);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("College Helper <3"); // установка заголовка
        stage.setWidth(1000);
        stage.setHeight(650);
        stage.show();                   // отображение окна на экране
    }
}
