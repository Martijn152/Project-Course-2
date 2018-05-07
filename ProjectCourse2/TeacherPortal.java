package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherPortal implements Initializable,Actions,ControlledScenes {
    @FXML private Button viewTeacherBtn;
    @FXML private Button viewStudentBtn;
    @FXML private Button viewAdministrationBtn;
    @FXML private Button exitBtn;
    @FXML private Button updatePwBtn;
    @FXML private Button searchBtn;
    @FXML private MenuButton groups;
    @FXML private MenuItem groupYear9;
    @FXML private MenuItem groupYear10;
    @FXML private MenuItem groupYear11;
    @FXML private MenuItem groupYear12;
    @FXML private TextField searchField;
    private ScenesController myController;
    private String searchFxmlFile="searchresult.fxml";
    private String passwordchangeFxmlFile="changepword.fxml";



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }



    @FXML private void handleSearchBtn() throws IOException {
        myController.popUpStage(searchFxmlFile);
    }

    @FXML private void goToGroup9()throws IOException {
        myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);

    }
    @FXML private void goToGroup10()throws IOException {
        myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);

    }
    @FXML private void goToGroup11()throws IOException {
        myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);

    }
    @FXML private void goToGroup12()throws IOException {
        myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);

    }
    @FXML private void goToAdminMbr()throws IOException{
        myController.setScenes(SchoolAppFramework.teacherContactAdminSceneID);

    }
    @FXML private void goToTeacher()throws IOException{
        myController.setScenes(SchoolAppFramework.viewTeacherSceneID);

    }

    @Override
    public void exitBtn(ActionEvent event) throws IOException {
        myController.setScenes(SchoolAppFramework.loginSceneID);

    }
    @Override
    public void updatePword(ActionEvent event) throws IOException {
        myController.popUpStage(passwordchangeFxmlFile);

    }

    @Override
    public void setScreenParent(ScenesController screenController) {
        myController=screenController;
    }
}
