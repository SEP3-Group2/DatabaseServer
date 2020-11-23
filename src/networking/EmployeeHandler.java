package networking;

import model.DatabaseManager;
import model.DatabaseManagerImpl;
import transferobjects.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class EmployeeHandler implements Runnable
{
    private Socket socket;
    private DatabaseManagerImpl databaseManager;

    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public EmployeeHandler(Socket socket, DatabaseManagerImpl databaseManager)
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
            if("RegisterEmployeeUser".equals(request.getType()))
            {
                databaseManager.getEmployeeManager().registerEmployeeUser((EmployeeUser)request.getArg());
            }
            else if("GetEmployeeUser".equals(request.getType())){
                EmployeeUser result = databaseManager.getEmployeeManager().getEmployeeUser((String)request.getArg());
                outToClient.writeObject(new Request("GetEmployeeUser", result));
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
