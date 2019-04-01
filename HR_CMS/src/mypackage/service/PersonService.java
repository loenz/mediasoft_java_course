package mypackage.service;

import mypackage.entity.Gender;
import mypackage.entity.Person;
import mypackage.exception.PersonDataSourceException;

import java.util.Date;
import java.util.List;

public interface PersonService {
    List<Person> getAllPersons() throws PersonDataSourceException;
    List<Person> getPersonByName(String namePerson) throws PersonDataSourceException;
    Person setNewPerson(String firstname, String lastname, Gender gender, String birthDate) throws PersonDataSourceException;
    Person setNewBirthDate(String birthDate, Person person) throws PersonDataSourceException;
}
