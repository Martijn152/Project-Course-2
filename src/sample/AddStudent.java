//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddStudent implements Initializable {
    public TextField parentSSN;
    public TextField parentName;
    public TextField parentEmail;
    public TextField parentPhone;
    ObservableList<String> list = FXCollections.observableArrayList(new String[]{"GroupYear9", "GroupYear10", "GroupYear11", "GroupYear12"});
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField ssn;
    @FXML
    private DatePicker dateOfB;
    @FXML
    private RadioButton maleGender;
    @FXML
    private RadioButton femaleGender;
    @FXML
    private TextField homeAddress;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    private TextField userEmail;
    @FXML
    private ChoiceBox group;
    @FXML
    private Button saveBtn;

    public AddStudent() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.group.setItems(this.list);
    }

    @FXML
    private void handleSaveBtn() throws IOException {
        ((Stage)this.saveBtn.getScene().getWindow()).close();
    }
}
