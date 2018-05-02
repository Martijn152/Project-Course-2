//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SearchResult implements Initializable {
    @FXML
    private Button okeyBtn;
    @FXML
    private TextArea searchResultText;

    public SearchResult() {
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void handleOkeyBtn() {
        ((Stage)this.okeyBtn.getScene().getWindow()).close();
    }
}
