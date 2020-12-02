package model.warehouseproductmanager;

import database.productDAO.ProductDAOImpl;
import database.warehouseproductDAO.WarehouseProductDAO;
import database.warehouseproductDAO.WarehouseProductDAOImpl;
import transferobjects.Product;
import transferobjects.WarehouseProduct;

import java.sql.SQLException;
import java.util.List;

public class WarehouseProductManagerImpl implements WarehouseProductManager{
    private WarehouseProductDAO warehouseProductDAO;
    public WarehouseProductManagerImpl(){
        try
        {
            warehouseProductDAO = WarehouseProductDAOImpl.getInstance();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<WarehouseProduct> getAllWarehouseProducts() {
        try
        {
            return warehouseProductDAO.getAllWarehouseProducts();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<WarehouseProduct> getStoreWarehouseProducts(int storeid) {
        try
        {
            return warehouseProductDAO.getStoreWarehouseProducts(storeid);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public WarehouseProduct addWarehouseProduct(int storeid, int productid, int quantity) {
        try
        {
            WarehouseProduct tmp = warehouseProductDAO.addWarehouseProduct(storeid,productid,quantity);
            return tmp;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }


}