package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PasswordRecovery {
    @FXML private Button okBtn;
    @FXML private TextField ssn;
    @FXML private TextField email;


    @FXML private void okeyBtn(ActionEvent event) {
        Alert info=new Alert(Alert.AlertType.INFORMATION);
        info.setHeaderText("              PASSWORD RECOVERING");
        info.setContentText("An email have been sent to you with your password!");
        info.show();
        ((Stage)okBtn.getScene().getWindow()).close();
    }

}
