package model;

import database.clientDAO.ClientDAO;
import database.clientDAO.ClientDAOImpl;
import database.productDAO.ProductDAO;
import database.productDAO.ProductDAOImpl;
import transferobjects.Hello;
import transferobjects.Product;

import java.sql.SQLException;
import java.util.List;

public class DatabaseManagerImpl implements DatabaseManager
{
    private ClientDAO clientDAO;
    private ProductDAO productDAO;

    public DatabaseManagerImpl()
    {
        try
        {
            clientDAO = ClientDAOImpl.getInstance();
            productDAO = ProductDAOImpl.getInstance();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public Hello getHello()
    {
        try
        {
            return clientDAO.getHello();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
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
}
