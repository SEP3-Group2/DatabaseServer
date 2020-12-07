package model.productmanager;

import transferobjects.Product;

import java.util.List;

public interface ProductManager
{
    List<Product> getAllProducts();
    Product getProductById(int id);
    List<Product> getTitleCategoryFilteredProducts(String title, String category);
    List<Product> getTitleCategoryPriceFilteredProducts(String title, String category, String price);

    Product addProduct(String title, String category, String description, double price);
    void modifyProduct(Product product);

    int getLastProductID();
}
