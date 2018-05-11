package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentLogin implements UserLogin, ControlledScenes,Initializable {
    @FXML
    private TextField userName;
    @FXML private PasswordField password;
    @FXML private Button enterAsStudent;
    @FXML private Button yesBtn;
    @FXML private Button abandonBtn;
    private ScenesController myController;
    private String passwordRecFxmlFileName="passwordRecovery.fxml";
    private static String currentUser;
    private  String user;


    public StudentLogin(){}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @Override
    public void login(ActionEvent event) {
        this.user=this.userName.getText();
        System.out.println(this.user);
        setCurrentUser(this.user);

        this.myController.loadScene(SchoolAppFramework.studentSceneID,SchoolAppFramework.studentSceneFile);
        myController.setScenes(SchoolAppFramework.studentSceneID);
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

    public static String getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(String currentUser) {
        StudentLogin.currentUser = currentUser;
    }
}


