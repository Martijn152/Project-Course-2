package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PasswordRecovery {
    @FXML private Button okBtn;
    private Alert info;


    @FXML private void okeyBtn(ActionEvent event) {
        ((Stage)okBtn.getScene().getWindow()).close();

    }
}
