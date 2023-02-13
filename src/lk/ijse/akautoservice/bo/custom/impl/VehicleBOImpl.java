package lk.ijse.akautoservice.bo.custom.impl;

import lk.ijse.akautoservice.bo.custom.VehicleBO;
import lk.ijse.akautoservice.dao.DAOFactory;
import lk.ijse.akautoservice.dao.custom.VehicleDAO;
import lk.ijse.akautoservice.dao.custom.impl.VehicleDAOImpl;
import lk.ijse.akautoservice.dto.VehicleDTO;
import lk.ijse.akautoservice.entity.Item;
import lk.ijse.akautoservice.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleBOImpl implements VehicleBO {
    VehicleDAO vehicleDAO= (VehicleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VEHICLE);

     public ArrayList existsCustomerIds() throws SQLException, ClassNotFoundException {
        return vehicleDAO.getCustomerIds();
    }

    public boolean saveVehicle(VehicleDTO vehicle) throws SQLException, ClassNotFoundException {
         return vehicleDAO.save(new Vehicle(vehicle.getVehicle_number(), vehicle.getVehicle_brand(), vehicle.getVehicle_category(), vehicle.getCustomer_id() ));
    }
    public boolean deleteVehicle(String vehicle) throws SQLException, ClassNotFoundException {
         return vehicleDAO.delete(vehicle);
    }
    public ArrayList<VehicleDTO>searchVehicle(String vehicle) throws SQLException, ClassNotFoundException {
        ArrayList<Vehicle> search = vehicleDAO.search(vehicle);
        ArrayList<VehicleDTO>allVehicles=new ArrayList<>();
        for(Vehicle v:search){
            allVehicles.add(new VehicleDTO(v.getVehicle_number(), v.getVehicle_brand(), v.getVehicle_category(), v.getCustomer_id()));
        }
        return allVehicles;
    }
    public ArrayList<VehicleDTO>showAllVehicleData() throws SQLException, ClassNotFoundException {
        ArrayList<Vehicle> all = vehicleDAO.showAllData();
        ArrayList<VehicleDTO>allVehicles=new ArrayList<>();
        for(Vehicle vehicle:all){
            allVehicles.add(new VehicleDTO(vehicle.getVehicle_number(), vehicle.getVehicle_brand(), vehicle.getVehicle_category(), vehicle.getCustomer_id()));
        }
        return allVehicles;
    }
    public  ArrayList<VehicleDTO> showVehicleFromCustomerID(String x) throws SQLException, ClassNotFoundException {
         return vehicleDAO.showVehicleFromCustomerID(x);
    }
    public boolean updateVehicle(VehicleDTO vehicle) throws SQLException, ClassNotFoundException {
         return vehicleDAO.Update(new Vehicle(vehicle.getVehicle_number(), vehicle.getVehicle_brand(), vehicle.getVehicle_category(), vehicle.getCustomer_id() ));
    }

}
