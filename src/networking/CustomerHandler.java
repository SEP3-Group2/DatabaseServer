package networking;

import model.DatabaseManager;
import model.DatabaseManagerImpl;
import transferobjects.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class CustomerHandler implements Runnable
{
    private Socket socket;
    private DatabaseManagerImpl databaseManager;

    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public CustomerHandler(Socket socket, DatabaseManagerImpl databaseManager)
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

    @Override public void run()
    {
        try
        {
            Request request = (Request) inFromClient.readObject();
            if("RegisterCustomerUser".equals(request.getType()))
            {
                databaseManager.getCustomerManager().registerCustomerUser((CustomerUser)request.getArg());
            }
            else if("GetAllUsers".equals(request.getType())){
                List<CustomerUser> result = databaseManager.getCustomerManager().getAllUsers();
                outToClient.writeObject(new Request("GetAllUsers", result));
            }
            else if("GetCustomerUser".equals(request.getType())){
                CustomerUser result = databaseManager.getCustomerManager().getCustomerUser((String)request.getArg());
                outToClient.writeObject(new Request("GetCustomerUser", result));
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
