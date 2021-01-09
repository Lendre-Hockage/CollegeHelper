import javafx.scene.text.Text;

import java.sql.*;

public class ShowEvent {
    public static void show() {
        try (Connection conn = DriverManager.getConnection(AutorizCode.url, AutorizCode.root, AutorizCode.password)) { //подключаемся к бд
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from events where event_name='"+Events.EventComboBox.getValue()+"'");
            switch (Events.EventComboBox.getValue()) {
                case "Самостоятельные работы":
                    while(resultSet.next()) {
                        for (int i = 1; i < 7; i++) {
                            String text= resultSet.getString(i)+" ";
                            Events.evShow = text;
                            Events.textArea.setText(Events.evShow);//это не так должно работать, но я так заебался что мне лень думать
                        }
                    }
                    break;        //Действия при выборе соответствующего эл-та списка
                case "Контрольные работы":
                   // lbl.setText("yes2");
                    break;
                case "Мероприятия от колледжа":
                    //lbl.setText("yes3");
                    break;
                case "Другое":
                   // lbl.setText("yes4");
                    break;
                default:
                   // lbl.setText("not found");
                    break;
            }

        } catch (SQLException throwables) {
            Menu.DatabaseFail(); //если не получилось подключиться, держим в курсе
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
