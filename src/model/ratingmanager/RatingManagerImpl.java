package model.ratingmanager;

import database.ratingDAO.RatingDAO;
import database.ratingDAO.RatingDAOImpl;
import database.warehouseproductDAO.WarehouseProductDAO;
import database.warehouseproductDAO.WarehouseProductDAOImpl;
import transferobjects.DidUserBuyJoin;
import transferobjects.Rating;
import transferobjects.WarehouseProduct;

import java.sql.SQLException;
import java.util.List;

public class RatingManagerImpl implements RatingManager {
    private RatingDAO ratingDAO;
    public RatingManagerImpl(){
        try
        {
            ratingDAO = RatingDAOImpl.getInstance();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
    @Override
    public List<Rating> getAllRatings() {
        try
        {
            return ratingDAO.getAllRatings();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void addRating(Rating rating) {
        try
        {
            ratingDAO.addRating(rating);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<DidUserBuyJoin> didUserBuyThisProduct(String email) {
        try
        {
            return ratingDAO.didUserBuyThisProduct(email);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }
}
