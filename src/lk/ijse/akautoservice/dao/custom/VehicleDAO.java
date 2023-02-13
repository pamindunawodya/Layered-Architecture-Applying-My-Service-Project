package lk.ijse.akautoservice.dao.custom;

import lk.ijse.akautoservice.dao.CrudDAO;
import lk.ijse.akautoservice.dto.VehicleDTO;
import lk.ijse.akautoservice.entity.Vehicle;
import lk.ijse.akautoservice.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleDAO extends CrudDAO<Vehicle,String> {


     ArrayList getCustomerIds() throws SQLException, ClassNotFoundException ;

     ArrayList<VehicleDTO> showVehicleFromCustomerID(String x) throws SQLException, ClassNotFoundException;


}
