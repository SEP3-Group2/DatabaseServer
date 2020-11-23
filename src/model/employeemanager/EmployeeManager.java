package model.employeemanager;

import transferobjects.CustomerUser;
import transferobjects.EmployeeUser;

import java.util.List;

public interface EmployeeManager
{
    void registerEmployeeUser(EmployeeUser employeeUser);
    EmployeeUser getEmployeeUser(String email);
}
