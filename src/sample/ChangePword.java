package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ChangePword {

    @FXML private Button saveBtn;
    @FXML private TextField rePassword;
    @FXML private TextField newPassword;
   DBConnections con=new DBConnections();
   private static String currentUser;


    @FXML private void saveBtnPressed(){




        Alert info=new Alert(Alert.AlertType.INFORMATION);
        info.setHeaderText("          PASSWORD SUCCESSFULLY UPDATED!!!");
        info.setContentText("An email have been sent to you.");
        info.show();
        ((Stage)saveBtn.getScene().getWindow()).close();

    }

}


