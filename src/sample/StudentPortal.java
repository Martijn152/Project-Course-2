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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class StudentPortal implements Initializable, Actions, ControlledScenes {
    @FXML
    private Button exit;
    @FXML
    private Button downloadPdf;
    @FXML
    private Button viewBoardMembers;
    @FXML
    private Button viewTeachers;
    @FXML
    private Button viewClassMates;
    @FXML
    private Button updatePw;
    @FXML
    private Label mathsGrade1;
    @FXML
    private Label biologyGrade1;
    @FXML
    private Label chemistryGrade1;
    @FXML
    private Label englishGrade1;
    @FXML
    private Label philosophyGrade1;
    @FXML
    private Label physicsGrade1;
    @FXML
    private Label mathsGrade1Transcript;
    @FXML
    private Label biologyGrade1Transcript;
    @FXML
    private Label chemistryGrade1Transcript;
    @FXML
    private Label englishGrade1Transcript;
    @FXML
    private Label philosophyGrade1Transcript;
    @FXML
    private Label physicsGrade1Transcript;
    @FXML
    private Label semester1AvgGrade;
    @FXML
    private Label mathsGrade2;
    @FXML
    private Label biologyGrade2;
    @FXML
    private Label chemistryGrade2;
    @FXML
    private Label englishGrade2;
    @FXML
    private Label philosophyGrade2;
    @FXML
    private Label physicsGrade2;
    @FXML
    private Label mathsGrade2Transcript;
    @FXML
    private Label biologyGrade2Transcript;
    @FXML
    private Label chemistryGrade2Transcript;
    @FXML
    private Label englishGrade2Transcript;
    @FXML
    private Label philosophyGrade2Transcript;
    @FXML
    private Label physicsGrade2Transcript;
    @FXML
    private Label semester2AvgGrade;
    @FXML
    private Label studentNameTranscript1;
    @FXML
    private Label studentNameTranscript2;
    @FXML
    private Label studentName;
    @FXML
    private Label studentSurname;
    @FXML
    private Label gradeYear;
    @FXML
    private TextArea classmatesList;
    @FXML
    private TextArea weekSchedule;
    @FXML
    private TextArea policy;
    @FXML
    private Label labelComment1;
    @FXML
    private Label labelComment2;
    @FXML
    private Label labelComment3;
    @FXML
    private Label labelComment4;
    @FXML
    private Label labelComment5;
    @FXML
    private Label labelComment6;
    @FXML
    private Label labelComment7;
    @FXML
    private Label labelComment8;
    private ScenesController myController;
    private String fxmlFileClassmate = "classMates.fxml";
    private String fxmlFileContactTeacher = "studentContactTeacher.fxml";
    private String fxmlFileChangePW = "changepword.fxml";

    public StudentPortal() {
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void downloadBtn() {
    }

    public void viewBoardMbrBtn(ActionEvent event) {
        this.myController.setScenes(SchoolAppFramework.studentContactAdminSceneID);
    }

    public void viewClassMateBtn(ActionEvent event) throws IOException {
        this.myController.popUpStage(this.fxmlFileClassmate);
    }

    public void viewTeacherBtn(ActionEvent event) throws IOException {
        this.myController.popUpStage(this.fxmlFileContactTeacher);
    }

    public void exitBtn(ActionEvent event) throws IOException {
        this.myController.setScenes(SchoolAppFramework.loginSceneID);
    }

    public void updatePword(ActionEvent event) throws IOException {
        this.myController.popUpStage(this.fxmlFileChangePW);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }
}
