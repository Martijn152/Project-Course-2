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
//WORK IN PROGRESS BELOW
 /*   public static void editTeachers(ObservableList<Teacher> editedList) {
        try {
            for(int i = 0; i < editedList.size(); i++) {
                System.out.println("SSN of person in edit: ");
                System.out.println(editedList.get(i).getSSN());
                ArrayList list = getTeacherID(editedList);
                statement.execute("DELETE FROM teachers WHERE teacherid = " + list.get(i));

                System.out.println("Deleted from teachers table");

                statement.execute("DELETE FROM persons WHERE ssn = '" + editedList.get(i).getSSN() + "'");

                System.out.println("Deleted from persons table");

                statement.execute("" +
                        "INSERT INTO persons (ssn, firstname, lastname, dateofbirth, address, phonenumber, loginid, password, emailadress)" +
                        "VALUES ('" +
                        editedList.get(i).getSSN() + "','" +
                        editedList.get(i).getName() + "','" +
                        editedList.get(i).getSurname() + "','" +
                        editedList.get(i).getDateOfBirth() + "','" +
                        editedList.get(i).getHomeAddress() + "','" +
                        editedList.get(i).getPhoneNum() + "','" +
                        editedList.get(i).getUserName() + "','" +
                        editedList.get(i).getPassWord() + "','" +
                        editedList.get(i).getEmailAddress() + "')");

                statement.execute("INSERT INTO teachers (ssn, subject)" +
                        "VALUES ((SELECT persons.ssn FROM persons WHERE ssn = '" + editedList.get(i).getSSN() + "'),'" + editedList.get(i).getTeachingField() + "');");
            }
        } catch (SQLException var4) {
            System.out.println("Something went wrong...");
            var4.printStackTrace();
        }

    }

    public static ArrayList getTeacherID(ObservableList<Teacher> editedList) {
        ArrayList<String> teacherIDList = new ArrayList<>();
        try {
            for(int i = 0; i < editedList.size(); i++) {
                System.out.println("SSN of person in getID: " + editedList.get(i).getSSN());
                teacherIDList.add(statement.executeQuery("SELECT teacherid FROM teachers WHERE ssn = " + editedList.get(i).getSSN()).getString(1));
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
        return teacherIDList;
    }*/
}
