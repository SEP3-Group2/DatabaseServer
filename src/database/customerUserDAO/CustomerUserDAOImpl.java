package database.customerUserDAO;

import transferobjects.CustomerUser;
import transferobjects.EmployeeUser;
import transferobjects.Product;

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
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectsep3",
            "group2", "password");
    }

    @Override public void addUser(CustomerUser customerUser) throws SQLException
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

    @Override public List<CustomerUser> getAllUsers() throws SQLException
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
                    resultSet.getString("email"), resultSet.getString("password"),
                    resultSet.getString("name"), resultSet.getString("address"),
                    resultSet.getString("phone"), resultSet.getDate("birthday"));

                returnList.add(content);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return returnList;
    }

    @Override public CustomerUser getUser(String email)
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM \"SEP3\".Customer WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                return new CustomerUser(resultSet.getInt("customerid"),
                    resultSet.getString("email"), resultSet.getString("password"),
                    resultSet.getString("name"), resultSet.getString("address"),
                    resultSet.getString("phone"), resultSet.getDate("birthday"));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override public CustomerUser getCustomerById(int id) throws SQLException
    {
        CustomerUser content = new CustomerUser();

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM \"SEP3\".customer where customerid = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {

                content.setUserID(resultSet.getInt("customerid"));
                content.setName(resultSet.getString("name"));
                content.setEmail(resultSet.getString("email"));
                content.setPassword(resultSet.getString("password"));
                content.setAddress(resultSet.getString("address"));
                content.setPhone(resultSet.getString("phone"));
                content.setBirthday(resultSet.getDate("birthday"));

            }

        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return content;
    }

        @Override public CustomerUser updateCustomerInfo (CustomerUser customerUser)
        throws SQLException {
        CustomerUser content = new CustomerUser();

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "UPDATE \"SEP3\".customer SET name = ?, email = ?, password = ?, address = ?, phone = ? WHERE customerid = ? ");
            statement.setString(1, customerUser.getName());
            statement.setString(2, customerUser.getEmail());
            statement.setString(3, customerUser.getPassword());
            statement.setString(4, customerUser.getAddress());
            statement.setString(5, customerUser.getPhone());
            statement.setInt(6, customerUser.getUserID());
            statement.executeUpdate();
            System.out.println("updated");

            PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM \"SEP3\".Customer where customerid = ?");
            statement2.setInt(1,   customerUser.getUserID()  );

            ResultSet resultSet2 = statement2.executeQuery();
            if (resultSet2.next())
            {
                content = new CustomerUser(
                    resultSet2.getInt("customerid"),
                    resultSet2.getString("email"),
                    resultSet2.getString("password"),
                    resultSet2.getString("name"),
                    resultSet2.getString("address"),
                    resultSet2.getString("phone"),
                    resultSet2.getDate("birthday")
                );
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return content;
    }
}

