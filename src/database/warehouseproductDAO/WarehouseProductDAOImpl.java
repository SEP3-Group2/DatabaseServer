package database.warehouseproductDAO;

import database.productDAO.ProductDAOImpl;
import model.warehouseproductmanager.WarehouseProductManagerImpl;
import transferobjects.CartProduct;
import transferobjects.Product;
import transferobjects.WarehouseProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WarehouseProductDAOImpl implements WarehouseProductDAO{
    private static WarehouseProductDAOImpl instance;


    private WarehouseProductDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }
    public static synchronized WarehouseProductDAOImpl getInstance() throws SQLException
    {
        if (instance == null)
        {
            instance = new WarehouseProductDAOImpl();
        }
        return instance;
    }
    private Connection getConnection() throws SQLException
    {
        return DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/projectsep3", "group2",
                        "password");
    }

    @Override
    public List<WarehouseProduct> getAllWarehouseProducts() throws SQLException {
        List<WarehouseProduct> returnList = new ArrayList<WarehouseProduct>();
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM \"SEP3\".WarehouseProduct");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                WarehouseProduct content = new WarehouseProduct();
                content.setStoreId(resultSet.getInt("storeid"));
                content.setProductId(resultSet.getInt("productid"));
                content.setQuantity(resultSet.getInt("quantity"));

                returnList.add(content);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return returnList;
    }

    @Override
    public List<WarehouseProduct> getStoreWarehouseProducts(int storeId) throws SQLException {
        List<WarehouseProduct> returnList = new ArrayList<WarehouseProduct>();
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM \"SEP3\".WarehouseProduct where storeid = ?");
            statement.setInt(1, storeId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                WarehouseProduct content = new WarehouseProduct();
                content.setStoreId(resultSet.getInt("storeid"));
                content.setProductId(resultSet.getInt("productid"));
                content.setQuantity(resultSet.getInt("quantity"));

                returnList.add(content);
            }
            System.out.println(returnList);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return returnList;
    }

    @Override
    public WarehouseProduct addWarehouseProduct(int storeid, int productid, int quantity) throws SQLException {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO\"SEP3\".warehouseproduct(storeid, productid, quantity) VALUES(?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, storeid);
            statement.setInt(2, productid);
            statement.setInt(3, quantity);
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
            {
                System.out.println("WarehouseProduct created in database");
                return new WarehouseProduct(storeid, productid, quantity);
            }
            else
                throw new SQLException("No keys generated");
        }
    }

    @Override public List<CartProduct> GetCartProducts(int productid,
        int quantity) throws SQLException
    {
        List<CartProduct> returnList = new ArrayList<CartProduct>();
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT \"SEP3\".product.productid, \"SEP3\".product.title, \"SEP3\".product.category, \"SEP3\".product.price,\n"
                    + "\"SEP3\".warehouseproduct.storeid, \"SEP3\".warehouseproduct.quantity\n"
                    + "FROM \"SEP3\".product  \n"
                    + "INNER JOIN \"SEP3\".warehouseproduct \n"
                    + "ON (\"SEP3\".product.productid = \"SEP3\".warehouseproduct.productid)\n"
                    + "WHERE \"SEP3\".product.productid = ? AND \"SEP3\".warehouseproduct.quantity >= ?");

            statement.setInt(1, productid);
            statement.setInt(2, quantity);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                CartProduct content = new CartProduct();
                content.setId(resultSet.getInt("productid"));
                content.setTitle(resultSet.getString("title"));
                content.setCategory(resultSet.getString("category"));
                content.setPrice(resultSet.getInt("price"));
                content.setStoreid(resultSet.getInt("storeid"));
                content.setQuantity(resultSet.getInt("quantity"));
                returnList.add(content);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return returnList;
    }
}
