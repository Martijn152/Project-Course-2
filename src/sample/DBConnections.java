//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jdk.nashorn.internal.runtime.Version;
import sample.SystemUsers.*;

public class DBConnections {
    private static Statement statement;

    public DBConnections() {
    }

    public static void connect() {
        try {
            String url = "jdbc:mysql://den1.mysql3.gear.host:3306/projectcourse2";
            Connection connection = DriverManager.getConnection(url, "projectcourse2", "Cg25k9o3?!3l");
            statement = connection.createStatement();
        } catch (SQLException var2) {
            System.out.println("Connection failed.");
            var2.printStackTrace();
        }

    }

    public static ArrayList<String> getLoginID() {
        ArrayList result = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT loginid FROM persons");

            while(resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return result;
    }

    public static ArrayList<String> getPassword() {
        ArrayList result = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT password FROM persons");

            while(resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return result;
    }

    public static ArrayList<String> getSSN() {
        ArrayList result = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT ssn FROM persons");

            while(resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return result;
    }

    public static boolean isAdmin(String SSN) {
        boolean result = false;

        try {
            for(ResultSet resultSet = statement.executeQuery("SELECT id FROM admins, persons WHERE admins.ssn = persons.ssn AND persons.ssn = '" + SSN + "'"); resultSet.next(); result = true) {
                ;
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return result;
    }

    public static boolean isteacher(String username,String password){

        ResultSet rs=null;

        try {
            String q1="SELECT SSN FROM persons WHERE LoginID='"+username+"' && Password='"+password +"'";
            rs=statement.executeQuery(q1);
            String ssn="";

            if(rs.next()){
                ssn=rs.getString("SSN");
            }
            else{
                return false;
            }
            q1="SELECT * From teachers WHERE SSN='"+ssn+"'";
            rs = statement.executeQuery(q1);

            if(rs.next()){
                return true;
            }
            else{
                return false;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;

    }

    public static ObservableList<Teacher> getTeacherInfo() {
        ObservableList result = FXCollections.observableArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT firstname, lastname, emailadress, phonenumber," +
                    " address, subject FROM persons, teachers WHERE persons.ssn = teachers.ssn");

            while(resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setName(resultSet.getString(1));
                teacher.setSurname(resultSet.getString(2));
                teacher.setEmailAddress(resultSet.getString(3));
                teacher.setPhoneNum(resultSet.getString(4));
                teacher.setHomeAddress(resultSet.getString(5));
                teacher.setTeachingField(resultSet.getString(6));
                result.add(teacher);
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return result;
    }
    public static ObservableList<Teacher> getTeacherInfo2() {
        ObservableList result = FXCollections.observableArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT firstname, lastname, emailadress," +
                    " phonenumber, address, subject FROM persons, teachers WHERE persons.ssn = teachers.ssn");

            while(resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setName(resultSet.getString(1));
                teacher.setSurname(resultSet.getString(2));
                teacher.setEmailAddress(resultSet.getString(3));
                teacher.setPhoneNum(resultSet.getString(4));
                teacher.setHomeAddress(resultSet.getString(5));
                teacher.setTeachingField(resultSet.getString(6));
                result.add(teacher);
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return result;
    }

    public static ObservableList<Staff> getStaffInfo() {
        ObservableList result = FXCollections.observableArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT firstname, lastname, emailadress," +
                    " phonenumber, address, job FROM persons, staff WHERE persons.ssn = staff.ssn");

            while(resultSet.next()) {
                Staff staff = new Staff();
                staff.setName(resultSet.getString(1));
                staff.setSurname(resultSet.getString(2));
                staff.setEmailAddress(resultSet.getString(3));
                staff.setPhoneNum(resultSet.getString(4));
                staff.setHomeAddress(resultSet.getString(5));
                staff.setPosition(resultSet.getString(6));
                result.add(staff);
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return result;
    }

    public static ObservableList<Student> getStudentInfo(String selectedGroup) {
        ObservableList result = FXCollections.observableArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT persons.SSN, firstname, lastname, dateofbirth, emailadress, phonenumber, address FROM persons, students, groups WHERE persons.ssn = students.ssn AND students.groupid = groups.groupid AND groups.groupid = '" + selectedGroup + "'");

            while(resultSet.next()) {
                Student student = new Student();
                student.setSSN(resultSet.getString(1));
                student.setName(resultSet.getString(2));
                student.setSurname(resultSet.getString(3));
                student.setDateOfBirth(resultSet.getString(4));
                student.setEmailAddress(resultSet.getString(5));
                student.setHomeAddress(resultSet.getString(6));
                result.add(student);
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return result;
    }

    public static ObservableList<Teacher> getTeacherInfoGroup(String selectedGroup) {
        ObservableList result = FXCollections.observableArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT subject, firstname, lastname, emailadress, phonenumber FROM persons, teachers, groups, groups_teachers WHERE persons.ssn = teachers.ssn AND teachers.teacherid = groups_teachers.teacherid AND groups_teachers.groupid = groups.groupid AND groups.groupid = '" + selectedGroup + "'");

            while(resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeachingField(resultSet.getString(1));
                teacher.setName(resultSet.getString(2));
                teacher.setSurname(resultSet.getString(3));
                teacher.setEmailAddress(resultSet.getString(4));
                teacher.setPhoneNum(resultSet.getString(5));
                result.add(teacher);
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return result;
    }

    public static void addTeacher(Teacher newTeacher) {
        try {
            statement.execute("" +
                    "INSERT INTO persons (ssn, firstname, lastname, dateofbirth, address, phonenumber, loginid, password, emailadress)" +
                    "VALUES ('" +
                    newTeacher.getSSN() + "','" +
                    newTeacher.getName() + "','" +
                    newTeacher.getSurname() + "','" +
                    newTeacher.getDateOfBirth() + "','" +
                    newTeacher.getHomeAddress() + "','" +
                    newTeacher.getPhoneNum() + "','" +
                    newTeacher.getUserName() + "','" +
                    newTeacher.getPassWord() + "','" +
                    newTeacher.getEmailAddress() + "')");

            statement.execute("INSERT INTO teachers (ssn, subject)" +
                    "VALUES ((SELECT persons.ssn FROM persons WHERE ssn = '" + newTeacher.getSSN() + "'),'" + newTeacher.getTeachingField() +"');");

        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public static void addStaff(Staff newStaff) {
        try {
            statement.execute("" +
                    "INSERT INTO persons (ssn, firstname, lastname, dateofbirth, address, phonenumber, loginid, password, emailadress)" +
                    "VALUES ('" +
                    newStaff.getSSN() + "','" +
                    newStaff.getName() + "','" +
                    newStaff.getSurname() + "','" +
                    newStaff.getDateOfBirth() + "','" +
                    newStaff.getHomeAddress() + "','" +
                    newStaff.getPhoneNum() + "','" +
                    newStaff.getUserName() + "','" +
                    newStaff.getPassword() + "','" +
                    newStaff.getEmailAddress() + "')");

            statement.execute("INSERT INTO staff (ssn, job)" +
                    "VALUES ((SELECT persons.ssn FROM persons WHERE ssn = '" + newStaff.getSSN() + "'),'" + newStaff.getPosition() +"');");

        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

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


