package opgave4_JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Boys");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }
    private final TextField txfName = new TextField();
    private final Label lblName = new Label("Name:");
    private final Label lblNames = new Label("Names:");

    private final ArrayList<String> boysNames = new ArrayList<>();
    private final ListView<String> lvwboysNames = new ListView<>();

    private final Button btnAdd = new Button("Add");

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);

        pane.add(lblNames,0,1);
        pane.add(lvwboysNames,1,1,4,4);
        lvwboysNames.setPrefWidth(200);
        lvwboysNames.setPrefHeight(200);
        lvwboysNames.getItems().setAll(boysNames);

        pane.add(lblName,0,5);
        pane.add(txfName,1,5,3,1);
        pane.add(btnAdd,4,5);

        btnAdd.setOnAction(event -> addName());

    }
    public void addName(){
        String name = txfName.getText().trim();

        if(name.length() > 0){
            boysNames.add(name);
            lvwboysNames.getItems().setAll(boysNames);
            txfName.clear();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing input");
            alert.setHeaderText("Can't add blank");
            alert.show();
        }
    }
}
