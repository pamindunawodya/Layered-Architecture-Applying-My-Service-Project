package lk.ijse.akautoservice.dao.custom;

import lk.ijse.akautoservice.dao.CrudDAO;
import lk.ijse.akautoservice.dto.CustomerDTO;
import lk.ijse.akautoservice.dto.ReservationGraphtoDTO;
import lk.ijse.akautoservice.dto.ReservationtoDTO;
import lk.ijse.akautoservice.dto.VehicleDTO;
import lk.ijse.akautoservice.entity.Customer;
import lk.ijse.akautoservice.entity.Reservation;
import lk.ijse.akautoservice.entity.Vehicle;
import lk.ijse.akautoservice.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationDAO extends CrudDAO<Reservation,String> {
    ArrayList<Customer> getCustomerIds() throws SQLException, ClassNotFoundException ;
    ArrayList<Vehicle> getVehicleNumbers() throws SQLException, ClassNotFoundException ;

    ArrayList<ReservationGraphtoDTO> GetMonthDatesForReservedTotalAll() throws SQLException, ClassNotFoundException ;

    String GetLastReservationID() throws SQLException, ClassNotFoundException ;

    ArrayList<String> getReserveIds() throws SQLException, ClassNotFoundException ;

}
