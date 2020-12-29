import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Schedule {
    public static void Window () {
        Stage stage = new Stage();
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 0, 10);
        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton main_sched = new RadioButton("Основное расписание");
        RadioButton change_sched = new RadioButton("Изменения в расписании");

        main_sched.setToggleGroup(toggleGroup);
        change_sched.setToggleGroup(toggleGroup);

        GridPane grid = new GridPane();
        grid.setLayoutX(50);
        grid.setLayoutY(150);
        grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(200));

        Text lbl0 = new Text("День недели");
        Text lbl1 = new Text("1");
        Text lbl2 = new Text("2");
        Text lbl3 = new Text("3");
        Text lbl4 = new Text("4");
        Text lbl5 = new Text("5");
        Text lbl6 = new Text("6");

        GridPane grid2 = new GridPane();

        grid2.setLayoutX(50);
        grid2.setLayoutY(150);

        grid2.setGridLinesVisible(true);
        grid2.getColumnConstraints().add(new ColumnConstraints(100));
        grid2.getColumnConstraints().add(new ColumnConstraints(250));
        grid2.getColumnConstraints().add(new ColumnConstraints(50));
        grid2.getColumnConstraints().add(new ColumnConstraints(250));

        pane.getChildren().addAll(main_sched, change_sched);

        main_sched.setOnAction(event -> {
            grid.add(lbl0, 0, 0);
            grid.add(lbl1, 0, 1); //0-столбец 1-строка
            grid.add(lbl2, 0, 2);
            grid.add(lbl3, 0, 3);
            grid.add(lbl4, 0, 4);
            grid.add(lbl5, 0, 5);
            grid.add(lbl6, 0, 6);

            pane.getChildren().clear();
            pane.getChildren().addAll(main_sched, change_sched, grid);
        });
        change_sched.setOnAction(event -> {
            grid2.add(lbl0, 0, 0);
            grid2.add(lbl1, 0, 1); //0-столбец 1-строка
            grid2.add(lbl2, 0, 2);
            grid2.add(lbl3, 0, 3);
            grid2.add(lbl4, 0, 4);
            grid2.add(lbl5, 0, 5);
            grid2.add(lbl6, 0, 6);

            pane.getChildren().clear();
            pane.getChildren().addAll(main_sched, change_sched, grid2);
        });

        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(650);
        stage.show();
    }
}