//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.SystemUsers.Grades;
import sample.SystemUsers.Teacher;

public class ViewAddGrade implements Initializable, ControlledScenes {
    ScenesController myController;
    @FXML
    private Button saveBtn;
    @FXML
    private Button returnBtn;
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn ssn;
    @FXML
    private TableColumn email;

    @FXML
    private TableColumn mgrade1;

    @FXML
    private TableColumn mgrade2;

    @FXML
    private Button refresh;

    @FXML
    private Label groupName;

    @FXML
    private TableView gradetable;

    public ViewAddGrade() {
    }



    public void initialize(URL location, ResourceBundle resources) {
        this.gradetable.setItems(null);
        DBConnections.connect();
        ObservableList<Grades> gradeList = DBConnections.getGradeInfo();
        this.gradetable.setEditable(false);
        this.ssn.setCellValueFactory(new PropertyValueFactory("SSN"));
        this.name.setCellValueFactory(new PropertyValueFactory("name"));
        this.email.setCellValueFactory(new PropertyValueFactory("emailAddress"));
        this.mgrade1.setCellValueFactory (new PropertyValueFactory("Mgrade1"));
        this.mgrade2.setCellValueFactory (new PropertyValueFactory("Mgrade2"));

        this.gradetable.setItems(gradeList);
    }


    @FXML
    private void handleSaveBtn() {
        ((Stage)this.saveBtn.getScene().getWindow()).close();
    }

    @FXML
    private void handleReturnBtn() throws IOException {
        this.myController.setScenes(SchoolAppFramework.teacherSceneID);
    }

    @FXML
    private void onRefresh() {
        Platform.runLater(() -> {
            groupName.setText("Subject Name : "+DBConnections.sub);
        });
        this.gradetable.setItems(null);
        DBConnections.connect();
        ObservableList<Grades> gradeList = DBConnections.getGradeInfo();
        this.gradetable.setEditable(false);
        this.ssn.setCellValueFactory(new PropertyValueFactory("SSN"));
        this.name.setCellValueFactory(new PropertyValueFactory("name"));
        this.email.setCellValueFactory(new PropertyValueFactory("emailAddress"));
        this.mgrade1.setCellValueFactory (new PropertyValueFactory("Mgrade1"));
        this.mgrade2.setCellValueFactory (new PropertyValueFactory("Mgrade2"));
        this.gradetable.setItems(gradeList);

    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }
}
