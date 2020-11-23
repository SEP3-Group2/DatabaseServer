package model.employeemanager;

import database.employeeUserDAO.EmployeeUserDAO;
import database.employeeUserDAO.EmployeeUserDAOImpl;
import transferobjects.EmployeeUser;

import java.sql.SQLException;

public class EmployeeManagerImpl implements EmployeeManager
{
    private EmployeeUserDAO employeeUserDAO;

    public EmployeeManagerImpl()
    {
        try
        {
            employeeUserDAO = EmployeeUserDAOImpl.getInstance();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public void registerEmployeeUser(EmployeeUser employeeUser)
    {
        try
        {
            employeeUserDAO.addUser(employeeUser);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public EmployeeUser getEmployeeUser(String email)
    {
        try
        {
            return employeeUserDAO.getUser(email);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }
}
