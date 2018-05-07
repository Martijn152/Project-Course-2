package sample.SchoolActors;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Group {

    private StringProperty gradeYearName=new SimpleStringProperty("gradeYearName");
    private Teacher[] teachers;
    private ArrayList<Student>students;

    public Group(StringProperty gradeYearName, Teacher[] teachers, ArrayList<Student> students) {
        this.gradeYearName = gradeYearName;
        this.teachers = teachers;
        this.students = students;
    }

    public String getGradeYearName() {
        return gradeYearName.get();
    }

    public StringProperty gradeYearNameProperty() {
        return gradeYearName;
    }

    public void setGradeYearName(String gradeYearName) {
        this.gradeYearName.set(gradeYearName);
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
