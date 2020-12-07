package database.transactionproduct;

import transferobjects.HistoryProduct;
import transferobjects.Transaction;
import transferobjects.TransactionProduct;

import java.sql.SQLException;
import java.util.List;

public interface TransactionProductDAO
{
  TransactionProduct addTransactionProduct(TransactionProduct transactionProduct) throws SQLException;

  List<HistoryProduct> getTransProById(int transid)throws SQLException;
}
