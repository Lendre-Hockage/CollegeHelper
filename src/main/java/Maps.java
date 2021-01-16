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



public class Maps {
    private static Stage primaryStage = new Stage();

    public static void Map() {
        GridPane grid = new GridPane();

        grid.setPadding(new Insets(115, 30, 35, 35));
       // grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.getColumnConstraints().add(new ColumnConstraints(700));
        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(75));
        grid.getRowConstraints().add(new RowConstraints(8));
        grid.getRowConstraints().add(new RowConstraints(30));
        grid.getRowConstraints().add(new RowConstraints(380));


        Label mp = new Label("Карты зданий");
        mp.setId("welcome-text");   //для CSS
        grid.add(mp, 1, 0);

        ToggleGroup group= new ToggleGroup();

        RadioButton newCorp = new RadioButton("Новый корпус");
        newCorp.setToggleGroup(group);
        newCorp.setId("floors");

        RadioButton oldCorp = new RadioButton("Старый корпус");
        oldCorp.setToggleGroup(group);
        oldCorp.setId("floors");

        RadioButton jank1 = new RadioButton("Общежитие мужское");
        jank1.setToggleGroup(group);
        jank1.setId("floors");

        RadioButton jank2 = new RadioButton("Общежитие женское");
        jank2.setToggleGroup(group);
        jank2.setId("floors");



        RadioButton firstN = new RadioButton("1 этаж");
        firstN.setToggleGroup(group);
        firstN.setId("floors");

        RadioButton secondN = new RadioButton("2 этаж");
        secondN.setToggleGroup(group);
        secondN.setId("floors");

        RadioButton thirdN = new RadioButton("3 этаж");
        thirdN.setToggleGroup(group);
        thirdN.setId("floors");

        RadioButton fourthN = new RadioButton("4 этаж");
        fourthN.setToggleGroup(group);
        fourthN.setId("floors");

        RadioButton firstOld = new RadioButton("1 этаж");
        firstOld.setToggleGroup(group);
        firstOld.setId("floors");

        RadioButton secondOld = new RadioButton("2 этаж");
        secondOld.setToggleGroup(group);
        secondOld.setId("floors");

        VBox floorsN = new VBox();
        floorsN.setAlignment(Pos.CENTER);
        floorsN.setSpacing(25);
        floorsN.getChildren().addAll(firstN, secondN, thirdN, fourthN);
//        grid.add(floorsN, 1, 0);

        VBox floorsOld = new VBox();
        floorsOld.setAlignment(Pos.CENTER);
        floorsOld.setSpacing(25);
        floorsOld.getChildren().addAll(firstOld, secondOld);
//        grid.add(floorsOld, 1, 0);

        HBox corp = new HBox();
        corp.setAlignment(Pos.BASELINE_LEFT);
        corp.setSpacing(25);
        corp.getChildren().addAll(newCorp, oldCorp, jank1, jank2);
        grid.add(corp, 1, 2);

        //КНОПУЛЕЧКА "←"
        Button left = new Button("←");
        HBox box_for_arrow = new HBox(100); //поместить в контейнер HBox, но это больше для удобства
        left.setId("buttons");
        box_for_arrow.setAlignment(Pos.BOTTOM_LEFT);
        box_for_arrow.getChildren().add(left);
        grid.add(box_for_arrow, 0, 3);
        left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
///////////////////////////////////////////////////////////////////////////

        newCorp.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(mp, box_for_arrow);
            grid.add(floorsN, 2, 3);
            grid.getChildren().addAll(corp);
        });

        oldCorp.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(mp, box_for_arrow);
            grid.add(floorsOld, 2, 3);
            grid.getChildren().addAll(corp);
        });

        jank1.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(mp, box_for_arrow);
            grid.getChildren().addAll( corp);
            grid.add(new ImageView("1этаж.png"), 1, 3);
        });

        jank2.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(mp, box_for_arrow);
            grid.getChildren().addAll(corp);
            grid.add(new ImageView("4этаж.png"), 1, 3);
        });

///////////////////////////////////////////////////////////////////////////

        firstN.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(mp, box_for_arrow);
            grid.getChildren().addAll(floorsN, corp);
            grid.add(new ImageView("1этаж.png"), 1, 3);

        });


        secondN.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(mp, box_for_arrow);
            grid.getChildren().addAll(floorsN, corp);
            grid.add(new ImageView("2этаж.png"), 1, 3);
        });



        thirdN.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(mp, box_for_arrow);
            grid.getChildren().addAll(floorsN, corp);
            grid.add(new ImageView("3этаж.png"), 1, 3);
        });


        fourthN.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(mp, box_for_arrow);
            grid.getChildren().addAll(floorsN, corp);
            grid.add(new ImageView("4этаж.png"), 1, 3);
        });

        ///////////////////////////////////////////////////////

        firstOld.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(mp, box_for_arrow);
            grid.getChildren().addAll(floorsOld, corp);
            grid.add(new ImageView("1этаж.png"), 1, 3);
        });


        secondOld.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(mp, box_for_arrow);
            grid.getChildren().addAll(floorsOld, corp);
            grid.add(new ImageView("2этаж.png"), 1, 3);
        });



        Scene scene = new Scene(grid, 1000, 650); //добавляем Grid в Scene

        primaryStage.setScene(scene); //добавляем scene в stage
        primaryStage.setTitle("Схемы этажей");
        scene.getStylesheets().add(0, "ForMaps.css"); //подключение CSS
        primaryStage.show();

    }
}