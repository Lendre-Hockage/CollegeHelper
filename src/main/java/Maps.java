import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Maps {
    private static Stage primaryStage = new Stage();

    public static void Map() {
        Pane pane = new Pane();


        Image av = new Image("LichKab.png");
        Button btn1 = new Button("", new ImageView(av));
        btn1.setId("buttons");
        btn1.setLayoutX(0);
        btn1.setLayoutY(20);
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                switch (AccountForStudent.usertype) {
                    case 1: AccountForStudent.WindowStudent(); break;
                    case 2: AccountForTeacher.WindowTeacher(); break;
                    case 3: AccountForSuperAdmin.WindowAdmin(); break;
                    default: Menu.Alert18();
                }

                primaryStage.hide();
            }
        });


        Image map = new Image("Map.png");
        Button btn3 = new Button("", new ImageView(map));
        btn3.setId("buttons");
        btn3.setLayoutX(0);
        btn3.setLayoutY(137);
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Maps.Map();
                primaryStage.hide();
            }
        });


        Image ev = new Image("Ev.png");
        Button btn4 = new Button("", new ImageView(ev));
        btn4.setId("buttons");
        btn4.setLayoutX(0);
        btn4.setLayoutY(254);
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AddEvent.delEv();
//                Events.Window();
//                primaryStage.hide();
                switch (AccountForStudent.usertype) {
                    case 1: Events.Window(); break;
                    case 2: Events.EventsForPrepAndSuperadm(); break;
                    case 3: Events.EventsForPrepAndSuperadm(); break;
                    default: Menu.Alert18();
                }

                primaryStage.hide();
            }
        });


        Image shed = new Image("Shed.png");
        Button btn5 = new Button("", new ImageView(shed));
        btn5.setId("buttons");
        btn5.setLayoutX(0);
        btn5.setLayoutY(371);
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                switch (AccountForStudent.usertype) {
                    case 1: Schedule.Window(); break;
                    case 2: Schedule.shedForPrepod(); break;
                    case 3: Schedule.createSchedule(); break;
                    default: Menu.Alert18();
                }

                primaryStage.hide();
            }
        });

        Image exit = new Image("Exit.png");
        Button btn6 = new Button("", new ImageView(exit));
        btn6.setId("buttons");
        btn6.setLayoutX(0);
        btn6.setLayoutY(538);
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Authorization.input();
                primaryStage.hide();
            }
        });

        Label ex = new Label("Выход");
        ex.setId("labels");
        ex.setLayoutX(65);
        ex.setLayoutY(599);


        Label authorize = new Label("Личный кабинет");
        authorize.setId("labels");
        authorize.setLayoutX(25);
        authorize.setLayoutY(83);

        Label maps = new Label("Карта корпусов");
        maps.setId("labels");
        maps.setLayoutX(30);
        maps.setLayoutY(197);

        Label eve = new Label("События");
        eve.setId("labels");
        eve.setLayoutX(53);
        eve.setLayoutY(315);

        Label shedl = new Label("Расписание");
        shedl.setId("labels");
        shedl.setLayoutX(40);
        shedl.setLayoutY(432);


///////////////КОРПУСА////////////////////////////
        Button newCorp = new Button("Новый корпус");
        newCorp.setId("floors");

        Button oldCorp = new Button("Старый корпус");
        oldCorp.setId("floors");

        Button jank1 = new Button("Общежитие мужское");
        jank1.setId("floors");

        Button jank2 = new Button("Общежитие женское");
        jank2.setId("floors");



//////////////////ЭТАЖИ НОВОГО КОРПУСА///////////////////////////
        Button firstN = new Button("1 этаж");
        firstN.setId("floor");

        Button secondN = new Button("2 этаж");
        secondN.setId("floor");

        Button thirdN = new Button("3 этаж");
        thirdN.setId("floor");

        Button fourthN = new Button("4 этаж");
        fourthN.setId("floor");



////////////////////ЭТАЖИ СТАРОГО КОРПУСА///////////////////////
        Button firstOld = new Button("1 этаж");
        firstOld.setId("floor");

        Button secondOld = new Button("2 этаж");
        secondOld.setId("floor");



////////////////////ЭТАЖИ МУЖСКОГО ОБЩЕЖИТИЯ///////////////////////
        Button firstJank1 = new Button ("1 этаж");
        firstJank1.setId("floor");

        Button secondJank1 = new Button ("2 этаж");
        secondJank1.setId("floor");

        Button thirdJank1 = new Button ("3 этаж");
        thirdJank1.setId("floor");

        Button fourthJank1 = new Button ("4 этаж");
        fourthJank1.setId("floor");



