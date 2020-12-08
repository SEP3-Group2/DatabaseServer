package model.transactionproductmanager;

import transferobjects.HistoryProduct;
import transferobjects.ReserveHistory;
import transferobjects.Transaction;
import transferobjects.TransactionProduct;

import java.sql.SQLException;
import java.util.List;

public interface TransactionProductManager
{
  TransactionProduct addTransactionProduct(TransactionProduct transactionProduct);

  List<HistoryProduct> getTransProById(int transid);

  List<ReserveHistory> getAllReserveHistory();
  List<ReserveHistory> getReserveHistoryByStoreEmail(int storeid, String email)  ;
  List<ReserveHistory> getReserveHistoryByStoreEmailDelivery(int storeid, String email, String deliverymethod)  ;
}
