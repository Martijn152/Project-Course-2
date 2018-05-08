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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.SystemUsers.Teacher;

public class ViewTeacher implements Initializable, ControlledScenes {
    public TableView teacherTableView;
    public TableColumn firstNameCol;
    public TableColumn lastNameCol;
    public TableColumn emailCol;
    public TableColumn telCol;
    public TableColumn addressCol;
    public TableColumn subjectCol;
    private ScenesController myController;
    @FXML
    private Button returnBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button deleteBtn;

    public ViewTeacher() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        DBConnections.connect();
        ObservableList<Teacher> infoList = DBConnections.getTeacherInfo();
        this.teacherTableView.setEditable(true);
        this.firstNameCol.setCellValueFactory(new PropertyValueFactory("name"));
        this.lastNameCol.setCellValueFactory(new PropertyValueFactory("surname"));
        this.emailCol.setCellValueFactory(new PropertyValueFactory("emailAddress"));
        this.telCol.setCellValueFactory(new PropertyValueFactory("phoneNum"));
        this.addressCol.setCellValueFactory(new PropertyValueFactory("homeAddress"));
        this.subjectCol.setCellValueFactory(new PropertyValueFactory("teachingField"));
        this.teacherTableView.setItems(infoList);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }

    @FXML
    private void handleReturnBtn() throws IOException {
        this.myController.setScenes(SchoolAppFramework.adminSceneID);
    }

    @FXML
    private void handleUpdateBtn() {
    }

    @FXML
    private void handleDeleteBtnBtn() {
    }
}
