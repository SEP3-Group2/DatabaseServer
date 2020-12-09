package database.ratingDAO;

import database.warehouseproductDAO.WarehouseProductDAOImpl;
import transferobjects.DidUserBuyJoin;
import transferobjects.Rating;
import transferobjects.WarehouseProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RatingDAOImpl implements RatingDAO {
    private static RatingDAOImpl instance;


    private RatingDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }
    public static synchronized RatingDAOImpl getInstance() throws SQLException
    {
        if (instance == null)
        {
            instance = new RatingDAOImpl();
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
    public List<Rating> getAllRatings() throws SQLException {
        List<Rating> returnList = new ArrayList<Rating>();
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM \"SEP3\".feedback");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                Rating content = new Rating();
                content.setId(resultSet.getInt("feedbackid"));
                content.setProductid(resultSet.getInt("productid"));
                content.setName(resultSet.getString("customername"));
                content.setComment(resultSet.getString("feedback"));
                content.setStar(resultSet.getInt("starrating"));


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
    public void addRating(Rating rating) throws SQLException {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO\"SEP3\".feedback(feedbackid, productid, customername, feedback, starrating) VALUES(?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, rating.getId());
            statement.setInt(2, rating.getProductid());
            statement.setString(3, rating.getName());
            statement.setString(4, rating.getComment());
            statement.setInt(5,rating.getStar());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
            {
                System.out.println("Rating created in database");
            }
            else
                throw new SQLException("No keys generated");
        }

    }

    @Override
    public List<DidUserBuyJoin> didUserBuyThisProduct(String email) throws SQLException {
        List<DidUserBuyJoin> returnList = new ArrayList<DidUserBuyJoin>();
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT \"SEP3\".transactionproduct.transactionid, \"SEP3\".transaction.email, \"SEP3\".transactionproduct.productid\n" +
                            "              FROM \"SEP3\".transaction\n" +
                            "              INNER JOIN \"SEP3\".transactionproduct\n" +
                            "              ON (\"SEP3\".transaction.transactionid = \"SEP3\".transactionproduct.transactionid)\n" +
                            "              WHERE \"SEP3\".transaction.email = ?;",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                DidUserBuyJoin content = new DidUserBuyJoin();
                content.setTransactionid(resultSet.getInt("transactionid"));
                content.setProductid(resultSet.getInt("productid"));
                content.setEmail(resultSet.getString("email"));
                returnList.add(content);
            }

        }catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return returnList;
    }
}
