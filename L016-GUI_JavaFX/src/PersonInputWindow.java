import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class PersonInputWindow extends Stage {

    public PersonInputWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinWidth(100);
        this.setMinHeight(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private Person person;

    private TextField txfName = new TextField();
    private TextField txfTitle = new TextField();

    private CheckBox chkSenior = new CheckBox();

    private Button btnOk = new Button("OK");
    private Button btnCancel = new Button("Cancel");

    private void initContent(GridPane pane) {

        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(20);

        Label lblName = new Label("Name: ");
        pane.add(lblName, 0, 0);

        Label lblTitle = new Label("Title: ");
        pane.add(lblTitle, 0, 1);

        Label lblSenior = new Label("Senior");
        pane.add(lblSenior, 0, 2);
        GridPane.setMargin(lblSenior, new Insets(0, 0, 0, 20));


        pane.add(txfName, 2, 0);
        pane.add(txfTitle, 2, 1);
        pane.add(chkSenior, 0, 2);
        pane.add(btnCancel, 0, 3);
        GridPane.setMargin(btnCancel, new Insets(0, 0, 0, 10));
        pane.add(btnOk, 1, 3);

        btnCancel.setOnAction(actionEvent -> cancelAction());
        btnOk.setOnAction(actionEvent -> addPerson());


    }

    private void addPerson() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        boolean isSenior = chkSenior.isSelected();

        if (name.equals("") || title.equals("")) {
            //TODO: Opgave 2
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing information!");
            alert.setHeaderText("Person is missing a name or a title");
            alert.setContentText("Type in a name and a title");
            alert.show();
        } else {
            person = new Person(txfName.getText(), txfTitle.getText(), chkSenior.isSelected());
            txfTitle.clear();
            txfName.clear();
            txfName.requestFocus();
            PersonInputWindow.this.hide();
        }
    }

    private void cancelAction() {
        txfName.clear();
        txfTitle.clear();
        txfName.requestFocus();
        person = null;
        PersonInputWindow.this.hide();
    }

    public Person getPerson() {
        return person;
    }
}
