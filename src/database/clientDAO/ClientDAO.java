package database.clientDAO;

import transferobjects.Hello;

import java.sql.SQLException;

public interface ClientDAO
{
    Hello getHello() throws SQLException;
}
