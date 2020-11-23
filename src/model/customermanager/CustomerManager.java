package model.customermanager;

import transferobjects.CustomerUser;
import transferobjects.EmployeeUser;

import java.util.List;

public interface CustomerManager
{
    void registerCustomerUser(CustomerUser customerUser);
    List<CustomerUser> getAllUsers();
    CustomerUser getCustomerUser(String email);
}
