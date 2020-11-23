package model.productmanager;

import transferobjects.Product;

import java.util.List;

public interface ProductManager
{
    List<Product> getAllProducts();
    boolean addProduct(String title, String category, String description, double price);
}
