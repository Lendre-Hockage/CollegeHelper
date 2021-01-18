import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class addChanges {



    public static void addChanges() {

        //проверка надо ли удалять расписание
        if (Schedule.words[0].equals("Mon")==false) { Schedule.monday_check=1; }

        if (Schedule.EventComboBox.getValue()==null) {Menu.Alert15();}

        else {

            try (Connection conn = DriverManager.getConnection(AutorizCode.url, AutorizCode.root, AutorizCode.password)) { //подключаемся к бд
                Statement statement = conn.createStatement(); //штука, которая обрабатывает запросы sql



                if (Schedule.words[0].equals("Mon") && Schedule.monday_check==0) {
                    //если сегодня понедельник,
                    // удаляем изменения за прошлую неделю у всех групп,
                    //  если они ещё не были удалены (т.е monday_check==0)
                statement.executeUpdate("delete from changeschendule");
                    Schedule.monday_check=1;
                }



                int q=0; //счётчик текстфилдов

                String next_day="";

                switch (Schedule.words[0]) {

                    case "Mon": next_day="Tue"; break;
                    case "Tue":next_day="Wed"; break;
                    case "Wed":next_day="Thu"; break;
                    case "Thu":next_day="Fri"; break;
                    case "Fri":next_day="Mon"; break;

                }

                for (int i=1; i<3; i++) { //счётчик дней недели
                    for (int j = 1; j < 7; j++) { //счётчик пар

                        if (i==1) { //на сегодня
                        statement.executeUpdate
                                ("insert into changeschendule values ('" + Schedule.EventComboBox.getValue() +
                                        "', '"+ Schedule.words[0] +"', '"+ j +"','" + Schedule.txt1[q].getText() + "')"); }
                        else { //на завтра
                            statement.executeUpdate
                                    ("insert into changeschendule values ('" + Schedule.EventComboBox.getValue() +
                                            "', '"+ next_day +"', '"+ j +"','" + Schedule.txt1[q].getText() + "')"); }

                        q++;

                    }
                } //вписываем новое

            } catch (SQLException throwables) {
                Menu.DatabaseFail(); //если не получилось подключиться, держим в курсе
                throwables.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }

}
