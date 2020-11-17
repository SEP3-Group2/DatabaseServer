package model;

import transferobjects.Hello;
import transferobjects.Image;
import transferobjects.Product;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseManager
{
    //maybe add listener (subject)
    Hello getHello();
    
    List<Product> getAllProducts();
    boolean addProduct(String title, String category, String description, double price);
}
