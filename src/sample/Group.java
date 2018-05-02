//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.SystemUsers.Student;
import sample.SystemUsers.Teacher;

public class Group implements Initializable, ControlledScenes {
    public TableView studentTable;
    public TableView teacherTable;
    public TableColumn studentSSNCol;
    public TableColumn studentFirstNameCol;
    public TableColumn studentLastNameCol;
    public TableColumn studentDateOfBirthCol;
    public TableColumn studentEmailCol;
    public TableColumn studentAddressCol;
    public TableColumn teacherSubjectCol;
    public TableColumn teacherFirstNameCol;
    public TableColumn teacherLastNameCol;
    public TableColumn teacherEmailCol;
    public TableColumn teacherTelCol;
    private ScenesController myController;
    @FXML
    private Label groupName;
    @FXML
    private Button returnBtn;
    @FXML
    private Button saveBtn;
    @FXML
    private Button deleteBtn;
    public static String selectedGroup;

    public Group() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        selectedGroup = AdminPortal.getSelectedGroup();
        System.out.println("Selected group: " + selectedGroup);
        DBConnections.connect();
        ObservableList<Student> infoList = DBConnections.getStudentInfo(selectedGroup);
        this.studentTable.setEditable(true);
        this.studentSSNCol.setCellValueFactory(new PropertyValueFactory("SSN"));
        this.studentFirstNameCol.setCellValueFactory(new PropertyValueFactory("name"));
        this.studentLastNameCol.setCellValueFactory(new PropertyValueFactory("surname"));
        this.studentDateOfBirthCol.setCellValueFactory(new PropertyValueFactory("dateOfBirth"));
        this.studentEmailCol.setCellValueFactory(new PropertyValueFactory("emailAddress"));
        this.studentAddressCol.setCellValueFactory(new PropertyValueFactory("homeAddress"));
        this.studentTable.setItems(infoList);
        ObservableList<Teacher> infoList2 = DBConnections.getTeacherInfoGroup(selectedGroup);
        this.teacherTable.setEditable(true);
        this.teacherSubjectCol.setCellValueFactory(new PropertyValueFactory("TeachingField"));
        this.teacherFirstNameCol.setCellValueFactory(new PropertyValueFactory("name"));
        this.teacherLastNameCol.setCellValueFactory(new PropertyValueFactory("surname"));
        this.teacherEmailCol.setCellValueFactory(new PropertyValueFactory("emailAddress"));
        this.teacherTelCol.setCellValueFactory(new PropertyValueFactory("phoneNum"));
        this.teacherTable.setItems(infoList2);
    }

    @FXML
    private void handleReturnBtn() throws IOException {
        this.myController.setScenes(SchoolAppFramework.adminSceneID);
    }

    @FXML
    private void handleSaveBtn() {
    }

    @FXML
    private void handleDeleteBtn() {
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }
}
