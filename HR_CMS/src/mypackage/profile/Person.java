package mypackage.profile;

import java.util.Calendar;
import java.util.Date;

public class Person {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Gender gender;

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Date getBirthDate() { return birthDate; }
    public Gender getGender() { return gender; }

    public Person(String firstName, String lastName, Date birthDate, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        long result = 0;

        if (this.birthDate != null) {
            final Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.getBirthDate());
            result += calendar.get(Calendar.DATE) + 1000000;
            result += calendar.get(Calendar.MONTH) + 10000;
            result += calendar.get(Calendar.YEAR);
        }
        return Long.valueOf(result).intValue();
    }

}
