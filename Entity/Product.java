package Entity;

import java.sql.Timestamp;

public class Product {
    public class Table{
        public static final String TABLE_NAME = "product";
    }
    public class Column{
        public static final String NUM = "product_num";
        public static final String NAME = "product_name";
        public static final String DISPLAY_COUNT = "product_display_count";
        public static final String ADD_TIME = "product_add_time";
        public static final String UPDATE_TIME = "product_update_time";
        public static final String INVENTORY_COUNT = "product_inventory_count";
        public static final String PRICE = "product_price";
    }
    private int num;
    private String name;
    private int displayCount;
    private Timestamp addTime;
    private Timestamp updateTime;
    private int inventoryCount;
    private int price;

    public Product(){
    }
    public Product(int num,
                   String name,
                   int displayCount,
                   Timestamp addTime,
                   Timestamp updateTime,
                   int inventoryCount,
                   int price){
        this.num = num;
        this.name = name;
        this.displayCount = displayCount;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.inventoryCount = inventoryCount;
        this.price = price;
    }
    public void setNum(int num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDisplayCount(int displayCount) {
        this.displayCount = displayCount;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public int getDisplayCount() {
        return displayCount;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }


}
