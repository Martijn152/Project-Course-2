//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SendMail {
    @FXML
    private Button sendBtn;
    @FXML
    private Button addBtn;
    @FXML
    private TextField sender;
    @FXML
    private TextField receiver;
    @FXML
    private TextField subject;
    @FXML
    private TextArea textMail;

    public SendMail() {
    }

    @FXML
    private void sendMail() {
        ((Stage)this.sendBtn.getScene().getWindow()).close();
    }

    @FXML
    private void addDocument() {
    }
}
