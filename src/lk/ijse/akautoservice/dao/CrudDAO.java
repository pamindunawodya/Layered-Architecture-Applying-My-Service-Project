package lk.ijse.akautoservice.dao;

import lk.ijse.akautoservice.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T , String> extends SuperDAO {
    boolean save(T customer) throws SQLException, ClassNotFoundException ;

    boolean Update(T r) throws SQLException, ClassNotFoundException;

    ArrayList<T> search(String x) throws SQLException, ClassNotFoundException ;

    boolean delete(String x) throws SQLException, ClassNotFoundException ;

    ArrayList<T> showAllData() throws SQLException, ClassNotFoundException;

}
