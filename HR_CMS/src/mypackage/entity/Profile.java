package mypackage.entity;

import java.util.Date;

public class Profile extends Person {

    private String phoneNumber;
    private String eMail;
    private Education educationList;
    private Boolean haveCar;

    public Profile(
            String firstName,
            String lastName,
            Date birthDate,
            Gender gender,
            String phoneNumber,
            String eMail,
            Education educationList,
            Boolean haveCar ) {
        super(firstName, lastName, birthDate, gender);
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.educationList = educationList;
        this.haveCar = haveCar;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public String geteMail() { return eMail; }

    public Education getEducationList() {return educationList;}

    public Boolean getHaveCar() { return haveCar; }
}
