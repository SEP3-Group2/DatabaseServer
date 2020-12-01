package database.productDAO;

import transferobjects.Product;


import java.sql.SQLException;
import java.util.List;

public interface ProductDAO
{
    List<Product> getAllProducts() throws SQLException;
    Product getProductById(int id) throws SQLException;
    List<Product> getTitleCategoryFilteredProducts(String title, String category) throws SQLException;
    List<Product> getTitleCategoryPriceFilteredProducts(String title, String category,int price) throws SQLException;

    Product addProduct(String title, String category, String description, double price) throws SQLException;
}
