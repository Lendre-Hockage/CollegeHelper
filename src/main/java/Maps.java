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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Maps {
    private static Stage primaryStage = new Stage();

    public static void Map() {
        GridPane grid = new GridPane();

        grid.setHgap(0);
        grid.setVgap(10);
        grid.setPadding(new Insets(130, 60, 30, 30));
        grid.setGridLinesVisible(true);


        Image inpstr = new Image("1этаж.jpeg");
        ImageView first_floor = new ImageView(new Image("1этаж.jpeg"));
        GridPane.setHalignment(first_floor, HPos.CENTER);
        GridPane.setValignment(first_floor, VPos.BOTTOM);
        grid.getChildren().add(first_floor);


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



        Scene scene = new Scene(grid, 1000, 650); //добавляем Grid в Scene

        primaryStage.setScene(scene); //добавляем scene в stage
        primaryStage.setTitle("Карты");
        scene.getStylesheets().add(0, "ForMaps.css"); //подключение CSS
        primaryStage.show();

    }
}
