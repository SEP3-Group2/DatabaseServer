package database.customerUserDAO;

import transferobjects.CustomerUser;

import java.sql.SQLException;
import java.util.List;

public interface CustomerUserDAO
{
    void addUser(CustomerUser customerUser) throws SQLException;

    List<CustomerUser> getAllUsers() throws SQLException;
}
