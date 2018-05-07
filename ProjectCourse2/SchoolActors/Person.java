package sample.SchoolActors;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private IntegerProperty SSN= new SimpleIntegerProperty(this,"SSN");
    private StringProperty name = new SimpleStringProperty(this,"name");
    private StringProperty surname = new SimpleStringProperty(this,"surname");
    private StringProperty dateOfBirth = new SimpleStringProperty(this,"dateOfBirth");
    private StringProperty gender= new SimpleStringProperty(this,"gender");
    private StringProperty homeAddress = new SimpleStringProperty(this,"homeAddress");
    private StringProperty emailAddress = new SimpleStringProperty(this,"emailAddress");


    public Person(){}

    public Person(IntegerProperty SSN, StringProperty name, StringProperty surname, StringProperty dateOfBirth, StringProperty gender, StringProperty homeAddress, StringProperty emailAddress) {
        this.SSN = SSN;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.homeAddress = homeAddress;
        this.emailAddress = emailAddress;
    }

    public int getSSN() {
        return SSN.get();
    }

    public IntegerProperty SSNProperty() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN.set(SSN);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getDateOfBirth() {
        return dateOfBirth.get();
    }

    public StringProperty dateOfBirthProperty() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getHomeAddress() {
        return homeAddress.get();
    }

    public StringProperty homeAddressProperty() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress.set(homeAddress);
    }

    public String getEmailAddress() {
        return emailAddress.get();
    }

    public StringProperty emailAddressProperty() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress.set(emailAddress);
    }
}
