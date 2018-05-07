package sample.SystemUsers;

import javafx.beans.property.*;

public class Student extends Person {

    private StringProperty parentName = new SimpleStringProperty(this,"parentName");
    private StringProperty parentEmail = new SimpleStringProperty(this,"parentEmail");
    private StringProperty parentPhoneNum = new SimpleStringProperty(this,"parentPhoneNum");
    private Group gradeYear;



    private DoubleProperty firstSemester = new SimpleDoubleProperty(this,"firstSemester");
    private DoubleProperty biology1 = new SimpleDoubleProperty(this,"biology1");
    private DoubleProperty maths1 = new SimpleDoubleProperty(this,"maths1");
    private DoubleProperty chemistry1 = new SimpleDoubleProperty(this,"chemistry1");
    private DoubleProperty english1 = new SimpleDoubleProperty(this,"english1");
    private DoubleProperty physics1 = new SimpleDoubleProperty(this,"physics");
    private DoubleProperty philosophy1 = new SimpleDoubleProperty(this,"philosophy1");


    private DoubleProperty secondSemester = new SimpleDoubleProperty(this,"secondSemester");
    private DoubleProperty biology2 = new SimpleDoubleProperty(this,"biology2");
    private DoubleProperty maths2 = new SimpleDoubleProperty(this,"maths2");
    private DoubleProperty chemistry2 = new SimpleDoubleProperty(this,"chemistry2");
    private DoubleProperty english2 = new SimpleDoubleProperty(this,"english2");
    private DoubleProperty physics2 = new SimpleDoubleProperty(this,"physics2");
    private DoubleProperty philosophy2 = new SimpleDoubleProperty(this,"philosophy2");



    public Student(){super();}

    public Student(StringProperty parentName, StringProperty parentEmail, StringProperty parentPhoneNum, Group gradeYear,
                  DoubleProperty firstSemester, DoubleProperty biology1,
                   DoubleProperty maths1, DoubleProperty chemistry1, DoubleProperty english1,
                   DoubleProperty physics1, DoubleProperty philosophy1,
                  DoubleProperty secondSemester, DoubleProperty biology2,
                   DoubleProperty maths2, DoubleProperty chemistry2, DoubleProperty english2,
                   DoubleProperty physics2, DoubleProperty philosophy2) {
        this.parentName = parentName;
        this.parentEmail = parentEmail;
        this.parentPhoneNum = parentPhoneNum;
        this.gradeYear = gradeYear;
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

    public Student(IntegerProperty SSN, StringProperty name, StringProperty surname, StringProperty dateOfBirth, StringProperty gender, StringProperty homeAddress, StringProperty emailAddress, StringProperty ICENumber, StringProperty logingID, StringProperty password, StringProperty phoneNum, StringProperty parentName, StringProperty parentEmail, StringProperty parentPhoneNum, Group gradeYear, DoubleProperty firstSemester, DoubleProperty biology1, DoubleProperty maths1, DoubleProperty chemistry1, DoubleProperty english1, DoubleProperty physics1, DoubleProperty philosophy1, DoubleProperty secondSemester, DoubleProperty biology2, DoubleProperty maths2, DoubleProperty chemistry2, DoubleProperty english2, DoubleProperty physics2, DoubleProperty philosophy2) {
        this.parentName = parentName;
        this.parentEmail = parentEmail;
        this.parentPhoneNum = parentPhoneNum;
        this.gradeYear = gradeYear;
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

}

