import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class StandartMenu {

    public static Button  btn1, btn3, btn4, btn5, btn6, btn7;
    public static Label authorize, maps, eve, shedl, ex, reg_teach;

    public static void showMenu() {

        if (AccountForStudent.usertype<3) { //если это аккаунт учителя или студента,
            //то загружаем меню студента

        Image av = new Image("LichKab.png");
      btn1 = new Button("", new ImageView(av));
        btn1.setId("buttons");
        btn1.setLayoutX(0);
        btn1.setLayoutY(20);
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Schedule.stage.close();
                Events.stage.close();
                Maps.primaryStage.close();


                if (AccountForStudent.usertype==1)
                AccountForStudent.WindowStudent();
                else AccountForTeacher.WindowTeacher();

            }
        });


        Image map = new Image("Map.png");
        btn3 = new Button("", new ImageView(map));
        btn3.setId("buttons");
        btn3.setLayoutX(0);
        btn3.setLayoutY(137);
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Maps.Map();
                Events.stage.hide();
                Schedule.stage.hide();
                if (AccountForStudent.usertype==1)
                AccountForStudent.primaryStage.hide();
                else AccountForTeacher.primaryStage.hide();
            }
        });


        Image ev = new Image("Ev.png");
       btn4 = new Button("", new ImageView(ev));
        btn4.setId("buttons");
        btn4.setLayoutX(0);
        btn4.setLayoutY(254);
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AddEvent.delEv();
                Events.Window();
                Schedule.stage.hide();
                Maps.primaryStage.hide();
                if (AccountForStudent.usertype==1)
                    AccountForStudent.primaryStage.hide();
                else AccountForTeacher.primaryStage.hide();
            }
        });


        Image shed = new Image("Shed.png");
        btn5 = new Button("", new ImageView(shed));
        btn5.setId("buttons");
        btn5.setLayoutX(0);
        btn5.setLayoutY(371);
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            Events.stage.hide();
            Maps.primaryStage.hide();
                if (AccountForStudent.usertype==1)
                {  Schedule.Window();
                    AccountForStudent.primaryStage.hide(); }
                else {Schedule.shedForPrepod();
                    AccountForTeacher.primaryStage.hide(); }
            }
        });

        Image exit = new Image("Exit.png");
        btn6 = new Button("", new ImageView(exit));
        btn6.setId("buttons");
        btn6.setLayoutX(0);
        btn6.setLayoutY(538);
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Authorization.input();
                if (AccountForStudent.usertype==1)
                    AccountForStudent.primaryStage.hide();
                else AccountForTeacher.primaryStage.hide();
            }
        });

        ex = new Label("Выход");
        ex.setId("labels");
        ex.setLayoutX(65);
        ex.setLayoutY(599);


        authorize = new Label("Личный кабинет");
        authorize.setId("labels");
        authorize.setLayoutX(25);
        authorize.setLayoutY(83);

        maps = new Label("Карта корпусов");
        maps.setId("labels");
        maps.setLayoutX(30);
        maps.setLayoutY(197);

        eve = new Label("События");
        eve.setId("labels");
        eve.setLayoutX(53);
        eve.setLayoutY(315);

        shedl = new Label("Расписание");
        shedl.setId("labels");
        shedl.setLayoutX(40);
        shedl.setLayoutY(432);



    }
    else // если аккаунт суперадмина, загружаем меню суперадмина

    {
        Image av = new Image("LichKab.png");
        btn1 = new Button("", new ImageView(av));
        btn1.setId("buttons");
        btn1.setLayoutX(0);
        btn1.setLayoutY(20);
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Schedule.stage.hide();
                Events.stage.hide();
                RegistTeacher.primaryStage.hide();

                AccountForSuperAdmin.WindowAdmin();



            }
        });



        Image ev = new Image("Ev.png");
        btn4 = new Button("", new ImageView(ev));
        btn4.setId("buttons");
        btn4.setLayoutX(0);
        btn4.setLayoutY(140);
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AddEvent.delEv();
                Schedule.stage.hide();
                RegistTeacher.primaryStage.hide();
                Events.EventsForPrepAndSuperadm();
                AccountForSuperAdmin.primaryStage.hide();

            }
        });


        Image shed = new Image("Shed.png");
        btn5 = new Button("", new ImageView(shed));
        btn5.setId("buttons");
        btn5.setLayoutX(0);
        btn5.setLayoutY(260);
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Schedule.createSchedule();
                Events.stage.hide();
                RegistTeacher.primaryStage.hide();
                AccountForSuperAdmin.primaryStage.hide();
            }
        });

        Image reg_t = new Image("Reg.png");
        btn7 = new Button("", new ImageView(reg_t));
        btn7.setId("buttons");
        btn7.setLayoutX(0);
        btn7.setLayoutY(380);
        btn7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                RegistTeacher.RegistT();
                Schedule.stage.hide();
                Events.stage.hide();
                AccountForSuperAdmin.primaryStage.hide();
            }
        });

        Image exit = new Image("Exit.png");
        btn6 = new Button("", new ImageView(exit));
        btn6.setId("buttons");
        btn6.setLayoutX(0);
        btn6.setLayoutY(537);
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Authorization.input();
                Schedule.stage.close();
                Events.stage.close();
                RegistTeacher.primaryStage.close();
                AccountForSuperAdmin.primaryStage.close();
            }
        });




        authorize = new Label("Личный кабинет");
        authorize.setId("labels");
        authorize.setLayoutX(25);
        authorize.setLayoutY(83);


        eve = new Label("Редакировать\n    события");
        eve.setId("labels");
        eve.setLayoutX(37);
        eve.setLayoutY(203);

        shedl = new Label("Редакировать\n расписание");
        shedl.setId("labels");
        shedl.setLayoutX(35);
        shedl.setLayoutY(323);

        reg_teach = new Label("  Регистрация\nпреподавателя");
        reg_teach.setId("labels");
        reg_teach.setLayoutX(30);
        reg_teach.setLayoutY(443);

        ex = new Label("Выход");
        ex.setId("labels");
        ex.setLayoutX(65);
        ex.setLayoutY(600);

    }
} }
