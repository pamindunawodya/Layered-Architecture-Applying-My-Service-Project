package lk.ijse.akautoservice.bo.custom.impl;

import lk.ijse.akautoservice.bo.custom.ReservationBO;
import lk.ijse.akautoservice.dao.CrudDAO;
import lk.ijse.akautoservice.dao.DAOFactory;
import lk.ijse.akautoservice.dao.custom.ReservationDAO;
import lk.ijse.akautoservice.dao.custom.ServiceDAO;
import lk.ijse.akautoservice.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.akautoservice.dao.custom.impl.ServiceDAOImpl;
import lk.ijse.akautoservice.dto.*;
import lk.ijse.akautoservice.entity.Customer;
import lk.ijse.akautoservice.entity.Reservation;
import lk.ijse.akautoservice.entity.ServicePackage;
import lk.ijse.akautoservice.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationBOImpl implements ReservationBO {

    ServiceDAO serviceDAO= (ServiceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SERVICE);
    ReservationDAO reservationDAO= (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);

    public  String GetLastReservationID() throws SQLException, ClassNotFoundException {
        return reservationDAO.GetLastReservationID();
    }
    public ArrayList<ServicePackageDTO> showAllServiceData() throws SQLException, ClassNotFoundException {
        //return reservationDAO.showAllData();
        ArrayList<ServicePackage> v =serviceDAO.showAllData();
        ArrayList<ServicePackageDTO>allReservation=new ArrayList<>();
        for(ServicePackage si :v){
           allReservation.add(new ServicePackageDTO(si.getService_code(), si.getService_type(), si.getService_description(), si.getService_fee()));//error
        }
        return allReservation;
    }
    public  ArrayList<CustomerDTO> getCustomerIds() throws SQLException, ClassNotFoundException {
      //  return reservationDAO.getCustomerIds();
        ArrayList<Customer> v =reservationDAO.getCustomerIds();
        ArrayList<CustomerDTO>allReservation=new ArrayList<>();
        for(Customer customer :v){
            allReservation.add(new CustomerDTO(customer.getCustomer_id(),customer.getCustomer_name(),customer.getCustomer_nic(),customer.getCustomer_address(),customer.getCustomer_mobile()));
        }
        return allReservation;
    }

    public  ArrayList<VehicleDTO> getVehicleNumbers() throws SQLException, ClassNotFoundException {
        //return reservationDAO.getVehicleNumbers();
        ArrayList<Vehicle> v =reservationDAO.getVehicleNumbers();
        ArrayList<VehicleDTO>allReservation=new ArrayList<>();
        for(Vehicle vehicle :v){
            allReservation.add(new VehicleDTO(vehicle.getVehicle_number(), vehicle.getVehicle_brand(), vehicle.getVehicle_category(),vehicle.getCustomer_id()));
        }
        return allReservation;
    }
    public  ArrayList<ReservationGraphtoDTO> GetMonthDatesForReservedTotalAll() throws SQLException, ClassNotFoundException {
        return reservationDAO.GetMonthDatesForReservedTotalAll();
    }
    public boolean saveReservertionDetails(ReservationtoDTO reservationton) throws SQLException, ClassNotFoundException {
        return reservationDAO.save(new Reservation(reservationton.getReserved_Id(),reservationton.getReserved_CustomerID(),reservationton.getReserved_VehicleNo(),reservationton.getReserved_ServiceType(),reservationton.getReserved_ServiceFee(),reservationton.getReserved_Date()));
    }
}
