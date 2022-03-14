package opgave5_javaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Boys and Girls");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }
    // Felt variabler der har labels og tekstfelter
    private final TextField txfName = new TextField();
    private final Label lblName = new Label("Name:");
    private final Label lblNames = new Label("Names:");

    // Vores 2 arraylists der indeholder drenge og pigenavne samt vores listview
    private final ArrayList<String> boysNames = new ArrayList<>();
    private final ArrayList<String> girlsNames = new ArrayList<>();
    private final ListView<String> lvwNames = new ListView<>();

    // Add knap der tilføjer til listview
    private final Button btnAdd = new Button("Add");

    // Med vores radiobuttons skal der være en gruppe de hører ind under
    private final ToggleGroup group = new ToggleGroup();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);
        //Opretter en horisontal box som der kan komme radiobuttions i
        HBox box = new HBox();
        pane.add(box,0,0);

        // Opretter det antal radiobuttons som der er i vores String array
        String[] genders = {"Boys", "Girls"};
        // Enhanced for loop som opretter en radiobutton og sætter det ind i hbox
        for (String gender : genders) {
            RadioButton rb = new RadioButton();
            box.getChildren().add(rb);
            rb.setText(gender);
            rb.setToggleGroup(group);
        }


        pane.add(lblNames,0,1);
        pane.add(lvwNames,1,1,4,4);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);
        lvwNames.getItems().setAll(boysNames);

        pane.add(lblName,0,5);
        pane.add(txfName,1,5,3,1);
        pane.add(btnAdd,4,5);

        btnAdd.setOnAction(event -> addName());

    }

    /**
     * Tilføjer et navn til listview alt efter hvad der er valgt af radiobuttonn
     */
    public void addName(){
        String name = txfName.getText().trim();
        RadioButton rb = (RadioButton) group.getSelectedToggle();

        // Hvis radiobutton indeholder et drengenavn:
        if(rb.getText().equalsIgnoreCase("Boys")){
            if(name.length() > 0){
                boysNames.add(name);
                lvwNames.getItems().setAll(boysNames);
                txfName.clear();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Missing input");
                alert.setHeaderText("Can't add blank");
                alert.show();
            }
        }
        //Hvis den indeholder et pigenavn
        else{
            if(name.length() > 0){
                girlsNames.add(name);
                lvwNames.getItems().setAll(girlsNames);
                txfName.clear();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Missing input");
                alert.setHeaderText("Can't add blank");
                alert.show();
            }
        }
    }
}
