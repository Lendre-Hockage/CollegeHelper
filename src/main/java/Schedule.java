import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Date; //

public class Schedule {
    public static void Main_Schedule () {
        Stage stage = new Stage();

        Date date = new Date();             //
        System.out.println(date);           //


        Text nameTypeSched = new Text("Основное расписание");
        nameTypeSched.setLayoutX(10);
        nameTypeSched.setLayoutY(10);

        GridPane grid = new GridPane();
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

        grid.add(lbl0, 0, 0);
        grid.add(lbl1, 0, 1); //0-столбец 1-строка
        grid.add(lbl2, 0, 2);
        grid.add(lbl3, 0, 3);
        grid.add(lbl4, 0, 4);
        grid.add(lbl5, 0, 5);
        grid.add(lbl6, 0, 6);



        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(650);
        stage.show();
    }
}
