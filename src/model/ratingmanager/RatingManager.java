package model.ratingmanager;

import transferobjects.DidUserBuyJoin;
import transferobjects.Rating;

import java.sql.SQLException;
import java.util.List;

public interface RatingManager {
    List<Rating> getAllRatings();
    void addRating(Rating rating);
    List<DidUserBuyJoin> didUserBuyThisProduct(String email);

}
