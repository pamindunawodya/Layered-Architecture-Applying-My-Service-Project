package lk.ijse.akautoservice.bo.custom.impl;

import lk.ijse.akautoservice.bo.custom.ReceptionistBO;
import lk.ijse.akautoservice.dao.DAOFactory;
import lk.ijse.akautoservice.dao.custom.ReservationDAO;
import lk.ijse.akautoservice.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.akautoservice.dto.ReservationGraphtoDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReceptionistBOImpl implements ReceptionistBO {
    ReservationDAO reservationDAO= (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);

    public ArrayList<ReservationGraphtoDTO> GetMonthDatesForReservedTotalAll() throws SQLException, ClassNotFoundException {
        return reservationDAO.GetMonthDatesForReservedTotalAll();
    }
}
