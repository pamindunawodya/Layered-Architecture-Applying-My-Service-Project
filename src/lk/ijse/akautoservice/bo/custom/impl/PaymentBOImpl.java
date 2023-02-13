package lk.ijse.akautoservice.bo.custom.impl;

import lk.ijse.akautoservice.bo.custom.PaymentBO;
import lk.ijse.akautoservice.dao.DAOFactory;
import lk.ijse.akautoservice.dao.custom.CustomerOrderDAO;
import lk.ijse.akautoservice.dao.custom.impl.CustomerOrderDAOImpl;
import lk.ijse.akautoservice.dao.custom.ReservationDAO;
import lk.ijse.akautoservice.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.akautoservice.dto.ReservationtoDTO;
import lk.ijse.akautoservice.entity.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {
    ReservationDAO reservationDAO= (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
    CustomerOrderDAO customerOrderDAO= (CustomerOrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMERORDER);

    public String GetLastReservationID() throws SQLException, ClassNotFoundException {

        return reservationDAO.GetLastReservationID();
    }

    public String GetLastOrderID() throws SQLException, ClassNotFoundException {
        return customerOrderDAO.GetLastOrderID();
    }

    public ArrayList<ReservationtoDTO> showAllReservationData() throws SQLException, ClassNotFoundException {
        ArrayList<Reservation> all =reservationDAO.showAllData();
        ArrayList<ReservationtoDTO>allReservation=new ArrayList<>();
        for(Reservation reservation :all){
            allReservation.add(new ReservationtoDTO(reservation.getReserved_Id(), reservation.getReserved_CustomerID(), reservation.getReserved_VehicleNo(), reservation.getReserved_ServiceType(),reservation.getReserved_ServiceFee(),reservation.getReserved_Date()));
        }
        return allReservation;
    }
}