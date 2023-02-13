package lk.ijse.akautoservice.bo.custom;

import lk.ijse.akautoservice.bo.SuperBO;
import lk.ijse.akautoservice.dto.CustomerDTO;
import lk.ijse.akautoservice.dto.ReservationGraphtoDTO;
import lk.ijse.akautoservice.dto.ReservationtoDTO;
import lk.ijse.akautoservice.dto.ServicePackageDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationBO extends SuperBO {
   String GetLastReservationID() throws SQLException, ClassNotFoundException ;

   ArrayList<ServicePackageDTO> showAllServiceData() throws SQLException, ClassNotFoundException ;

   ArrayList<CustomerDTO> getCustomerIds() throws SQLException, ClassNotFoundException ;

   ArrayList getVehicleNumbers() throws SQLException, ClassNotFoundException ;

   ArrayList<ReservationGraphtoDTO> GetMonthDatesForReservedTotalAll() throws SQLException, ClassNotFoundException ;

   boolean saveReservertionDetails(ReservationtoDTO reservationton) throws SQLException, ClassNotFoundException ;

}
