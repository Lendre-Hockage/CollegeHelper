import java.sql.*;

public class RegistrCode {

    public static String NewLogin = "", NewPassword = "", hash = "";
    public static int id=0; //тут всё очевидно
    public static void RegistrME() {
        NewLogin = Registration.log1.getText();
        int newid=0;
        try (Connection conn = DriverManager.getConnection(AutorizCode.url, AutorizCode.root, AutorizCode.password)) { //подключаемся к бд
            Statement statement = conn.createStatement(); //штука, которая обрабатывает запросы sql
            ResultSet resultSet = statement.executeQuery("SELECT * from users_info"); //коробка с данными из базы
            int matching = 0;
            while (resultSet.next()) {//пока в коробке есть данные
                String CurrentLogin = resultSet.getString(2);
                id=resultSet.getInt(1);
                //берём данные из первой строки первого столбца
                if (CurrentLogin.equals(NewLogin.trim())) {
                    matching = 1;
                }  //сравниваем с тем, что введено
            }

            if (matching == 0) {
                if (Registration.name1.getText().matches("^[a-zA-Z0-9]*$") || Registration.surname1.getText().matches("^[a-zA-Z0-9]*$") || Registration.father1.getText().matches("^[a-zA-Z0-9]*$")) {
                    Menu.Alert12();
                    Registration.name1.clear();
                    Registration.surname1.clear();
                    Registration.father1.clear();//Имя фамилия и отчество только русскими буквами
                } else {
                    if (Registration.cmbox.getValue()==null){
                        Menu.Alert15();
                    }
                    else{
                        if (Registration.email1.getText().contains("@")) {
                            Menu.Alert13();
                            Registration.email1.clear();//заполнение только первой половины почты
                        } else {
                            if (NewLogin.trim().isEmpty()) {
                                Menu.Alert9();
                                Registration.log1.clear();
                            } else { //еси написан пустой логин, выгоняем
                                if (NewLogin.indexOf(" ") != -1) {
                                    Menu.Alert10();
                                    Registration.log1.clear();
                                } else { //если написан логин с пробелами, выгоняем
                                    NewPassword = Registration.pass1.getText(); //читаем пароль
                                    hash = byteArrayToHexString(RegistrCode.computeHash(NewPassword));
                                    if (NewPassword.trim().equals("")) {
                                        Menu.Alert6();
                                        Registration.pass1.clear();
                                    } else { //если пустой пароль, выгоняем
                                        if (NewPassword.indexOf(" ") != -1) {
                                            Menu.Alert11();
                                            Registration.pass1.clear();
                                        } else {//если пароль с пробелами, выгоняем
                                            if (NewPassword.equals(Registration.pass2.getText()) == false) {//если пароль не совпадает
                                                Menu.Alert3();
                                                Registration.pass1.clear();
                                                Registration.pass2.clear();
                                            } else {
                                                newid = id;
                                                newid++;


                                                //записываем id, логин, пароль и тип (1 - студент) в users_info
                                                statement.executeUpdate("insert into users_info VALUES ('" + newid + "','" + NewLogin + "', '" + hash + "', " + 1 + ")");
                                                //записываем имя, фамилию, отчество, почту, группу в student_info
                                                statement.executeUpdate("insert into student_info VALUES ('" + Registration.name1.getText() + "','" + Registration.surname1.getText() + "', '" + Registration.father1.getText() + "', '" + Registration.cmbox.getValue() + "', '" + Registration.email1.getText() + Registration.EventComboBox.getValue() + "'," + newid + ")");
                                                Menu.Alert5();
                                                Authorization.input();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }else Menu.Alert4();
        } catch (
                SQLException throwables) {
            Menu.DatabaseFail(); //если не получилось подключиться, держим в курсе
            throwables.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void RegistrTeacher() {
        NewLogin = RegistTeacher.log1.getText();
        int newid=0;
        try (Connection conn = DriverManager.getConnection(AutorizCode.url, AutorizCode.root, AutorizCode.password)) { //подключаемся к бд
            Statement statement = conn.createStatement(); //штука, которая обрабатывает запросы sql
            ResultSet resultSet = statement.executeQuery("SELECT * from users_info"); //коробка с данными из базы
            int matching = 0;
            while (resultSet.next()) {//пока в коробке есть данные
                String CurrentLogin = resultSet.getString(2);
                id=resultSet.getInt(1);
                //берём данные из первой строки первого столбца
                if (CurrentLogin.equals(NewLogin.trim())) {
                    matching = 1;
                }  //сравниваем с тем, что введено
            }

            if (matching == 0) {
                if (RegistTeacher.name1.getText().matches("^[a-zA-Z0-9]*$") || RegistTeacher.surname1.getText().matches("^[a-zA-Z0-9]*$") || RegistTeacher.father1.getText().matches("^[a-zA-Z0-9]*$")) {
                    Menu.Alert12();
                    RegistTeacher.name1.clear();
                    RegistTeacher.surname1.clear();
                    RegistTeacher.father1.clear();//Имя фамилия и отчество только русскими буквами
                } else {

                        if (RegistTeacher.email1.getText().contains("@")) {
                            Menu.Alert13();
                            RegistTeacher.email1.clear();//заполнение только первой половины почты
                        } else {
                            if (NewLogin.trim().isEmpty()) {
                                Menu.Alert9();
                                RegistTeacher.log1.clear();
                            } else { //еси написан пустой логин, выгоняем
                                if (NewLogin.indexOf(" ") != -1) {
                                    Menu.Alert10();
                                    RegistTeacher.log1.clear();
                                } else { //если написан логин с пробелами, выгоняем
                                    NewPassword = RegistTeacher.pass1.getText(); //читаем пароль
                                    hash = byteArrayToHexString(RegistrCode.computeHash(NewPassword));
                                    if (NewPassword.trim().equals("")) {
                                        Menu.Alert6();
                                        RegistTeacher.pass1.clear();
                                    } else { //если пустой пароль, выгоняем
                                        if (NewPassword.indexOf(" ") != -1) {
                                            Menu.Alert11();
                                            RegistTeacher.pass1.clear();
                                        } else {//если пароль с пробелами, выгоняем
                                            if (NewPassword.equals(RegistTeacher.pass2.getText()) == false) {//если пароль не совпадает
                                                Menu.Alert3();
                                                RegistTeacher.pass1.clear();
                                                RegistTeacher.pass2.clear();
                                            } else {
                                                newid = id;
                                                newid++;


                                                //записываем id, логин, пароль и тип (2 - препод) в users_info
                                                statement.executeUpdate("insert into users_info VALUES ('" + newid + "','" + NewLogin + "', '" + hash + "', " + 2 + ")");
                                                //записываем имя, фамилию, отчество, почту в prepods_info
                                                statement.executeUpdate("insert into prepods_info VALUES ('" + RegistTeacher.name1.getText() + "','" + RegistTeacher.surname1.getText() + "', '" + RegistTeacher.father1.getText() + "', '" + RegistTeacher.email1.getText() + RegistTeacher.EventComboBox.getValue() + "'," + newid + ")");
                                                Menu.Alert5();
                                                Authorization.input();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

            }else Menu.Alert4();
        } catch (
                SQLException throwables) {
            Menu.DatabaseFail(); //если не получилось подключиться, держим в курсе
            throwables.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public static byte[] computeHash(String x)
            throws Exception {
        java.security.MessageDigest d = null;
        d = java.security.MessageDigest.getInstance("SHA-1");
        d.reset();
        d.update(x.getBytes());
        return d.digest();
    }

    public static String byteArrayToHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString().toUpperCase();
    }
}
