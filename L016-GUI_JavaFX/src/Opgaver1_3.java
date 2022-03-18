import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Opgaver1_3 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Person administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        personInputWindow = new PersonInputWindow("Person administration", stage);
    }

    PersonInputWindow personInputWindow;


    TextField txfName = new TextField();
    TextField txfTitle = new TextField();

    CheckBox chkSenior = new CheckBox();

    ListView<String> lvwPersons = new ListView<>();
    ArrayList<String> names = new ArrayList<>();

    Button btnAddPerson = new Button("Add Person");

    private void initContent(GridPane pane) {

        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setVgap(20);
        pane.setHgap(30);


        /**
         * Først lav labels der skal bruges i programmet
         */
//        Label lblName = new Label("Name: ");
//        pane.add(lblName, 0, 0);
//        Label lblTitle = new Label("Title: ");
//        pane.add(lblTitle, 0, 1);
//        Label lblPersons = new Label("Persons: ");
//        pane.add(lblPersons, 0, 3);
//
//        Label lblSenior = new Label("Senior");
//        pane.add(lblSenior, 1, 2);
//
//        GridPane.setMargin(lblSenior, new Insets(0, 0, 0, 20));
        /**
         * Derefter tilføj mere funktionelle elementer
         */
//        pane.add(txfName, 1, 0);
//
//        pane.add(txfTitle, 1, 1);
//
//        pane.add(chkSenior, 1, 2);

        pane.add(lvwPersons, 0, 0, 1, 3);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(300);

        pane.add(btnAddPerson, 1, 1);

        lvwPersons.getItems().setAll(this.initNames());

        btnAddPerson.setOnAction(actionEvent -> createPerson());


    }

    private ArrayList<String> initNames() {
        names.add("Underviser Hans Madsen");
        names.add("Doctor Jan Peterson");
        names.add("Mekaniker Pia Madsen");
        names.add("Landmand Søren Sørensen");
        names.add("Politimand Birgitte Jensen");

        return names;
    }

    private void createPerson() {

        personInputWindow.showAndWait();

        if(personInputWindow.getPerson() != null) {
            Person person = personInputWindow.getPerson();

            names.add(person.toString());
            lvwPersons.getItems().setAll(names);
        }
    }
}
