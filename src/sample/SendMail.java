package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SendMail {

    @FXML private Button sendBtn;
    @FXML private Button addBtn;
    @FXML private TextField sender;
    @FXML private TextField receiver;
    @FXML private TextField subject;
    @FXML private TextArea textMail;


    @FXML private void sendMail(){
        ((Stage)sendBtn.getScene().getWindow()).close();
    }


    @FXML private void addDocument(){}

}
