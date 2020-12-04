package model.employeemanager;

import database.employeeUserDAO.EmployeeUserDAO;
import database.employeeUserDAO.EmployeeUserDAOImpl;
import transferobjects.EmployeeUser;

import java.sql.SQLException;
import java.util.List;

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

    @Override
    public List<EmployeeUser> getAllEmployeeUsers()
    {
        try
        {
            return employeeUserDAO.getAllUsers();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public EmployeeUser getEmployeeByID(int id)
    {
        try
        {
            return employeeUserDAO.getUserByID(id);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public EmployeeUser updateEmployeeUser(EmployeeUser user)
    {
        try
        {
            return employeeUserDAO.updateUser(user);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteUser(int id)
    {
        try
        {
            employeeUserDAO.deleteUser(id);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
}
