import java.sql.*;

public class addSchendule {

    public static void addLessons() {

        if (Schedule.EventComboBox.getValue()==null) {Menu.Alert15();}

        else {

        try (Connection conn = DriverManager.getConnection(AutorizCode.url, AutorizCode.root, AutorizCode.password)) { //подключаемся к бд
            Statement statement = conn.createStatement(); //штука, которая обрабатывает запросы sql
             //коробка для записи взятых данных из таблицы
            statement.executeUpdate("delete from mainschendule where group_name = '" + Schedule.EventComboBox.getValue() + "'"); //удаляем предыдущее расписание
            int q=0; //счётчик текстфилдов
            for (int i=1; i<6; i++) { //счётчик дней недели
                for (int j = 1; j < 7; j++) { //счётчик пар

                    statement.executeUpdate("insert into mainschendule values ('" + Schedule.EventComboBox.getValue() + "', '"+ i +"', '"+ j +"','" + Schedule.txt[q].getText() + "')");
                    q++;

                }
            } //вписываем новое
            Menu.Alert14(); //уведомляем что всё круто
        } catch (SQLException throwables) {
            Menu.DatabaseFail(); //если не получилось подключиться, держим в курсе
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    } }
}
