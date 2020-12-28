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

        grid.setHgap(0);
        grid.setVgap(10);
        grid.setPadding(new Insets(130, 30, 30, 30));
        grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(800));
        grid.getRowConstraints().add(new RowConstraints(10));
        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(500));

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
        corp.setAlignment(Pos.CENTER);
        corp.setSpacing(25);
        corp.getChildren().addAll(newCorp, oldCorp, jank1, jank2);
        grid.add(corp, 0, 0);

///////////////////////////////////////////////////////////////////////////

        newCorp.setOnAction(event -> {
            grid.getChildren().clear();
            grid.add(floorsN, 1, 1);
            grid.getChildren().addAll(corp);
        });

        oldCorp.setOnAction(event -> {
            grid.getChildren().clear();
            grid.add(floorsOld, 1, 1);
            grid.getChildren().addAll(corp);
        });

        jank1.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll( corp);
            grid.add(new ImageView("1этаж.jpeg"), 0, 1);
        });

        jank2.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(corp);
            grid.add(new ImageView("4этаж.jpeg"), 0, 1);
        });

///////////////////////////////////////////////////////////////////////////

        firstN.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(floorsN, corp);
            grid.add(new ImageView("1этаж.jpeg"), 0, 1);

        });


        secondN.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(floorsN, corp);
            grid.add(new ImageView("2этаж.jpeg"), 0, 1);
        });



        thirdN.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(floorsN, corp);
            grid.add(new ImageView("3этаж.jpeg"), 0, 1);
        });


        fourthN.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(floorsN, corp);
            grid.add(new ImageView("4этаж.jpeg"), 0, 1);
        });

         ///////////////////////////////////////////////////////

        firstOld.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(floorsOld, corp);
            grid.add(new ImageView("1этаж.jpeg"), 0, 1);
        });


        secondOld.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(floorsOld, corp);
            grid.add(new ImageView("2этаж.jpeg"), 0, 1);
        });


        Scene scene = new Scene(grid, 1000, 800); //добавляем Grid в Scene

        primaryStage.setScene(scene); //добавляем scene в stage
        primaryStage.setTitle("Схемы этажей");
        scene.getStylesheets().add(0, "ForMaps.css"); //подключение CSS
        primaryStage.show();

    }
}
