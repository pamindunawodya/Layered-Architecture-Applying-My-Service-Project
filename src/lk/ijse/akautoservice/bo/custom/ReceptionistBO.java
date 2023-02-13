package lk.ijse.akautoservice.bo.custom;

import lk.ijse.akautoservice.bo.SuperBO;
import lk.ijse.akautoservice.dto.ReservationGraphtoDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReceptionistBO extends SuperBO {
    ArrayList<ReservationGraphtoDTO> GetMonthDatesForReservedTotalAll() throws SQLException, ClassNotFoundException;
}
