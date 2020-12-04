package database.transactionDAO;

import database.warehouseproductDAO.WarehouseProductDAOImpl;
import transferobjects.Transaction;

import java.sql.*;

public class TransactionDAOImpl implements TransactionDAO
{
  private static TransactionDAOImpl instance;


  private TransactionDAOImpl() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }
  public static synchronized TransactionDAOImpl getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new TransactionDAOImpl();
    }
    return instance;
  }
  private Connection getConnection() throws SQLException
  {
    return DriverManager
        .getConnection("jdbc:postgresql://localhost:5432/projectsep3", "group2",
            "password");
  }

  @Override public Transaction addTransaction(Transaction transaction)
      throws SQLException
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO\"SEP3\".transaction(storeid, date, totalprice, customername, phone, address, deliverymethod,email) VALUES(?,?,?,?,?,?,?,?)",
          PreparedStatement.RETURN_GENERATED_KEYS);

      statement.setInt(1, transaction.getStoreid());
      statement.setDate(2, transaction.getDate());
      statement.setDouble(3, transaction.getTotalPrice());
      statement.setString(4, transaction.getCustomerName());
      statement.setString(5, transaction.getPhone());
      statement.setString(6, transaction.getAddress());
      statement.setString(7, transaction.getDeliverymethod());
      statement.setString(8, transaction.getEmail());
      statement.executeUpdate();

      ResultSet resultSet = statement.getGeneratedKeys();
      if (resultSet.next())
      {
        System.out.println("Transaction added to database");
        return new Transaction();
      }
      else{
        throw new SQLException("No keys generated");
      }
    }
  }

  @Override public int getLastTransactionID() throws SQLException
  {
    int content = 0;
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT MAX(transactionid) FROM \"SEP3\".transaction;");
      ResultSet resultSet = statement.executeQuery();

      if (resultSet.next())
      {
        content = resultSet.getInt("max");
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return content;
  }

}
