package database.ratingDAO;

import transferobjects.DidUserBuyJoin;
import transferobjects.Rating;

import java.sql.SQLException;
import java.util.List;

public interface RatingDAO {
    List<Rating> getAllRatings() throws SQLException;
    void addRating(Rating rating) throws SQLException;
    List<DidUserBuyJoin> didUserBuyThisProduct(String email) throws SQLException;
}
