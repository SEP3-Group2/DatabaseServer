package database.transactionproduct;

import database.transactionDAO.TransactionDAO;
import database.transactionDAO.TransactionDAOImpl;
import transferobjects.Transaction;
import transferobjects.TransactionProduct;

import java.sql.*;

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
}
