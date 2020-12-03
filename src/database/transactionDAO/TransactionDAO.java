package database.transactionDAO;

import transferobjects.Transaction;

import java.sql.SQLException;

public interface TransactionDAO
{
  Transaction addTransaction(Transaction transaction) throws SQLException;
}
