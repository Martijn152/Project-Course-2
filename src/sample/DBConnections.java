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

    String url="jdbc:mysql://den1.mysql3.gear.host:3306/projectcourse2";
    Statement st = null;
    ResultSet rs = null;

    String user = "projectcourse2";
    String password = "Cg25k9o3?!3l";
    String groupID;
    String firstname;
    String name;

    public void DBconnect(){
            try{
                Connection connection = DriverManager.getConnection(url,user,password);
                st=connection.createStatement();
            }
            catch (SQLException ex){
                System.out.println("Failed to connect "+ ex.getMessage());
            }
        }


        public ObservableList<Classmate> getClassmate(String groupID){
        DBconnect();
        ObservableList<Classmate>classmatesArray=FXCollections.observableArrayList();
            try {
                rs = st.executeQuery(
                        "SELECT FirstName,LastName,EmailAdress FROM persons,students WHERE persons.SSN=students.SSN AND students.GroupID = '" + groupID + "';");
                while (rs.next()) {
                    String name= rs.getString(1)+" "+rs.getString(2);
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

    public  String getStudentGroup(String loginID){
        DBconnect();
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
        DBconnect();
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
        DBconnect();
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

    public ObservableList<TeacherGroupedByGroup> getTeacher(String loginID){
        DBconnect();
        ObservableList<TeacherGroupedByGroup>teachersArray=FXCollections.observableArrayList();
        try {
            rs = st.executeQuery(
                    "SELECT firstName,lastName,emailAdress,subject FROM persons,students," +
                            "groups,groups_teachers,teachers WHERE persons.SSN = teachers.SSN AND " +
                            "teachers.teacherID=groups_teachers.teacherID AND groups_teachers.groupID = " +
                            "groups.groupID AND groups.groupID = students.groupID AND students.SSN = " +
                            "(SELECT SSN FROM persons WHERE loginID = '"+loginID+"')");
            while (rs.next()) {
                String name= rs.getString(1)+" "+rs.getString(2);
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

//    public void changePassword(String newPass,String loginD){
//        try {
//            rs=st.executeQuery(
//                    "UPDATE persons SET password = '"+newPass+"' WHERE password = '"+oldPass+"';"
//            );
//        }catch (SQLClientInfoException e){
//            Alert error=new Alert(Alert.AlertType.ERROR);
//            error.setHeaderText("      OLD PASS NOT RECOGNISED");
//            error.setContentText("MAKE SURE YOU HAVE ENTERED THE CORRECT OLD PASS VALUE!");
//            error.show();
//            }catch (SQLException e){
//        e.printStackTrace();
//        }
    }


