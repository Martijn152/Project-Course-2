package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jdk.nashorn.internal.runtime.Version;
import sample.SystemUsers.Classmate;
import sample.SystemUsers.TeacherGroupedByGroup;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnections {

   private static final String URL="jdbc:mysql://den1.mysql3.gear.host:3306/projectcourse2";
   private static Statement st = null;
   private static ResultSet rs = null;

   private static final String USER = "projectcourse2";
   private static final String PASSWORD = "Cg25k9o3?!3l";
    String groupID;
    String firstname;
    String name;

    public static void connect(){
            try{
                Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
                st=connection.createStatement();
            }
            catch (SQLException ex){
                System.out.println("Failed to connect "+ ex.getMessage());
            }
        }


        public ObservableList<Classmate> getGroupParticipant(String groupID){
        ObservableList<Classmate>classmatesArray=FXCollections.observableArrayList();
            try {
                rs = st.executeQuery(
                        "SELECT FirstName,LastName,EmailAdress FROM persons,students WHERE persons.SSN=students.SSN AND students.GroupID = '" + groupID + "';");
                while (rs.next()) {
                    String name= rs.getString(1)+"  "+rs.getString(2);
                    String email= rs.getString(3);

                    Classmate classmate=new Classmate(name,email);
                    classmatesArray.add(classmate);
                    }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
            return classmatesArray;
        }

    public ObservableList<String> ClassmatesName(String groupID){
        ObservableList<String>classmatesArray=FXCollections.observableArrayList();
        try {
            rs = st.executeQuery(
                    "SELECT FirstName,LastName FROM persons,students WHERE persons.SSN = students.SSN AND students.GroupID = '" + groupID + "';");
            while (rs.next()) {
                String name= rs.getString(1)+"  "+rs.getString(2);
                classmatesArray.add(name);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return classmatesArray;
    }

    public  String getStudentGroup(String loginID){
        String groupID=null;
        try {
        rs = st.executeQuery("SELECT GroupID FROM students,persons WHERE persons.LoginID = '"+loginID+"' AND persons.SSN = students.SSN;");
            while (rs.next()) {
               groupID = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return groupID;
    }


    public  String getStudentfisrtName(String loginID){
        String firstname=null;
        try {
            rs = st.executeQuery("SELECT DISTINCT firstName FROM persons,students WHERE persons.LoginID = '"+loginID+"';");
            while (rs.next()) {
                firstname = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }return firstname;
    }

    public  String getStudentFullName(String loginID){
        String name = null;
        try {
            rs = st.executeQuery("SELECT DISTINCT firstName, LastName FROM persons,students WHERE persons.LoginID = '"+loginID+"';");
            while (rs.next()) {
                name = rs.getString(1)+"  "+rs.getString(2);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }return name;
    }

    public String getReceiverEmailAdddress(String recieverName){
        String emailAddress=null;
        try {
            rs = st.executeQuery("SELECT EmailAdress FROM persons Where '"+recieverName+"' = (SELECT CONCAT(CONCAT (FirstName,'  '),LastName));");
            while (rs.next()) {
                emailAddress = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }return emailAddress;

    }

    public ObservableList<TeacherGroupedByGroup> getTeacher(String loginID){
        ObservableList<TeacherGroupedByGroup>teachersArray=FXCollections.observableArrayList();
        try {
            rs = st.executeQuery(
                    "SELECT firstName,lastName,emailAdress,subject FROM persons,students," +
                            "groups,groups_teachers,teachers WHERE persons.SSN = teachers.SSN AND " +
                            "teachers.teacherID=groups_teachers.teacherID AND groups_teachers.groupID = " +
                            "groups.groupID AND groups.groupID = students.groupID AND students.SSN = " +
                            "(SELECT SSN FROM persons WHERE loginID = '"+loginID+"')");
            while (rs.next()) {
                String name= rs.getString(1)+"  "+rs.getString(2);
                String email= rs.getString(3);
                String subject= rs.getString(4);

                TeacherGroupedByGroup teacher=new TeacherGroupedByGroup(name,email,subject);

                teachersArray.add(teacher);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return teachersArray;
    }

    public ObservableList<String> groupTeacher(String loginID){
        ObservableList<String>teachersArray=FXCollections.observableArrayList();
        try {
            rs = st.executeQuery(
                    "SELECT firstName,lastName,emailAdress,subject FROM persons,students," +
                            "groups,groups_teachers,teachers WHERE persons.SSN = teachers.SSN AND " +
                            "teachers.teacherID=groups_teachers.teacherID AND groups_teachers.groupID = " +
                            "groups.groupID AND groups.groupID = students.groupID AND students.SSN = " +
                            "(SELECT SSN FROM persons WHERE loginID = '"+loginID+"')");
            while (rs.next()) {
                String name= rs.getString(1)+"  "+rs.getString(2);

                teachersArray.add(name);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return teachersArray;
    }

    public double getfirstSemesterGrades(String loginID,String subject){
        double grade =0;
        try {
            rs =st.executeQuery(
                    "SELECT gradeOne FROM grades,teachers,students,persons " +
                            "WHERE persons.SSN = students.SSN AND grades.studentID = students.studentID " +
                            "AND persons.loginID = '"+loginID+"' AND grades.teacherID = teachers.teacherID " +
                            "AND teachers.subject = '"+subject+"'"
            );
            while (rs.next()){
                grade = Double.parseDouble(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return grade;
    }


    public double getSecondSemesterGrades(String loginID,String subject){
        double grade =0;
        try {
            rs =st.executeQuery(
                    "SELECT gradeTwo FROM grades,teachers,students,persons " +
                            "WHERE persons.SSN = students.SSN AND grades.studentID = students.studentID " +
                            "AND persons.loginID = '"+loginID+"' AND grades.teacherID = teachers.teacherID " +
                            "AND teachers.subject = '"+subject+"'"
            );
            while (rs.next()){
                grade = Double.parseDouble(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return grade;
    }

    public String getCurrentUserEmail(String loginID){
        String email=null;
        try {
            rs =st.executeQuery(
                    "select EmailAdress from persons where loginID ='"+loginID+"';"
            );
            while (rs.next()){
                email = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return email;
    }

    public String getCurrentUserPassword(String loginID){
        String pass=null;
        try {
            rs =st.executeQuery(
                    "select Password from persons where loginID ='"+loginID+"';"
            );
            while (rs.next()){
                pass = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pass;
    }

    public String principalsName(String position){
        String name=null;
        try {
            rs =st.executeQuery(
                    "SELECT FirstName, LastName FROM persons, admins WHERE persons.SSN = admins.SSN AND admins.Position = '" + position + "'"
            );
            while (rs.next()){
                name = rs.getString(1)+"  "+rs.getString(2);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return name;
    }

    public String getprincipalEmail(String position){
        String email=null;
        try {
            rs =st.executeQuery(
                    "SELECT EmailAdress FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                email = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }
    public String getprincipalTel(String position){
        String tel=null;
        try {
            rs =st.executeQuery(
                    "SELECT PhoneNumber FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                tel = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tel;
    }




    public String getITmanagerlName(String position){
        String name=null;
        try {
            rs =st.executeQuery(
                    "SELECT FirstName,LastName FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                name = rs.getString(1)+"  "+rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
    public String getITmanagerEmail(String position){
        String email=null;
        try {
            rs =st.executeQuery(
                    "SELECT EmailAdress FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                email = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }
    public String getITmanagerTel(String position){
        String tel=null;
        try {
            rs =st.executeQuery(
                    "SELECT PhoneNumber FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                tel = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tel;
    }




    public String getSecretaryName(String position){
        String name=null;
        try {
            rs =st.executeQuery(
                    "SELECT FirstName,LastName FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+" '"
            );
            while (rs.next()){
                name = rs.getString(1)+"  "+rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
    public String getSecretaryEmail(String position){
        String email=null;
        try {
            rs =st.executeQuery(
                    "SELECT EmailAdress FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                email = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }
    public String getSecretaryTel(String position){
        String tel=null;
        try {
            rs =st.executeQuery(
                    "SELECT PhoneNumber FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                tel = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tel;
    }



    public String getHRmanagerName(String position){
        String name=null;
        try {
            rs =st.executeQuery(
                    "SELECT FirstName,LastName FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                name = rs.getString(1)+"  "+rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
    public String getHRmanagerEmail(String position){
        String email=null;
        try {
            rs =st.executeQuery(
                    "SELECT EmailAdress FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                email = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }
    public String getHRmanagerTel(String position){
        String tel="";
        try {
            rs =st.executeQuery(
                    "SELECT PhoneNumber FROM persons,admins WHERE persons.SSN = admins.SSN and admins.Position = '"+position+"'"
            );
            while (rs.next()){
                tel = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tel;
    }

    public String recoveredPassword(String ssn, String email){
        String password = null;
        try {
            rs =st.executeQuery(
                    "SELECT Password FROM persons WHERE SSN = '"+ssn+"' AND EmailAdress = '"+email+"'"
            );
            while (rs.next()){
                password = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }


    public ObservableList<String> teachersName(){
        ObservableList<String>classmatesArray=FXCollections.observableArrayList();
        try {
            rs = st.executeQuery(
                    "SELECT FirstName,LastName FROM persons,teachers WHERE persons.SSN = teachers.SSN");
            while (rs.next()) {
                String name= rs.getString(1)+"  "+rs.getString(2);
                classmatesArray.add(name);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return classmatesArray;
    }

    public ObservableList<String> adminsName(){
        ObservableList<String>classmatesArray=FXCollections.observableArrayList();
        try {
            rs = st.executeQuery(
                    "SELECT FirstName,LastName FROM persons,admins WHERE persons.SSN = admins.SSN");
            while (rs.next()) {
                String name= rs.getString(1)+"  "+rs.getString(2);
                classmatesArray.add(name);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return classmatesArray;
    }

    public  ObservableList<String> studentNamesByGroup(String groupID){
        ObservableList<String>studentNames = FXCollections.observableArrayList();
        try {
            rs = st.executeQuery("SELECT FirstName,LastName FROM persons,students WHERE persons.SSN = students.SSN AND students.GroupID = '"+groupID+"'");
            while (rs.next()) {
                String name = rs.getString(1)+"  "+rs.getString(2);
                studentNames.add(name);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return studentNames;
    }

}


