package lk.ijse.akautoservice.entity;

public class Vehicle {
    private String vehicle_number;
    private String vehicle_brand;
    private String vehicle_category;
    private String customer_id;

    public Vehicle() {
    }

    public Vehicle(String vehicle_number, String vehicle_brand, String vehicle_category, String customer_id) {
        this.vehicle_number = vehicle_number;
        this.vehicle_brand = vehicle_brand;
        this.vehicle_category = vehicle_category;
        this.customer_id = customer_id;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public String getVehicle_brand() {
        return vehicle_brand;
    }

    public void setVehicle_brand(String vehicle_brand) {
        this.vehicle_brand = vehicle_brand;
    }

    public String getVehicle_category() {
        return vehicle_category;
    }

    public void setVehicle_category(String vehicle_category) {
        this.vehicle_category = vehicle_category;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
}
