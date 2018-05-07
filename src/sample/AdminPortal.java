package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminPortal implements Initializable,Actions,ControlledScenes {

    @FXML private Button teachersModule;
    @FXML private MenuButton studentGroup;
    @FXML private MenuButton addPerson;
    @FXML private MenuButton addmanagePerson;
    @FXML private MenuItem addStudent;
    @FXML private MenuItem addTeacher;
    @FXML private MenuItem addStaff;
    @FXML private MenuItem addAdmin;
    @FXML private MenuItem groupYear9;
    @FXML private MenuItem groupYear10;
    @FXML private MenuItem groupYear11;
    @FXML private MenuItem groupYear12;
    @FXML private Button staffsModule;
    @FXML private Button classessModule;
    @FXML private Button coursessModule;
    @FXML private Button newsModule;
    @FXML private Button exit;
    @FXML private Button updatePw;
    @FXML private Button searchBtn;
    @FXML private Button managePerson;
    @FXML private Label username;
    @FXML private TextField searchField;

    private ScenesController myController;
    private String newsFxmlFileName="news.fxml";
    private String searchFxmlFileName="searchresult.fxml";
    private String addStudentFxmlFileName="addstudent.fxml";
    private String addTeacherFxmlFileName="addteacher.fxml";
    private String addStaffFxmlFileName="addstaff.fxml";
    private String addAdminFxmlFileName="addadmin.fxml";
    private String changePWFxmlFileName="changepword.fxml";




    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML private void manageBoardMbr()throws IOException{
        myController.setScenes(SchoolAppFramework.viewAdminSceneID);

    }
    @FXML private void manageStaff()throws IOException{
        myController.setScenes(SchoolAppFramework.viewStaffSceneID);

    }
    @FXML private void manageTeacher()throws IOException{
        myController.setScenes(SchoolAppFramework.viewTeacherSceneID);

    }

    @FXML private void upgradeNews()throws IOException{
        myController.popUpStage(newsFxmlFileName);

    }
    @FXML private void handleSearchBtn()throws IOException{
        myController.popUpStage(searchFxmlFileName);

    }
    @FXML private void addNewStudent()throws IOException{
        myController.popUpStage(addStudentFxmlFileName);

    }
    @FXML private void addNewTeacher()throws IOException{
        myController.popUpStage(addTeacherFxmlFileName);

    }
    @FXML private void addNewStaff()throws IOException{
        myController.popUpStage(addStaffFxmlFileName);

    }
    @FXML private void addNewAdmin()throws IOException{
        myController.popUpStage(addAdminFxmlFileName);

    }
    @FXML private void manageGroupYear9()throws IOException{
        myController.setScenes(SchoolAppFramework.groupSceneID);
    }
    @FXML private void manageGroupYear10()throws IOException{
        myController.setScenes(SchoolAppFramework.groupSceneID);
    }
    @FXML private void manageGroupYear11()throws IOException{
        myController.setScenes(SchoolAppFramework.groupSceneID);
    }
    @FXML private void manageGroupYear12()throws IOException{
        myController.setScenes(SchoolAppFramework.groupSceneID);
    }

    @Override
    public void exitBtn(ActionEvent event) throws IOException {
        myController.setScenes(SchoolAppFramework.loginSceneID);
    }

    @Override
    public void updatePword(ActionEvent event) throws IOException {
        myController.popUpStage(changePWFxmlFileName);
    }

    @Override
    public void setScreenParent(ScenesController screenController) {
        myController=screenController;
    }
}
