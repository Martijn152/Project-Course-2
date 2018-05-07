//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample.SystemUsers;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student extends Person {
    private StringProperty parentName = new SimpleStringProperty(this, "parentName");
    private StringProperty parentEmail = new SimpleStringProperty(this, "parentEmail");
    private StringProperty parentPhoneNum = new SimpleStringProperty(this, "parentPhoneNum");
    private StringProperty group = new SimpleStringProperty(this, "group");
    private StringProperty passWord = new SimpleStringProperty(this, "password");
    private StringProperty userName = new SimpleStringProperty(this, "userName");
    private DoubleProperty firstSemester = new SimpleDoubleProperty(this, "firstSemester");
    private DoubleProperty biology1 = new SimpleDoubleProperty(this, "biology1");
    private DoubleProperty maths1 = new SimpleDoubleProperty(this, "maths1");
    private DoubleProperty chemistry1 = new SimpleDoubleProperty(this, "chemistry1");
    private DoubleProperty english1 = new SimpleDoubleProperty(this, "english1");
    private DoubleProperty physics1 = new SimpleDoubleProperty(this, "physics");
    private DoubleProperty philosophy1 = new SimpleDoubleProperty(this, "philosophy1");
    private DoubleProperty secondSemester = new SimpleDoubleProperty(this, "secondSemester");
    private DoubleProperty biology2 = new SimpleDoubleProperty(this, "biology2");
    private DoubleProperty maths2 = new SimpleDoubleProperty(this, "maths2");
    private DoubleProperty chemistry2 = new SimpleDoubleProperty(this, "chemistry2");
    private DoubleProperty english2 = new SimpleDoubleProperty(this, "english2");
    private DoubleProperty physics2 = new SimpleDoubleProperty(this, "physics2");
    private DoubleProperty philosophy2 = new SimpleDoubleProperty(this, "philosophy2");

    public Student() {
    }

    public Student(StringProperty parentName, StringProperty parentEmail, StringProperty parentPhoneNum, StringProperty group, StringProperty passWord, StringProperty userName, DoubleProperty firstSemester, DoubleProperty biology1, DoubleProperty maths1, DoubleProperty chemistry1, DoubleProperty english1, DoubleProperty physics1, DoubleProperty philosophy1, DoubleProperty secondSemester, DoubleProperty biology2, DoubleProperty maths2, DoubleProperty chemistry2, DoubleProperty english2, DoubleProperty physics2, DoubleProperty philosophy2) {
        this.parentName = parentName;
        this.parentEmail = parentEmail;
        this.parentPhoneNum = parentPhoneNum;
        this.group = group;
        this.passWord = passWord;
        this.userName = userName;
        this.firstSemester = firstSemester;
        this.biology1 = biology1;
        this.maths1 = maths1;
        this.chemistry1 = chemistry1;
        this.english1 = english1;
        this.physics1 = physics1;
        this.philosophy1 = philosophy1;
        this.secondSemester = secondSemester;
        this.biology2 = biology2;
        this.maths2 = maths2;
        this.chemistry2 = chemistry2;
        this.english2 = english2;
        this.physics2 = physics2;
        this.philosophy2 = philosophy2;
    }

    public Student(StringProperty SSN, StringProperty name, StringProperty surname, StringProperty dateOfBirth, StringProperty gender, StringProperty homeAddress, StringProperty emailAddress, StringProperty parentName, StringProperty parentEmail, StringProperty parentPhoneNum, StringProperty group, StringProperty passWord, StringProperty userName, DoubleProperty firstSemester, DoubleProperty biology1, DoubleProperty maths1, DoubleProperty chemistry1, DoubleProperty english1, DoubleProperty physics1, DoubleProperty philosophy1, DoubleProperty secondSemester, DoubleProperty biology2, DoubleProperty maths2, DoubleProperty chemistry2, DoubleProperty english2, DoubleProperty physics2, DoubleProperty philosophy2) {
        super(SSN, name, surname, dateOfBirth, gender, homeAddress, emailAddress);
        this.parentName = parentName;
        this.parentEmail = parentEmail;
        this.parentPhoneNum = parentPhoneNum;
        this.group = group;
        this.passWord = passWord;
        this.userName = userName;
        this.firstSemester = firstSemester;
        this.biology1 = biology1;
        this.maths1 = maths1;
        this.chemistry1 = chemistry1;
        this.english1 = english1;
        this.physics1 = physics1;
        this.philosophy1 = philosophy1;
        this.secondSemester = secondSemester;
        this.biology2 = biology2;
        this.maths2 = maths2;
        this.chemistry2 = chemistry2;
        this.english2 = english2;
        this.physics2 = physics2;
        this.philosophy2 = philosophy2;
    }

    public String getParentName() {
        return (String)this.parentName.get();
    }

    public StringProperty parentNameProperty() {
        return this.parentName;
    }

    public void setParentName(String parentName) {
        this.parentName.set(parentName);
    }

    public String getParentEmail() {
        return (String)this.parentEmail.get();
    }

    public StringProperty parentEmailProperty() {
        return this.parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail.set(parentEmail);
    }

    public String getParentPhoneNum() {
        return (String)this.parentPhoneNum.get();
    }

    public StringProperty parentPhoneNumProperty() {
        return this.parentPhoneNum;
    }

    public void setParentPhoneNum(String parentPhoneNum) {
        this.parentPhoneNum.set(parentPhoneNum);
    }

    public String getUserName() {
        return (String)this.userName.get();
    }

    public StringProperty userNameProperty() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public StringProperty getGradeYear() {
        return this.group;
    }

    public void setGradeYear(String group) {
        this.group.set(group); }

    public String getPassWord() {
        return (String)this.passWord.get();
    }

    public StringProperty passWordProperty() {
        return this.passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord.set(passWord);
    }

    public double getPhysics1() {
        return this.physics1.get();
    }

    public DoubleProperty physics1Property() {
        return this.physics1;
    }

    public void setPhysics1(double physics1) {
        this.physics1.set(physics1);
    }

    public double getPhysics2() {
        return this.physics2.get();
    }

    public DoubleProperty physics2Property() {
        return this.physics2;
    }

    public void setPhysics2(double physics2) {
        this.physics2.set(physics2);
    }

    public double getFirstSemester() {
        return this.firstSemester.get();
    }

    public DoubleProperty firstSemesterProperty() {
        return this.firstSemester;
    }

    public void setFirstSemester(double firstSemester) {
        firstSemester = (this.maths1.doubleValue() + this.biology1.doubleValue() + this.chemistry1.doubleValue() + this.philosophy1.doubleValue() + this.physics1.doubleValue() + this.english1.doubleValue()) / 4.0D;
        this.firstSemester.set(firstSemester);
    }

    public double getBiology1() {
        return this.biology1.get();
    }

    public DoubleProperty biology1Property() {
        return this.biology1;
    }

    public void setBiology1(double biology1) {
        this.biology1.set(biology1);
    }

    public double getMaths1() {
        return this.maths1.get();
    }

    public DoubleProperty maths1Property() {
        return this.maths1;
    }

    public void setMaths1(double maths1) {
        this.maths1.set(maths1);
    }

    public double getChemistry1() {
        return this.chemistry1.get();
    }

    public DoubleProperty chemistry1Property() {
        return this.chemistry1;
    }

    public void setChemistry1(double chemistry1) {
        this.chemistry1.set(chemistry1);
    }

    public double getEnglish1() {
        return this.english1.get();
    }

    public DoubleProperty english1Property() {
        return this.english1;
    }

    public void setEnglish1(double english1) {
        this.english1.set(english1);
    }

    public double getPhilosophy1() {
        return this.philosophy1.get();
    }

    public DoubleProperty philosophy1Property() {
        return this.philosophy1;
    }

    public void setPhilosophy1(double philosophy1) {
        this.philosophy1.set(philosophy1);
    }

    public double getSecondSemester() {
        return this.secondSemester.get();
    }

    public DoubleProperty secondSemesterProperty() {
        return this.secondSemester;
    }

    public void setSecondSemester(double secondSemester) {
        secondSemester = (this.maths2.doubleValue() + this.biology2.doubleValue() + this.chemistry2.doubleValue() + this.philosophy2.doubleValue() + this.physics2.doubleValue() + this.english2.doubleValue()) / 4.0D;
        this.secondSemester.set(secondSemester);
    }

    public double getBiology2() {
        return this.biology2.get();
    }

    public DoubleProperty biology2Property() {
        return this.biology2;
    }

    public void setBiology2(double biology2) {
        this.biology2.set(biology2);
    }

    public double getMaths2() {
        return this.maths2.get();
    }

    public DoubleProperty maths2Property() {
        return this.maths2;
    }

    public void setMaths2(double maths2) {
        this.maths2.set(maths2);
    }

    public double getChemistry2() {
        return this.chemistry2.get();
    }

    public DoubleProperty chemistry2Property() {
        return this.chemistry2;
    }

    public void setChemistry2(double chemistry2) {
        this.chemistry2.set(chemistry2);
    }

    public double getEnglish2() {
        return this.english2.get();
    }

    public DoubleProperty english2Property() {
        return this.english2;
    }

    public void setEnglish2(double english2) {
        this.english2.set(english2);
    }

    public double getLiterature2() {
        return this.physics2.get();
    }

    public DoubleProperty literature2Property() {
        return this.physics2;
    }

    public void setLiterature2(double literature2) {
        this.physics2.set(literature2);
    }

    public double getPhilosophy2() {
        return this.philosophy2.get();
    }

    public DoubleProperty philosophy2Property() {
        return this.philosophy2;
    }

    public void setPhilosophy2(double philosophy2) {
        this.philosophy2.set(philosophy2);
    }
}
