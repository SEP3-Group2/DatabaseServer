package database.transactionproduct;

import transferobjects.HistoryProduct;
import transferobjects.ReserveHistory;
import transferobjects.Transaction;
import transferobjects.TransactionProduct;

import java.sql.SQLException;
import java.util.List;

public interface TransactionProductDAO
{
  TransactionProduct addTransactionProduct(TransactionProduct transactionProduct) throws SQLException;

  List<HistoryProduct> getTransProById(int transid) throws SQLException;

  List<ReserveHistory> getAllReserveHistory() throws SQLException;
  List<ReserveHistory> getReserveHistoryByStoreEmail(int storeid, String email) throws SQLException;
  List<ReserveHistory> getReserveHistoryByStoreEmailDelivery(int storeid, String email, String deliverymethod) throws SQLException;
}
