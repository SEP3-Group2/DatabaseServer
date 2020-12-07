package database.employeeUserDAO;

import transferobjects.CustomerUser;
import transferobjects.EmployeeUser;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeUserDAO
{
    void addUser(EmployeeUser employeeUser) throws SQLException;

    EmployeeUser getUser(String email) throws SQLException;

    List<EmployeeUser> getAllUsers()throws SQLException;

    EmployeeUser getUserByID(int id)throws SQLException;

    EmployeeUser updateUser(EmployeeUser user) throws SQLException;

    void deleteUser(int id) throws SQLException;
}
