package transferobjects;

import java.io.Serializable;

public class ReserveHistory implements Serializable
{
  private int transactionod;
  private int storeid;
  private int productid;
  private String customername;
  private String email;
  private String deliverymethod;
  private int quantity;
  private double totalprice;
  private String title;

  public ReserveHistory()
  {
  }

  public ReserveHistory(int transactionod, int storeid, int productid,
      String customername, String email, String deliverymethod, int quantity,
      double totalprice, String title)
  {
    this.transactionod = transactionod;
    this.storeid = storeid;
    this.productid = productid;
    this.customername = customername;
    this.email = email;
    this.deliverymethod = deliverymethod;
    this.quantity = quantity;
    this.totalprice = totalprice;
    this.title = title;
  }

  public int getTransactionod()
  {
    return transactionod;
  }

  public void setTransactionod(int transactionod)
  {
    this.transactionod = transactionod;
  }

  public int getStoreid()
  {
    return storeid;
  }

  public void setStoreid(int storeid)
  {
    this.storeid = storeid;
  }

  public String getCustomername()
  {
    return customername;
  }

  public void setCustomername(String customername)
  {
    this.customername = customername;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getDeliverymethod()
  {
    return deliverymethod;
  }

  public void setDeliverymethod(String deliverymethod)
  {
    this.deliverymethod = deliverymethod;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public void setQuantity(int quantity)
  {
    this.quantity = quantity;
  }

  public double getTotalprice()
  {
    return totalprice;
  }

  public void setTotalprice(double totalprice)
  {
    this.totalprice = totalprice;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public int getProductid()
  {
    return productid;
  }

  public void setProductid(int productid)
  {
    this.productid = productid;
  }
}
