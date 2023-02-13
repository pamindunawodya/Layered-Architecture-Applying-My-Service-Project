package lk.ijse.akautoservice.bo.custom.impl;

import lk.ijse.akautoservice.bo.custom.OwnerReservationDetailsBO;
import lk.ijse.akautoservice.dao.DAOFactory;
import lk.ijse.akautoservice.dao.custom.ReservationDAO;
import lk.ijse.akautoservice.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.akautoservice.dto.CustomerDTO;
import lk.ijse.akautoservice.dto.ReservationtoDTO;
import lk.ijse.akautoservice.entity.Customer;
import lk.ijse.akautoservice.entity.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;

public class OwnerReserveDetailsBOImpl implements OwnerReservationDetailsBO {
    ReservationDAO reservationDAO= (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);

    public ArrayList<ReservationtoDTO>showReservationAllData() throws SQLException, ClassNotFoundException {
        ArrayList<Reservation> all =reservationDAO.showAllData();
        ArrayList<ReservationtoDTO>allReservation=new ArrayList<>();
        for(Reservation reservation :all){
            allReservation.add(new ReservationtoDTO(reservation.getReserved_Id(), reservation.getReserved_CustomerID(), reservation.getReserved_VehicleNo(), reservation.getReserved_ServiceType(),reservation.getReserved_ServiceFee(),reservation.getReserved_Date()));
        }
        return allReservation;


    }

}
