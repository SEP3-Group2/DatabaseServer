package database.wpJoinDAO;

import transferobjects.WPJoin;

import java.sql.SQLException;
import java.util.List;

public interface WPJoinDAO {
    List<WPJoin> GetAllWPJoin() throws SQLException;
    List<WPJoin> GetStoreWPJoin(int storeid) throws  SQLException;
}
