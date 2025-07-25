package DTO;

import Entity.Product;

import java.sql.Timestamp;

public class ProductDTO {
    private int num;
    private String name;
    private int displayCount;
    private Timestamp addTime;
    private Timestamp updateTime;
    private int inventoryCount;
    private int price;

    // dto를 TelBook entity로 변환
    public static Product fromDto(ProductDTO dto) {
        return new Product(
                dto.getNum(),
                dto.getName(),
                dto.getDisplayCount(),
                dto.getAddTime(),
                dto.getUpdateTime(),
                dto.getInventoryCount(),
                dto.getPrice()
        );
    }

    // Entity(TelBook)을 TelBookDto로 변환..
    public static ProductDTO fromEntity(Product entity) {
        return new ProductDTO(
                entity.getNum(),
                entity.getName(),
                entity.getDisplayCount(),
                entity.getAddTime(),
                entity.getUpdateTime(),
                entity.getInventoryCount(),
                entity.getPrice()
        );
    }

    public static ProductDTO makeDto(int num,
                                     String name,
                                     int displayCount,
                                     Timestamp addTime,
                                     Timestamp updateTime,
                                     int inventoryCount,
                                     int price) {

        return new ProductDTO(num, name, displayCount, addTime, updateTime, inventoryCount, price);
    }

    public ProductDTO() {
    }

    public ProductDTO(int num,
                      String name,
                      int displayCount,
                      Timestamp addTime,
                      Timestamp updateTime,
                      int inventoryCount,
                      int price) {
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
