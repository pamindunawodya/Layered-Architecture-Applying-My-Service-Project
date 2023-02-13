package lk.ijse.akautoservice.bo.custom;

import lk.ijse.akautoservice.bo.SuperBO;
import lk.ijse.akautoservice.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    boolean saveCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException ;

    boolean updateCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException ;

    boolean deleteCustomer(String r) throws SQLException, ClassNotFoundException ;

    ArrayList<CustomerDTO> searchCustomer(String x) throws SQLException, ClassNotFoundException ;

    ArrayList<CustomerDTO>showAllCustomerData() throws SQLException, ClassNotFoundException ;

}
