package networking;

import model.DatabaseManager;
import transferobjects.Hello;
import transferobjects.Product;
import transferobjects.Request;

import java.beans.PropertyChangeEvent;
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
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
