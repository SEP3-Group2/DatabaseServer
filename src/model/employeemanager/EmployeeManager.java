package model.employeemanager;

import transferobjects.CustomerUser;
import transferobjects.EmployeeUser;

import java.util.List;

public interface EmployeeManager
{
    void registerEmployeeUser(EmployeeUser employeeUser);
    EmployeeUser getEmployeeUser(String email);

    List<EmployeeUser> getAllEmployeeUsers();

    EmployeeUser getEmployeeByID(int id);

    EmployeeUser updateEmployeeUser(EmployeeUser user);

    void deleteUser(int id);
}
