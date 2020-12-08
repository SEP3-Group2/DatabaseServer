package model.transactionproductmanager;

import database.transactionDAO.TransactionDAO;
import database.transactionDAO.TransactionDAOImpl;
import database.transactionproduct.TransactionProductDAO;
import database.transactionproduct.TransactionProductDAOImpl;
import model.transactionmanager.TransactionManager;
import transferobjects.HistoryProduct;
import transferobjects.ReserveHistory;
import transferobjects.Transaction;
import transferobjects.TransactionProduct;

import java.sql.SQLException;
import java.util.List;

public class TransactionProductManagerImpl implements TransactionProductManager
{
  private TransactionProductDAO transactionProductDAO;

  public TransactionProductManagerImpl(){
    try
    {
      transactionProductDAO = TransactionProductDAOImpl.getInstance();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public TransactionProduct addTransactionProduct(TransactionProduct transactionProduct)
  {
    try
    {
      return transactionProductDAO.addTransactionProduct(transactionProduct);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public List<HistoryProduct> getTransProById(int transid)
  {
    try
    {
      return transactionProductDAO.getTransProById(transid);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public List<ReserveHistory> getAllReserveHistory()
  {
    try
    {
      return transactionProductDAO.getAllReserveHistory();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public List<ReserveHistory> getReserveHistoryByStoreEmail(
      int storeid, String email)
  {
    try
    {
      return transactionProductDAO.getReserveHistoryByStoreEmail(storeid,email);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public List<ReserveHistory> getReserveHistoryByStoreEmailDelivery(
      int storeid, String email, String deliverymethod)
  {
    try
    {
      return transactionProductDAO.getReserveHistoryByStoreEmailDelivery(storeid, email, deliverymethod);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }
}
