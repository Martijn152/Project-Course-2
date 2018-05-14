//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class TeacherPortal implements Initializable, Actions, ControlledScenes {
    @FXML
    private Button viewTeacherBtn;
    @FXML
    private Button viewStudentBtn;
    @FXML
    private Button viewAdministrationBtn;
    @FXML
    private Button exitBtn;
    @FXML
    private Button updatePwBtn;
    @FXML
    private Button searchBtn;
    @FXML
    private MenuButton groups;
    @FXML
    private MenuItem groupYear9;
    @FXML
    private MenuItem groupYear10;
    @FXML
    private MenuItem groupYear11;
    @FXML
    private MenuItem groupYear12;
    @FXML
    private TextField searchField;
    @FXML
    private Label username;



    private ScenesController myController;
    private String searchFxmlFile = "searchresult.fxml";
    private String passwordchangeFxmlFile = "changepword.fxml";

    public TeacherPortal() {

    }

    public String openfileteacher() {
        // The name of the file to open.
        String fileName = "temp.txt";

        // This will reference one line at a time
        String line = null;
        String username=null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            int i=0;
            while ((line = bufferedReader.readLine()) != null) {
                if (i==0) {
                    System.out.println(line);
                    username=line;
                    break;
                }
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

        return username;

    }

    public static void createfilegrade(String gradeyear){
        // The name of the file to open.
        String fileName = "grade.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                    new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(gradeyear);


            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }



    public void initialize(URL location, ResourceBundle resources) {
        String t=openfileteacher();
        this.username.setText(t);
        this.username.setTextAlignment(TextAlignment.CENTER);
        this.username.setAlignment(Pos.CENTER);
    }

    /**
     * Search the persons in the database it will show the persons in the textAre
     * @throws IOException
     */
    @FXML
    private void handleSearchBtn() throws IOException {
        if(searchField.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty Field");
            alert.setHeaderText(null);
            alert.setContentText("Please enter first name ");
            alert.show();
        }else{
            FXMLLoader loader;
            Parent parent;
            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/searchresult.fxml"));
            parent = loader.load();
            SearchResult searchResult = loader.getController();
            searchResult.setData(DBConnections.getSearchResult(searchField.getText().trim()));
            Stage stage = new Stage();
            stage.setTitle("Search Result");
            stage.setScene(new Scene(parent));
            stage.show();

//            this.myController.popUpStage(this.searchFxmlFile);
        }
    }

    @FXML
    private void goToGroup9() throws IOException {
        createfilegrade("9");
        this.myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);
    }

    @FXML
    private void goToGroup10() throws IOException {
        createfilegrade("10");
        this.myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);
    }

    @FXML
    private void goToGroup11() throws IOException {
        createfilegrade("11");
        this.myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);
    }

    @FXML
    private void goToGroup12() throws IOException {
        createfilegrade("12");
        this.myController.setScenes(SchoolAppFramework.viewAddgradeSceneID);
    }

    @FXML
    private void goToAdminMbr() throws IOException {
        this.myController.setScenes(SchoolAppFramework.teacherContactAdminSceneID);
    }

    @FXML
    private void goToTeacher() throws IOException {
        this.myController.setScenes(SchoolAppFramework.teachersContactsSceneID);
    }

    public void exitBtn(ActionEvent event) throws IOException {
        this.myController.setScenes(SchoolAppFramework.loginSceneID);
    }

    public void updatePword(ActionEvent event) throws IOException {
        this.myController.popUpStage(this.passwordchangeFxmlFile);
    }

    public void setScreenParent(ScenesController screenController) {
        this.myController = screenController;
    }
}
