package mypackage.service;

import mypackage.entity.Person;
import mypackage.exception.DatabaseException;
import mypackage.exception.PersonDataSourceException;
import mypackage.facade.DatabaseFacade;
import mypackage.facade.PostgresDatabaseFacade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDatabaseService implements PersonService {
    private DatabaseFacade databaseFacade = new PostgresDatabaseFacade();
    private final String databaseLogin = "postgres";
    private final String databasePassword = "10068168";
    private final String tableName = "persons";
    private final String idField = "id";
    private final String nameField = "name";

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
    public Person getPersonByID(Integer id) throws PersonDataSourceException {
        Person person = null;
        try {
            this.databaseFacade.connect(this.databaseLogin, this.databasePassword);
            Connection connection = this.databaseFacade.getConnection();
            if(connection != null) {
                String sql = "select * from " + this.tableName + " where " + this.idField + " = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()) {
                    person = new Person();
                    person.setId(resultSet.getInt(this.idField));
                    person.setName(resultSet.getString(this.nameField));
                }

            }
        } catch (DatabaseException de) {
            throw new PersonDataSourceException("Unable to get person from the database: " + de.getMessage());
        } catch (SQLException sqle) {
            throw new PersonDataSourceException("Error while operating with the database statement");
        } finally {
            this.databaseFacade.disconnect();
        }

        return person;
    }
}
