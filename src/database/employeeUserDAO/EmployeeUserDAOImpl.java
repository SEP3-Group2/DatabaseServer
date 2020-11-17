package database.employeeUserDAO;

import transferobjects.CustomerUser;

import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeUserDAOImpl implements EmployeeUserDAO
{
    private static EmployeeUserDAOImpl instance;

    private EmployeeUserDAOImpl() throws SQLException
    {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized EmployeeUserDAOImpl getInstance() throws SQLException
    {
        if (instance == null)
        {
            instance = new EmployeeUserDAOImpl();
        }
        return instance;
    }

    @Override
    public void addUser(CustomerUser customerUser)
    {

    }
}
