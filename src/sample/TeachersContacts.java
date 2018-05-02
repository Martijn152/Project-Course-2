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

public class TeachersContacts implements Initializable, ControlledScenes {
    private ScenesController myController;
    @FXML
    private Button returnBtn;

    public TeachersContacts() {
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }

    @FXML
    private void handleReturnBtn() throws IOException {
        this.myController.setScenes(SchoolAppFramework.teacherSceneID);
    }
}
