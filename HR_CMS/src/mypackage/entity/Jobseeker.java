package mypackage.entity;

import mypackage.exception.WrongDateException;
import mypackage.exception.WrongGenderException;

import java.util.Date;

public abstract class Jobseeker {

    private String firstName;
    private String lastName;
    private Date birthDate;
    private Gender gender;
    private Integer id;

    public abstract void changeBirthDate(Date birthDate) throws WrongDateException;

    public abstract void changeGender(Gender gender) throws WrongGenderException;

}
