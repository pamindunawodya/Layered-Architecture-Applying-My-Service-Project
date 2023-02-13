package lk.ijse.akautoservice.dto;

public class CustomerOrderDetailsDTO {
    private String order_id;
    private String item_code;
    private String item_name;
    private int qty;
    private double unit_price;

    public CustomerOrderDetailsDTO(String order_id, String item_code, String item_name, int qty, double unit_price) {
        this.order_id = order_id;
        this.item_code = item_code;
        this.item_name = item_name;
        this.qty = qty;
        this.unit_price = unit_price;
    }

    public CustomerOrderDetailsDTO() {
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
}
