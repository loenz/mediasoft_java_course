package mypackage.facade;

import mypackage.exception.DatabaseException;
import java.sql.Connection;

public interface DatabaseFacade {
    void connect(String login, String password) throws DatabaseException;
    Connection getConnection();
    void disconnect();
}
