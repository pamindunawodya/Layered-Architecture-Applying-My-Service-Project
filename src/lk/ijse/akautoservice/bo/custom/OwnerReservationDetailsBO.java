package lk.ijse.akautoservice.bo.custom;

import lk.ijse.akautoservice.bo.SuperBO;
import lk.ijse.akautoservice.dto.ReservationtoDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OwnerReservationDetailsBO extends SuperBO {

     ArrayList<ReservationtoDTO> showReservationAllData() throws SQLException, ClassNotFoundException;
}
