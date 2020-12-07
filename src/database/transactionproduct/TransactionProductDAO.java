package database.transactionproduct;

import transferobjects.Transaction;
import transferobjects.TransactionProduct;

import java.sql.SQLException;

public interface TransactionProductDAO
{
  TransactionProduct addTransactionProduct(TransactionProduct transactionProduct) throws SQLException;
}
