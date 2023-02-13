package lk.ijse.akautoservice.bo.custom.impl;

import lk.ijse.akautoservice.bo.custom.OwnerCustomerBO;
import lk.ijse.akautoservice.dao.CrudDAO;
import lk.ijse.akautoservice.dao.DAOFactory;
import lk.ijse.akautoservice.dao.custom.CustomerDAO;
import lk.ijse.akautoservice.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.akautoservice.dto.CustomerDTO;
import lk.ijse.akautoservice.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class OwnerCustomerBOImpl implements OwnerCustomerBO {
    CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);//hide the object creation Logic


    public ArrayList<CustomerDTO>showAllCustomerData() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> all = customerDAO.showAllData();
        ArrayList<CustomerDTO>allCustomer=new ArrayList<>();
        for(Customer v:all){
            allCustomer.add(new CustomerDTO(v.getCustomer_id(),v.getCustomer_name(),v.getCustomer_nic(),v.getCustomer_address(),v.getCustomer_mobile()));
        }
        return allCustomer;

    }
    public ArrayList<CustomerDTO> searchCustomer(String x) throws SQLException, ClassNotFoundException {
        ArrayList<Customer> search = customerDAO.search(x);
        ArrayList<CustomerDTO>allCustomer=new ArrayList<>();
        for(Customer v:search){
            allCustomer.add(new CustomerDTO(v.getCustomer_id(),v.getCustomer_name(),v.getCustomer_nic(),v.getCustomer_address(),v.getCustomer_mobile()));
        }
        return allCustomer;


    }
}

