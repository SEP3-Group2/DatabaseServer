package model.transactionmanager;

import transferobjects.Transaction;
import transferobjects.WarehouseProduct;

import java.sql.SQLException;
import java.util.List;

public interface TransactionManager
{
  Transaction addTransaction(Transaction transaction);

  int getLastTransactionID();
  List<Transaction> GetTransactionsByEmail(String email);
  Transaction UpdateTransactionToReady(int id) ;
  Transaction UpdateTransactionToDelivered(int id) ;

}
