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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.SystemUsers.Staff;
import sample.SystemUsers.Student;
import sample.SystemUsers.Teacher;

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

    public static ObservableList<Teacher> getTeacherInfo() {
        ObservableList result = FXCollections.observableArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT firstname, lastname, emailadress, phonenumber, address, subject FROM persons, teachers WHERE persons.ssn = teachers.ssn");

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
            ResultSet resultSet = statement.executeQuery("SELECT firstname, lastname, emailadress, phonenumber, address, job FROM persons, staff WHERE persons.ssn = staff.ssn");

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
}
