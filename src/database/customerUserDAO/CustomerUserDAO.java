package database.customerUserDAO;

import transferobjects.CustomerUser;
import transferobjects.Product;

import java.sql.SQLException;
import java.util.List;

public interface CustomerUserDAO
{
    void addUser(CustomerUser customerUser) throws SQLException;

    List<CustomerUser> getAllUsers() throws SQLException;

    CustomerUser getUser(String email) throws SQLException;
    CustomerUser getCustomerById(int id) throws SQLException;

    CustomerUser updateCustomerInfo(CustomerUser customerUser) throws SQLException;

}
