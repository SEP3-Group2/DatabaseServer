package transferobjects;

import java.io.Serializable;
import java.sql.Date;

public class EmployeeUser implements Serializable
{
    private int userID;
    private String email;
    private String password;
    private String name;
    private String address;
    private String phone;
    private int securityLevel;
    private String position;
    private int storeID;

    public EmployeeUser(int userID, String name, String email, String address, String phone, int securityLevel, String position, int storeID, String password)
    {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.securityLevel = securityLevel;
        this.position = position;
        this.storeID = storeID;
    }

    public EmployeeUser()
    {
    }

    public int getUserID()
    {
        return userID;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPhone()
    {
        return phone;
    }

    public int getSecurityLevel()
    {
        return securityLevel;
    }

    public String getPosition()
    {
        return position;
    }

    public int getStoreID()
    {
        return storeID;
    }
}
