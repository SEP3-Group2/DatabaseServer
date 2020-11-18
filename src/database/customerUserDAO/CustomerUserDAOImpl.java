package database.customerUserDAO;

import transferobjects.CustomerUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerUserDAOImpl implements CustomerUserDAO
{
    private static CustomerUserDAOImpl instance;

    private CustomerUserDAOImpl() throws SQLException
    {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized CustomerUserDAOImpl getInstance() throws SQLException
    {
        if (instance == null)
        {
            instance = new CustomerUserDAOImpl();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectsep3", "group2", "password");
    }

    @Override
    public void addUser(CustomerUser customerUser) throws SQLException
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO\"SEP3\".customer(name, email, password, address, phone, birthday) VALUES(?,?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, customerUser.getName());
            statement.setString(2, customerUser.getEmail());
            statement.setString(3, customerUser.getPassword());
            statement.setString(4, customerUser.getAddress());
            statement.setString(5, customerUser.getPhone());
            statement.setDate(6, customerUser.getBirthday());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
            {
                System.out.println("User added to database");
            }
            else
                throw new SQLException("No keys generated");
        }
    }

    @Override
    public List<CustomerUser> getAllUsers() throws SQLException
    {
        List<CustomerUser> returnList = new ArrayList<CustomerUser>();
        try
        {
            DriverManager.registerDriver(new org.postgresql.Driver());
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"SEP3\".Customer");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                CustomerUser content = new CustomerUser(resultSet.getInt("customerid"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getDate("birthday"));

                returnList.add(content);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return returnList;
    }
}