///////////////////////ЭТАЖИ ЖЕНСКОГО ОБЩЕЖИТИЯ//////////////////////
        Button firstJank2 = new Button ("1 этаж");
        firstJank2.setId("floor");

        Button secondJank2 = new Button ("2 этаж");
        secondJank2.setId("floor");

        Button thirdJank2 = new Button ("3 этаж");
        thirdJank2.setId("floor");

        Button fourthJank2 = new Button ("4 этаж");
        fourthJank2.setId("floor");

        Button fifthJank2 = new Button ("5 этаж");
        fifthJank2.setId("floor");




        VBox floorsN = new VBox();
        floorsN.setAlignment(Pos.CENTER);
        floorsN.setSpacing(25);
        floorsN.getChildren().addAll(firstN, secondN, thirdN, fourthN);


        VBox floorsOld = new VBox();
        floorsOld.setAlignment(Pos.CENTER);
        floorsOld.setSpacing(25);
        floorsOld.getChildren().addAll(firstOld, secondOld);



        VBox floorsJank1 = new VBox();
        floorsJank1.setAlignment(Pos.CENTER);
        floorsJank1.setSpacing(25);
        floorsJank1.getChildren().addAll(firstJank1, secondJank1, thirdJank1, fourthJank1);


        VBox floorsJank2 = new VBox();
        floorsJank2.setAlignment(Pos.CENTER);
        floorsJank2.setSpacing(25);
        floorsJank2.getChildren().addAll(firstJank2, secondJank2, thirdJank2, fourthJank2, fifthJank2);


        HBox corp = new HBox();
        corp.setAlignment(Pos.BASELINE_LEFT);
        corp.setSpacing(10);
        corp.getChildren().addAll(newCorp, oldCorp, jank1, jank2);
        pane.getChildren().addAll(corp);
        corp.setLayoutX(212);
        corp.setLayoutY(53);


///////////////////////////////////////////////////////////////////////////

        newCorp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsN);
                floorsN.setLayoutX(837);
                floorsN.setLayoutY(250);
                pane.getChildren().addAll(corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
            }
        });


        oldCorp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            pane.getChildren().clear();
            pane.getChildren().addAll(floorsOld);
            floorsOld.setLayoutX(837);
            floorsOld.setLayoutY(250);
            pane.getChildren().addAll(corp);
            }

        });


        jank1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsJank1, corp);
                floorsJank1.setLayoutX(837);
                floorsJank1.setLayoutY(250);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
            }
        });

        jank2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsJank2);
                floorsJank2.setLayoutX(837);
                floorsJank2.setLayoutY(250);
                pane.getChildren().addAll(corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
            }
        });

