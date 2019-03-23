package mypackage;

import mypackage.entity.Education;
import mypackage.exception.WrongGenderException;
import mypackage.entity.Gender;
import mypackage.entity.Person;
import mypackage.entity.Profile;
import mypackage.exception.WrongDateException;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import mypackage.exception.PersonDataSourceException;
import mypackage.service.PersonDatabaseService;
import mypackage.service.PersonService;

public class Runme {
    public static void main(String[] args)  {

        Integer idProfile;
        String namePerson;

        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter operation: \n" +
                        "1 - New profile..\n" +
                        "2 - Edit profile..\n" +
                        "3 - Find profile..\n" +
                        "4 - Send message..\n" +
                        "5 - Transaction log..\n" +
                        "6 - Exit..\n");
                int selectedItem = in.nextInt();
                if (selectedItem == 1 ) {
                    System.out.print("Enter id of new person: ");
                    idProfile = in.nextInt();
                    System.out.print("Enter name of new person: ");
                    namePerson = in.next();
                    break;
                }
            } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
            }
        }

//        System.out.print("Enter Firstname: ");
//        String firstname = in.next();
//        System.out.print("Enter Lastname: ");
//        String lastname = in.next();
//        Gender gender;
//
        // Проверка правильности ввода пола
//        while (true) {
//            try {
//                    System.out.print("Enter gender: ");
//                    String genderText = in.next().toUpperCase();
//                    gender = Gender.valueOf(genderText);
//                    break;
//
//            } catch (IllegalArgumentException e) {
//                    System.out.println(e.getMessage());
//            }
//        }
//


        PersonService personService = new PersonDatabaseService();

        try {
            System.out.println("All of the persons: ");
            personService.getAllPersons().forEach(System.out::println);

            System.out.println("");
            System.out.println("Person with the ID = 2: ");
            System.out.println(personService.getPersonByID(2));

            System.out.println(personService.setNewPerson(idProfile, namePerson));

        } catch (PersonDataSourceException pdse) {
            pdse.printStackTrace();
        }


        Calendar calendar = new GregorianCalendar(1985, Calendar.DECEMBER,27);
        Date datePirmatov = calendar.getTime();

        Calendar calendarPetrov = new GregorianCalendar(1982, Calendar.JANUARY,12);
        Date datePetrov = calendarPetrov.getTime();

        Education educationLola;
        educationLola = new Education(
                1990,
                1995,
                "ULSTU",
                "informatic",
                "specialist");

        Profile lolaPetrova = new Profile(
                "Lola",
                "Petrova",
                new Date(),
                Gender.FEMALE,
                "8-901-001-01-01",
                "petrova@mail.ru",
                educationLola,
                Boolean.TRUE);


//       System.out.println(lolaPetrova + " - his code - " + lolaPetrova.hashCode());
//        System.out.println(dimaPirmatov + " hash: " + dimaPirmatov.hashCode());
//        System.out.println(ivanPetrov);

//        Date newDate = new Date();
//        Long time = newDate.getTime();
//        System.out.println(time);
//
//        try {
//            ivanIvanov.changeBirthDate(newDate);
//        } catch (WrongDateException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            ivanIvanov.changeGender(Gender.FEMALE);
//        } catch (WrongGenderException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(ivanIvanov + " - his code - " + ivanIvanov.hashCode());

    }

}