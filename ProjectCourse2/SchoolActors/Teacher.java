package sample.SchoolActors;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Teacher extends Person {

    private StringProperty passWord = new SimpleStringProperty(this,"password");
    private StringProperty userName = new SimpleStringProperty(this,"userName");
    private StringProperty teachingField = new SimpleStringProperty(this,"teachingField");
    private StringProperty phoneNum = new SimpleStringProperty(this,"phoneNum");
    private Group[]gradeYearList;


    public Teacher(){super();}

    public Teacher(StringProperty passWord ,StringProperty userName, StringProperty teachingField, StringProperty phoneNum, Group[] gradeYearList) {
        this.passWord = passWord;
        this.userName=userName;
        this.teachingField = teachingField;
        this.phoneNum = phoneNum;
        this.gradeYearList = gradeYearList;
    }

    public Teacher(IntegerProperty SSN, StringProperty name, StringProperty surname, StringProperty dateOfBirth, StringProperty gender, StringProperty homeAddress, StringProperty emailAddress, StringProperty passWord,StringProperty userName,StringProperty teachingField, StringProperty phoneNum, Group[] gradeYearList) {
        super(SSN, name, surname, dateOfBirth, gender, homeAddress, emailAddress);
        this.passWord = passWord;
        this.userName=userName;
        this.teachingField = teachingField;
        this.phoneNum = phoneNum;
        this.gradeYearList = gradeYearList;
    }

    public String getPassWord() {
        return passWord.get();
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

    public String getPhoneNum() {
        return phoneNum.get();
    }

    public StringProperty phoneNumProperty() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum.set(phoneNum);
    }

    public Group[] getGradeYearList() {
        return gradeYearList;
    }

    public void setGradeYearList(Group[] gradeYearList) {
        this.gradeYearList = gradeYearList;
    }

    public StringProperty passWordProperty() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord.set(passWord);
    }

    public String getUserName() {
        return userName.get();
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }
}
