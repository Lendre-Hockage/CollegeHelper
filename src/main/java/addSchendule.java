import java.sql.*;

public class addSchendule {

    public static void addLessons() {

        if (Schedule.EventComboBox.getValue()==null) {Menu.Alert15();}

        else {

        try (Connection conn = DriverManager.getConnection(AutorizCode.url, AutorizCode.root, AutorizCode.password)) { //подключаемся к бд
            Statement statement = conn.createStatement(); //штука, которая обрабатывает запросы sql

            statement.executeUpdate("delete from mainschendule where group_name = '"
                    + Schedule.EventComboBox.getValue() + "'"); //удаляем предыдущее расписание
            int q=0; //счётчик текстфилдов
            String day_of_week="";
            for (int i=1; i<6; i++) { //счётчик дней недели
                for (int j = 1; j < 7; j++) { //счётчик пар
                    switch (i) {
                        case 1: day_of_week="Mon"; break; //в зависимости от текущего значения
                        case 2: day_of_week="Tue"; break; //счётчика дней недели заменям цифру
                        case 3: day_of_week="Wed"; break; //на буквы. это удобнее для отображения изменений
                        case 4: day_of_week="Thu"; break; //и расписания на определённый день
                        case 5: day_of_week="Fri"; break;
                    }
                    statement.executeUpdate("insert into mainschendule values ('" + Schedule.EventComboBox.getValue() + "', '"+ day_of_week +"', '"+ j +"','" + Schedule.txt[q].getText() + "')");
                    q++;

                }
            } //вписываем новое

        } catch (SQLException throwables) {
            Menu.DatabaseFail(); //если не получилось подключиться, держим в курсе
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    } }
}
