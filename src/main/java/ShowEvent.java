import javafx.scene.text.Text;

import java.sql.*;

public class ShowEvent {
    public static void show() {

        for (int i=1; i<500; i++) { //так надо. не ломать
            Text text = new Text(" ");
            Events.evShow[i] = text;
        }


        try (Connection conn = DriverManager.getConnection(AutorizCode.url, AutorizCode.root, AutorizCode.password)) { //подключаемся к бд
            Statement statement = conn.createStatement(); //запрос sql
            ResultSet resultSet = statement.executeQuery("select * from events where event_name='"+Events.EventComboBox.getValue()+"'");
            int q=0;

                    while (resultSet.next()) { //пока не закончится результ сэт
                        for (int i=2; i<6; i++) { //берём элементы без id
                            Text text = new Text (resultSet.getString(i)+" ");

                            Events.evShow[i+q] = text;
                            q=q+6; //двигаем массив чтобы записывалось всё, а не только последнее поверх всего

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
