package lk.ijse.akautoservice.bo.custom;

import lk.ijse.akautoservice.bo.SuperBO;
import lk.ijse.akautoservice.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OwnerCustomerBO extends SuperBO {
     ArrayList<CustomerDTO> showAllCustomerData() throws SQLException, ClassNotFoundException ;

     ArrayList<CustomerDTO> searchCustomer(String x) throws SQLException, ClassNotFoundException ;

}
