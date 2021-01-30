import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.*;

public class showScendule {

    public static void showLessons () {


        for (int i=0; i<30; i++) {
            Text text = new Text(" ");
            Schedule.showtxt[i] = text;
        }

        try (Connection conn = DriverManager.getConnection(AutorizCode.url, AutorizCode.root, AutorizCode.password)) { //подключаемся к бд
            Statement statement = conn.createStatement(); //штука, которая обрабатывает запросы sql
            ResultSet resultSet = statement.executeQuery("select * from mainschendule where group_name='"
                    + AutorizCode.group_name + "'"); //вынимаем всё расписание для определённой группы
            int q=0; //счётчик полей
            while(resultSet.next()&&q<30) {

                Text text = new Text(resultSet.getString(4));
                Schedule.showtxt[q]=text;

                q++;

            }


        } catch (SQLException throwables) {
            Menu.DatabaseFail(); //если не получилось подключиться, держим в курсе
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

public static void showLessonsAdmin() {


    for (int i=0; i<30; i++) {
        TextField text = new TextField(" ");
        Schedule.txt[i] = text;
    }

    try (Connection conn = DriverManager.getConnection(AutorizCode.url, AutorizCode.root, AutorizCode.password)) { //подключаемся к бд
        Statement statement = conn.createStatement(); //штука, которая обрабатывает запросы sql
        ResultSet resultSet = statement.executeQuery("select * from mainschendule where group_name='"
                + Schedule.EventComboBox.getValue() + "'"); //вынимаем всё расписание для определённой группы
        int q=0; //счётчик полей
        while(resultSet.next()&&q<30) {

            TextField text = new TextField(resultSet.getString(4));
            Schedule.txt[q]=text;

            q++;

        }


    } catch (SQLException throwables) {
        Menu.DatabaseFail(); //если не получилось подключиться, держим в курсе
        throwables.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }

}


}