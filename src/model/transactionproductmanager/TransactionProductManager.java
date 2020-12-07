package model.transactionproductmanager;

import transferobjects.HistoryProduct;
import transferobjects.Transaction;
import transferobjects.TransactionProduct;

import java.sql.SQLException;
import java.util.List;

public interface TransactionProductManager
{
  TransactionProduct addTransactionProduct(TransactionProduct transactionProduct);

  List<HistoryProduct> getTransProById(int transid) ;
}
