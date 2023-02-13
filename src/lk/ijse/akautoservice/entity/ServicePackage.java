package lk.ijse.akautoservice.entity;

public class ServicePackage {
    private String service_code;
    private String service_type;
    private String service_description;
    private Double service_fee;

    public ServicePackage() {
    }

    public ServicePackage(String service_code, String service_type, String service_description, Double service_fee) {
        this.service_code = service_code;
        this.service_type = service_type;
        this.service_description = service_description;
        this.service_fee = service_fee;
    }

    public String getService_code() {
        return service_code;
    }

    public void setService_code(String service_code) {
        this.service_code = service_code;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getService_description() {
        return service_description;
    }

    public void setService_description(String service_description) {
        this.service_description = service_description;
    }

    public Double getService_fee() {
        return service_fee;
    }

    public void setService_fee(Double service_fee) {
        this.service_fee = service_fee;
    }
}
