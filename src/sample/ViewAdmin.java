//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class ViewAdmin implements Initializable, ControlledScenes {
    private ScenesController myController;
    private String fxmlFileName = "manageadmin.fxml";
    @FXML
    private Button returnBtn;
    @FXML
    private Label userName;
    @FXML
    private Label principalName;
    @FXML
    private Label principalEmail;
    @FXML
    private Label principalTel;
    @FXML
    private Label itManagerName;
    @FXML
    private Label itMangerEmail;
    @FXML
    private Label itManagerTel;
    @FXML
    private Label secretaryName;
    @FXML
    private Label secretaryEmail;
    @FXML
    private Label secretaryTel;
    @FXML
    private Label humanResName;
    @FXML
    private Label humanResEmail;
    @FXML
    private Label humanResTel;
    @FXML
    private MenuButton updateAdmin;
    @FXML
    private MenuItem principal;
    @FXML
    private MenuItem It_System;
    @FXML
    private MenuItem humanRessources;
    @FXML
    private MenuItem secretary;

    public ViewAdmin() {
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void updatePrincipal() throws IOException {
        this.myController.popUpStage(this.fxmlFileName);
    }

    @FXML
    private void updateIt_System() throws IOException {
        this.myController.popUpStage(this.fxmlFileName);
    }

    @FXML
    private void updateHumanRessources() throws IOException {
        this.myController.popUpStage(this.fxmlFileName);
    }

    @FXML
    private void updateSecretary() throws IOException {
        this.myController.popUpStage(this.fxmlFileName);
    }

    @FXML
    private void handleReturnBtn() throws IOException {
        this.myController.setScenes(SchoolAppFramework.adminSceneID);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }
}
