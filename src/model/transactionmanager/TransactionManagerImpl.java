package model.transactionmanager;

import database.transactionDAO.TransactionDAO;
import database.transactionDAO.TransactionDAOImpl;
import database.warehouseproductDAO.WarehouseProductDAO;
import database.warehouseproductDAO.WarehouseProductDAOImpl;
import transferobjects.Transaction;
import transferobjects.WarehouseProduct;

import java.sql.SQLException;

public class TransactionManagerImpl implements TransactionManager
{
  private TransactionDAO transactionDAO;

  public TransactionManagerImpl(){
    try
    {
      transactionDAO = TransactionDAOImpl.getInstance();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public Transaction addTransaction(Transaction transaction)
  {
    try
    {
      return transactionDAO.addTransaction(transaction);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public int getLastTransactionID()
  {
    try
    {
      return transactionDAO.getLastTransactionID();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return 0;
  }
}
