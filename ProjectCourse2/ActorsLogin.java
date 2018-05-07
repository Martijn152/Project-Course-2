package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public interface ActorsLogin {

    @FXML public void login(ActionEvent event)throws IOException;
    @FXML public void passwordRecovering(ActionEvent event)throws IOException;
    @FXML public void abandonAction(ActionEvent event);

}
