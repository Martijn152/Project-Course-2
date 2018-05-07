package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StudentContactAdmin implements ControlledScenes {

    @FXML private Button returnBtn;
    private ScenesController myController;

    @FXML private void handleReturnBtn(){
        myController.setScenes(SchoolAppFramework.studentSceneID);

    }

    @Override
    public void setScreenParent(ScenesController screenController) {
        myController=screenController;
    }
}
