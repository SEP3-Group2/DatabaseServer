package transferobjects;

import java.io.Serializable;

public class Product implements Serializable
{
    private int id;
    private String title;
    private String category;
    private String description;
    private double price;

    public Product( int id,String title, String category, String description,
        double price)
    {
        this.id=id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.price = price;
    }
    public Product( String title, String category, String description,
        double price)
    {
        this.title = title;
        this.category = category;
        this.description = description;
        this.price = price;
    }
    public Product(){

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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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
