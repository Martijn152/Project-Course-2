package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TeacherContactAdmin implements ControlledScenes {

    @FXML private Button returnBtn;
    private ScenesController myController;


    @FXML private void handleReturnBtn(){
        myController.setScenes(SchoolAppFramework.teacherSceneID);

    }

    @Override
    public void setScreenParent(ScenesController screenController) {
        myController=screenController;
    }
}
