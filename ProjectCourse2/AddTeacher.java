package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddTeacher implements Initializable{

    ObservableList<String> list= FXCollections.observableArrayList(
            "Maths","Physics","Chemistry","Biology","Philosophy","English"
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
    @FXML private ChoiceBox subject;
    @FXML private Button saveBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        subject.setItems(list);
    }

    @FXML private void handleSaveBtn()throws IOException {
        ((Stage)saveBtn.getScene().getWindow()).close();

    }
}
