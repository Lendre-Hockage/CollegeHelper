import javafx.scene.text.Text;

import java.sql.*;

    public class showChanges {


        public static void showChanges() {

            for (int i=0; i<12; i++) {
                Text text = new Text(" ");
                Schedule.showtxt2[i] = text;
            }


            String next_day="";

            switch (Schedule.words[0]) {

                case "Mon": next_day="Tue"; break;
                case "Tue":next_day="Wed"; break;
                case "Wed":next_day="Thu"; break;
                case "Thu":next_day="Fri"; break;
                case "Fri":next_day="Mon"; break;

            }

            try (Connection conn = DriverManager.getConnection(AutorizCode.url, AutorizCode.root, AutorizCode.password)) { //подключаемся к бд
                Statement statement = conn.createStatement(); //штука, которая обрабатывает запросы sql
                //вынимаем все измения для определённой группы на два дня
                ResultSet resultSet = statement.executeQuery
                        ("select * from changeschendule where group_name='"+ Schedule.EventComboBox1.getValue() +
                                "'and day_of_week='" +Schedule.words[0]+ "' or day_of_week='" + next_day + "'");
                int q=0; //счётчик полей
                while(resultSet.next()&&q<12) {

                    Text text = new Text(resultSet.getString(4));
                    Schedule.showtxt2[q]=text;

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





