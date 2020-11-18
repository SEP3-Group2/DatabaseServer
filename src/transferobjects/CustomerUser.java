package transferobjects;


import java.io.Serializable;
import java.sql.Date;

public class CustomerUser implements Serializable
{
    private int userID;
    private String email;
    private String password;
    private String name;
    private String address;
    private String phone;
    private Date birthday;

    public CustomerUser(int userID, String email, String password, String name, String address, String phone, Date birthday)
    {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
    }

    public CustomerUser()
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

    public Date getBirthday()
    {
        return birthday;
    }
}
