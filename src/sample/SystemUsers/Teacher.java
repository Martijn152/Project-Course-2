package sample.SystemUsers;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Teacher extends Person {


    private StringProperty teachingField = new SimpleStringProperty(this,"teachingField");

    private Group[]gradeYearList;


    public Teacher(){super();}

    public Teacher(StringProperty teachingField, Group[] gradeYearList) {
        this.teachingField = teachingField;
        this.gradeYearList = gradeYearList;
    }

    public Teacher(IntegerProperty SSN, StringProperty name, StringProperty surname, StringProperty dateOfBirth, StringProperty gender, StringProperty homeAddress, StringProperty emailAddress, StringProperty ICENumber, StringProperty logingID, StringProperty password, StringProperty phoneNum, StringProperty teachingField, Group[] gradeYearList) {
        super(SSN, name, surname, dateOfBirth, gender, homeAddress, emailAddress, ICENumber, logingID, password, phoneNum);
        this.teachingField = teachingField;
        this.gradeYearList = gradeYearList;
    }

    public String getTeachingField() {
        return teachingField.get();
    }

    public StringProperty teachingFieldProperty() {
        return teachingField;
    }

    public void setTeachingField(String teachingField) {
        this.teachingField.set(teachingField);
    }

    public Group[] getGradeYearList() {
        return gradeYearList;
    }

    public void setGradeYearList(Group[] gradeYearList) {
        this.gradeYearList = gradeYearList;
    }
}
