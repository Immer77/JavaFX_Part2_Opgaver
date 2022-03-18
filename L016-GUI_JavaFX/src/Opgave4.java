import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Opgave4 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Boys");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    ListView<String> lvwBoys = new ListView<>();
    ArrayList<String> boys = new ArrayList<>();

    TextField txfName = new TextField();

    Button btnAdd = new Button("Add");

    private void initContent(GridPane pane) {

        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setVgap(20);
        pane.setHgap(20);

        Label lblList = new Label("Names: ");
        Label lblInput = new Label("Name: ");

        pane.add(lblList, 0, 0);
        pane.add(lblInput, 0, 2);
        pane.add(lvwBoys, 1, 0, 1, 2);
        lvwBoys.setPrefSize(100, 150);
        pane.add(txfName, 1, 2);
        pane.add(btnAdd, 2, 2);

        btnAdd.setOnAction(actionEvent -> addBoy());

    }

    private void addBoy() {
        String boy = txfName.getText().trim();

        boys.add(boy);
        lvwBoys.getItems().setAll(boys);
        txfName.clear();

    }
}
