package model;

import database.clientDAO.ClientDAO;
import database.clientDAO.ClientDAOImpl;
import database.customerUserDAO.CustomerUserDAO;
import database.customerUserDAO.CustomerUserDAOImpl;
import database.employeeUserDAO.EmployeeUserDAO;
import database.employeeUserDAO.EmployeeUserDAOImpl;
import database.productDAO.ProductDAO;
import database.productDAO.ProductDAOImpl;
import model.customermanager.CustomerManager;
import model.customermanager.CustomerManagerImpl;
import model.employeemanager.EmployeeManager;
import model.employeemanager.EmployeeManagerImpl;
import model.productmanager.ProductManager;
import model.productmanager.ProductManagerImpl;
import transferobjects.EmployeeUser;
import transferobjects.Hello;
import transferobjects.Product;
import transferobjects.CustomerUser;

import java.sql.SQLException;
import java.util.List;

public class DatabaseManagerImpl
{
    private final CustomerManager customerManager;
    private final ProductManager productManager;
    private final EmployeeManager employeeManager;

    public DatabaseManagerImpl()
    {
        customerManager = new CustomerManagerImpl();
        productManager = new ProductManagerImpl();
        employeeManager = new EmployeeManagerImpl();
    }

    public CustomerManager getCustomerManager()
    {
        return customerManager;
    }

    public ProductManager getProductManager()
    {
        return productManager;
    }

    public EmployeeManager getEmployeeManager()
    {
        return employeeManager;
    }

    /*
    private ClientDAO clientDAO;
    private ProductDAO productDAO;
    private CustomerUserDAO customerUserDAO;
    private EmployeeUserDAO employeeUserDAO;

    public DatabaseManagerImpl()
    {
        try
        {
            clientDAO = ClientDAOImpl.getInstance();
            productDAO = ProductDAOImpl.getInstance();
            customerUserDAO = CustomerUserDAOImpl.getInstance();
            employeeUserDAO = EmployeeUserDAOImpl.getInstance();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
    //woof


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

    @Override public boolean addProduct(String title, String category,
        String description, double price)
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

    @Override
    public void registerCustomerUser(CustomerUser customerUser)
    {
        try
        {
            System.out.println(customerUser.getEmail() + customerUser.getAddress() + customerUser.getName());
            customerUserDAO.addUser(customerUser);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<CustomerUser> getAllUsers()
    {
        try
        {
            return customerUserDAO.getAllUsers();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void registerEmployeeUser(EmployeeUser employeeUser)
    {
        try
        {
            employeeUserDAO.addUser(employeeUser);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public CustomerUser getCustomerUser(String email)
    {
        try
        {
            return customerUserDAO.getUser(email);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public EmployeeUser getEmployeeUser(String email)
    {
        try
        {
            return employeeUserDAO.getUser(email);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

     */

}
