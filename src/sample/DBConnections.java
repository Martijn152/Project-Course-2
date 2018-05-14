//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.SystemUsers.Grades;
import sample.SystemUsers.Staff;
import sample.SystemUsers.Student;
import sample.SystemUsers.Teacher;

public class DBConnections {
    private static Statement statement;
    public static String sub = null;
    private static String tid = null;

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

            while (resultSet.next()) {
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

            while (resultSet.next()) {
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

            while (resultSet.next()) {
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
            for (ResultSet resultSet = statement.executeQuery("SELECT id FROM admins, persons WHERE admins.ssn = persons.ssn AND persons.ssn = '" + SSN + "'"); resultSet.next(); result = true) {
                ;
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return result;
    }

    public static boolean isteacher(String username, String password) {

        ResultSet rs = null;


        try {
            String q1 = "SELECT SSN,FirstName,LastName FROM persons WHERE LoginID='" + username + "' && Password='" + password + "'";
            rs = statement.executeQuery(q1);
            String ssn = "";
            String tname = "";
            if (rs.next()) {
                ssn = rs.getString("SSN");
                tname = rs.getString(2) + " " + rs.getString(3);
            } else {
                return false;
            }
            q1 = "SELECT Subject,teacherid From teachers WHERE SSN='" + ssn + "'";
            rs = statement.executeQuery(q1);

            if (rs.next()) {
                sub = rs.getString(1);
                tid = rs.getString(2);
                TeachersLogIn.createfileteacher(tname, ssn, sub, tid);
                return true;
            } else {
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
            ResultSet resultSet = statement.executeQuery("SELECT firstname, lastname, emailadress, phonenumber, address, subject FROM persons, teachers WHERE persons.ssn = teachers.ssn");

            while (resultSet.next()) {
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
            ResultSet resultSet = statement.executeQuery("SELECT firstname, lastname, emailadress, phonenumber, address, subject FROM persons, teachers WHERE persons.ssn = teachers.ssn");

            while (resultSet.next()) {
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

            while (resultSet.next()) {
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

            while (resultSet.next()) {
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

            while (resultSet.next()) {
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
                    "VALUES ((SELECT persons.ssn FROM persons WHERE ssn = '" + newTeacher.getSSN() + "'),'" + newTeacher.getTeachingField() + "');");

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
                    "VALUES ((SELECT persons.ssn FROM persons WHERE ssn = '" + newStaff.getSSN() + "'),'" + newStaff.getPosition() + "');");

        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    /**
     * This method will return the grades in the ObservableList.
     * @return ObservableList
     */
    public static ObservableList<Grades> getGradeInfo() {

        ObservableList result = FXCollections.observableArrayList();
        String gradeyear = openfilegrade();
        System.out.println(gradeyear);

        try {
            ResultSet resultSet = statement.executeQuery("SELECT p.SSN,p.FirstName,p.EmailAdress,g.GradeOne,g.GradeTwo FROM " +
                    "persons p,grades g,groups gp,groups_teachers gt,teachers t,students s " +
                    "WHERE gp.Year='"+gradeyear+"' AND gp.GroupID=gt.GroupID AND " +
                    "gt.TeacherID=t.teacherid " +
                    "AND p.SSN = s.SSN AND g.studentID = s.studentID AND " +
                    "g.teacherID = t.teacherID AND t.teacherID = "+tid+" " +
                    "AND t.subject = '"+sub+"'");

/*            ResultSet resultSet = statement.executeQuery("select ssn,FirstName,EmailAdress from persons where SSN in " +
                    "(select ssn from students where GroupID in " +
                    "(select GroupID from groups where Year='" + gradeyear + "' ));");*/


            while (resultSet.next()) {
                Grades staff = new Grades();
                staff.setSSN(resultSet.getString(1));
                staff.setName(resultSet.getString(2));
                staff.setEmailAdress(resultSet.getString(3));
                staff.setMgrade1(resultSet.getDouble(4));
                staff.setMgrade2(resultSet.getDouble(5));
                result.add(staff);
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return result;
    }

    public static String openfilegrade() {
        String fileName = "grade.txt";

        // This will reference one line at a time
        String line = null;
        String username = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (i == 0) {
                    System.out.println(line);
                    username = line;
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

    public static ArrayList<String> getAdminInfo() {
        ArrayList<String> Admininfo = new ArrayList<String>();
        try {
            ResultSet resultSet = statement.executeQuery("select FirstName,EmailAdress,PhoneNumber from persons where SSN = \n" +
                    "(select SSN from admins where position = 'Principal');");

            while (resultSet.next()) {
                Admininfo.add(resultSet.getString(1));
                Admininfo.add(resultSet.getString(2));
                Admininfo.add(resultSet.getString(3));
            }
            resultSet = statement.executeQuery("select FirstName,EmailAdress,PhoneNumber from persons where SSN = \n" +
                    "(select SSN from admins where position = 'IT Manager');");

            while (resultSet.next()) {
                Admininfo.add(resultSet.getString(1));
                Admininfo.add(resultSet.getString(2));
                Admininfo.add(resultSet.getString(3));
            }
            resultSet = statement.executeQuery("select FirstName,EmailAdress,PhoneNumber from persons where SSN = \n" +
                    "(select SSN from admins where position = 'General Secretary');");

            while (resultSet.next()) {
                Admininfo.add(resultSet.getString(1));
                Admininfo.add(resultSet.getString(2));
                Admininfo.add(resultSet.getString(3));
            }
            resultSet = statement.executeQuery("select FirstName,EmailAdress,PhoneNumber from persons where SSN = \n" +
                    "(select SSN from admins where position = 'Human Resources Manager');");

            while (resultSet.next()) {
                Admininfo.add(resultSet.getString(1));
                Admininfo.add(resultSet.getString(2));
                Admininfo.add(resultSet.getString(3));
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return Admininfo;
    }

    public static boolean updatePass(String login, String email, String pass) {
        try {
            int i = statement.executeUpdate("" +
                    "UPDATE persons\n" +
                    "SET Password =" + "'" + pass + "'" + "\n" +
                    "WHERE LoginID= " + "'" + login + "'" + " and Password=" + "'" + email + "'" + ";");
            if (i > 0) {

                return true;
            } else {
                return false;
            }
        } catch (SQLException var4) {

            var4.printStackTrace();
            return false;
        }


    }

    /**
     * This method will search the persons data from database.
     * if any data is found then it will return the string with data
     * else it will return the empty string
     *
     *
     */
    public static String getSearchResult(String name){
        String list = "";
        try {
            ResultSet resultSet = statement.executeQuery("select ssn,FirstName,LastName,PhoneNumber,EmailAdress " +
                    "from persons where FirstName LIKE '"+name+"%'");

            while (resultSet.next()) {
                list += resultSet.getString(1)+"\t\t\t"+resultSet.getString(2)+"\t\t\t"+
                        resultSet.getString(3)+"\t\t\t"+resultSet.getString(4)
                        +"\t\t\t"+resultSet.getString(5)+"\n";
            }
            System.out.println("size : "+list);
        } catch (SQLException var3) {
            list ="";
            var3.printStackTrace();
        }
        return list;
    }


}
