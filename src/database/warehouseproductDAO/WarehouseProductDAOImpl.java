package database.warehouseproductDAO;

import database.productDAO.ProductDAOImpl;
import model.warehouseproductmanager.WarehouseProductManagerImpl;
import transferobjects.CartProduct;
import transferobjects.OrderProduct;
import transferobjects.Product;
import transferobjects.WarehouseProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WarehouseProductDAOImpl implements WarehouseProductDAO
{
  private static WarehouseProductDAOImpl instance;

  private WarehouseProductDAOImpl() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized WarehouseProductDAOImpl getInstance()
      throws SQLException
  {
    if (instance == null)
    {
      instance = new WarehouseProductDAOImpl();
    }
    return instance;
  }

  private Connection getConnection() throws SQLException
  {
    return DriverManager
        .getConnection("jdbc:postgresql://localhost:5432/projectsep3", "group2",
            "password");
  }

  @Override public List<WarehouseProduct> getAllWarehouseProducts()
      throws SQLException
  {
    List<WarehouseProduct> returnList = new ArrayList<WarehouseProduct>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection
          .prepareStatement("SELECT * FROM \"SEP3\".WarehouseProduct");
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        WarehouseProduct content = new WarehouseProduct();
        content.setStoreId(resultSet.getInt("storeid"));
        content.setProductId(resultSet.getInt("productid"));
        content.setQuantity(resultSet.getInt("quantity"));

        returnList.add(content);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return returnList;
  }

  @Override public List<WarehouseProduct> getStoreWarehouseProducts(int storeId)
      throws SQLException
  {
    List<WarehouseProduct> returnList = new ArrayList<WarehouseProduct>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM \"SEP3\".WarehouseProduct where storeid = ?");
      statement.setInt(1, storeId);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        WarehouseProduct content = new WarehouseProduct();
        content.setStoreId(resultSet.getInt("storeid"));
        content.setProductId(resultSet.getInt("productid"));
        content.setQuantity(resultSet.getInt("quantity"));

        returnList.add(content);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return returnList;
  }

  @Override public WarehouseProduct addWarehouseProduct(int storeid,
      int productid, int quantity) throws SQLException
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO\"SEP3\".warehouseproduct(storeid, productid, quantity) VALUES(?,?,?,?)",
          PreparedStatement.RETURN_GENERATED_KEYS);
      statement.setInt(1, storeid);
      statement.setInt(2, productid);
      statement.setInt(3, quantity);
      statement.executeUpdate();

      ResultSet resultSet = statement.getGeneratedKeys();
      if (resultSet.next())
      {
        System.out.println("WarehouseProduct created in database");
        return new WarehouseProduct(storeid, productid, quantity);
      }
      else
        throw new SQLException("No keys generated");
    }
  }

  @Override public List<CartProduct> GetCartProducts(int productid,
      int quantity) throws SQLException
  {
    List<CartProduct> returnList = new ArrayList<CartProduct>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT \"SEP3\".product.productid, \"SEP3\".product.title, \"SEP3\".product.category, \"SEP3\".product.price,\n"
              + "\"SEP3\".warehouseproduct.storeid, \"SEP3\".warehouseproduct.quantity\n"
              + "FROM \"SEP3\".product  \n"
              + "INNER JOIN \"SEP3\".warehouseproduct \n"
              + "ON (\"SEP3\".product.productid = \"SEP3\".warehouseproduct.productid)\n"
              + "WHERE \"SEP3\".product.productid = ? AND \"SEP3\".warehouseproduct.quantity >= ?");

      statement.setInt(1, productid);
      statement.setInt(2, quantity);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        CartProduct content = new CartProduct();
        content.setId(resultSet.getInt("productid"));
        content.setTitle(resultSet.getString("title"));
        content.setCategory(resultSet.getString("category"));
        content.setPrice(resultSet.getInt("price"));
        content.setStoreid(resultSet.getInt("storeid"));
        content.setQuantity(resultSet.getInt("quantity"));
        returnList.add(content);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return returnList;
  }

  @Override public List<CartProduct> GetNotCartProducts(int productid,
      int quantity) throws SQLException
  {
    List<CartProduct> returnList = new ArrayList<CartProduct>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT \"SEP3\".product.productid, \"SEP3\".product.title, \"SEP3\".product.category, \"SEP3\".product.price,\n"
              + "\"SEP3\".warehouseproduct.storeid, \"SEP3\".warehouseproduct.quantity\n"
              + "FROM \"SEP3\".product  \n"
              + "INNER JOIN \"SEP3\".warehouseproduct \n"
              + "ON (\"SEP3\".product.productid = \"SEP3\".warehouseproduct.productid)\n"
              + "WHERE \"SEP3\".product.productid = ? AND \"SEP3\".warehouseproduct.quantity < ?");

      statement.setInt(1, productid);
      statement.setInt(2, quantity);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        CartProduct content = new CartProduct();
        content.setId(resultSet.getInt("productid"));
        content.setTitle(resultSet.getString("title"));
        content.setCategory(resultSet.getString("category"));
        content.setPrice(resultSet.getInt("price"));
        content.setStoreid(resultSet.getInt("storeid"));
        content.setQuantity(resultSet.getInt("quantity"));
        returnList.add(content);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return returnList;
  }

  @Override public void OrderProductFromManufacturer(OrderProduct orderProduct)
      throws SQLException
  {
    try (Connection connection = getConnection())
    {

      PreparedStatement statement = connection.prepareStatement(
          "UPDATE \"SEP3\".warehouseproduct SET quantity=? WHERE storeid =? AND productid=? ");
      statement.setInt(1,
          orderProduct.getWarehouseProduct().getQuantity() + orderProduct
              .getOrderCount());
      statement.setInt(2, orderProduct.getWarehouseProduct().getStoreId());
      statement.setInt(3, orderProduct.getWarehouseProduct().getProductId());

      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void OrderProductFromStore(OrderProduct orderProduct)
      throws SQLException
  {
    try (Connection connection = getConnection())
    {

      PreparedStatement statement = connection.prepareStatement(
          "UPDATE \"SEP3\".warehouseproduct SET quantity=? WHERE storeid =? AND productid=? ");
      statement.setInt(1,
          orderProduct.getWarehouseProduct().getQuantity() + orderProduct
              .getOrderCount());
      statement.setInt(2, orderProduct.getWarehouseProduct().getStoreId());
      statement.setInt(3, orderProduct.getWarehouseProduct().getProductId());
      statement.executeUpdate();

      PreparedStatement statement2 = connection.prepareStatement(
          "SELECT * FROM\"SEP3\".warehouseproduct WHERE storeid =? AND productid=?");
      statement2.setInt(1, orderProduct.getStoreId());
      statement2.setInt(2, orderProduct.getWarehouseProduct().getProductId());
      ResultSet resultSet = statement2.executeQuery();

      WarehouseProduct content = new WarehouseProduct();
      while (resultSet.next())
      {
        content.setStoreId(resultSet.getInt("storeid"));
        content.setProductId(resultSet.getInt("productid"));
        content.setQuantity(resultSet.getInt("quantity"));
      }

      PreparedStatement statement3 = connection.prepareStatement(
          "UPDATE \"SEP3\".warehouseproduct SET quantity=? WHERE storeid =? AND productid=?");
      statement3
          .setInt(1, content.getQuantity() - orderProduct.getOrderCount());
      statement3.setInt(2, orderProduct.getStoreId());
      statement3.setInt(3, orderProduct.getWarehouseProduct().getProductId());
      statement3.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void DecrementProductQuantity(OrderProduct orderProduct)
      throws SQLException
  {
    try (Connection connection = getConnection())
    {

      PreparedStatement statement = connection.prepareStatement(
          "UPDATE \"SEP3\".warehouseproduct SET quantity=? WHERE storeid=? AND productid=?");
      statement.setInt(1,
          orderProduct.getWarehouseProduct().getQuantity() - orderProduct
              .getOrderCount());
      statement.setInt(2, orderProduct.getWarehouseProduct().getStoreId());
      statement.setInt(3, orderProduct.getWarehouseProduct().getProductId());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public List<WarehouseProduct> getWarehouseProductFromStoresById(
      WarehouseProduct warehouseProduct) throws SQLException
  {
    List<WarehouseProduct> returnList = new ArrayList<WarehouseProduct>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM \"SEP3\".WarehouseProduct WHERE productid = ? EXCEPT SELECT * FROM \"SEP3\".WarehouseProduct WHERE storeid=?");
      statement.setInt(1, warehouseProduct.getProductId());
      statement.setInt(2, warehouseProduct.getStoreId());
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        WarehouseProduct content = new WarehouseProduct();

        content.setStoreId(resultSet.getInt("storeid"));
        content.setProductId(resultSet.getInt("productid"));
        content.setQuantity(resultSet.getInt("quantity"));
        returnList.add(content);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return returnList;

  }

  @Override public WarehouseProduct UpdateWarehouseQuantity(int storeid,
      int productid, int quantity) throws SQLException
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "UPDATE \"SEP3\".warehouseproduct SET quantity=quantity - ? WHERE storeid=? AND productid=?;");
      statement.setInt(1, quantity);
      statement.setInt(2, storeid);
      statement.setInt(3, productid);
      statement.executeUpdate();

      System.out.println("WarehouseProduct updated in database");
      return new WarehouseProduct(storeid, productid, quantity);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

}
