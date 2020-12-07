package transferobjects;

import java.io.Serializable;

public class HistoryProduct implements Serializable
{
  private int transactionid;
  private String title;
  private  String category;
  private int quantity;

  public HistoryProduct()
  {
  }

  public HistoryProduct(int transactionid, String title, String category,
      int quantity)
  {
    this.transactionid = transactionid;
    this.title = title;
    this.category = category;
    this.quantity = quantity;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getCategory()
  {
    return category;
  }

  public void setCategory(String category)
  {
    this.category = category;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public void setQuantity(int quantity)
  {
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
}
