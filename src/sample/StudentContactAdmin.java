package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class StudentContactAdmin implements ControlledScenes {

    @FXML private Button returnBtn;
    @FXML private Label userName;
    @FXML private Label principalName;
    @FXML private Label principalEmail;
    @FXML private Label principalTel;
    @FXML private Label itManagerName;
    @FXML private Label itMangerEmail;
    @FXML private Label itManagerTel;
    @FXML private Label secretaryName;
    @FXML private Label secretaryEmail;
    @FXML private Label secretaryTel;
    @FXML private Label humanResName;
    @FXML private Label humanResEmail;
    @FXML private Label humanResTel;
    @FXML private MenuButton updateAdmin;
    @FXML private MenuItem principal;
    @FXML private MenuItem It_System;
    @FXML private MenuItem humanRessources;
    @FXML private MenuItem secretary;
    private ScenesController myController;

    @FXML private void handleReturnBtn(){
        myController.setScenes(SchoolAppFramework.studentSceneID);

    }

    @Override
    public void setScreenParent(ScenesController screenController) {
        myController=screenController;
    }
}
