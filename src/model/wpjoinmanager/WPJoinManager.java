package model.wpjoinmanager;

import transferobjects.WPJoin;
import transferobjects.WarehouseProduct;

import java.util.List;

public interface WPJoinManager {
    List<WPJoin> getAllWPJoin();
    List<WPJoin> getStoreWPJoin(int storeid);
}
