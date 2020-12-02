package model.warehouseproductmanager;

import transferobjects.WarehouseProduct;

import java.util.List;

public interface WarehouseProductManager {

    List<WarehouseProduct> getAllWarehouseProducts();
    List<WarehouseProduct> getStoreWarehouseProducts(int storeid);
    WarehouseProduct addWarehouseProduct(int storeid, int productid, int quantity);
}
