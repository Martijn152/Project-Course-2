package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable,ControlledScenes{

    @FXML private Button adminBtn;
    @FXML private Button staffBtn;
    @FXML private Button studentBtn;
    @FXML private Button teachersBtn;
    @FXML private Button exit;

    @FXML private TextArea sportNews;
    @FXML private TextArea commonNews;
    @FXML private TextArea meetings;
      private ScenesController myController;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void handleAdmBtn() throws IOException{
        myController.setScenes(SchoolAppFramework.adminLoginSceneID);

    }
    @FXML private void handleStudentBtn() throws IOException{
        myController.setScenes(SchoolAppFramework.studentLoginSceneID);


    }
    @FXML private void handleTeachersBtn() throws IOException{
        myController.setScenes(SchoolAppFramework.teacherLoginSceneID);

    }
    @FXML private void handleStaffBtn() throws IOException{
        myController.setScenes(SchoolAppFramework.staffLoginSceneID);

    }

    @FXML private void exitAppBtn(){
        Platform.exit();
        //System.exit(1);
    }


    @Override
    public void setScreenParent(ScenesController screenController) {
        myController=screenController;
    }
}

