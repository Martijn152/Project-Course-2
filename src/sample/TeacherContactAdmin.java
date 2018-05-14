//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TeacherContactAdmin implements Initializable,ControlledScenes {

    private ScenesController myController;

    @FXML
    private Label groupName;

    @FXML
    private Button returnBtn;

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





    public TeacherContactAdmin() {
    }
    public void initialize(URL location, ResourceBundle resources) {

        DBConnections.connect();
        ArrayList<String> as=DBConnections.getAdminInfo();
        System.out.println(as);
        principalName.setText(as.get(0));
        principalEmail.setText(as.get(1));
        principalTel.setText(as.get(2));
        itManagerName.setText(as.get(3));

        itMangerEmail.setText(as.get(4));
        itManagerTel.setText(as.get(5));
        secretaryName.setText(as.get(6));
        secretaryEmail.setText(as.get(7));
        secretaryTel.setText(as.get(8));
        humanResName.setText(as.get(9));
        humanResEmail.setText(as.get(10));
        humanResTel.setText(as.get(11));

    }
    @FXML
    private void handleReturnBtn() {
        this.myController.setScenes(SchoolAppFramework.teacherSceneID);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }
}
