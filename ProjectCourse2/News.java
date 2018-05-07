package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class News {

    @FXML private Button upgradeNews;
    @FXML private TextArea news;

    @FXML private void upgradeNewsBtn(){
        ((Stage)upgradeNews.getScene().getWindow()).close();
    }


}
