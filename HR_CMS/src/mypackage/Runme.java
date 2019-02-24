package mypackage;

import mypackage.profile.Gender;
import mypackage.profile.Person;
import mypackage.exception.WrongDateException;

import java.util.Date;

public class Runme {
    public static void main(String[] args) {
        Person ivanIvanov = new Person("Ivan","Ivanov", new Date(), Gender.MALE);
        Person lolaPetrova = new Person("Lola","Petrova", new Date(), Gender.FEMALE);

        System.out.println(ivanIvanov + " - his code - " + ivanIvanov.hashCode());
        System.out.println(lolaPetrova + " - his code - " + lolaPetrova.hashCode());

        Date newDate = new Date();
        newDate.setTime(23456);

        try {
            ivanIvanov.changeBirthDate(newDate);
        } catch (WrongDateException e) {
            e.printStackTrace();
        }

        System.out.println(ivanIvanov + " - his code - " + ivanIvanov.hashCode());

    }

}