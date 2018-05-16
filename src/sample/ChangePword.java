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
        if (userName.getText() == null || userName.getText().trim().isEmpty() || email.getText() == null || email.getText().trim().isEmpty()
                ||newPassword.getText() == null || newPassword.getText().trim().isEmpty()){
            Alert info = new Alert(AlertType.INFORMATION);
            info.setHeaderText("          Fields are empty");
            info.setContentText("Please enter the required fields");
            info.show();
            ((Stage) this.saveBtn.getScene().getWindow()).close();
            return;

        }
        DBConnections.connect();
        boolean s = DBConnections.updatePass(userName.getText(), email.getText(), newPassword.getText());
        if(s == true) {
            Alert info = new Alert(AlertType.INFORMATION);
            info.setHeaderText("          PASSWORD SUCCESSFULLY UPDATED!!!");
            info.setContentText("An email have been sent to you.");
            info.show();
            ((Stage) this.saveBtn.getScene().getWindow()).close();
        }
        else{
            Alert info = new Alert(AlertType.INFORMATION);
            info.setHeaderText("          PASSWORD NOT UPDATED!!!");
            info.setContentText("Wrong Credentials Entered");
            info.show();
            ((Stage) this.saveBtn.getScene().getWindow()).close();
        }

    }
}
