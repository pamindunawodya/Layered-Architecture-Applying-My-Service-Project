package lk.ijse.akautoservice.dao.custom;

import lk.ijse.akautoservice.dao.SuperDAO;

import java.sql.SQLException;

public interface QueryDAO extends SuperDAO {
     void SearchOrderByOrderID(String id)throws SQLException,ClassNotFoundException;
}
