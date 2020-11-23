package model.customermanager;

import database.customerUserDAO.CustomerUserDAO;
import database.customerUserDAO.CustomerUserDAOImpl;
import transferobjects.CustomerUser;

import java.sql.SQLException;
import java.util.List;

public class CustomerManagerImpl implements CustomerManager
{
    private CustomerUserDAO customerUserDAO;

    public CustomerManagerImpl()
    {
        try
        {
            customerUserDAO = CustomerUserDAOImpl.getInstance();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public void registerCustomerUser(CustomerUser customerUser)
    {
        try
        {
            System.out.println(customerUser.getEmail() + customerUser.getAddress() + customerUser.getName());
            customerUserDAO.addUser(customerUser);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<CustomerUser> getAllUsers()
    {
        try
        {
            return customerUserDAO.getAllUsers();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomerUser getCustomerUser(String email)
    {
        try
        {
            return customerUserDAO.getUser(email);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }
}
