package transferobjects;

import java.io.Serializable;

public class OrderProduct implements Serializable {
    private WarehouseProduct warehouseProduct;
    private int orderCount;
    private int storeId;

    public OrderProduct(WarehouseProduct warehouseProduct, int orderCount) {
        this.warehouseProduct = warehouseProduct;
        this.orderCount = orderCount;
        this.storeId=0;
    }

    public OrderProduct() {
    }

    public WarehouseProduct getWarehouseProduct() {
        return warehouseProduct;
    }

    public void setWarehouseProduct(WarehouseProduct warehouseProduct) {
        this.warehouseProduct = warehouseProduct;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public OrderProduct(WarehouseProduct warehouseProduct, int orderCount, int storeId) {
        this.warehouseProduct = warehouseProduct;
        this.orderCount = orderCount;
        this.storeId = storeId;
    }
    public OrderProduct(int storeId, WarehouseProduct warehouseProduct){
        this.warehouseProduct=warehouseProduct;
        this.orderCount=0;
        this.storeId=storeId;
    }
}
