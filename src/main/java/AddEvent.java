import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class AddEvent {
    public static int id = 0;

    //public static int eventType=0;
    public static void addEv() {
        int newid = 0;
        boolean flag = false;
        if (Events.box.getValue() == null && Events.CourseBox.getValue() == null) {
            Menu.Alert15();
        } else {

            try (Connection conn = DriverManager.getConnection(AutorizCode.url, AutorizCode.root, AutorizCode.password)) { //подключаемся к бд
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * from events");
                LocalDate localDate = LocalDate.now();
                LocalDate local = Events.datePicker.getValue();
                while (resultSet.next()) {
                    id = resultSet.getInt(1);
                    newid = id;
                    newid++;

                }
                if (local.isBefore(localDate)) {
                    Menu.Alert17();

                } else {
                    statement.executeUpdate("insert into events VALUES(" + newid + ",'" + Events.EventComboBox.getValue() + "','" + Events.description.getText() + "','" + Events.datePicker.getValue() + "','" + Events.box.getValue() + "','" + Events.CourseBox.getValue() + "')");
                    Menu.Alert16();//тут сам занос в бд
                }
            } catch (SQLException throwables) {
                Menu.DatabaseFail(); //если не получилось подключиться, держим в курсе
                throwables.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void delEv() {
        try (Connection conn = DriverManager.getConnection(AutorizCode.url, AutorizCode.root, AutorizCode.password)) { //подключаемся к бд
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from events");
            LocalDate localDate = LocalDate.now();
            LocalDate local = Events.datePicker.getValue();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
                Date date = resultSet.getDate(4);
                LocalDate localDate1 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date));
                if (localDate.isAfter(localDate1)) {
                    statement.executeUpdate("delete from events where event_date ='" + localDate1 + "'");
                }
            }
        } catch (SQLException throwables) {
            Menu.DatabaseFail(); //если не получилось подключиться, держим в курсе
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
