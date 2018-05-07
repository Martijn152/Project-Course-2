package sample.SchoolActors;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Staff extends Person {

    private StringProperty password = new SimpleStringProperty(this,"password");
    private StringProperty userName = new SimpleStringProperty(this,"userName");
    private StringProperty phoneNum = new SimpleStringProperty(this,"phoneNum");


    public Staff(){super();}

    public Staff(StringProperty password,StringProperty userName,StringProperty phoneNum) {
        this.password = password;
        this.userName=userName;
        this.phoneNum = phoneNum;
    }

    public Staff(IntegerProperty SSN, StringProperty name, StringProperty surname, StringProperty dateOfBirth,
                 StringProperty gender, StringProperty homeAddress, StringProperty emailAddress, StringProperty password,StringProperty userName,
                 StringProperty phoneNum) {
        super(SSN, name, surname, dateOfBirth, gender, homeAddress, emailAddress);
        this.password = password;
        this.userName = userName;
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
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

    public String getPhoneNum() {
        return phoneNum.get();
    }

    public StringProperty phoneNumProperty() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum.set(phoneNum);
    }
}
