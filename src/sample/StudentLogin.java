//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class StudentLogin implements UserLogin, ControlledScenes {
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Button enterAsStudent;
    @FXML
    private Button yesBtn;
    @FXML
    private Button abandonBtn;
    private ScenesController myController;
    private String passwordRecFxmlFileName = "passwordRecovery.fxml";

    public StudentLogin() {
    }

    public void login(ActionEvent event) throws IOException {
        this.myController.setScenes(SchoolAppFramework.studentSceneID);
    }

    public void passwordRecovering(ActionEvent event) throws IOException {
        this.myController.popUpStage(this.passwordRecFxmlFileName);
    }

    public void abandonAction(ActionEvent event) {
        this.myController.setScenes(SchoolAppFramework.loginSceneID);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }
}
