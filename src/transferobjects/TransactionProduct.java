package transferobjects;

import java.io.Serializable;

public class TransactionProduct implements Serializable
{
  private int transactionid;
  private int productid;
  private int quantity;

  public TransactionProduct()
  {
  }

  public TransactionProduct(int transactionid, int productid, int quantity)
  {
    this.transactionid = transactionid;
    this.productid = productid;
    this.quantity = quantity;
  }

  public int getTransactionid()
  {
    return transactionid;
  }

  public void setTransactionid(int transactionid)
  {
    this.transactionid = transactionid;
  }

  public int getProductid()
  {
    return productid;
  }

  public void setProductid(int productid)
  {
    this.productid = productid;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public void setQuantity(int quantity)
  {
    this.quantity = quantity;
  }
}
