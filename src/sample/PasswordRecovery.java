//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PasswordRecovery {
    @FXML
    private Button okBtn;
    @FXML
    private TextField ssn;
    @FXML
    private TextField email;

    public PasswordRecovery() {
    }

    @FXML
    private void okeyBtn(ActionEvent event) {
        Alert info = new Alert(AlertType.INFORMATION);
        info.setHeaderText("              PASSWORD RECOVERING");
        info.setContentText("An email have been sent to you with your password!");
        info.show();
        ((Stage)this.okBtn.getScene().getWindow()).close();
    }
}
