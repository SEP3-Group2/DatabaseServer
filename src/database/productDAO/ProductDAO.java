package database.productDAO;

import transferobjects.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO
{
    List<Product> getAllProducts() throws SQLException;
}
