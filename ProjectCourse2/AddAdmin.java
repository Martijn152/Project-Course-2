package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddAdmin implements Initializable{
   private ScenesController myController;

   ObservableList<String>list= FXCollections.observableArrayList(
           "Principal","Human Res.Manager","IT-System Manager","General Secretary"
   );


    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField ssn;
    @FXML private DatePicker dateOfB;
    @FXML private RadioButton maleGender;
    @FXML private RadioButton femaleGender;
    @FXML private TextField homeAddress;
    @FXML private TextField phoneNumber;
    @FXML private TextField userName;
    @FXML private TextField password;
    @FXML private TextField userEmail;
    @FXML private Button saveBtn;
    @FXML private ChoiceBox position;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        position.setItems(list);

    }

    @FXML private void handleSaveBtn()throws IOException {
        ((Stage)saveBtn.getScene().getWindow()).close();

    }
}
