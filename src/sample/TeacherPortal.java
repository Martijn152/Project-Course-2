//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class TeacherPortal implements Initializable, Actions, ControlledScenes {
    @FXML
    private Button viewTeacherBtn;
    @FXML
    private Button viewStudentBtn;
    @FXML
    private Button viewAdministrationBtn;
    @FXML
    private Button exitBtn;
    @FXML
    private Button updatePwBtn;
    @FXML
    private Button searchBtn;
    @FXML
    private MenuButton groups;
    @FXML
    private MenuItem groupYear9;
    @FXML
    private MenuItem groupYear10;
    @FXML
    private MenuItem groupYear11;
    @FXML
    private MenuItem groupYear12;
    @FXML
    private TextField searchField;
    private ScenesController myController;
    private String searchFxmlFile = "searchresult.fxml";
    private String passwordchangeFxmlFile = "changepword.fxml";

    public TeacherPortal() {
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void handleSearchBtn() throws IOException {
        this.myController.popUpStage(this.searchFxmlFile);
    }

    @FXML
    private void goToGroup9() throws IOException {
        this.myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);
    }

    @FXML
    private void goToGroup10() throws IOException {
        this.myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);
    }

    @FXML
    private void goToGroup11() throws IOException {
        this.myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);
    }

    @FXML
    private void goToGroup12() throws IOException {
        this.myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);
    }

    @FXML
    private void goToAdminMbr() throws IOException {
        this.myController.setScenes(SchoolAppFramework.teacherContactAdminSceneID);
    }

    @FXML
    private void goToTeacher() throws IOException {
        this.myController.setScenes(SchoolAppFramework.teachersContactsSceneID);
    }

    public void exitBtn(ActionEvent event) throws IOException {
        this.myController.setScenes(SchoolAppFramework.loginSceneID);
    }

    public void updatePword(ActionEvent event) throws IOException {
        this.myController.popUpStage(this.passwordchangeFxmlFile);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }
}
