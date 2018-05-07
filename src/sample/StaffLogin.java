package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class StaffLogin implements UserLogin,ControlledScenes,Initializable {

    @FXML
    private TextField userName;
    @FXML private PasswordField password;
    @FXML private Button enterAsStaff;
    @FXML private Button yesBtn;
    @FXML private Button abandonBtn;
    private ScenesController myController;
    private String passwordRecFxmlFileName="passwordRecovery.fxml";
    private String usrName="Stephan";
    private String passW="0000";

    private ArrayList<String>admin=new ArrayList<>();
    private ArrayList<String>student=new ArrayList<>();
    private ArrayList<String>teacher=new ArrayList<>();
    private ArrayList<String>staff=new ArrayList<>();
    private HashMap<String,String>loginInfo=new HashMap<>();



    @Override
    public void login(ActionEvent event) throws IOException {
        //myController.setScenes(SchoolAppFramework.staffSceneID);
//        if (staff.contains(userName.getText())){
//            myController.setScenes(SchoolAppFramework.staffSceneID);
//            }else {
//            Alert wrongPass=new Alert(Alert.AlertType.ERROR);
//            wrongPass.setHeaderText("         WRONG PASS!!!");
//            wrongPass.setContentText("Check your login info.");
//            wrongPass.show();
//        }

        if (loginInfo.containsValue(userName.getText())){
            myController.setScenes(SchoolAppFramework.staffSceneID);
        }else {
            Alert wrongPass=new Alert(Alert.AlertType.ERROR);
            wrongPass.setHeaderText("         WRONG PASS!!!");
            wrongPass.setContentText("Check your login info.");
            wrongPass.show();
        }
    }

    @Override
    public void passwordRecovering(ActionEvent event) throws IOException {
        myController.popUpStage(passwordRecFxmlFileName);
    }

    @Override
    public void abandonAction(ActionEvent event) {
        myController.setScenes(SchoolAppFramework.loginSceneID);
    }


    @Override
    public void setScreenParent(ScenesController screenController) {
        myController=screenController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        student.add("student");
        teacher.add("teacher");
        admin.add("admin");
        staff.add(usrName);

        loginInfo.put(usrName,passW);
    }
}
