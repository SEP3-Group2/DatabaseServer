package model;

import transferobjects.EmployeeUser;
import transferobjects.Hello;
import transferobjects.Product;
import transferobjects.CustomerUser;

import java.util.List;

public interface DatabaseManager
{
    //maybe add listener (subject)
    Hello getHello();
    
    List<Product> getAllProducts();
    List<Product> getFilteredProducts(String title);
    boolean addProduct(String title, String category, String description, double price);

    void registerCustomerUser(CustomerUser customerUser);
    List<CustomerUser> getAllUsers();
    void registerEmployeeUser(EmployeeUser employeeUser);

    CustomerUser getCustomerUser(String email);

    EmployeeUser getEmployeeUser(String email);
}
