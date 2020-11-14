package database.productDAO;

import database.clientDAO.ClientDAOImpl;
import transferobjects.Hello;
import transferobjects.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO
{
    private static ProductDAOImpl instance;

    private ProductDAOImpl() throws SQLException
    {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized ProductDAOImpl getInstance() throws SQLException
    {
        if (instance == null)
        {
            instance = new ProductDAOImpl();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectsep3", "group2", "password");
    }

    //asd
    @Override
    public List<Product> getAllProducts() throws SQLException
    {
        List<Product> returnList = new ArrayList<Product>();
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
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"SEP3\".Product");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                Product content = new Product();
                content.setId(resultSet.getInt("productid"));
                content.setTitle(resultSet.getString("title"));
                content.setCategory(resultSet.getString("category"));
                content.setDescription(resultSet.getString("description"));
                content.setPrice(resultSet.getDouble("price"));

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
