package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewTeacher implements Initializable,ControlledScenes {
    private ScenesController myController;

    @FXML
    private Button returnBtn;
    @FXML private Button updateBtn;
    @FXML private Button deleteBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setScreenParent(ScenesController screenController) {
        myController=screenController;
    }

    @FXML private void handleReturnBtn()throws IOException {
        myController.setScenes(SchoolAppFramework.adminSceneID);
    }

    @FXML private void handleUpdateBtn(){

    }

    @FXML private void handleDeleteBtnBtn(){

    }
}
