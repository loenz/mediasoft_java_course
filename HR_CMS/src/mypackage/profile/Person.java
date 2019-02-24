package mypackage.profile;

import mypackage.exception.WrongDateException;

import java.text.SimpleDateFormat;
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

    /*
    * Переопределяем метод hashCode() класса Object
     */
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

    /*
    * Сравниваем объекты
     */
    private boolean isEqualsNullSafe(Object first, Object second) {
        boolean result = false;
        if ((first != null) && (second != null)) {
            result = first.equals(second);
        }
        if ((first == null) && (second == null)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean equals(Object another) {
        if (another == null) {
            return false;
        }

        if (!(another instanceof Person)) {
            return false;
        }

        Person anotherPerson = (Person)another;
        return this.isEqualsNullSafe(this.getFirstName(), anotherPerson.getFirstName())
                && this.isEqualsNullSafe(this.getLastName(), anotherPerson.getLastName())
                && this.isEqualsNullSafe(this.getBirthDate(), anotherPerson.getBirthDate())
                && this.isEqualsNullSafe(this.getGender(), anotherPerson.getGender());
    }

    @Override
    public String toString() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String result = this.getLastName() != null ? this.getLastName() + " " : "";
        result += this.getFirstName() != null ? this.getFirstName() + " " : "";
        result += this.getBirthDate() != null ? dateFormat.format(this.getBirthDate()) + " " : "";
        result += this.getGender() != null ? this.getGender() : "";

        return result;
    }

    @Override
    public Object clone() {
        return new Person(
                this.getFirstName(),
                this.getLastName(),
                (Date)this.getBirthDate().clone(),
                this.getGender()
        );
    }

    public void changeBirthDate(Date birthDate) throws WrongDateException) {

    }


}
