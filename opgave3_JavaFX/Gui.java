package opgave3_JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

public class Gui extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Person Administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        //Seperat klasse hvor vi får et nyt window pop-up
        personWindow = new PersonInputWindow("Enter Credentials",stage);
    }


    //Opretter vores Windows pop up som vi har lavet en klasse til
    private PersonInputWindow personWindow;
    private Label lblPersons = new Label("Persons");
    // Her opretter vi vores listview, den skal have en Arraylist så vi kan have en masse elementer inde i listview
    private final ListView<Person> lwvPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();

    // Her tilføjes knapperne
    private final Button btnAdd = new Button("Add Person");

    //Initialerisering af pane
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        //Tilføjer Labels
        pane.add(lblPersons, 0, 3);

        //Tilføjer og konfiguerer listview
        pane.add(lwvPersons, 1, 0, 3, 6);
        lwvPersons.setPrefHeight(200);
        lwvPersons.setPrefWidth(200);
        //Her tager den arraylist inputtet og smider i sit listview
        lwvPersons.getItems().setAll(persons);

        //Knappen der tilføjer en person
        pane.add(btnAdd, 6, 0);
        btnAdd.setOnAction(event -> this.addPerson());

    }

    // Metode til at tilføje person
    public void addPerson() {
        //Vi viser vinduet og afventer brugen enten trykker ok eller cancel
        personWindow.showAndWait();

        //Hvis den person objekt indeholder ikke indeholder null værdi vil vi tilføje personen til vores listview
        if(personWindow.getPerson() != null){
            Person person = personWindow.getPerson();
            persons.add(person);
            lwvPersons.getItems().setAll(persons);
        }

    }
}
