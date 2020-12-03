package transferobjects;

import java.io.Serializable;
import java.sql.Date;

public class Transaction implements Serializable
{
  private  int id;
  private int storeid;
  private Date date;
  private double totalPrice;
  private String customername;
  private String phone;
  private String address;
  private String deliverymethod;
  private String email;

  public Transaction()
  {
  }

  public Transaction(int id, int storeid, Date date, double totalPrice,
       String customername, String phone, String address,
      String deliverymethod, String email)
  {
    this.id = id;
    this.storeid = storeid;
    this.date = date;
    this.totalPrice = totalPrice;
    this.customername = customername;
    this.phone = phone;
    this.address = address;
    this.deliverymethod = deliverymethod;
    this.email = email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getEmail()
  {
    return email;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public int getStoreid()
  {
    return storeid;
  }

  public void setStoreid(int storeid)
  {
    this.storeid = storeid;
  }

  public Date getDate()
  {
    return date;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  public double getTotalPrice()
  {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice)
  {
    this.totalPrice = totalPrice;
  }



  public String getCustomerName()
  {
    return customername;
  }

  public void setCustomerName(String customerName)
  {
    this.customername = customerName;
  }

  public String getPhone()
  {
    return phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getDeliverymethod()
  {
    return deliverymethod;
  }

  public void setDeliverymethod(String deliverymethod)
  {
    this.deliverymethod = deliverymethod;
  }
}
