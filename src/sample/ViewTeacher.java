//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import sample.SystemUsers.Teacher;

public class ViewTeacher implements Initializable, ControlledScenes {
    public TableView teacherTableView;
    public TableColumn firstNameCol;
    public TableColumn lastNameCol;
    public TableColumn emailCol;
    public TableColumn telCol;
    public TableColumn addressCol;
    public TableColumn subjectCol;
    public TableColumn ssnCol;
    public TableColumn dobCol;
    public TableColumn usernameCol;
    public TableColumn passwordCol;
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

        this.ssnCol.setCellValueFactory(new PropertyValueFactory("SSN"));
        this.firstNameCol.setCellValueFactory(new PropertyValueFactory("name"));
        this.lastNameCol.setCellValueFactory(new PropertyValueFactory("surname"));
        //this.dobCol.setCellFactory(new PropertyValueFactory("dateOfBirth"));
        this.addressCol.setCellValueFactory(new PropertyValueFactory("homeAddress"));
        this.telCol.setCellValueFactory(new PropertyValueFactory("phoneNum"));
        this.emailCol.setCellValueFactory(new PropertyValueFactory("emailAddress"));
        this.subjectCol.setCellValueFactory(new PropertyValueFactory("teachingField"));
        //this.usernameCol.setCellFactory(new PropertyValueFactory("userName"));
        //this.passwordCol.setCellFactory(new PropertyValueFactory("password"));

        this.teacherTableView.setItems(infoList);

        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setName(t.getNewValue());
                    }
                }
        );

        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setSurname(t.getNewValue());
                    }
                }
        );

        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setEmailAddress(t.getNewValue());
                    }
                }
        );

        telCol.setCellFactory(TextFieldTableCell.forTableColumn());
        telCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPhoneNum(t.getNewValue());
                    }
                }
        );

        addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        addressCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setHomeAddress(t.getNewValue());
                    }
                }
        );

        subjectCol.setCellFactory(TextFieldTableCell.forTableColumn());
        subjectCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Teacher, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Teacher, String> t) {
                        System.out.println("New value: ");
                        ((Teacher) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setTeachingField(t.getNewValue());
                        System.out.println(t.getNewValue());
                        System.out.println("New value in object: ");
                        System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getTeachingField());

                    }
                }
        );
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
        //WORK IN PROGRESS BELOW
/*        ObservableList<Teacher> editedList = teacherTableView.getItems();
        System.out.println("New value in list:");
        System.out.println(editedList.get(2).getTeachingField());

        System.out.println("Will now try connection");
        DBConnections.connect();
        DBConnections.editTeachers(editedList);
        System.out.println("Oh boy let's hope it worked");*/
    }

    @FXML
    private void onEditStart(){
        System.out.println("Edit start");
    }

    @FXML
    private void handleDeleteBtnBtn() {
    }


}
