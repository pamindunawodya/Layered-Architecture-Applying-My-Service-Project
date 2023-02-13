package lk.ijse.akautoservice.entity;

public class Item {
    private String item_code;
    private String item_name;
    private String description;
    private String brand;
    private String stock;
    private double unit_price;

    public Item() {
    }

    public Item(String item_code, String item_name, String description, String brand, String stock, double unit_price) {
        this.item_code = item_code;
        this.item_name = item_name;
        this.description = description;
        this.brand = brand;
        this.stock = stock;
        this.unit_price = unit_price;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
}
