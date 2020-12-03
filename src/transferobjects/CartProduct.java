package transferobjects;

import java.io.Serializable;

public class CartProduct implements Serializable
{
  private int id;
  private String title;
  private String category;
  private double price;
  private int storeid;
  private int quantity;

  public CartProduct( int id,String title, String category, int storeid,
      double price, int quantity)
  {
    this.id=id;
    this.title = title;
    this.category = category;
    this.storeid = storeid;
    this.price = price;
    this.quantity = quantity;
  }

  public CartProduct(){ }

  public int getQuantity()
  {
    return quantity;
  }

  public void setQuantity(int quantity)
  {
    this.quantity = quantity;
  }

  public int getStoreid()
  {
    return storeid;
  }

  public void setStoreid(int storeid)
  {
    this.storeid = storeid;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
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

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }
}
