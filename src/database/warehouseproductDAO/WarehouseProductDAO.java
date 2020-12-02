package database.warehouseproductDAO;

import transferobjects.Product;
import transferobjects.WarehouseProduct;

import java.sql.SQLException;
import java.util.List;

public interface WarehouseProductDAO {
    List<WarehouseProduct> getAllWarehouseProducts() throws SQLException;
    List<WarehouseProduct> getStoreWarehouseProducts(int storeId) throws SQLException;
    WarehouseProduct addWarehouseProduct(int storeid, int productid, int quantity) throws SQLException;
}
