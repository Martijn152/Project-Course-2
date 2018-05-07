package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewAddGrade implements Initializable,ControlledScenes{
    ScenesController myController;

    @FXML private Button saveBtn;
    @FXML private Button returnBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void handleSaveBtn(){
        ((Stage)saveBtn.getScene().getWindow()).close();
    }

    @FXML private void handleReturnBtn()throws IOException{
        myController.setScenes(SchoolAppFramework.teacherSceneID);
    }

    @Override
    public void setScreenParent(ScenesController screenController) {
        myController=screenController;
    }
}
