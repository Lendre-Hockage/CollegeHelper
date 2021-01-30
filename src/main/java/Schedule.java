import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.Date;


public class Schedule {
    //объявление массива!!!!!!!!! для внесения расписания
    public static TextField[] txt = new TextField[30]; //основное
    public static TextField[] txt1 = new TextField[12]; //изменения
    public static int select; //проверка выбора что вносить
    //объявление выпадающего списка. глобально, потому что в addSchendule
    //название группы читается в бд
    public static ObservableList<String> listEvent = FXCollections.observableArrayList("1-ИС",
            "1-СП",
            "1-СА",
            "2-ТМС",
            "2-TO",
            "2-CA",
            "3-ИС",
            "3-ПСО1",
            "3-ПСО2",
            "4-ПР1");

    public static  ComboBox<String> EventComboBox = new ComboBox<String>(listEvent);

    //объявление массива для отображения расписания и изменений(2)
    public static Text[] showtxt = new Text[30];
    public static Text[] showtxt2 = new Text[12];
    //выпадающий список для отображения расписания
    public static ObservableList<String> listEvent1 = FXCollections.observableArrayList("1-ИС",
            "1-СП",
            "1-СА",
            "2-ТМС",
            "2-TO",
            "2-CA",
            "3-ИС",
            "3-ПСО1",
            "3-ПСО2",
            "4-ПР1");

    public static  ComboBox<String> EventComboBox1 = new ComboBox<String>(listEvent1);

    //дата глобально, потому что она нужна для изменений
    public static Date date = new Date();
    public static String dat = String.valueOf(date);
    public static String[] words = dat.split(" ");


    public  static Stage stage = new Stage();

