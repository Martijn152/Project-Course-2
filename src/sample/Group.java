package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Group implements Initializable,ControlledScenes {
 private ScenesController myController;

   @FXML private Label groupName;
    @FXML private Button returnBtn;
    @FXML private Button saveBtn;
    @FXML private Button deleteBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void handleReturnBtn()throws IOException{
     myController.setScenes(SchoolAppFramework.adminSceneID);

    }

    @FXML private void handleSaveBtn(){

    }

    @FXML private void handleDeleteBtn(){

    }

 @Override
 public void setScreenParent(ScenesController screenController) {
  myController=screenController;
 }
}
