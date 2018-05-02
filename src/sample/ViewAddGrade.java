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
import javafx.stage.Stage;

public class ViewAddGrade implements Initializable, ControlledScenes {
    ScenesController myController;
    @FXML
    private Button saveBtn;
    @FXML
    private Button returnBtn;

    public ViewAddGrade() {
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void handleSaveBtn() {
        ((Stage)this.saveBtn.getScene().getWindow()).close();
    }

    @FXML
    private void handleReturnBtn() throws IOException {
        this.myController.setScenes(SchoolAppFramework.teacherSceneID);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }
}
