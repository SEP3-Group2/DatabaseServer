package transferobjects;

import java.io.Serializable;

public class WPJoin implements Serializable {
    private WarehouseProduct warehouseProduct;
    private Product product;

    public WPJoin(WarehouseProduct warehouseProduct, Product product) {
        this.warehouseProduct = warehouseProduct;
        this.product = product;
    }

    public WPJoin() {
    }

    public WarehouseProduct getWarehouseProduct() {
        return warehouseProduct;
    }

    public void setWarehouseProduct(WarehouseProduct warehouseProduct) {
        this.warehouseProduct = warehouseProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
