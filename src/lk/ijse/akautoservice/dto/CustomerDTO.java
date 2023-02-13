package lk.ijse.akautoservice.dto;

public class CustomerDTO {
    private String customer_id;
    private String customer_name;
    private String customer_nic;
    private String customer_address;
    private String customer_mobile;

    public CustomerDTO(String text, String mtxtldnameText, String mtxtldnicText, String mtxtldaddressText, String mcolMobileNoText, String s) {
    }

    public CustomerDTO(String customer_id, String customer_name, String customer_nic, String customer_address, String customer_mobile) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_nic = customer_nic;
        this.customer_address = customer_address;
        this.customer_mobile = customer_mobile;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_nic() {
        return customer_nic;
    }

    public void setCustomer_nic(String customer_nic) {
        this.customer_nic = customer_nic;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_mobile() {
        return customer_mobile;
    }

    public void setCustomer_mobile(String customer_mobile) {
        this.customer_mobile = customer_mobile;
    }
}

