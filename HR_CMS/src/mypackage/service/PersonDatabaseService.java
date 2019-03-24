package mypackage.service;

import mypackage.entity.Gender;
import mypackage.entity.Person;
import mypackage.exception.DatabaseException;
import mypackage.exception.PersonDataSourceException;
import mypackage.facade.DatabaseFacade;
import mypackage.facade.PostgresDatabaseFacade;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.sql.Date.valueOf;

public class PersonDatabaseService implements PersonService {
    private DatabaseFacade databaseFacade = new PostgresDatabaseFacade();
    private final String databaseLogin = "postgres";
    private final String databasePassword = "10068168";
    private final String tableName = "persons";
    private final String idField = "id";
    private final String nameField = "firstname";
    private final String lastNameField = "lastname";

    @Override
    public List<Person> getAllPersons() throws PersonDataSourceException {
        List<Person> persons = new ArrayList<Person>();
        try {
            this.databaseFacade.connect(this.databaseLogin, this.databasePassword);
            Connection connection = this.databaseFacade.getConnection();
            if(connection != null) {
                Statement statement = connection.createStatement();
                String sql = "select * from " + this.tableName;
                ResultSet resultSet = statement.executeQuery(sql);
                while(resultSet.next()) {
                    Person person = new Person();
                    person.setId(resultSet.getInt(this.idField));
                    person.setName(resultSet.getString(this.nameField));
                    persons.add(person);
                }

            }
        } catch (DatabaseException de) {
            throw new PersonDataSourceException("Unable to get person list from the database: " + de.getMessage());
        } catch (SQLException sqle) {
            throw new PersonDataSourceException("Error while operating with the database statement");
        } finally {
            this.databaseFacade.disconnect();
        }

        return persons;
    }

    @Override
    public List<Person> getPersonByName(String namePerson) throws PersonDataSourceException {
        Person person = null;
        List<Person> personArrayList = new ArrayList<>();

        try {
            this.databaseFacade.connect(this.databaseLogin, this.databasePassword);
            Connection connection = this.databaseFacade.getConnection();
            if(connection != null) {
                String sql = "SELECT * FROM persons WHERE firstname ILIKE ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + namePerson + "%");
                ResultSet resultSet = preparedStatement.executeQuery();



                while(resultSet.next()) {
                    person = new Person();
                    person.setId(resultSet.getInt(this.idField));
                    person.setName(resultSet.getString(this.nameField));
                    personArrayList.add(person);

                }

                //System.out.println(personArrayList);

            }
        } catch (DatabaseException de) {
            throw new PersonDataSourceException("Unable to get person from the database: " + de.getMessage());
        } catch (SQLException sqle) {
            throw new PersonDataSourceException("Error while operating with the database statement");
        } finally {
            this.databaseFacade.disconnect();
        }

        return personArrayList;
    }

    @Override
    public Person setNewPerson(String firstname, String lastname, Gender gender, String birthDate) throws PersonDataSourceException {
        Person person = null;

        try {
            this.databaseFacade.connect(this.databaseLogin, this.databasePassword);
            Connection connection = this.databaseFacade.getConnection();
            if(connection != null) {

                String sql = "INSERT INTO persons(" +
                        "firstname, " +
                        "lastname, " +
                        "gender, " +
                        "birthdate) VALUES(?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, firstname);
                preparedStatement.setString(2, lastname);
                preparedStatement.setString(3, gender.toString());
                preparedStatement.setDate(4, valueOf(birthDate));

                int rows = preparedStatement.executeUpdate();
                System.out.printf("%d rows added", rows);

//                while(resultSet.next()) {
//                    person = new Person();
//                   // person.setId(resultSet.getInt(id));
//                    person.setName(resultSet.getString(namePerson));
//                }

            }
        } catch (DatabaseException de) {
            throw new PersonDataSourceException("Unable to get person from the database: " + de.getMessage());
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new PersonDataSourceException("Error while operating with the database statement");
        } finally {
            this.databaseFacade.disconnect();
        }

        return person;
    }

}