///////////////////////////////////////////////////////////////////////////

        firstN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsN, corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
                floorsN.setLayoutX(837);
                floorsN.setLayoutY(250);
                ImageView first_floor_new_corp = new ImageView("FirstFloorNewCorp.png");
                pane.getChildren().addAll(first_floor_new_corp);
                first_floor_new_corp.setLayoutX(213);
                first_floor_new_corp.setLayoutY(116);

            }
        });


        secondN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsN, corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
                floorsN.setLayoutX(837);
                floorsN.setLayoutY(250);
                ImageView second_floor_new_corp = new ImageView("FirstFloorNewCorp.png");
                pane.getChildren().addAll(second_floor_new_corp);
                second_floor_new_corp.setLayoutX(213);
                second_floor_new_corp.setLayoutY(116);

            }
        });



        thirdN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsN, corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
                floorsN.setLayoutX(837);
                floorsN.setLayoutY(250);
                ImageView third_floor_new_corp = new ImageView("FirstFloorNewCorp.png");
                pane.getChildren().addAll(third_floor_new_corp);
                third_floor_new_corp.setLayoutX(213);
                third_floor_new_corp.setLayoutY(116);
            }
        });


        fourthN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsN, corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
                floorsN.setLayoutX(837);
                floorsN.setLayoutY(250);
                ImageView fourth_floor_new_corp = new ImageView("FirstFloorNewCorp.png");
                pane.getChildren().addAll(fourth_floor_new_corp);
                fourth_floor_new_corp.setLayoutX(213);
                fourth_floor_new_corp.setLayoutY(116);
            }
        });

        ///////////////////////////////////////////////////////

        firstOld.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsOld, corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
                floorsOld.setLayoutX(837);
                floorsOld.setLayoutY(250);
                ImageView first_floor_old_corp = new ImageView("FirstFloorNewCorp.png");
                pane.getChildren().addAll(first_floor_old_corp);
                first_floor_old_corp.setLayoutX(213);
                first_floor_old_corp.setLayoutY(116);
            }
        });


        secondOld.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsOld, corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
                floorsOld.setLayoutX(837);
                floorsOld.setLayoutY(250);
                ImageView second_floor_old_corp = new ImageView("FirstFloorNewCorp.png");
                pane.getChildren().addAll(second_floor_old_corp);
                second_floor_old_corp.setLayoutX(213);
                second_floor_old_corp.setLayoutY(116);
            }
        });


        firstJank1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsJank1, corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
                floorsJank1.setLayoutX(837);
                floorsJank1.setLayoutY(250);
                ImageView first_floor_jank1 = new ImageView("FirstFloorNewCorp.png");
                pane.getChildren().addAll(first_floor_jank1);
                first_floor_jank1.setLayoutX(213);
                first_floor_jank1.setLayoutY(116);
            }
        });

        secondJank1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsJank1, corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
                floorsJank1.setLayoutX(837);
                floorsJank1.setLayoutY(250);
                ImageView second_floor_jank1 = new ImageView("FirstFloorNewCorp.png");
                pane.getChildren().addAll(second_floor_jank1);
                second_floor_jank1.setLayoutX(213);
                second_floor_jank1.setLayoutY(116);
            }
        });


        thirdJank1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsJank1, corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
                floorsJank1.setLayoutX(837);
                floorsJank1.setLayoutY(250);
                ImageView third_floor_jank1 = new ImageView("FirstFloorNewCorp.png");
                pane.getChildren().addAll(third_floor_jank1);
                third_floor_jank1.setLayoutX(213);
                third_floor_jank1.setLayoutY(116);
            }
        });


        fourthJank1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsJank1, corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
                floorsJank1.setLayoutX(837);
                floorsJank1.setLayoutY(250);
                ImageView fourth_floor_jank1 = new ImageView("FirstFloorNewCorp.png");
                pane.getChildren().addAll(fourth_floor_jank1);
                fourth_floor_jank1.setLayoutX(213);
                fourth_floor_jank1.setLayoutY(116);
            }
        });


        firstJank2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsJank2, corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
                floorsJank2.setLayoutX(837);
                floorsJank2.setLayoutY(250);
                ImageView first_floor_jank2 = new ImageView("FirstFloorNewCorp.png");
                pane.getChildren().addAll(first_floor_jank2);
                first_floor_jank2.setLayoutX(213);
                first_floor_jank2.setLayoutY(116);
            }
        });


        secondJank2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsJank2, corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
                floorsJank2.setLayoutX(837);
                floorsJank2.setLayoutY(250);
                ImageView second_floor_jank2 = new ImageView("FirstFloorNewCorp.png");
                pane.getChildren().addAll(second_floor_jank2);
                second_floor_jank2.setLayoutX(213);
                second_floor_jank2.setLayoutY(116);
            }
        });

        thirdJank2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsJank2, corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
                floorsJank2.setLayoutX(837);
                floorsJank2.setLayoutY(250);
                ImageView third_floor_jank2 = new ImageView("FirstFloorNewCorp.png");
                pane.getChildren().addAll(third_floor_jank2);
                third_floor_jank2.setLayoutX(213);
                third_floor_jank2.setLayoutY(116);
            }
        });

        fourthJank2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsJank2, corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
                floorsJank2.setLayoutX(837);
                floorsJank2.setLayoutY(250);
                ImageView fourth_floor_jank2 = new ImageView("FirstFloorNewCorp.png");
                pane.getChildren().addAll(fourth_floor_jank2);
                fourth_floor_jank2.setLayoutX(213);
                fourth_floor_jank2.setLayoutY(116);
            }
        });

        fifthJank2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(floorsJank2, corp);
//                corp.setLayoutX(220);
//                corp.setLayoutY(55);
                floorsJank2.setLayoutX(837);
                floorsJank2.setLayoutY(250);
                ImageView fifth_floor_jank2 = new ImageView("FirstFloorNewCorp.png");
                pane.getChildren().addAll(fifth_floor_jank2);
                fifth_floor_jank2.setLayoutX(213);
                fifth_floor_jank2.setLayoutY(116);
            }
        });


        Pane pane1 = new Pane(pane, btn1, btn3, btn4, btn5, btn6, ex, authorize, maps, eve, shedl);

        Scene scene = new Scene(pane1,1000, 650); //добавляем Grid в Scene

        primaryStage.setScene(scene); //добавляем scene в stage
        primaryStage.setTitle("Схемы этажей");
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\ThemeFolder\\theme.txt")))
        {
            String th = reader.readLine();

            if (th.equals("1")){
                scene.getStylesheets().add("ForMaps.css");
            }
            else {
                scene.getStylesheets().add("ForMapsGREY.css");
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        //scene.getStylesheets().add(0, "ForMaps.css"); //подключение CSS
        primaryStage.show();

    }
}
