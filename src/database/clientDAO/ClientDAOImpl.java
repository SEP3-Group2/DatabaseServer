package database.clientDAO;

import transferobjects.Hello;

import java.sql.*;

public class ClientDAOImpl implements ClientDAO
{
    private static ClientDAOImpl instance;

    private ClientDAOImpl() throws SQLException
    {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized ClientDAOImpl getInstance() throws SQLException
    {
        if (instance == null)
        {
            instance = new ClientDAOImpl();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectsep3", "group2", "password");
    }

    @Override
    public Hello getHello() throws SQLException
    {
        Hello returnHello = new Hello("boi");
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
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"test\".test");
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                String content = resultSet.getString("stringcontent");

                returnHello = new Hello(content);
            }
            else
            {
                returnHello = new Hello("Did not work");
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return returnHello;
    }
}
