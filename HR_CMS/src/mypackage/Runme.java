package mypackage;

import mypackage.entity.Education;
import mypackage.exception.WrongGenderException;
import mypackage.entity.Gender;
import mypackage.entity.Person;
import mypackage.entity.Profile;
import mypackage.exception.WrongDateException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import mypackage.exception.PersonDataSourceException;
import mypackage.service.PersonDatabaseService;
import mypackage.service.PersonService;

public class Runme {
    public static void main(String[] args)  {

        int selectedItem;
        String namePerson;
        Gender gender;

        Scanner in = new Scanner(System.in);

        PersonService personService = new PersonDatabaseService();

//        try {
//
//            System.out.println("\nPerson with the ID = 8: ");
//            System.out.println(personService.getPersonByID(8));
//
//        } catch (PersonDataSourceException pdse) {
//            pdse.printStackTrace();
//        }


        while (true) {
            try {
                System.out.print("\nMain menu: \n" +
                        "| 1 - New profile.. | 2 - Edit profile.. | 3 - Find person.. |\n" +
                        "| 4 - All of the persons.. | 5 - Exit.. |\n");
                try {
                    System.out.print("Enter menu number: _");
                    selectedItem = in.nextInt();
                } catch (InputMismatchException ime) {
                    ime.printStackTrace();
                    break;
                }

                if (selectedItem == 1) {

                    System.out.print("Enter first name: ");
                    String firstname = in.next();
                    System.out.print("Enter last name: ");
                    String lastname = in.next();

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

                    System.out.print("Enter birth date (like '2001-09-28'): ");
                    String date = in.next();
                    DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                    try {
                        format.parse(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    try {
                        System.out.println("Set new person: ");
                        personService.setNewPerson(firstname, lastname, gender, date);
                    } catch (PersonDataSourceException e) {
                        e.printStackTrace();
                    }
                }

                if (selectedItem == 3) {
                    System.out.print("Введите фамилию человека: ");
                    namePerson = in.nextLine();
                    namePerson += in.nextLine();
                    System.out.println("\nPerson with the name = " + namePerson + ": ");
                    try {
                        System.out.println(personService.getPersonByName(namePerson));
                    } catch (PersonDataSourceException pdse) {
                        pdse.printStackTrace();
                    }
                }

                if (selectedItem == 4) {
                    System.out.println("All of the persons: ");
                    try {
                        personService.getAllPersons().forEach(System.out::println);
                    } catch (PersonDataSourceException pdse) {
                        pdse.printStackTrace();
                    }
                }

                if (selectedItem == 5) {
                    System.out.println("Exit... ");
                    break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }



//        Calendar calendar = new GregorianCalendar(1985, Calendar.DECEMBER,27);
//        Date datePirmatov = calendar.getTime();
//
//        Calendar calendarPetrov = new GregorianCalendar(1982, Calendar.JANUARY,12);
//        Date datePetrov = calendarPetrov.getTime();
//
//        Education educationLola;
//        educationLola = new Education(
//                1990,
//                1995,
//                "ULSTU",
//                "informatic",
//                "specialist");
//
//        Profile lolaPetrova = new Profile(
//                "Lola",
//                "Petrova",
//                new Date(),
//                Gender.FEMALE,
//                "8-901-001-01-01",
//                "petrova@mail.ru",
//                educationLola,
//                Boolean.TRUE);
//
//
//       System.out.println(lolaPetrova + " - his code - " + lolaPetrova.hashCode());
//


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