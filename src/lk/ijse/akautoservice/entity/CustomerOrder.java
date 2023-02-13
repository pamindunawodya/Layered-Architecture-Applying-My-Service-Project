package lk.ijse.akautoservice.entity;

import java.util.Date;

public class  CustomerOrder {
    private String order_id;
    private String reservation_id;
    private Date reservation_date;
    private double total_price;

    public CustomerOrder() {
    }

    public CustomerOrder(String order_id, String reservation_id, Date reservation_date, double total_price) {
        this.order_id = order_id;
        this.reservation_id = reservation_id;
        this.reservation_date = reservation_date;
        this.total_price = total_price;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(String reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
}
