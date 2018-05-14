//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class TeachersLogIn implements UserLogin, ControlledScenes {
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Button enterAsTeacher;
    @FXML
    private Button yesBtn;
    @FXML
    private Button abandonBtn;
    ScenesController myController;
    private String passwordRecFxmlFileName = "passwordRecovery.fxml";

    public TeachersLogIn() {
    }

    public static void createfileteacher(String username,String ssn,String subject,String tid){

        String fileName = "temp.txt";

        try {

            FileWriter fileWriter = new FileWriter(fileName);


            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);



            bufferedWriter.write(username.trim().replace(" ",""));
            bufferedWriter.newLine();
            bufferedWriter.write(ssn);
            bufferedWriter.newLine();
            bufferedWriter.write(subject);
            bufferedWriter.newLine();
            bufferedWriter.write(tid);


            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");

        }
    }

    public void login(ActionEvent event) throws IOException {

        String un=userName.getText();
        String ps=password.getText();
        System.out.println(un);
        DBConnections.connect();
        boolean resu=DBConnections.isteacher(un,ps);
        if (resu) {
            myController.setScenes(SchoolAppFramework.teacherSceneID);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            String titleTxt="Error";
            alert.setTitle(titleTxt);
            String s = "Please Enter correct UserName and Password ";
            alert.setContentText(s);
            alert.showAndWait();

        }
    }

    public void passwordRecovering(ActionEvent event) throws IOException {
        this.myController.popUpStage(this.passwordRecFxmlFileName);
    }

    public void abandonAction(ActionEvent event) {
        this.myController.setScenes(SchoolAppFramework.loginSceneID);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }
}