    public static void Window () { //Окно расписания

        BackgroundImage bgI;
        if (AccountForStudent.scene.getStylesheets().contains("ForStudentForm.css")){
        bgI = new BackgroundImage(new Image("BackSheduleForStudent.png",1000,650,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);}
        else {
           bgI = new BackgroundImage(new Image("BackSheduleForStudentGREY.png",1000,650,false,true),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);}

        FlowPane pane = new FlowPane(Orientation.HORIZONTAL, 25, 20);
        FlowPane pane2 = new FlowPane(Orientation.HORIZONTAL, 25, 20);
        pane.setLayoutX(250);
        pane.setLayoutY(110);
        pane2.setLayoutX(250);
        pane2.setLayoutY(415);

        StandartMenu.showMenu();

        Pane pane1 = new Pane(StandartMenu.btn1, StandartMenu.btn3, StandartMenu.btn5, StandartMenu.btn4,  StandartMenu.btn6,
                StandartMenu.authorize, StandartMenu.eve, StandartMenu.ex, StandartMenu.shedl, StandartMenu.maps);


        GridPane grid = new GridPane();
        grid.setLayoutX(50);
        grid.setLayoutY(150);
        grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(30));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));



        Text lbl1 = new Text("1");
        Text lbl2 = new Text("2");
        Text lbl3 = new Text("3");
        Text lbl4 = new Text("4");
        Text lbl5 = new Text("5");
        Text lbl6 = new Text("6");


        Text lbl11 = new Text("Понедельник");
        Text lbl21 = new Text("Вторник");
        Text lbl31 = new Text("Среда");
        Text lbl41 = new Text("Четверг");
        Text lbl51 = new Text("Пятница");




        grid.add(lbl1, 0, 1); //0-столбец 1-строка
        grid.add(lbl2, 0, 2);
        grid.add(lbl3, 0, 3);
        grid.add(lbl4, 0, 4);
        grid.add(lbl5, 0, 5);
        grid.add(lbl6, 0, 6);

        grid.add(lbl11, 1, 0);
        grid.add(lbl21, 2, 0); //0-столбец 1-строка
        grid.add(lbl31, 3, 0);
        grid.add(lbl41, 4, 0);
        grid.add(lbl51, 5, 0);

        grid.setHalignment(lbl1, HPos.CENTER);
        grid.setHalignment(lbl2, HPos.CENTER);
        grid.setHalignment(lbl3, HPos.CENTER);
        grid.setHalignment(lbl4, HPos.CENTER);
        grid.setHalignment(lbl5, HPos.CENTER);
        grid.setHalignment(lbl6, HPos.CENTER);

        grid.setHalignment(lbl11, HPos.CENTER);
        grid.setHalignment(lbl21, HPos.CENTER);
        grid.setHalignment(lbl31, HPos.CENTER);
        grid.setHalignment(lbl41, HPos.CENTER);
        grid.setHalignment(lbl51, HPos.CENTER);



        GridPane grid2 = new GridPane();
        grid2.setLayoutX(50);
        grid2.setLayoutY(350);

        grid2.setGridLinesVisible(true);
        grid2.getColumnConstraints().add(new ColumnConstraints(30));
        grid2.getColumnConstraints().add(new ColumnConstraints(130));
        grid2.getColumnConstraints().add(new ColumnConstraints(80));
        grid2.getColumnConstraints().add(new ColumnConstraints(130));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));

        Date date = new Date();
        String dat = String.valueOf(date);
        String[] words = dat.split(" ");
        Label fDay = new Label();
        fDay.setId("text");
        Label sDay = new Label();
        sDay.setId("text");

        grid2.setHalignment(fDay, HPos.CENTER);
        grid2.setHalignment(sDay, HPos.CENTER);


        switch (words[0]){
            case "Mon":{fDay.setText("Понедельник"); sDay.setText("Вторник");break;}
            case "Tue":{fDay.setText("Вторник"); sDay.setText("Среда");break;}
            case "Wed":{fDay.setText("Среда"); sDay.setText("Четверг");break;}
            case "Thu":{fDay.setText("Четверг"); sDay.setText("Пятница");break;}
            case "Fri":{fDay.setText("Пятница"); sDay.setText("Понедельник");break;}
            case "Sat":{fDay.setText("Выходной"); sDay.setText("Понедельник");break;}
            case "Sun":{fDay.setText("Выходной"); sDay.setText("Понедельник");break;}
            default:{ Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Эм... Походу считано неправильное время");
                alert.setContentText("Событие было отправлено следующим группам: ");
                alert.showAndWait();
            }
        }

        grid2.add(fDay, 1, 0);
        grid2.add(sDay, 3, 0);

        grid2.add(lbl1, 0, 1); //0-столбец 1-строка
        grid2.add(lbl2, 0, 2);
        grid2.add(lbl3, 0, 3);
        grid2.add(lbl4, 0, 4);
        grid2.add(lbl5, 0, 5);
        grid2.add(lbl6, 0, 6);


            EventComboBox1.setValue(AutorizCode.group_name);

            //добавление текста с расписанием
            for (int i = 0; i < 30; i++) {
                Text text = new Text();
                showtxt[i] = text;
            }
            int p = 0;

            for (int q = 1; q < 6; q++) {
                for (int j = 1; j < 7; j++) {
                    grid2.add(showtxt[p], q, j);
                    grid.add(showtxt[p], q, j);
                    p++;
                }
            }


            if (EventComboBox1.getValue() == null) {
                Menu.Alert15();
            } else {
                showScendule.showLessons();

                int k = 0;

                for (int q = 1; q < 6; q++) {
                    for (int j = 1; j < 7; j++) {

                        grid.add(showtxt[k], q, j);
                        k++;
                    }
                }
                pane.getChildren().clear();
                pane.getChildren().addAll(grid);

                int o = 0;

                showChanges.showChanges();

                for (int j = 1; j < 7; j++) {

                    grid2.add(showtxt2[o], 1, j);
                    o++;
                }

                for (int j = 1; j < 7; j++) {

                    grid2.add(showtxt2[o], 3, j);
                    o++;
                }


                pane2.getChildren().clear();
                pane2.getChildren().addAll(grid2);
            }

        EventComboBox1.setLayoutX(40);
        EventComboBox1.setLayoutY(245);
        EventComboBox1.setId("event");

        Pane group = new Pane(pane1, pane, pane2);
        group.setBackground(new Background(bgI));
        Scene scene = new Scene(group, 1000,650);
        stage.setScene(scene);
        stage.setTitle("Просмотр расписания");
        stage.setResizable(false);
        scene.getStylesheets().add(0, "ForSchedule.css");
        stage.show();

    }

    public static void shedForPrepod(){
        Stage stage = new Stage();
        BackgroundImage bgI;
        if (AccountForTeacher.scene.getStylesheets().contains("ForTeacherForm.css")){
            bgI = new BackgroundImage(new Image("BackForShedWithText.png",1000,650,false,true),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);}
        else {
            bgI = new BackgroundImage(new Image("SheduleBackGREY.png",1000,650,false,true),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);}
        FlowPane pane = new FlowPane(Orientation.HORIZONTAL, 25, 20);
        FlowPane pane2 = new FlowPane(Orientation.HORIZONTAL, 25, 20);
        pane.setLayoutX(250);
        pane.setLayoutY(110);
        pane2.setLayoutX(250);
        pane2.setLayoutY(415);



       StandartMenu.showMenu();

       Pane pane1;

        if (AccountForStudent.usertype<3) {
            pane1 = new Pane(pane, StandartMenu.btn1, StandartMenu.btn3, StandartMenu.btn5, StandartMenu.btn4,  StandartMenu.btn6,
                    StandartMenu.authorize, StandartMenu.eve, StandartMenu.ex, StandartMenu.shedl, StandartMenu.maps); }
        else
        {  pane1 = new Pane(pane, StandartMenu.btn1,  StandartMenu.btn5, StandartMenu.btn4,  StandartMenu.btn6, StandartMenu.btn7,
                StandartMenu.authorize, StandartMenu.eve, StandartMenu.ex, StandartMenu.shedl,  StandartMenu.reg_teach); }

        GridPane grid = new GridPane();
        grid.setLayoutX(50);
        grid.setLayoutY(150);
        grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(30));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));



        Text lbl1 = new Text("1");
        Text lbl2 = new Text("2");
        Text lbl3 = new Text("3");
        Text lbl4 = new Text("4");
        Text lbl5 = new Text("5");
        Text lbl6 = new Text("6");


        Text lbl11 = new Text("Понедельник");
        Text lbl21 = new Text("Вторник");
        Text lbl31 = new Text("Среда");
        Text lbl41 = new Text("Четверг");
        Text lbl51 = new Text("Пятница");




        grid.add(lbl1, 0, 1); //0-столбец 1-строка
        grid.add(lbl2, 0, 2);
        grid.add(lbl3, 0, 3);
        grid.add(lbl4, 0, 4);
        grid.add(lbl5, 0, 5);
        grid.add(lbl6, 0, 6);

        grid.add(lbl11, 1, 0);
        grid.add(lbl21, 2, 0); //0-столбец 1-строка
        grid.add(lbl31, 3, 0);
        grid.add(lbl41, 4, 0);
        grid.add(lbl51, 5, 0);

        grid.setHalignment(lbl1, HPos.CENTER);
        grid.setHalignment(lbl2, HPos.CENTER);
        grid.setHalignment(lbl3, HPos.CENTER);
        grid.setHalignment(lbl4, HPos.CENTER);
        grid.setHalignment(lbl5, HPos.CENTER);
        grid.setHalignment(lbl6, HPos.CENTER);

        grid.setHalignment(lbl11, HPos.CENTER);
        grid.setHalignment(lbl21, HPos.CENTER);
        grid.setHalignment(lbl31, HPos.CENTER);
        grid.setHalignment(lbl41, HPos.CENTER);
        grid.setHalignment(lbl51, HPos.CENTER);



        GridPane grid2 = new GridPane();
        grid2.setLayoutX(50);
        grid2.setLayoutY(150);

        grid2.setGridLinesVisible(true);
        grid2.getColumnConstraints().add(new ColumnConstraints(30));
        grid2.getColumnConstraints().add(new ColumnConstraints(130));
        grid2.getColumnConstraints().add(new ColumnConstraints(80));
        grid2.getColumnConstraints().add(new ColumnConstraints(130));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));

        Date date = new Date();
        String dat = String.valueOf(date);
        String[] words = dat.split(" ");
        Label fDay = new Label();
        fDay.setId("text");
        Label sDay = new Label();
        sDay.setId("text");

        grid2.setHalignment(fDay, HPos.CENTER);
        grid2.setHalignment(sDay, HPos.CENTER);

        switch (words[0]){
            case "Mon":{fDay.setText("Понедельник"); sDay.setText("Вторник");break;}
            case "Tue":{fDay.setText("Вторник"); sDay.setText("Среда");break;}
            case "Wed":{fDay.setText("Среда"); sDay.setText("Четверг");break;}
            case "Thu":{fDay.setText("Четверг"); sDay.setText("Пятница");break;}
            case "Fri":{fDay.setText("Пятница"); sDay.setText("Понедельник");break;}
            case "Sat":{fDay.setText("Выходной"); sDay.setText("Понедельник");break;}
            case "Sun":{fDay.setText("Выходной"); sDay.setText("Понедельник");break;}
            default:{ Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Эм... Походу считано неправильное время");
                alert.setContentText("Событие было отправлено следующим группам: ");
                alert.showAndWait();
            }
        }

        grid2.add(fDay, 1, 0);
        grid2.add(sDay, 3, 0);

        grid2.add(lbl1, 0, 1); //0-столбец 1-строка
        grid2.add(lbl2, 0, 2);
        grid2.add(lbl3, 0, 3);
        grid2.add(lbl4, 0, 4);
        grid2.add(lbl5, 0, 5);
        grid2.add(lbl6, 0, 6);

        EventComboBox1.setOnAction(event -> {
                switch (Schedule.EventComboBox1.getValue()) {
                case "1-ИС": Schedule.showSFP(grid, grid2, pane, pane2);break;        //Действия при выборе соответствующего эл-та списка
                case "1-СП": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "1-СА": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "2-ТМС": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "2-ТО": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "2-СА": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "3-ИС": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "3-ПСО1": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "3-ПСО2": Schedule.showSFP(grid, grid2, pane, pane2);break;
                case "4-ПР1": Schedule.showSFP(grid, grid2, pane, pane2);break;
            }
        });


        EventComboBox1.setLayoutX(750);
        EventComboBox1.setLayoutY(62);
        EventComboBox1.setId("event");


        Pane group = new Pane(pane1, pane, pane2, EventComboBox1);
        group.setBackground(new Background(bgI));
        Scene scene = new Scene(group, 1000,650);
        stage.setScene(scene);
        stage.setTitle("Просмотр расписания");
        stage.setResizable(false);
        scene.getStylesheets().add(0, "ForSchedule.css");
        stage.show();
    }


    public static void showSFP(GridPane grid, GridPane grid2, FlowPane pane, FlowPane pane2){
        //добавление текста с расписанием
        for (int i=0; i<30; i++) {
            Text text = new Text();
            showtxt[i] = text;
        }
        int p=0;

        for (int q=1; q<6; q++){
            for (int j=1; j<7; j++) {
                grid2.add(showtxt[p], q, j);
                grid.add(showtxt[p], q, j);
                p++;
            }
        }


        if (EventComboBox1.getValue()==null) {Menu.Alert15();}
        else {
            showScendule.showLessons();

            int k=0;

            for (int q=1; q<6; q++){
                for (int j=1; j<7; j++) {

                    grid.add(showtxt[k], q, j);
                    k++;
                }
            }
            pane.getChildren().clear();
            pane.getChildren().addAll(grid);

            showChanges.showChanges();

            int o=0;

            for (int j=1; j<7; j++) {

                grid2.add(showtxt2[o], 1, j);
                o++;
            }

            for (int j=1; j<7; j++) {

                grid2.add(showtxt2[o], 3, j);
                o++;
            }

            pane2.getChildren().clear();
            pane2.getChildren().addAll(grid2);
        }

    }


    public static void createSchedule(){
        Stage stage = new Stage();
        BackgroundImage bgI;
        if (AccountForSuperAdmin.scene.getStylesheets().contains("ForAdminForm.css")){
            bgI = new BackgroundImage(new Image("BackForShedWithText.png",1000,650,false,true),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);}
        else {
            bgI = new BackgroundImage(new Image("SheduleBackGREY.png",1000,650,false,true),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);}

        FlowPane pane = new FlowPane(Orientation.HORIZONTAL, 25, 20);

        FlowPane pane2 = new FlowPane(Orientation.HORIZONTAL, 25, 20);
        pane.setLayoutX(250);
        pane.setLayoutY(110);
        pane2.setLayoutX(250);
        pane2.setLayoutY(415);

        StandartMenu.showMenu();

        Pane pane1;


        if (AccountForStudent.usertype<3) {
            pane1 = new Pane(pane, StandartMenu.btn1, StandartMenu.btn3, StandartMenu.btn5, StandartMenu.btn4,  StandartMenu.btn6,
                    StandartMenu.authorize, StandartMenu.eve, StandartMenu.ex, StandartMenu.shedl, StandartMenu.maps); }
        else
        {  pane1 = new Pane(pane, StandartMenu.btn1,  StandartMenu.btn5, StandartMenu.btn4,  StandartMenu.btn6, StandartMenu.btn7,
                StandartMenu.authorize, StandartMenu.eve, StandartMenu.ex, StandartMenu.shedl,  StandartMenu.reg_teach); }


        GridPane grid = new GridPane();
        grid.setLayoutX(50);
        grid.setLayoutY(150);
        grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(30));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getColumnConstraints().add(new ColumnConstraints(130));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));


        Text lbl1 = new Text("1");
        Text lbl2 = new Text("2");
        Text lbl3 = new Text("3");
        Text lbl4 = new Text("4");
        Text lbl5 = new Text("5");
        Text lbl6 = new Text("6");
        Text lb1 = new Text("Понедельник");
        Text lb2 = new Text("Вторник");
        Text lb3 = new Text("Среда");
        Text lb4 = new Text("Четверг");
        Text lb5 = new Text("Пятница");


        grid.add(lb1, 1, 0);
        grid.add(lb2, 2, 0);
        grid.add(lb3, 3, 0);
        grid.add(lb4, 4, 0);
        grid.add(lb5, 5, 0);

        for (int i=0; i<30; i++) {
            TextField textField = new TextField();
            textField.setId("edit");
            txt[i] = textField;
        }
        int k=0;

        for (int q=1; q<6; q++){
            for (int j=1; j<7; j++) {
                grid.add(txt[k], q, j);
                k++;
            }
        }




        grid.setHalignment(lb1, HPos.CENTER);
        grid.setHalignment(lb2, HPos.CENTER);
        grid.setHalignment(lb3, HPos.CENTER);
        grid.setHalignment(lb4, HPos.CENTER);
        grid.setHalignment(lb5, HPos.CENTER);

        GridPane grid2 = new GridPane();

        grid2.setLayoutX(50);
        grid2.setLayoutY(350);

        grid2.setGridLinesVisible(true);
        grid2.getColumnConstraints().add(new ColumnConstraints(30));
        grid2.getColumnConstraints().add(new ColumnConstraints(130));
        grid2.getColumnConstraints().add(new ColumnConstraints(80));
        grid2.getColumnConstraints().add(new ColumnConstraints(130));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));
        grid2.getRowConstraints().add(new RowConstraints(25));

        for (int i=0; i<12; i++) {
            TextField textField = new TextField();
            textField.setId("edit");
            txt1[i] = textField;
        }
        int P=0;

        for (int q=1; q<4; q+=2){
            for (int j=1; j<7; j++) {
                grid2.add(txt1[P], q, j);
                P++;
            }
        }


        EventComboBox.setOnAction(event -> {

            showScendule.showLessonsAdmin();

            int s=0;

            for (int q=1; q<6; q++){
                for (int j=1; j<7; j++) {
                    txt[s].setId("edit");
                    grid.add(txt[s], q, j);
                    s++;
                }
            }



            pane.getChildren().clear();
            pane.getChildren().addAll(grid);

            showChanges.showChangesAdmin();

            int v=0;

            for (int q=1; q<4; q+=2){
                for (int j=1; j<7; j++) {
                    txt1[v].setId("edit");
                    grid2.add(txt1[v], q, j);
                    v++;
                }
            }




        });

        Date date = new Date();
        String dat = String.valueOf(date);
        String[] words = dat.split(" ");
        Label fDay = new Label();
        fDay.setId("text");
        Label sDay = new Label();
        sDay.setId("text");

        switch (words[0]){
            case "Mon":{fDay.setText("Понедельник"); sDay.setText("Вторник");break;}
            case "Tue":{fDay.setText("Вторник"); sDay.setText("Среда");break;}
            case "Wed":{fDay.setText("Среда"); sDay.setText("Четверг");break;}
            case "Thu":{fDay.setText("Четверг"); sDay.setText("Пятница");break;}
            case "Fri":{fDay.setText("Пятница"); sDay.setText("Понедельник");break;}
            case "Sat":{fDay.setText("Выходной"); sDay.setText("Понедельник");break;}
            case "Sun":{fDay.setText("Выходной"); sDay.setText("Понедельник");break;}
            default:{ Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Эм... Походу считано неправильное время");
                alert.setContentText("Событие было отправлено следующим группам: ");
                alert.showAndWait();
            }
        }

        grid2.add(fDay, 1, 0);
        grid2.add(sDay, 3, 0);

        grid2.setHalignment(fDay, HPos.CENTER);
        grid2.setHalignment(sDay, HPos.CENTER);

            pane.getChildren().clear();

            grid.add(lbl1, 0, 1); //0-столбец 1-строка
            grid.add(lbl2, 0, 2);
            grid.add(lbl3, 0, 3);
            grid.add(lbl4, 0, 4);
            grid.add(lbl5, 0, 5);
            grid.add(lbl6, 0, 6);

            pane.getChildren().addAll(grid);

            grid2.add(lbl1, 0, 1); //0-столбец 1-строка
            grid2.add(lbl2, 0, 2);
            grid2.add(lbl3, 0, 3);
            grid2.add(lbl4, 0, 4);
            grid2.add(lbl5, 0, 5);
            grid2.add(lbl6, 0, 6);

            grid2.setHalignment(lbl1, HPos.CENTER);
            grid2.setHalignment(lbl2, HPos.CENTER);
            grid2.setHalignment(lbl3, HPos.CENTER);
            grid2.setHalignment(lbl4, HPos.CENTER);
            grid2.setHalignment(lbl5, HPos.CENTER);
            grid2.setHalignment(lbl6, HPos.CENTER);


            pane2.getChildren().clear();
            pane2.getChildren().addAll(grid2);


        EventComboBox.setLayoutX(750);
        EventComboBox.setLayoutY(62);
        EventComboBox.setId("event");



        Button btn = new Button("Сохранить");
        btn.setId("btn");
        btn.setLayoutY(550);    // установка положения надписи по оси Y
        btn.setLayoutX(770);   // установка положения надписи по оси X

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addSchendule.addLessons(); //добавляем основное расписание
                addChanges.addChanges(); //добавляем изменения
                Menu.Alert14(); //уведомляем что всё круто
            }
        });


        Pane root = new Pane(pane2, pane,pane1, EventComboBox, btn);



        root.setBackground(new Background(bgI));
        Scene scene = new Scene(root, 1000, 650); //добавляем Grid в Scene
        scene.getStylesheets().add("ForSchedule.css"); //подключение CSS
        stage.setTitle("Внесение изменений в расписание");
        stage.setScene(scene); //добавляем scene в stage
        stage.setResizable(false);
        stage.show();

    }
}