package mypackage.service;

import mypackage.entity.Person;
import mypackage.exception.PersonDataSourceException;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons() throws PersonDataSourceException;
    Person getPersonByID(Integer id) throws PersonDataSourceException;
    Person setNewPerson(Integer id, String name) throws PersonDataSourceException;

}
