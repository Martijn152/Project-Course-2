package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChangePword {

    @FXML private Button saveBtn;
    @FXML private TextField userName;
    @FXML private TextField email;
    @FXML private TextField newPassword;

    @FXML private void handleSaveBtn(){
        ((Stage)saveBtn.getScene().getWindow()).close();


    }
}
