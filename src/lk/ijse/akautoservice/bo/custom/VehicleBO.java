package lk.ijse.akautoservice.bo.custom;

import lk.ijse.akautoservice.bo.SuperBO;
import lk.ijse.akautoservice.dto.VehicleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleBO extends SuperBO {

    ArrayList existsCustomerIds() throws SQLException, ClassNotFoundException;

    boolean saveVehicle(VehicleDTO vehicle) throws SQLException, ClassNotFoundException;

    boolean deleteVehicle(String vehicle) throws SQLException, ClassNotFoundException;

    ArrayList<VehicleDTO>searchVehicle(String vehicle) throws SQLException, ClassNotFoundException;

    ArrayList<VehicleDTO>showAllVehicleData() throws SQLException, ClassNotFoundException;

    ArrayList<VehicleDTO> showVehicleFromCustomerID(String x) throws SQLException, ClassNotFoundException;

    boolean updateVehicle(VehicleDTO vehicle) throws SQLException, ClassNotFoundException;

}
