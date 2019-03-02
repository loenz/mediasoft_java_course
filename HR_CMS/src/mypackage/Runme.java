package mypackage;

import mypackage.exception.WrongGenderException;
import mypackage.profile.Gender;
import mypackage.profile.Person;
import mypackage.exception.WrongDateException;

import java.util.Date;
import java.util.Scanner;

public class Runme {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Firstname: ");
        String firstname = in.next();
        System.out.print("Enter Lastname: ");
        String lastname = in.next();
        Gender gender;

        while (true) {
            try {
                    System.out.print("Enter gender: ");
                    String genderText = in.next().toUpperCase();
                    gender = Gender.valueOf(genderText);
                    break;

            } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
            }
        }

        System.out.print("Enter grade point average: ");
        double gradePointAverage = in.nextDouble();

        Person ivanIvanov = new Person(firstname,lastname, new Date(), gender, gradePointAverage, Boolean.FALSE);
        Person lolaPetrova = new Person("Lola","Petrova", new Date(), Gender.FEMALE, gradePointAverage, Boolean.FALSE);

        System.out.println(ivanIvanov + " - his code - " + ivanIvanov.hashCode());
        System.out.println(lolaPetrova + " - his code - " + lolaPetrova.hashCode());

        Date newDate = new Date();
        Long time = newDate.getTime();
        System.out.println(time);

        try {
            ivanIvanov.changeBirthDate(newDate);
        } catch (WrongDateException e) {
            e.printStackTrace();
        }

        try {
            ivanIvanov.changeGender(Gender.FEMALE);
        } catch (WrongGenderException e) {
            e.printStackTrace();
        }

        System.out.println(ivanIvanov + " - his code - " + ivanIvanov.hashCode());

    }

}