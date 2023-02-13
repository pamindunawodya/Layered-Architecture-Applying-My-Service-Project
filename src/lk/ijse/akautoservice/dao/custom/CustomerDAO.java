package lk.ijse.akautoservice.dao.custom;

import lk.ijse.akautoservice.dao.CrudDAO;
import lk.ijse.akautoservice.dto.CustomerDTO;
import lk.ijse.akautoservice.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    ArrayList<Customer> showAllData() throws SQLException, ClassNotFoundException;
}
