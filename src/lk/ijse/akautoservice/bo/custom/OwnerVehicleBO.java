package lk.ijse.akautoservice.bo.custom;

import lk.ijse.akautoservice.bo.SuperBO;
import lk.ijse.akautoservice.dto.VehicleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OwnerVehicleBO extends SuperBO {
     ArrayList<VehicleDTO>searchVehicle(String vehicle) throws SQLException, ClassNotFoundException ;

     ArrayList<VehicleDTO>showAllVehicleData() throws SQLException, ClassNotFoundException ;

}

