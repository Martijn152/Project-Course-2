//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.IOException;
import java.util.HashMap;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ScenesController extends StackPane {
    private HashMap<String, Node> scenes = new HashMap();

    public ScenesController() {
    }

    public void addScene(String name, Node scene) {
        this.scenes.put(name, scene);
    }

    public Node getScenes(String name) {
        return (Node)this.scenes.get(name);
    }

    public boolean loadScene(String name, String resource) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource(resource));
            Parent loadScene = (Parent)loader.load();
            ControlledScenes controlledScene = (ControlledScenes)loader.getController();
            controlledScene.setScreenParent(this);
            this.addScene(name, loadScene);
            return true;
        } catch (Exception var6) {
            System.out.println(var6.getMessage());
            return false;
        }
    }

    public boolean setScenes(String name) {
        if (this.scenes.get(name) != null) {
            DoubleProperty opacity = this.opacityProperty();
            Timeline fade;
            if (!this.getChildren().isEmpty()) {
                fade = new Timeline(new KeyFrame[]{new KeyFrame(Duration.ZERO, new KeyValue[]{new KeyValue(opacity, 1.0D)}), new KeyFrame(new Duration(500.0D), (event) -> {
                    this.getChildren().remove(0);
                    this.getChildren().add(0, this.scenes.get(name));
                    Timeline fadeIn = new Timeline(new KeyFrame[]{new KeyFrame(Duration.ZERO, new KeyValue[]{new KeyValue(opacity, 0.0D)}), new KeyFrame(new Duration(500.0D), new KeyValue[]{new KeyValue(opacity, 1.0D)})});
                    fadeIn.play();
                }, new KeyValue[]{new KeyValue(opacity, 0.0D)})});
                fade.play();
            } else {
                this.setOpacity(0.0D);
                this.getChildren().add(this.scenes.get(name));
                fade = new Timeline(new KeyFrame[]{new KeyFrame(Duration.ZERO, new KeyValue[]{new KeyValue(opacity, 0.0D)}), new KeyFrame(new Duration(500.0D), new KeyValue[]{new KeyValue(opacity, 1.0D)})});
                fade.play();
            }

            return true;
        } else {
            System.out.println("Scene hasn't been loaded!!! \n");
            return false;
        }
    }

    public boolean unloadScene(String name) {
        if (this.scenes.remove(name) == null) {
            System.out.println("Scene didn't exist");
            return false;
        } else {
            return true;
        }
    }

    public void popUpStage(String fileName) throws IOException {
        Stage stage = new Stage();
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource(fileName));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        stage.centerOnScreen();
        stage.setOnCloseRequest((event12) -> {
        });
        stage.setOnHiding((event1) -> {
        });
    }
}
