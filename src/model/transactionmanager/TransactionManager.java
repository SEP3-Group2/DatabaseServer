package model.transactionmanager;

import transferobjects.Transaction;
import transferobjects.WarehouseProduct;

import java.util.List;

public interface TransactionManager
{
  Transaction addTransaction(Transaction transaction);

  int getLastTransactionID();
  List<Transaction> GetTransactionsByEmail(String email);

}
