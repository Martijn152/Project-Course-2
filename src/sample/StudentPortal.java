package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import sun.jvm.hotspot.debugger.AddressException;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;


public class StudentPortal implements Initializable,Actions,ControlledScenes {

    @FXML private Button exit;
    @FXML private Button pdfViewT1;
    @FXML private Button pdfViewT2;
    @FXML private Button viewBoardMembers;
    @FXML private Button viewTeachers;
    @FXML private Button viewClassMates;
    @FXML private Button updatePw;
    @FXML private Label mathsGrade1;
    @FXML private Label biologyGrade1;
    @FXML private Label chemistryGrade1;
    @FXML private Label englishGrade1;
    @FXML private Label philosophyGrade1;
    @FXML private Label physicsGrade1;

    @FXML private Label mathsGrade1Transcript;
    @FXML private Label biologyGrade1Transcript;
    @FXML private Label chemistryGrade1Transcript;
    @FXML private Label englishGrade1Transcript;
    @FXML private Label philosophyGrade1Transcript;
    @FXML private Label physicsGrade1Transcript;

    @FXML private Label mathsGrade2;
    @FXML private Label biologyGrade2;
    @FXML private Label chemistryGrade2;
    @FXML private Label englishGrade2;
    @FXML private Label philosophyGrade2;
    @FXML private Label physicsGrade2;

    @FXML private Label mathsGrade2Transcript;
    @FXML private Label biologyGrade2Transcript;
    @FXML private Label chemistryGrade2Transcript;
    @FXML private Label englishGrade2Transcript;
    @FXML private Label philosophyGrade2Transcript;
    @FXML private Label physicsGrade2Transcript;

    @FXML private Label studentNameTranscript1;
    @FXML private Label studentNameTranscript2;
    @FXML private Label userName;

    @FXML private Label labelComment1;
    @FXML private Label labelComment2;
    @FXML private Label labelComment3;
    @FXML private Label labelComment4;
    @FXML private Label labelComment5;
    @FXML private Label labelComment6;
    @FXML private Label labelComment7;
    @FXML private Label labelComment8;

    @FXML private AnchorPane transcript1;
    @FXML private AnchorPane transcript2;

    private ScenesController myController;
    private String fxmlFileClassmate = "classeMates.fxml";
    private String fxmlFileContactTeacher = "studentContactTeacher.fxml";
    private String fxmlFileChangePW = "changepword.fxml";
    private static String usr;
    private static String usrname;
    private static String fullname;
    private String currentUserGroup;
    private  String subjectPhysics="Physics";
    private  String subjectChemistry="Chemistry";
    private  String subjectEnglish="English";
    private  String subjectPhilosophy="Philosophy";
    private  String subjectMaths="Maths";
    private  String subjectBiology="Biology";
    DBConnections con=new DBConnections();
    private String emailAddress,passWord,toEmail,content,attachmentFile,FileName,subject;


    private static String USER_NAME = "nonosteven9@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "Projectcourse2"; // GMail password
    private static String RECIPIENT1 = "";
    private static String RECIPIENT2 = "nonosteven9@gmail.com";



    String from = USER_NAME;
    String pass = PASSWORD;
    String[] to = { RECIPIENT1,RECIPIENT2 }; // list of recipient email addresses
    String subj = "Sending pgf transcript";
    String body = "Kilimajaro technical highschool";



    public StudentPortal(){}


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        usr=StudentLogin.getCurrentUser();
        usrname=con.getStudentfisrtName(usr);
        this.userName.setText(usrname);

        fullname=con.getStudentFullName(usr);
        this.studentNameTranscript1.setText(fullname);
        this.studentNameTranscript2.setText(fullname);

        System.out.println(usrname);
        System.out.println(fullname);


        /**GRADE SEMESTER 1**/
        physicsGrade1.setText(String.valueOf(con.getfirstSemesterGrades(usr,subjectPhysics)));
        physicsGrade1Transcript.setText(physicsGrade1.getText());

        philosophyGrade1.setText(String.valueOf(con.getfirstSemesterGrades(usr,subjectPhilosophy)));
        philosophyGrade1Transcript.setText(philosophyGrade1.getText());

        englishGrade1.setText(String.valueOf(con.getfirstSemesterGrades(usr,subjectEnglish)));
        englishGrade1Transcript.setText(englishGrade1.getText());

        biologyGrade1.setText(String.valueOf(con.getfirstSemesterGrades(usr,subjectBiology)));
        biologyGrade1Transcript.setText(biologyGrade1.getText());

        mathsGrade1.setText(String.valueOf(con.getfirstSemesterGrades(usr,subjectMaths)));
        mathsGrade1Transcript.setText(mathsGrade1.getText());

        chemistryGrade1.setText(String.valueOf(con.getfirstSemesterGrades(usr,subjectChemistry)));
        chemistryGrade1Transcript.setText(chemistryGrade1.getText());

