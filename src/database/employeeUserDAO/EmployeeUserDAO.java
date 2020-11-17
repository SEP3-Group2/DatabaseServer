package database.employeeUserDAO;

import transferobjects.CustomerUser;
import transferobjects.EmployeeUser;

import java.sql.SQLException;

public interface EmployeeUserDAO
{
    void addUser(EmployeeUser employeeUser) throws SQLException;
}
