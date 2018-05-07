package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TeachersLogIn implements UserLogin, ControlledScenes {
    @FXML private TextField userName;
    @FXML private PasswordField password;
    @FXML private Button enterAsTeacher;
    @FXML private Button yesBtn;
    @FXML private Button abandonBtn;
    ScenesController myController;
    private String passwordRecFxmlFileName="passwordRecovery.fxml";


    @Override
    public void login(ActionEvent event) throws IOException {
        myController.setScenes(SchoolAppFramework.teacherSceneID);
    }

    @Override
    public void passwordRecovering(ActionEvent event) throws IOException {
        myController.popUpStage(passwordRecFxmlFileName);
    }

    @Override
    public void abandonAction(ActionEvent event) {
        myController.setScenes(SchoolAppFramework.loginSceneID);
    }


    @Override
    public void setScreenParent(ScenesController screenController) {
        myController=screenController;
    }
}
