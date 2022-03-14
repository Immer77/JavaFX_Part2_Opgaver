package opgave3_JavaFX;

import guidemoes2.demoopenwindow.Movie;
import guidemoes2.demoopenwindow.MovieInputWindow;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

public class PersonInputWindow extends Stage {

    public PersonInputWindow(String title, Stage owner) {
        // Spørg Esben om nedenstående
        // Vi har her en seperat stage som er det vindue der popper op når vi vil lave en ny person.
        this.initOwner(owner);
        // Viser hvilken style det skal køres med (Skal gøres inden det bliver vist)
        this.initStyle(StageStyle.UTILITY);

        this.initModality(Modality.APPLICATION_MODAL);
        // Sætter størrelsen på vinduet
        this.setMinHeight(200);
        this.setMinWidth(200);
        // Kan ikke ændres i størrelse
        this.setResizable(false);

        //Sætter titlen til det vi har fået ind fra constructoren her er det "Enter Credentials"
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // De 2 tekstfelter der bliver skrevet ind i vores windows pop-up
    private final TextField txfTitle = new TextField();
    private final TextField txfName = new TextField();
    private final CheckBox chckSenior = new CheckBox();

    // Sætter person værdien til null, den vil senere få en værdi.
    private Person person = null;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name");
        pane.add(lblName, 0, 0);

        Label lblTitle = new Label("Titel");
        pane.add(lblTitle, 0, 1);

        Label lblSenior = new Label("Senior");
        pane.add(lblSenior,0,2);

        pane.add(txfName, 1, 0, 2, 1);

        pane.add(txfTitle, 1, 1, 2, 1);

        pane.add(chckSenior, 1, 2);

        //Sørger for at sætte det på den rigtige position
        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 3);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.TOP_RIGHT);

        //Cancel knap
        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        //OK knap
        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());

    }

    //Den sletter det input i tekstfelterne og gemmer input vinduet igen.
    private void cancelAction() {
        txfTitle.clear();
        txfTitle.requestFocus();
        txfName.clear();
        person = null;
        PersonInputWindow.this.hide();
    }

    // Tager det input der er blevet skrevet ind i tekstfelterne
    private void okAction() {
        String title = txfTitle.getText().trim();
        String name = txfName.getText().trim();

        //Hvis længden er over 0 vil der ikke komme en alarm
        if (title.length() > 0 && name.length() > 0) {
            //TJekker om senior checkboxen er blevet valgt
            if (chckSenior.isSelected()) {
                person = new Person(title, name, true);
                txfTitle.clear();
                txfName.clear();
                txfTitle.requestFocus();
                PersonInputWindow.this.hide();
            }
            //Hvis ikke checkboksen er valgt så kører nedenstående
            else {
                person = new Person(title, name);
                txfTitle.clear();
                txfName.clear();
                txfTitle.requestFocus();
                PersonInputWindow.this.hide();
            }
        }
        //Hvis der mangler input vil der komme en advarsel om at der mangler input
        else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Create Person");
            alert.setHeaderText("Information missing");
            alert.setContentText("Type title and name");
            alert.show();
        }
    }
    public Person getPerson() {
        return person;
    }
}
