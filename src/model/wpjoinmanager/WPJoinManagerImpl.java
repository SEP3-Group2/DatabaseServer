package model.wpjoinmanager;

import database.warehouseproductDAO.WarehouseProductDAOImpl;
import database.wpJoinDAO.WPJoinDAO;
import database.wpJoinDAO.WPJoinDAOImpl;
import transferobjects.WPJoin;
import transferobjects.WarehouseProduct;

import java.sql.SQLException;
import java.util.List;

public class WPJoinManagerImpl implements WPJoinManager{

    private WPJoinDAO wpJoinDAO;

    public WPJoinManagerImpl() {
        try
        {
            wpJoinDAO = WPJoinDAOImpl.getInstance();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<WPJoin> getAllWPJoin() {
        try
        {
            return wpJoinDAO.GetAllWPJoin();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<WPJoin> getStoreWPJoin(int storeid) {
        try
        {
            return wpJoinDAO.GetStoreWPJoin(storeid);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }
}
