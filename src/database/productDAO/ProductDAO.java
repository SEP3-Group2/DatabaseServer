package database.productDAO;

import transferobjects.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO
{
    List<Product> getAllProducts() throws SQLException;
    Product addProduct(String title, String category, String description, double price) throws SQLException;
}
