package transferobjects;

import java.io.Serializable;

public class WarehouseProduct implements Serializable {
    private int storeId;
    private int productId;
    private int quantity;
    public WarehouseProduct(int storeId, int productId, int quantity){
        this.storeId=storeId;
        this.productId=productId;
        this.quantity=quantity;
    }
    public WarehouseProduct(){

    }

    public int getStoreId() {
        return storeId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
