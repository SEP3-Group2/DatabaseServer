package database.employeeUserDAO;

import transferobjects.CustomerUser;
import transferobjects.EmployeeUser;
import transferobjects.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                    "INSERT INTO\"SEP3\".employee(name, email, password, address, contact, seclevel, position, storeid) VALUES(?,?,?,?,?,?,?,?)",
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

    @Override
    public EmployeeUser getUser(String email) throws SQLException
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"SEP3\".employee WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                return new EmployeeUser(
                        resultSet.getInt("employeeid"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("contact"),
                        resultSet.getInt("seclevel"),
                        resultSet.getString("position"),
                        resultSet.getInt("storeid"),
                        resultSet.getString("password"));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EmployeeUser> getAllUsers() throws SQLException
    {
        List<EmployeeUser> returnList = new ArrayList<EmployeeUser>();
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM \"SEP3\".employee");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                EmployeeUser content = new EmployeeUser(
                        resultSet.getInt("employeeid"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("contact"),
                        resultSet.getInt("seclevel"),
                        resultSet.getString("position"),
                        resultSet.getInt("storeid"),
                        resultSet.getString("password")
                );

                returnList.add(content);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return returnList;
    }

    @Override
    public EmployeeUser getUserByID(int id) throws SQLException
    {
        EmployeeUser content = new EmployeeUser();

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM \"SEP3\".employee where employeeid = ?");
            statement.setInt(1,   id  );
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                content = new EmployeeUser(
                        resultSet.getInt("employeeid"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("contact"),
                        resultSet.getInt("seclevel"),
                        resultSet.getString("position"),
                        resultSet.getInt("storeid"),
                        resultSet.getString("password")
                );
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return content;
    }

    @Override
    public EmployeeUser updateUser(EmployeeUser user) throws SQLException
    {
        EmployeeUser content = new EmployeeUser();

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE \"SEP3\".employee SET name = ?, email = ?, address = ?, contact = ?, seclevel = ?, position = ?, storeid = ?, password = ? WHERE employeeid = ?");
            statement.setString(1,   user.getName()  );
            statement.setString(2,   user.getEmail()  );
            statement.setString(3,   user.getAddress() );
            statement.setString(4,   user.getPhone()  );
            statement.setInt(5,   user.getSecurityLevel() );
            statement.setString(6,   user.getPosition()  );
            statement.setInt(7,   user.getStoreID()  );
            statement.setString(8,   user.getPassword() );
            statement.setInt(9,   user.getUserID()  );

            statement.executeUpdate();
            PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM \"SEP3\".employee where employeeid = ?");
            statement2.setInt(1,   user.getUserID()  );

            ResultSet resultSet2 = statement2.executeQuery();
            if (resultSet2.next())
            {
                content = new EmployeeUser(
                        resultSet2.getInt("employeeid"),
                        resultSet2.getString("name"),
                        resultSet2.getString("email"),
                        resultSet2.getString("address"),
                        resultSet2.getString("contact"),
                        resultSet2.getInt("seclevel"),
                        resultSet2.getString("position"),
                        resultSet2.getInt("storeid"),
                        resultSet2.getString("password")
                );
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return content;
    }

    @Override
    public void deleteUser(int id) throws SQLException
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM \"SEP3\".employee where employeeid = ?");
            statement.setInt(1,   id  );
            statement.executeUpdate();

            System.out.println("Deleted employee user from database");
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
}
