//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class StaffLogin implements UserLogin, ControlledScenes, Initializable {
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Button enterAsStaff;
    @FXML
    private Button yesBtn;
    @FXML
    private Button abandonBtn;
    private ScenesController myController;
    private String passwordRecFxmlFileName = "passwordRecovery.fxml";
    private String usrName = "Stephan";
    private String passW = "0000";
    private ArrayList<String> admin = new ArrayList();
    private ArrayList<String> student = new ArrayList();
    private ArrayList<String> teacher = new ArrayList();
    private ArrayList<String> staff = new ArrayList();
    private HashMap<String, String> loginInfo = new HashMap();

    public StaffLogin() {
    }

    public void login(ActionEvent event) throws IOException {
        if (this.loginInfo.containsValue(this.userName.getText())) {
            this.myController.setScenes(SchoolAppFramework.staffSceneID);
        } else {
            Alert wrongPass = new Alert(AlertType.ERROR);
            wrongPass.setHeaderText("         WRONG PASS!!!");
            wrongPass.setContentText("Check your login info.");
            wrongPass.show();
        }

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

    public void initialize(URL location, ResourceBundle resources) {
        this.student.add("student");
        this.teacher.add("teacher");
        this.admin.add("admin");
        this.staff.add(this.usrName);
        this.loginInfo.put(this.usrName, this.passW);
    }
}
