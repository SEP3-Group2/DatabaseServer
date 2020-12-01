package model.productmanager;

import database.productDAO.ProductDAO;
import database.productDAO.ProductDAOImpl;
import transferobjects.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductManagerImpl implements ProductManager
{
    private ProductDAO productDAO;

    public ProductManagerImpl()
    {
        try
        {
            productDAO = ProductDAOImpl.getInstance();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProducts()
    {
        try
        {
            return productDAO.getAllProducts();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override public Product getProductById(int id)
    {
        try
        {
            return productDAO.getProductById(id);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override public List<Product> getTitleCategoryFilteredProducts(String title, String category)
    {
        try
        {
            return productDAO.getTitleCategoryFilteredProducts(title,category);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override public List<Product> getTitleCategoryPriceFilteredProducts(String title, String category, String price)
    {
        try
        {
            return productDAO.getTitleCategoryPriceFilteredProducts(title,category,Integer.parseInt(price));
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addProduct(String title, String category, String description, double price)
    {
        try
        {
            Product tmp = productDAO.addProduct(title, category, description, price);
            if(tmp != null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
