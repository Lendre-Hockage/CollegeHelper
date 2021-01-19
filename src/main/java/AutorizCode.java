import java.sql.*;

public class AutorizCode {


        public static String root="root";
    public static String password="root";
    public static String url="jdbc:mysql://localhost:3306/sharagahelper?serverTimezone=Europe/Moscow&useSSL=false";
    public static String NowPass="";
    public static String name;
    public static String surname;
    public static String second_name;
    public static String email;
    public static String group_name;
    public static int id;
    public static int type;
        //данные о бд, имя пользователя, пароль, расположение и коррекция бед с часовым поясом
        public static int check=0, matching=0;


        public static void AutorizeME() {
                try (Connection conn = DriverManager.getConnection(url, root, password)) { //подключаемся к бд
                    Statement statement = conn.createStatement(); //штука, которая обрабатывает запросы sql
                    ResultSet resultSet = statement.executeQuery("SELECT * from users_info"); //коробка для записи взятых данных из таблицы
                    //executeQuery метод для извлечения данных
                    matching = 0;
                    while (resultSet.next()) { //пока в коробке с данными есть данные
                        check = 0;
                        while (check == 0) { // пока нужные данные не найдены
                            String CurrentLogin = resultSet.getString(2);
                            String CurrentPassword = resultSet.getString(3);
                            id = resultSet.getInt(1);
                            type = resultSet.getInt(4);



                            if (CurrentLogin.equals(Authorization.log.getText().trim()) && matching == 0) {
                                //сравниваем логины, если ещё не найден проходящий
                                NowPass = Authorization.pas.getText().trim();
                                NowPass = RegistrCode.byteArrayToHexString(RegistrCode.computeHash(NowPass));
                                if (CurrentPassword.equals(NowPass)) { //сравниваем пароли
                                    matching = 1; //логин и пароль совпали с записанными
                                    Statement state = conn.createStatement();
                                    ResultSet rs = state.executeQuery("SELECT name, surname, second_name, group_name, email from student_info where id=" + id);
                                    while (rs.next()) {
                                        name = rs.getString(1);
                                        surname = rs.getString(2);
                                        second_name = rs.getString(3);
                                        group_name = rs.getString(4);
                                        email = rs.getString(5);
                                    }
                                    check = 4;
                                    if (type == 1){AccountForStudent.WindowStudent(); }
                                    else if (type == 2){AccountForTeacher.WindowTeacher();}
                                    else {AccountForSuperAdmin.WindowAdmin(); }
                                } else {
                                    matching = 2; //пароль не совпал
                                    check = 4;
                                }
                            } else {
                                check = 4;
                            }//такого логина нет
                        }

                    }


                } catch (SQLException throwables) {
                    Menu.DatabaseFail(); //если не получилось подключиться, держим в курсе
                    throwables.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            switch (matching) {
                case 1: /*Menu.Alert1();*/Authorization.log.clear();Authorization.pas.clear(); break; //всё верно
                case 2: Menu.Alert8();Authorization.pas.clear(); break;  //пароль неверный
                case 0: Menu.Alert2();Authorization.log.clear(); break;  //логина нет

            }

        }
    }

