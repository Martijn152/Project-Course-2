//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StudentContactAdmin implements ControlledScenes {
    @FXML
    private Button returnBtn;
    private ScenesController myController;

    public StudentContactAdmin() {
    }

    @FXML
    private void handleReturnBtn() {
        this.myController.setScenes(SchoolAppFramework.studentSceneID);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }
}
