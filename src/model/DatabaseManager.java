package model;

import transferobjects.Hello;
import transferobjects.Product;

import java.util.List;

public interface DatabaseManager
{
    //maybe add listener (subject)
    Hello getHello();
    
    List<Product> getAllProducts();
}
