package sample.SchoolActors;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AdminMember extends Person {

    private StringProperty passWord = new SimpleStringProperty(this,"password");
    private StringProperty userName = new SimpleStringProperty(this,"userName");
    private StringProperty phoneNum = new SimpleStringProperty(this,"phoneNum");
    private StringProperty position = new SimpleStringProperty(this,"position");


    public AdminMember(){super();}

    public AdminMember(StringProperty passWord,StringProperty userName, StringProperty phoneNum,StringProperty position) {
        this.passWord = passWord;
        this.userName=userName;
        this.phoneNum = phoneNum;
        this.position=position;
    }

    public AdminMember(IntegerProperty SSN, StringProperty name, StringProperty surname, StringProperty dateOfBirth, StringProperty gender, StringProperty homeAddress, StringProperty emailAddress, StringProperty passWord,StringProperty userName,StringProperty phoneNum,StringProperty position) {
        super(SSN, name, surname, dateOfBirth, gender, homeAddress, emailAddress);
        this.passWord = passWord;
        this.userName=userName;
        this.phoneNum = phoneNum;
        this.position=position;
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

    public String getPassWord() {
        return passWord.get();
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

    public String getPosition() {
        return position.get();
    }

    public StringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }
}
