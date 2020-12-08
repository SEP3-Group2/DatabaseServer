package database.transactionDAO;

import transferobjects.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface TransactionDAO
{
  Transaction addTransaction(Transaction transaction) throws SQLException;
  int getLastTransactionID() throws SQLException;
  List<Transaction> GetTransactionsByEmail(String email) throws SQLException;

Transaction UpdateTransactionToReady(int id) throws SQLException;
  Transaction UpdateTransactionToDelivered(int id) throws SQLException;
}
