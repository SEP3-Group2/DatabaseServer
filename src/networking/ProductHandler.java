package networking;

import model.DatabaseManager;
import model.DatabaseManagerImpl;
import transferobjects.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ProductHandler implements Runnable
{
    private Socket socket;
    private DatabaseManagerImpl databaseManager;

    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public ProductHandler(Socket socket, DatabaseManagerImpl databaseManager)
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
            if("GetAllProducts".equals(request.getType())){
                List<Product> result = databaseManager.getProductManager().getAllProducts();
                outToClient.writeObject(new Request("GetAllProducts", result));
            }
            else if ("AddProduct".equals(request.getType())){
                Product product1 = (Product) request.getArg();
                boolean product = databaseManager.getProductManager().addProduct(product1.getTitle(),product1.getCategory(), product1.getDescription(), product1.getPrice());
                outToClient.writeObject(new Request("AddProduct", product));
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
