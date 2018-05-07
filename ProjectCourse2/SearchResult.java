package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchResult implements Initializable {

    @FXML private Button okeyBtn;
    @FXML private TextArea searchResultText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void handleOkeyBtn(){
        ((Stage)okeyBtn.getScene().getWindow()).close();

    }
}
