package lk.ijse.akautoservice.dto;

import java.sql.Date;

public class ReservationtoDTO {
    private String Reserved_Id;
    private String Reserved_CustomerID;
    private String Reserved_VehicleNo;
    private String Reserved_ServiceType;
    private double Reserved_ServiceFee;
    private Date Reserved_Date;

    public ReservationtoDTO(String reserved_Id, String reserved_CustomerID, String reserved_VehicleNo, String reserved_ServiceType, double reserved_ServiceFee, Date reserved_Date) {
        Reserved_Id = reserved_Id;
        Reserved_CustomerID = reserved_CustomerID;
        Reserved_VehicleNo = reserved_VehicleNo;
        Reserved_ServiceType = reserved_ServiceType;
        Reserved_ServiceFee = reserved_ServiceFee;
        Reserved_Date = reserved_Date;
    }

    public String getReserved_Id() {
        return Reserved_Id;
    }

    public void setReserved_Id(String reserved_Id) {
        Reserved_Id = reserved_Id;
    }

    public String getReserved_CustomerID() {
        return Reserved_CustomerID;
    }

    public void setReserved_CustomerID(String reserved_CustomerID) {
        Reserved_CustomerID = reserved_CustomerID;
    }

    public String getReserved_VehicleNo() {
        return Reserved_VehicleNo;
    }

    public void setReserved_VehicleNo(String reserved_VehicleNo) {
        Reserved_VehicleNo = reserved_VehicleNo;
    }

    public String getReserved_ServiceType() {
        return Reserved_ServiceType;
    }

    public void setReserved_ServiceType(String reserved_ServiceType) {
        Reserved_ServiceType = reserved_ServiceType;
    }

    public double getReserved_ServiceFee() {
        return Reserved_ServiceFee;
    }

    public void setReserved_ServiceFee(double reserved_ServiceFee) {
        Reserved_ServiceFee = reserved_ServiceFee;
    }

    public Date getReserved_Date() {
        return Reserved_Date;
    }

    public void setReserved_Date(Date reserved_Date) {
        Reserved_Date = reserved_Date;
    }
}
