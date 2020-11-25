package networking;

import model.DatabaseManager;
import model.DatabaseManagerImpl;
import transferobjects.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Handler implements Runnable
{
    private Socket socket;
    private DatabaseManagerImpl databaseManager;

    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public Handler(Socket socket, DatabaseManagerImpl databaseManager)
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
            else if("RegisterCustomerUser".equals(request.getType()))
            {
                databaseManager.getCustomerManager().registerCustomerUser((CustomerUser)request.getArg());
            }
            else if("RegisterEmployeeUser".equals(request.getType()))
            {
                databaseManager.getEmployeeManager().registerEmployeeUser((EmployeeUser)request.getArg());
            }
            else if("GetAllUsers".equals(request.getType())){
                List<CustomerUser> result = databaseManager.getCustomerManager().getAllUsers();
                outToClient.writeObject(new Request("GetAllUsers", result));
            }
            else if("GetCustomerUser".equals(request.getType())){
                CustomerUser result = databaseManager.getCustomerManager().getCustomerUser((String)request.getArg());
                outToClient.writeObject(new Request("GetCustomerUser", result));
            }
            else if("GetEmployeeUser".equals(request.getType())){
                EmployeeUser result = databaseManager.getEmployeeManager().getEmployeeUser((String)request.getArg());
                outToClient.writeObject(new Request("GetEmployeeUser", result));
            }
            else if("GetTitleFilteredProducts".equals(request.getType())){
                List<Product> result = databaseManager.getProductManager().getTitleFilteredProducts((String)request.getArg());
                outToClient.writeObject(new Request("GetTitleFilteredProducts", result));
            }
            else if("GetTitleCategoryFilteredProducts".equals(request.getType())){
                String [] requests = (String[]) request.getArg();
                String title = requests[0];
                String category = requests[1];
                List<Product> result = databaseManager.getProductManager().getTitleCategoryFilteredProducts(title, category);
                outToClient.writeObject(new Request("GetTitleCategoryFilteredProducts", result));
            }
            else if("GetTitleCategoryPriceFilteredProducts".equals(request.getType())){
                String [] requests = (String[]) request.getArg();
                String title = requests[0];
                String category = requests[1];
                String price = requests[2];
                List<Product> result = databaseManager.getProductManager().getTitleCategoryPriceFilteredProducts(title, category,price);
                outToClient.writeObject(new Request("GetTitleCategoryPriceFilteredProducts", result));
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
