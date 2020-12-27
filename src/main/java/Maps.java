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
        grid.setPadding(new Insets(130, 60, 30, 30));
        grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(800));
        grid.getRowConstraints().add(new RowConstraints(500));
        grid.getColumnConstraints().add(new ColumnConstraints(50));


        ToggleGroup group= new ToggleGroup();


        RadioButton first = new RadioButton("1");
        first.setToggleGroup(group);
        first.setId("floors");

        RadioButton second = new RadioButton("2");
        second.setToggleGroup(group);
        second.setId("floors");

        RadioButton third = new RadioButton("3");
        third.setToggleGroup(group);
        third.setId("floors");

        RadioButton fourth = new RadioButton("4");
        fourth.setToggleGroup(group);
        fourth.setId("floors");

        VBox floors = new VBox();
        floors.setAlignment(Pos.CENTER);
        floors.setSpacing(25);
        floors.getChildren().addAll(first, second, third, fourth);
        grid.add(floors, 1, 0);

        first.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(new ImageView("1этаж.jpeg"), floors);
        });


        second.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(new ImageView("2этаж.jpeg"), floors);
        });



        third.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(new ImageView("3этаж.jpeg"), floors);
        });


        fourth.setOnAction(event -> {
            grid.getChildren().clear();
            grid.getChildren().addAll(new ImageView("4этаж.jpeg"), floors);
        });



        Scene scene = new Scene(grid, 1000, 650); //добавляем Grid в Scene

        primaryStage.setScene(scene); //добавляем scene в stage
        primaryStage.setTitle("Карты");
        scene.getStylesheets().add(0, "ForMaps.css"); //подключение CSS
        primaryStage.show();

    }
}
