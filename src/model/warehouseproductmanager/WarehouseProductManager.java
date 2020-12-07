package model.warehouseproductmanager;

import transferobjects.CartProduct;
import transferobjects.OrderProduct;
import transferobjects.WarehouseProduct;

import java.sql.SQLException;
import java.util.List;

public interface WarehouseProductManager {

    List<WarehouseProduct> getAllWarehouseProducts();
    List<WarehouseProduct> getStoreWarehouseProducts(int storeid);
    WarehouseProduct addWarehouseProduct(int storeid, int productid, int quantity);

    List<CartProduct> GetCartProducts(int productid, int quantity);
    List<CartProduct> GetNotCartProducts(int productid, int quantity);
    void OrderProductFromManufacturer(OrderProduct orderProduct);
    void OrderProductFromStore(OrderProduct orderProduct);
    void DecrementProductQuantity(OrderProduct orderProduct);
}
