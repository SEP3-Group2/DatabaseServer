package networking;

import model.DatabaseManager;
import transferobjects.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Handler implements Runnable
{
    private Socket socket;
    private DatabaseManager databaseManager;

    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public Handler(Socket socket, DatabaseManager databaseManager)
    {
        this.socket = socket;
        this.databaseManager = databaseManager;

        try
        {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //woof

    @Override public void run()
    {
        try
        {
            Request request = (Request) inFromClient.readObject();
            if ("GetHello".equals(request.getType()))
            {
                Hello result = databaseManager.getHello();
                outToClient.writeObject(new Request("GetHello", result));
            }
            else if("GetAllProducts".equals(request.getType())){
                List<Product> result = databaseManager.getAllProducts();
                outToClient.writeObject(new Request("GetAllProducts", result));
            }
            else if ("AddProduct".equals(request.getType())){
                Product product1 = (Product) request.getArg();
                boolean product = databaseManager.addProduct(product1.getTitle(),product1.getCategory(), product1.getDescription(), product1.getPrice());
                outToClient.writeObject(new Request("AddProduct", product));
            }
            else if("RegisterCustomerUser".equals(request.getType()))
            {
                databaseManager.registerCustomerUser((CustomerUser)request.getArg());
            }
            else if("RegisterEmployeeUser".equals(request.getType()))
            {
                databaseManager.registerEmployeeUser((EmployeeUser)request.getArg());
            }
            else if("GetAllUsers".equals(request.getType())){
                List<CustomerUser> result = databaseManager.getAllUsers();
                outToClient.writeObject(new Request("GetAllUsers", result));
            }
            else if("GetCustomerUser".equals(request.getType())){
                CustomerUser result = databaseManager.getCustomerUser((String)request.getArg());
                outToClient.writeObject(new Request("GetCustomerUser", result));
            }
            else if("GetEmployeeUser".equals(request.getType())){
                EmployeeUser result = databaseManager.getEmployeeUser((String)request.getArg());
                outToClient.writeObject(new Request("GetEmployeeUser", result));
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
