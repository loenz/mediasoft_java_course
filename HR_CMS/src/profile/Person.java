package profile;

import java.util.Date;

public class Person {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Gender gender;

    public Person(String firstName, String lastName, Date birthDate, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

}
