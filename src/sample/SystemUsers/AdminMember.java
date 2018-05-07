package sample.SystemUsers;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AdminMember extends Person {

    private StringProperty position = new SimpleStringProperty(this,"position");


    public AdminMember(){super();}

    public AdminMember(StringProperty position) {
        this.position = position;
    }

    public AdminMember(IntegerProperty SSN, StringProperty name, StringProperty surname, StringProperty dateOfBirth, StringProperty gender, StringProperty homeAddress, StringProperty emailAddress, StringProperty ICENumber, StringProperty logingID, StringProperty password, StringProperty phoneNum, StringProperty position) {
        super(SSN, name, surname, dateOfBirth, gender, homeAddress, emailAddress, ICENumber, logingID, password, phoneNum);
        this.position = position;
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

