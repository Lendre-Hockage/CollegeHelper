import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.nio.file.attribute.GroupPrincipal;

public class Changes {

    public static void Changes_today() {
        Stage stage = new Stage();

        Text nameTypeSched = new Text("Изменения в расписании на " /* + придумать как реализовать считывание текущего дня     */);
        nameTypeSched.setLayoutX(10);
        nameTypeSched.setLayoutY(10);

        GridPane grid1 = new GridPane();
        grid1.setGridLinesVisible(true);
        grid1.getColumnConstraints().add(new ColumnConstraints(150));
        grid1.getColumnConstraints().add(new ColumnConstraints(200));
        grid1.getColumnConstraints().add(new ColumnConstraints(200));
        grid1.getColumnConstraints().add(new ColumnConstraints(200));
        grid1.getColumnConstraints().add(new ColumnConstraints(200));

        Text lbl0 = new Text(/* Придумать считывание сегодняшнего дня */);
        Text lbl1 = new Text("1");
        Text lbl2 = new Text("2");
        Text lbl3 = new Text("3");
        Text lbl4 = new Text("4");
        Text lbl5 = new Text("5");
        Text lbl6 = new Text("6");

        grid1.add(lbl0, 0, 0);
        grid1.add(lbl1, 0, 1); //0-столбец 1-строка
        grid1.add(lbl2, 0, 2);
        grid1.add(lbl3, 0, 3);
        grid1.add(lbl4, 0, 4);
        grid1.add(lbl5, 0, 5);
        grid1.add(lbl6, 0, 6);

        Text nameTypeSched1 = new Text("Изменения в расписании на " /* + придумать как реализовать считывание следующего дня     */);
        nameTypeSched.setLayoutX(10);
        nameTypeSched.setLayoutY(10);

        GridPane grid2 = new GridPane();
        grid2.setGridLinesVisible(true);
        grid2.getColumnConstraints().add(new ColumnConstraints(150));
        grid2.getColumnConstraints().add(new ColumnConstraints(200));
        grid2.getColumnConstraints().add(new ColumnConstraints(200));
        grid2.getColumnConstraints().add(new ColumnConstraints(200));
        grid2.getColumnConstraints().add(new ColumnConstraints(200));

        Text lb0 = new Text(/* Придумать считывание завтрашнего дня */);
        Text lb1 = new Text("1");
        Text lb2 = new Text("2");
        Text lb3 = new Text("3");
        Text lb4 = new Text("4");
        Text lb5 = new Text("5");
        Text lb6 = new Text("6");

        grid2.add(lb0, 0, 0);
        grid2.add(lb1, 0, 1); //0-столбец 1-строка
        grid2.add(lb2, 0, 2);
        grid2.add(lb3, 0, 3);
        grid2.add(lb4, 0, 4);
        grid2.add(lb5, 0, 5);
        grid2.add(lb6, 0, 6);

        Group group = new Group(grid1, grid2);
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(650);
        stage.show();
    }
}
