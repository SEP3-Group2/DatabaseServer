package database.productDAO;

import database.clientDAO.ClientDAOImpl;
import transferobjects.Hello;
import transferobjects.Product;

import java.io.InputStream;
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
    return DriverManager
        .getConnection("jdbc:postgresql://localhost:5432/projectsep3", "group2",
            "password");
  }

  //asd
  @Override public List<Product> getAllProducts() throws SQLException
  {
    List<Product> returnList = new ArrayList<Product>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement("SELECT * FROM \"SEP3\".Product");
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

  @Override public List<Product> getTitleFilteredProducts(String title)
      throws SQLException
  {
    List<Product> returnList = new ArrayList<Product>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM \"SEP3\".Product where title LIKE ?");
      statement.setString(1, "%" + title + "%");
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

  @Override public List<Product> getTitleCategoryFilteredProducts(String title,
      String category) throws SQLException
  {
    if (title.equalsIgnoreCase("nullnull"))
    {
      title = "";
    }
    if (category.equalsIgnoreCase("All"))
    {
      category = "";
    }
    List<Product> returnList = new ArrayList<Product>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM \"SEP3\".Product where title LIKE ? AND category LIKE ?");
      statement.setString(1, "%" + title + "%");
      statement.setString(2, "%" + category + "%");
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

  @Override public List<Product> getTitleCategoryPriceFilteredProducts(String title,
      String category, int price) throws SQLException
  {
    if (title.equalsIgnoreCase("nullnull"))
    {
      title = "";
    }
    if (category.equalsIgnoreCase("All"))
    {
      category = "";
    }
    List<Product> returnList = new ArrayList<Product>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM \"SEP3\".Product where title LIKE ? AND category LIKE ? AND price<= ?");
      statement.setString(1, "%" + title + "%");
      statement.setString(2, "%" + category + "%");
      statement.setInt(3, price);
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

  @Override public Product addProduct(String title, String category,
      String description, double price) throws SQLException
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO\"SEP3\".product(title, category, description, price) VALUES(?,?,?,?)",
          PreparedStatement.RETURN_GENERATED_KEYS);
      statement.setString(1, title);
      statement.setString(2, category);
      statement.setString(3, description);
      statement.setDouble(4, price);
      statement.executeUpdate();

      ResultSet resultSet = statement.getGeneratedKeys();
      if (resultSet.next())
      {
        System.out.println("Product created in database");
        return new Product(resultSet.getInt(1), title, category, description,
            price);
      }
      else
        throw new SQLException("No keys generated");
    }
  }

}
