package model.productmanager;

import transferobjects.Product;

import java.util.List;

public interface ProductManager
{
    List<Product> getAllProducts();
    List<Product> getTitleFilteredProducts(String title);
    List<Product> getTitleCategoryFilteredProducts(String title, String category);
    List<Product> getTitleCategoryPriceFilteredProducts(String title, String category, String price);

    boolean addProduct(String title, String category, String description, double price);
}
