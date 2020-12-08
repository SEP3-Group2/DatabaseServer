package database.transactionproduct;

import database.transactionDAO.TransactionDAO;
import database.transactionDAO.TransactionDAOImpl;
import transferobjects.HistoryProduct;
import transferobjects.ReserveHistory;
import transferobjects.Transaction;
import transferobjects.TransactionProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionProductDAOImpl implements TransactionProductDAO
{
  private static TransactionProductDAOImpl instance;

  private TransactionProductDAOImpl() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized TransactionProductDAOImpl getInstance()
      throws SQLException
  {
    if (instance == null)
    {
      instance = new TransactionProductDAOImpl();
    }
    return instance;
  }

  private Connection getConnection() throws SQLException
  {
    return DriverManager
        .getConnection("jdbc:postgresql://localhost:5432/projectsep3", "group2",
            "password");
  }

  @Override public TransactionProduct addTransactionProduct(
      TransactionProduct transactionProduct) throws SQLException
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO\"SEP3\".transactionproduct(transactionid, productid, quantity) VALUES(?,?,?)");

      statement.setInt(1, transactionProduct.getTransactionid());
      statement.setInt(2, transactionProduct.getProductid());
      statement.setInt(3, transactionProduct.getQuantity());

      statement.executeUpdate();

      System.out.println("TransactionProduct added to database");
      return new TransactionProduct();

    }
  }

  @Override public List<HistoryProduct> getTransProById(int transid)
      throws SQLException
  {
    List<HistoryProduct> returnList = new ArrayList<HistoryProduct>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT \"SEP3\".transactionproduct.transactionid, \"SEP3\".product.title, \"SEP3\".product.category, \"SEP3\".transactionproduct.quantity\n"
              + "FROM \"SEP3\".product\n"
              + "INNER JOIN \"SEP3\".transactionproduct\n"
              + "ON (\"SEP3\".product.productid = \"SEP3\".transactionproduct.productid)\n"
              + "WHERE \"SEP3\".transactionproduct.transactionid = ?");
      statement.setInt(1, transid);

      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        HistoryProduct content = new HistoryProduct();
        content.setTransactionid(resultSet.getInt("transactionid"));
        content.setTitle(resultSet.getString("title"));
        content.setCategory(resultSet.getString("category"));
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

  @Override public List<ReserveHistory> getAllReserveHistory()
      throws SQLException
  {
    List<ReserveHistory> returnList = new ArrayList<ReserveHistory>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT \"SEP3\".transaction.transactionid, \"SEP3\".transaction.storeid, \"SEP3\".transactionproduct.productid,\"SEP3\".product.title, \n"
              + "\"SEP3\".transactionproduct.quantity, \"SEP3\".transaction.totalprice ,\"SEP3\".transaction.customername,\n"
              + "\"SEP3\".transaction.email, \"SEP3\".transaction.deliverymethod\n"
              + "From \"SEP3\".transactionproduct\n"
              + "JOIN \"SEP3\".transaction\n"
              + "ON \"SEP3\".transactionproduct.transactionid = \"SEP3\".transaction.transactionid\n"
              + "JOIN \"SEP3\".product\n"
              + "ON \"SEP3\".transactionproduct.productid = \"SEP3\".product.productid;");

      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        ReserveHistory content = new ReserveHistory();
        content.setTransactionod(resultSet.getInt("transactionid"));
        content.setStoreid(resultSet.getInt("storeid"));
        content.setTitle(resultSet.getString("title"));
        content.setQuantity(resultSet.getInt("quantity"));
        content.setTotalprice(resultSet.getDouble("totalprice"));
        content.setCustomername(resultSet.getString("customername"));
        content.setEmail(resultSet.getString("email"));
        content.setDeliverymethod(resultSet.getString("deliverymethod"));
        content.setProductid(resultSet.getInt("productid"));

        returnList.add(content);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return returnList;
  }

  @Override public List<ReserveHistory> getReserveHistoryByStoreEmail(
      int storeid, String email) throws SQLException
  {
    List<ReserveHistory> returnList = new ArrayList<ReserveHistory>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement;
      if (storeid == 0)
      {
        statement = connection.prepareStatement(
            "SELECT \"SEP3\".transaction.transactionid, \"SEP3\".transaction.storeid,\"SEP3\".transactionproduct.productid, \"SEP3\".product.title, \n"
                + "\"SEP3\".transactionproduct.quantity, \"SEP3\".transaction.totalprice ,\"SEP3\".transaction.customername,\n"
                + "\"SEP3\".transaction.email, \"SEP3\".transaction.deliverymethod\n"
                + "From \"SEP3\".transactionproduct\n" + "JOIN \"SEP3\".transaction\n"
                + "ON \"SEP3\".transactionproduct.transactionid = \"SEP3\".transaction.transactionid\n"
                + "JOIN \"SEP3\".product\n" + "ON \"SEP3\".transactionproduct.productid = \"SEP3\".product.productid\n"
                + "where deliverymethod LIKE ? AND storeid > ?;");
      }else
      {
        statement = connection.prepareStatement(
            "SELECT \"SEP3\".transaction.transactionid, \"SEP3\".transaction.storeid,\"SEP3\".transactionproduct.productid, \"SEP3\".product.title, \n"
                + "\"SEP3\".transactionproduct.quantity, \"SEP3\".transaction.totalprice ,\"SEP3\".transaction.customername,\n"
                + "\"SEP3\".transaction.email, \"SEP3\".transaction.deliverymethod\n"
                + "From \"SEP3\".transactionproduct\n" + "JOIN \"SEP3\".transaction\n"
                + "ON \"SEP3\".transactionproduct.transactionid = \"SEP3\".transaction.transactionid\n"
                + "JOIN \"SEP3\".product\n" + "ON \"SEP3\".transactionproduct.productid = \"SEP3\".product.productid\n"
                + "where deliverymethod LIKE ? AND storeid = ?;");
      }
      statement.setString(1, "%" + email + "%");
      statement.setInt(2, storeid);

      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        ReserveHistory content = new ReserveHistory();
        content.setTransactionod(resultSet.getInt("transactionid"));
        content.setStoreid(resultSet.getInt("storeid"));
        content.setTitle(resultSet.getString("title"));
        content.setQuantity(resultSet.getInt("quantity"));
        content.setTotalprice(resultSet.getDouble("totalprice"));
        content.setCustomername(resultSet.getString("customername"));
        content.setEmail(resultSet.getString("email"));
        content.setDeliverymethod(resultSet.getString("deliverymethod"));
        content.setProductid(resultSet.getInt("productid"));

        returnList.add(content);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return returnList;
  }

  @Override public List<ReserveHistory> getReserveHistoryByStoreEmailDelivery(
      int storeid, String email, String deliverymethod) throws SQLException
  {
    List<ReserveHistory> returnList = new ArrayList<ReserveHistory>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement;
      if (storeid == 0)
      {
         statement = connection.prepareStatement(
            "SELECT \"SEP3\".transaction.transactionid, \"SEP3\".transaction.storeid,\"SEP3\".transactionproduct.productid, \"SEP3\".product.title, \n"
                + "\"SEP3\".transactionproduct.quantity, \"SEP3\".transaction.totalprice ,\"SEP3\".transaction.customername,\n"
                + "\"SEP3\".transaction.email, \"SEP3\".transaction.deliverymethod\n"
                + "From \"SEP3\".transactionproduct\n"
                + "JOIN \"SEP3\".transaction\n"
                + "ON \"SEP3\".transactionproduct.transactionid = \"SEP3\".transaction.transactionid\n"
                + "JOIN \"SEP3\".product\n"
                + "ON \"SEP3\".transactionproduct.productid = \"SEP3\".product.productid\n"
                + "where email LIKE ? AND storeid > ? AND deliverymethod LIKE ?;");
      }
      else
      {
         statement = connection.prepareStatement(
            "SELECT \"SEP3\".transaction.transactionid, \"SEP3\".transaction.storeid,\"SEP3\".transactionproduct.productid, \"SEP3\".product.title, \n"
                + "\"SEP3\".transactionproduct.quantity, \"SEP3\".transaction.totalprice ,\"SEP3\".transaction.customername,\n"
                + "\"SEP3\".transaction.email, \"SEP3\".transaction.deliverymethod\n"
                + "From \"SEP3\".transactionproduct\n"
                + "JOIN \"SEP3\".transaction\n"
                + "ON \"SEP3\".transactionproduct.transactionid = \"SEP3\".transaction.transactionid\n"
                + "JOIN \"SEP3\".product\n"
                + "ON \"SEP3\".transactionproduct.productid = \"SEP3\".product.productid\n"
                + "where email LIKE ? AND storeid= ? AND deliverymethod LIKE ?;");
      }

      statement.setString(1, "%" + email + "%");
      statement.setInt(2, storeid);
      statement.setString(3, "%" + deliverymethod + "%");

      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        ReserveHistory content = new ReserveHistory();
        content.setTransactionod(resultSet.getInt("transactionid"));
        content.setStoreid(resultSet.getInt("storeid"));
        content.setTitle(resultSet.getString("title"));
        content.setQuantity(resultSet.getInt("quantity"));
        content.setTotalprice(resultSet.getDouble("totalprice"));
        content.setCustomername(resultSet.getString("customername"));
        content.setEmail(resultSet.getString("email"));
        content.setDeliverymethod(resultSet.getString("deliverymethod"));
        content.setProductid(resultSet.getInt("productid"));

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
