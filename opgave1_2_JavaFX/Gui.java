package opgave1_2_JavaFX;

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
        stage.setTitle("Person Administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    //Opretter Alle field variables såsom Textfelter, Labels og Checkbox
    private final Label lblName = new Label("Name");
    private final Label lblPersons = new Label("Persons");
    private final TextField txfName = new TextField();
    private final Label lblTitle = new Label("Title");
    private final TextField txfTitle = new TextField();
    private final Label lblSenior = new Label("Senior");
    private final CheckBox chckSenior = new CheckBox();

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
        pane.add(lblName, 0, 0);
        pane.add(lblTitle, 0, 1);
        pane.add(lblSenior, 0, 2);
        pane.add(lblPersons, 0, 3);

        //Tilføjer tekstfelter og checkbox
        pane.add(txfName, 1, 0);
        pane.add(txfTitle, 1, 1);
        pane.add(chckSenior, 1, 2);

        //Tilføjer og konfiguerer listview
        pane.add(lwvPersons, 1, 3, 3, 6);
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
        //Tjekker hvis der mangler input fra brugeren
        if(txfName.getText().isEmpty() || txfTitle.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing name or title");
            alert.setHeaderText("No named Typed");
            alert.setContentText("Type the name of the person");
            alert.show();
        } else{
            // hvis/når begge felter er udfyldt vil der så bliver oprettet en person
            String name = txfName.getText().trim();
            if (name.length() > 0 && chckSenior.isSelected()) {
                Person person = new Person(name, txfTitle.getText(), true);
                persons.add(person);
                lwvPersons.getItems().setAll(persons);
            } else {
                Person person = new Person(name, txfTitle.getText());
                persons.add(person);
                lwvPersons.getItems().setAll(persons);
            }
            clearFields();
        }
    }

    // Metode til at efter der er blevet added en person så ryder den alle felterne
    public void clearFields() {
        txfTitle.clear();
        txfName.clear();
        chckSenior.setSelected(false);
    }

    public void fillAction() {

    }
}
