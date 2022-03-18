import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Opgave5 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Boys");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    ArrayList<String> boys = new ArrayList<>();
    ArrayList<String> girls = new ArrayList<>();
    ListView<String> lvwNames = new ListView<>();

    TextField txfName = new TextField();

    Button btnAdd = new Button("Add");

    ToggleGroup group = new ToggleGroup();


    private void initContent(GridPane pane) {

//        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setVgap(20);
        pane.setHgap(20);

        // Tilføj navne til de 2 lister boys og girls
        initNames();

        // Sæt default listen til at være boys
//        lvwNames.getItems().addAll(boys);

        // Lav en array der indeholder de 2 lister
        ArrayList[] userData = {boys, girls};

        // lav en box der skal indeholde de 2 radiobuttons
        HBox box = new HBox();
        pane.add(box, 1, 0);
        box.setSpacing(50);

        /**
         * Lav et for-loop til at håndtere hvilken data de 2 radio buttons skal indeholde
         *
         * Først: lav en array med navnene til de 2 buttons
         *
         * Inde i loopet: Opret en radiobutton
         * tilføj radiobutton til box
         * giv radiobutton et navn, navnet kommer arrayet genderStrings
         *
         * Giv radiobutton data, dataen hentes fra en array (userData), der indeholder de 2 lister boys og girls
         *
         * Tilføj radiobutton til gruppen af radiobuttons
         * Giv radiobutton en metode der kaldes hvergang den bliver valg
         *
         */

        String[] genderStrings = {"Boy", "Girl"};
        for (int i = 0; i < genderStrings.length; i++) {
            RadioButton rb = new RadioButton();
            box.getChildren().add(rb);
            rb.setText(genderStrings[i]);

            rb.setUserData(userData[i]);

            rb.setToggleGroup(group);
            rb.setOnAction(actionEvent -> setGender());
        }

        // giv variabler til radiobuttons
        // sæt en default selected
//        RadioButton rbBoy = (RadioButton) group.getToggles().get(0);
//        RadioButton rbGirl = (RadioButton) group.getToggles().get(1);
//        rbBoy.setSelected(true);

        Label lblList = new Label("Names: ");
        Label lblInput = new Label("Name: ");

        pane.add(lblList, 0, 1);
        pane.add(lblInput, 0, 3);
        pane.add(lvwNames, 1, 1, 1, 2);
        lvwNames.setPrefSize(100, 150);
        pane.add(txfName, 1, 3);
        pane.add(btnAdd, 2, 3);

        btnAdd.setOnAction(actionEvent -> addName());

    }

    private void initNames() {
        boys.add("Martin");
        boys.add("Jan");
        boys.add("Bent");
        boys.add("Niels");
        boys.add("Thor");
        boys.add("Peter");
        boys.add("Finn");
        boys.add("Thomas");

        girls.add("Pia");
        girls.add("Camilla");
        girls.add("Sofie");
        girls.add("Jane");
        girls.add("Alberte");
    }

    private void setGender() {
        //Opret en radiobutton ud fra hvilken der selected
        RadioButton rb = (RadioButton) group.getSelectedToggle();

//        if (rb.getText().equalsIgnoreCase("boy")) {
//
//            lvwNames.getItems().setAll(boys);
//
//        } else if (rb.getText().equalsIgnoreCase("girl")) {
//
//            lvwNames.getItems().setAll(girls);
//        }

        lvwNames.getItems().setAll((List) rb.getUserData());

//        ArrayList<String> gender = (ArrayList) rb.getUserData();
//        lvwNames.getItems().setAll(gender);
    }

    private void addName() {
        RadioButton rb = (RadioButton) group.getSelectedToggle();

        String name = txfName.getText().trim();
        lvwNames.getItems().add(name);
        txfName.clear();

//        if (rb.getText().equalsIgnoreCase("Boy")){
//
//            String boy = txfName.getText().trim();
//
//            boys.add(boy);
//            lvwNames.getItems().setAll(boys);
//            txfName.clear();
//        } else if (rb.getText().equalsIgnoreCase("Girl")) {
//
//            String girl = txfName.getText().trim();
//
//            girls.add(girl);
//            lvwNames.getItems().setAll(girls);
//            txfName.clear();
//        }
    }
}
