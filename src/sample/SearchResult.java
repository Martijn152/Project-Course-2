//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

    public void setData(String data){
            if(data==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("No data found");
                alert.setHeaderText(null);
                alert.setContentText("Please enter different name ");
                alert.show();
            }else{
                searchResultText.setText("SSN\t\t\tFirstName\t\t\tLastName\t\t\tPhoneNumber\t\t\tEmailAddress\n"+data);
            }
    }

}
