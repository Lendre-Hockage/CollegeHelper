import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddEvent {
    public static int id=0;
    public static void addEv() {
        if (Events.box.getValue() == null) {
            Menu.Alert15();
        } else {

            try (Connection conn = DriverManager.getConnection(AutorizCode.url, AutorizCode.root, AutorizCode.password)) { //подключаемся к бд
                Statement statement = conn.createStatement();
            }
            catch (SQLException throwables) {
                Menu.DatabaseFail(); //если не получилось подключиться, держим в курсе
                throwables.printStackTrace();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