        /**GRADE SEMESTER 2**/
        physicsGrade2.setText(String.valueOf(con.getSecondSemesterGrades(usr,subjectPhysics)));
        physicsGrade2Transcript.setText(physicsGrade2.getText());

        philosophyGrade2.setText(String.valueOf(con.getSecondSemesterGrades(usr,subjectPhilosophy)));
        philosophyGrade2Transcript.setText(philosophyGrade2.getText());

        englishGrade2.setText(String.valueOf(con.getSecondSemesterGrades(usr,subjectEnglish)));
        englishGrade2Transcript.setText(englishGrade2.getText());

        biologyGrade2.setText(String.valueOf(con.getSecondSemesterGrades(usr,subjectBiology)));
        biologyGrade2Transcript.setText(biologyGrade2.getText());

        mathsGrade2.setText(String.valueOf(con.getSecondSemesterGrades(usr,subjectMaths)));
        mathsGrade2Transcript.setText(mathsGrade2.getText());

        chemistryGrade2.setText(String.valueOf(con.getSecondSemesterGrades(usr,subjectChemistry)));
        chemistryGrade2Transcript.setText(chemistryGrade2.getText());
        }


    @FXML private void pdfViewBtn1(){
        WritableImage image = transcript1.snapshot(new SnapshotParameters(), null);
        File file = new File("transcript.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage=new Stage();
        File file1 = new File("transcript.png");

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(file1.toURI().toString());
        StackPane root = new StackPane();
        root.getChildren().add(webView);
        Scene scene = new Scene(root, 500, 700);
        primaryStage.setTitle("Transcript1");
        primaryStage.setScene(scene);
        primaryStage.show();


        PDDocument doc= new PDDocument();
        PDPage page = new PDPage();
        PDImageXObject pdImageXObject;
        PDPageContentStream content;
        try {
            pdImageXObject = PDImageXObject.createFromFile("transcript.png",doc);
            content = new PDPageContentStream(doc, page);
            content.drawImage(pdImageXObject,0,300);
            content.close();
            doc.addPage(page);
            doc.save("transcript1.pdf");
            doc.close();
            file.delete();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        RECIPIENT1=con.getCurrentUserEmail(usr);
        System.out.println(RECIPIENT1);
        try {
            sendFromGMail(from, pass, to, subject, body);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }


    @FXML private void pdfVeiwBtn2() {
        WritableImage image = transcript2.snapshot(new SnapshotParameters(), null);
        File file = new File("transcript.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage=new Stage();
        File file1 = new File("transcript.png");

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(file1.toURI().toString());
        StackPane root = new StackPane();
        root.getChildren().add(webView);
        Scene scene = new Scene(root, 500, 700);
        primaryStage.setTitle("Transcript2");
        primaryStage.setScene(scene);
        primaryStage.show();

        PDDocument doc= new PDDocument();
        PDPage page = new PDPage();
        PDImageXObject pdImageXObject;
        PDPageContentStream content;
        try {
            pdImageXObject = PDImageXObject.createFromFile("transcript.png",doc);
            content = new PDPageContentStream(doc, page);
            content.drawImage(pdImageXObject,0,300);
            content.close();
            doc.addPage(page);
            doc.save("transcript2.pdf");
            doc.close();
            file.delete();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        RECIPIENT1=con.getCurrentUserEmail(usr);
        System.out.println(RECIPIENT1);
        try {
            sendFromGMail(from, pass, to, subject, body);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }


    public void viewBoardMbrBtn(ActionEvent event) {
        myController.setScenes(SchoolAppFramework.studentContactAdminSceneID);
    }

    public void viewClassMateBtn(ActionEvent event) throws IOException {
        myController.popUpStage(fxmlFileClassmate);

    }

    public void viewTeacherBtn(ActionEvent event) throws IOException {
        myController.popUpStage(fxmlFileContactTeacher);
    }

    @Override
    public void exitBtn(ActionEvent event) throws IOException {
        myController.setScenes(SchoolAppFramework.loginSceneID);
    }

    @Override
    public void updatePword(ActionEvent event) throws IOException {
        myController.popUpStage(fxmlFileChangePW);
    }

    @Override
    public void setScreenParent(ScenesController screenController) {
        myController=screenController;
    }


    private void sendFromGMail(String from, String pass, String[] to, String subject, String body) throws javax.mail.MessagingException{
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }
            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(javax.mail.Message.RecipientType.TO, toAddress[i]);
            }
            message.setSubject(subject);
            message.setText(body);
            MimeBodyPart mimeBodyPart=new MimeBodyPart();
            mimeBodyPart.setText("Try attachment");
            MimeBodyPart attachment=new MimeBodyPart();
            FileDataSource dataSource=new FileDataSource(new File("transcript1.pdf"));
            attachment.setDataHandler(new DataHandler(dataSource));
            attachment.setFileName("TRANSCRIPT.pdf");
            attachment.setDisposition(MimeBodyPart.ATTACHMENT);
            Multipart multipart=new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            multipart.addBodyPart(attachment);
            message.setContent(multipart);

            javax.mail.Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
    }
    }




