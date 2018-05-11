package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SchoolAppFramework extends Application{
    private static Stage primaryStage;

    public static String loginSceneID = "Login";
    public static String loginSceneFile = "login.fxml";
    public static String adminSceneID ="Admin Portal";
    public static String adminSceneFile = "admin.fxml";
    public static String teacherSceneID ="Teacher's Portal";
    public static String teacherSceneFile = "teacher.fxml";
    public static String studentSceneID ="Student's Portal";
    public static String studentSceneFile = "student.fxml";
    public static String staffSceneID ="StaffPortal's Portal";
    public static String staffSceneFile = "staff.fxml";

    public static String adminLoginSceneID ="Login as Admin";
    public static String adminLoginFile ="adminlogin.fxml";
    public static String teacherLoginSceneID ="Login as Teacher";
    public static String teacherLoginFile ="teacherslogin.fxml";
    public static String studentLoginSceneID ="Login as Student";
    public static String studentLoginFile ="studentlogin.fxml";
    public static String staffLoginSceneID ="Login as StaffPortal";
    public static String staffLoginFile ="stafflogin.fxml";

    public static String groupSceneID ="Group";
    public static String groupSceneIDFile ="group.fxml";

    public static String viewAddgradeSceneID ="View & Add Grade";
    public static String viewAddgradeSceneIDFile ="viewaddgrade.fxml";

    public static String viewAdminSceneID ="View Admin";
    public static String viewAdminSceneIDFile ="viewadmin.fxml";

    public static String viewStaffSceneID ="View Staff";
    public static String viewStaffSceneIDFile ="viewstaff.fxml";

    public static String viewTeacherSceneID ="View Teacher";
    public static String viewTeacherSceneIDFile ="viewteacher.fxml";

    public static String teacherContactAdminSceneID ="teacher view admin";
    public static String teacherContactAdminSceneFile ="teacherContactAdmin.fxml";

    public static String studentContactAdminSceneID ="student view admin";
    public static String studentContactAdminSceneFile ="studentContactAdmin.fxml";

    public static String teachersContactsSceneID ="teachers contacts";
    public static String teachersContactsSceneFile ="teachersContacts.fxml";

    public static String coverPageSceneID ="coverPage";
    public static String coverPageSceneFile ="coverPage.fxml";





    @Override
    public void start(Stage primaryStage) throws Exception {
        ScenesController mainContainer = new ScenesController();
        mainContainer.loadScene(SchoolAppFramework.loginSceneID, SchoolAppFramework.loginSceneFile);
        mainContainer.loadScene(SchoolAppFramework.adminSceneID, SchoolAppFramework.adminSceneFile);
        mainContainer.loadScene(SchoolAppFramework.teacherSceneID, SchoolAppFramework.teacherSceneFile);
        mainContainer.loadScene(SchoolAppFramework.studentSceneID, SchoolAppFramework.studentSceneFile);
        //mainContainer.loadScene(SchoolAppFramework.staffSceneID, SchoolAppFramework.staffSceneFile);
        mainContainer.loadScene(SchoolAppFramework.adminLoginSceneID, SchoolAppFramework.adminLoginFile);
        mainContainer.loadScene(SchoolAppFramework.teacherLoginSceneID, SchoolAppFramework.teacherLoginFile);
        mainContainer.loadScene(SchoolAppFramework.studentLoginSceneID, SchoolAppFramework.studentLoginFile);
        //mainContainer.loadScene(SchoolAppFramework.staffLoginSceneID, SchoolAppFramework.staffLoginFile);

        mainContainer.loadScene(SchoolAppFramework.groupSceneID, SchoolAppFramework.groupSceneIDFile);
        mainContainer.loadScene(SchoolAppFramework.viewAddgradeSceneID, SchoolAppFramework.viewAddgradeSceneIDFile);
        mainContainer.loadScene(SchoolAppFramework.viewAdminSceneID, SchoolAppFramework.viewAdminSceneIDFile);
        //mainContainer.loadScene(SchoolAppFramework.viewStaffSceneID, SchoolAppFramework.viewStaffSceneIDFile);
        mainContainer.loadScene(SchoolAppFramework.viewTeacherSceneID, SchoolAppFramework.viewTeacherSceneIDFile);
        mainContainer.loadScene(SchoolAppFramework.teacherContactAdminSceneID, SchoolAppFramework.teacherContactAdminSceneFile);
        mainContainer.loadScene(SchoolAppFramework.studentContactAdminSceneID, SchoolAppFramework.studentContactAdminSceneFile);
        mainContainer.loadScene(SchoolAppFramework.teachersContactsSceneID, SchoolAppFramework.teachersContactsSceneFile);
        mainContainer.loadScene(SchoolAppFramework.coverPageSceneID, SchoolAppFramework.coverPageSceneFile);



        mainContainer.setScenes(SchoolAppFramework.coverPageSceneID);

        Group root =new Group();
        root.getChildren().add(mainContainer);
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

}
