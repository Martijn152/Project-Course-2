package sample;

import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class CoverPage implements Initializable, ControlledScenes {
    private ScenesController myController;
    @FXML private ChoiceBox schools;
    @FXML private Button option;
    @FXML private Button exit;
    String schoolName1="KILIMANJARO TECHNICAL HIGH SCHOOL";


    ObservableList<String>list=FXCollections.observableArrayList(
            schoolName1
    );


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Line path=new Line(0,0,450,310);

        Path path1=new Path();
        path1.getElements().add(new MoveTo(0,0));
        path1.getElements().add(new MoveTo(200,200));
        PathTransition pt=new PathTransition(Duration.millis(2000),path,option);
        pt.setAutoReverse(false);
        pt.play();

        schools.setValue(schoolName1);
       schools.setItems(list);
    }

    @FXML private void schoolOption(){
        myController.setScenes(SchoolAppFramework.loginSceneID);

    }

    @Override
    public void setScreenParent(ScenesController screenController) {
        myController=screenController;
    }

    @FXML private void setExit(){
        Platform.exit();
    }
}
