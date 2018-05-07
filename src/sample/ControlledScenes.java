package sample;

import sample.ScenesController;

public interface ControlledScenes {


    // This method will allow the injection of the Parent Screenpane
    public void setScreenParent(ScenesController screenController);
}
