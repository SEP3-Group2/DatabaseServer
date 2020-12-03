package database.wpJoinDAO;

import database.warehouseproductDAO.WarehouseProductDAOImpl;
import transferobjects.Product;
import transferobjects.WPJoin;
import transferobjects.WarehouseProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WPJoinDAOImpl implements WPJoinDAO{
    private static WPJoinDAOImpl instance;

    public WPJoinDAOImpl() throws SQLException{
        DriverManager.registerDriver(new org.postgresql.Driver());
    }
    public static synchronized WPJoinDAOImpl getInstance() throws SQLException
    {
        if (instance == null)
        {
            instance = new WPJoinDAOImpl();
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
    public List<WPJoin> GetAllWPJoin() {
        List<WPJoin> returnList = new ArrayList<WPJoin>();
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT \"SEP3\".product.productid, \"SEP3\".product.title, \"SEP3\".product.category, \"SEP3\".product.price,\n" +
                            "\"SEP3\".warehouseproduct.storeid, \"SEP3\".warehouseproduct.quantity\n" +
                            "FROM \"SEP3\".product  \n" +
                            "INNER JOIN \"SEP3\".warehouseproduct \n" +
                            "ON (\"SEP3\".product.productid = \"SEP3\".warehouseproduct.productid);");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                WPJoin content = new WPJoin();
                WarehouseProduct warehouseProduct=new WarehouseProduct();
                warehouseProduct.setStoreId(resultSet.getInt("storeid"));
                warehouseProduct.setProductId(resultSet.getInt("productid"));
                warehouseProduct.setQuantity(resultSet.getInt("quantity"));

                Product product=new Product();
                product.setId(resultSet.getInt("productid"));
                product.setTitle(resultSet.getString("title"));
                product.setCategory(resultSet.getString("category"));
                product.setDescription("");
                product.setPrice(resultSet.getDouble("price"));

                content.setWarehouseProduct(warehouseProduct);
                content.setProduct(product);

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
    public List<WPJoin> GetStoreWPJoin(int storeid) {
        List<WPJoin> returnList = new ArrayList<WPJoin>();
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT \"SEP3\".product.productid, \"SEP3\".product.title, \"SEP3\".product.category, \"SEP3\".product.price,\n" +
                            "\"SEP3\".warehouseproduct.storeid, \"SEP3\".warehouseproduct.quantity\n" +
                            "FROM \"SEP3\".product  \n" +
                            "INNER JOIN \"SEP3\".warehouseproduct \n" +
                            "ON (\"SEP3\".product.productid = \"SEP3\".warehouseproduct.productid)\n" +
                            "WHERE (\"SEP3\".warehouseproduct.storeid=?)");
            statement.setInt(1, storeid);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                WPJoin content = new WPJoin();
                WarehouseProduct warehouseProduct=new WarehouseProduct();
                warehouseProduct.setStoreId(resultSet.getInt("storeid"));
                warehouseProduct.setProductId(resultSet.getInt("productid"));
                warehouseProduct.setQuantity(resultSet.getInt("quantity"));

                Product product=new Product();
                product.setId(resultSet.getInt("productid"));
                product.setTitle(resultSet.getString("title"));
                product.setCategory(resultSet.getString("category"));
                product.setDescription("");
                product.setPrice(resultSet.getDouble("price"));

                content.setWarehouseProduct(warehouseProduct);
                content.setProduct(product);

                returnList.add(content);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return returnList;    }
}
