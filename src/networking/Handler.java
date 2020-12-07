package networking;

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

    @Override
    public void run()
    {
        try
        {
            Request request = (Request) inFromClient.readObject();
            if ("GetAllProducts".equals(request.getType()))
            {
                List<Product> result = databaseManager.getProductManager().getAllProducts();
                outToClient.writeObject(new Request("GetAllProducts", result));
            }
            else if ("AddProduct".equals(request.getType()))
            {
                Product product1 = (Product) request.getArg();
                Product product = databaseManager.getProductManager().addProduct(product1.getTitle(), product1.getCategory(), product1.getDescription(), product1.getPrice());
                outToClient.writeObject(new Request("AddProduct", product));
            }
            else if ("RegisterCustomerUser".equals(request.getType()))
            {
                databaseManager.getCustomerManager().registerCustomerUser((CustomerUser) request.getArg());
            }
            else if ("RegisterEmployeeUser".equals(request.getType()))
            {
                databaseManager.getEmployeeManager().registerEmployeeUser((EmployeeUser) request.getArg());
            }
            else if ("GetAllUsers".equals(request.getType()))
            {
                List<CustomerUser> result = databaseManager.getCustomerManager().getAllUsers();
                outToClient.writeObject(new Request("GetAllUsers", result));
            }
            else if ("GetCustomerUser".equals(request.getType()))
            {
                CustomerUser result = databaseManager.getCustomerManager().getCustomerUser((String) request.getArg());
                outToClient.writeObject(new Request("GetCustomerUser", result));
            }
            else if ("GetEmployeeUser".equals(request.getType()))
            {
                EmployeeUser result = databaseManager.getEmployeeManager().getEmployeeUser((String) request.getArg());
                outToClient.writeObject(new Request("GetEmployeeUser", result));
            }
            else if ("GetProductById".equals(request.getType()))
            {
                Product result = databaseManager.getProductManager().getProductById((int) request.getArg());
                outToClient.writeObject(new Request("GetProductById", result));
            }
            else if ("GetTitleCategoryPriceFilteredProducts".equals(request.getType()))
            {
                String[] requests = (String[]) request.getArg();
                String title = requests[0];
                String category = requests[1];
                String price = requests[2];
                List<Product> result = databaseManager.getProductManager().getTitleCategoryPriceFilteredProducts(title, category, price);
                outToClient.writeObject(new Request("GetTitleCategoryPriceFilteredProducts", result));
            }
            else if ("GetLastProductID".equals(request.getType()))
            {
                int returnID = databaseManager.getProductManager().getLastProductID();
                outToClient.writeObject(new Request("GetLastProductID", returnID));
            }
            else if ("GetLastTransactionID".equals(request.getType()))
            {
                int returnID = databaseManager.getTransactionManager().getLastTransactionID();
                outToClient.writeObject(new Request("GetLastTransactionID", returnID));
            }
            else if ("GetAllWarehouseProducts".equals(request.getType()))
            {
                List<WarehouseProduct> result = databaseManager.getWarehouseProductManager().getAllWarehouseProducts();
                outToClient.writeObject(new Request("GetAllWarehouseProducts", result));
            }
            else if ("GetStoreWarehouseProduct".equals(request.getType()))
            {
                List<WarehouseProduct> result = databaseManager.getWarehouseProductManager().getStoreWarehouseProducts((int) request.getArg());
                outToClient.writeObject(new Request("GetStoreWarehouseProduct", result));
            }
            else if ("AddWarehouseProduct".equals(request.getType()))
            {
                WarehouseProduct warehouseProduct1 = (WarehouseProduct) request.getArg();
                WarehouseProduct warehouseProduct = databaseManager.getWarehouseProductManager().addWarehouseProduct(warehouseProduct1.getStoreId(), warehouseProduct1.getProductId(), warehouseProduct1.getQuantity());
                outToClient.writeObject(new Request("AddWarehouseProduct", warehouseProduct));
            }
            else if ("GetCartProducts".equals(request.getType()))
            {
                int[] requests = (int[]) request.getArg();
                int productid = requests[0];
                int quantity = requests[1];
                List<CartProduct> result = databaseManager.getWarehouseProductManager().GetCartProducts(productid, quantity);
                outToClient.writeObject(new Request("GetCartProducts", result));
            }
            else if ("AddTransaction".equals(request.getType()))
            {
                Transaction transaction = databaseManager.getTransactionManager().addTransaction((Transaction) request.getArg());
                outToClient.writeObject(new Request("AddTransaction", transaction));
            }
            else if ("AddTransactionProduct".equals(request.getType()))
            {
                TransactionProduct transactionProduct = databaseManager.getTransactionProductManager().addTransactionProduct((TransactionProduct) request.getArg());
                outToClient.writeObject(new Request("AddTransactionProduct", transactionProduct));
            }
            else if ("GetAllWPJoin".equals(request.getType()))
            {
                List<WPJoin> result = databaseManager.getWpJoinManager().getAllWPJoin();
                outToClient.writeObject(new Request("GetAllWPJoin", result));
            }
            else if ("GetStoreWPJoin".equals(request.getType()))
            {
                List<WPJoin> result = databaseManager.getWpJoinManager().getStoreWPJoin((int) request.getArg());
                outToClient.writeObject(new Request("GetStoreWPJoin", result));
            }
            else if("OrderProductFromManufacturer".equals(request.getType()))
            {
                databaseManager.getWarehouseProductManager().OrderProductFromManufacturer((OrderProduct)request.getArg());
            }
            else if("OrderProductFromStore".equals(request.getType()))
            {
                databaseManager.getWarehouseProductManager().OrderProductFromStore((OrderProduct)request.getArg());
            }
            else if("DecrementProductQuantity".equals(request.getType())){
                databaseManager.getWarehouseProductManager().DecrementProductQuantity((OrderProduct)request.getArg());
            }
            else if("GetWarehouseProductFromStoresById".equals(request.getType())){

                List<WarehouseProduct> result=databaseManager.getWarehouseProductManager().getWarehouseProductFromStoresById((WarehouseProduct)request.getArg());
                outToClient.writeObject(new Request("GetWarehouseProductFromStoresById", result));
            }
            else if("ModifyProduct".equals(request.getType())){
                databaseManager.getProductManager().modifyProduct((Product)request.getArg());
            }
        }
        catch (IOException |
                ClassNotFoundException e)

        {
            e.printStackTrace();
        }
    }
}
