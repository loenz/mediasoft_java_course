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

        System.out.println("MediaSoft exam. Learner: Pirmatov Dmitriy. Theme: \'HR SRM\'");
        System.out.println("Github: https://github.com/loenz/mediasoft_java_course.git");

        while (true) {
            try {
                System.out.print("\nSelect action: \n" +
                        "| [1] - New profile | [2] - Edit profile.. | [3] - Find person " +
                        "| [4] - All of the persons | [5] - Exit |\n");
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

                if (selectedItem == 2) {
                    System.out.println("..[1] - Change birth date  | [2] - Change status");
                    System.out.print("Select action: _");
                    selectedItem = in.nextInt();
                    System.out.print("Enter part of person name: ");
                    if (selectedItem == 1) {

                        namePerson = in.next();
                        try {
                            List<Person> persons = personService.getPersonByName(namePerson);
                            Person person = persons.get(0);
                            if (persons.size() == 1) {
                                System.out.println("Person defined as: " + person);
                                System.out.println("Enter new birth date for `" + person + "` (format: 1900-12-31): ");

                                //Scanner in = new Scanner(System.in);
                                String pDate = in.next();
                                String newDate = parseOfNewDate(pDate,"yyyy-mm-dd");

                                //persons.get(0).changeBirthDate(newDate);

                                try {
                                    System.out.println("Set new birth date of person to " + newDate);
                                    personService.setNewBirthDate(newDate, person);

                                } catch (PersonDataSourceException e) {
                                    e.printStackTrace();
                                }
                            }


                        } catch (PersonDataSourceException pdse) {
                            pdse.printStackTrace();
                        }
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

    }

    public static String parseOfNewDate(String newDate, String pattern) {

        DateFormat format = new SimpleDateFormat(pattern);
        try {
            format.parse(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }

}