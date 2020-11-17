package database.employeeUserDAO;

import transferobjects.EmployeeUser;

import java.sql.*;

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

    private Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectsep3", "group2", "password");
    }

    @Override
    public void addUser(EmployeeUser employeeUser) throws SQLException
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO\"SEP3\".employee(name, email, password, address, contact, seclevel, positon, storeid) VALUES(?,?,?,?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, employeeUser.getName());
            statement.setString(2, employeeUser.getEmail());
            statement.setString(3, employeeUser.getPassword());
            statement.setString(4, employeeUser.getAddress());
            statement.setString(5, employeeUser.getPhone());
            statement.setInt(6, employeeUser.getSecurityLevel());
            statement.setString(7, employeeUser.getPosition());
            statement.setInt(8, employeeUser.getStoreID());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
            {
                System.out.println("Employee added to database");
            }
            else
                throw new SQLException("No keys generated");
        }
    }
}
