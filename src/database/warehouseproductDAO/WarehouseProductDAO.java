package database.warehouseproductDAO;

import transferobjects.CartProduct;
import transferobjects.OrderProduct;
import transferobjects.Product;
import transferobjects.WarehouseProduct;

import java.sql.SQLException;
import java.util.List;

public interface WarehouseProductDAO {
    List<WarehouseProduct> getAllWarehouseProducts() throws SQLException;
    List<WarehouseProduct> getStoreWarehouseProducts(int storeId) throws SQLException;
    WarehouseProduct addWarehouseProduct(int storeid, int productid, int quantity) throws SQLException;

    List<CartProduct> GetCartProducts(int productid, int quantity) throws SQLException;
    List<CartProduct> GetNotCartProducts(int productid, int quantity) throws SQLException;
    void OrderProductFromManufacturer(OrderProduct orderProduct) throws SQLException;
    void OrderProductFromStore(OrderProduct orderProduct) throws SQLException;
    void DecrementProductQuantity(OrderProduct orderProduct) throws SQLException;
    List<WarehouseProduct> getWarehouseProductFromStoresById(WarehouseProduct warehouseProduct) throws SQLException;
}
