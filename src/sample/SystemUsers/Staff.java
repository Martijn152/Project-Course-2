package sample.SystemUsers;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Staff extends Person {

    private StringProperty ID = new SimpleStringProperty(this,"ID");
    private StringProperty position = new SimpleStringProperty(this,"position");



    public Staff(){super();}

    public Staff(StringProperty ID, StringProperty position) {
        this.ID = ID;
        this.position = position;
    }

    public Staff(IntegerProperty SSN, StringProperty name, StringProperty surname, StringProperty dateOfBirth, StringProperty gender, StringProperty homeAddress, StringProperty emailAddress, StringProperty ICENumber, StringProperty logingID, StringProperty password, StringProperty phoneNum, StringProperty ID, StringProperty position) {
        super(SSN, name, surname, dateOfBirth, gender, homeAddress, emailAddress, ICENumber, logingID, password, phoneNum);
        this.ID = ID;
        this.position = position;
    }

    public String getID() {
        return ID.get();
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
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
