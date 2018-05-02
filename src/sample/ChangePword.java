//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ChangePword {
    @FXML
    private Button saveBtn;
    @FXML
    private TextField userName;
    @FXML
    private TextField email;
    @FXML
    private TextField newPassword;

    public ChangePword() {
    }

    @FXML
    private void handleSaveBtn() {
        Alert info = new Alert(AlertType.INFORMATION);
        info.setHeaderText("          PASSWORD SUCCESSFULLY UPDATED!!!");
        info.setContentText("An email have been sent to you.");
        info.show();
        ((Stage)this.saveBtn.getScene().getWindow()).close();
    }
}
