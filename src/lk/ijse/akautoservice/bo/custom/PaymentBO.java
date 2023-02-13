package lk.ijse.akautoservice.bo.custom;

import lk.ijse.akautoservice.bo.SuperBO;
import lk.ijse.akautoservice.dto.ReservationtoDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentBO extends SuperBO {
    String GetLastReservationID() throws SQLException, ClassNotFoundException ;

    String GetLastOrderID() throws SQLException, ClassNotFoundException ;

    ArrayList<ReservationtoDTO> showAllReservationData() throws SQLException, ClassNotFoundException ;

}
