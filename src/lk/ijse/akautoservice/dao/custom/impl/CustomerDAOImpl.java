package lk.ijse.akautoservice.dao.custom.impl;


import lk.ijse.akautoservice.dao.CrudDAO;
import lk.ijse.akautoservice.dao.custom.CustomerDAO;
import lk.ijse.akautoservice.dto.CustomerDTO;
import lk.ijse.akautoservice.entity.Customer;
import lk.ijse.akautoservice.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Customer VALUES(?, ?, ?, ?, ?)",
                customer.getCustomer_id(),
                customer.getCustomer_name(),
                customer.getCustomer_nic(),
                customer.getCustomer_address(),
                customer.getCustomer_mobile()
        );
    }

    @Override
    public boolean Update(Customer r) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Customer SET  c_name = '" + r.getCustomer_name() + "', nic='" + r.getCustomer_nic() + "',address='" + r.getCustomer_address() + "',contact='" + r.getCustomer_mobile() + "'WHERE c_id='" +
                r.getCustomer_id() + "'");
    }

    @Override
    public ArrayList<Customer> search(String x) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT*FROM Customer WHERE c_id LIKE '%" + x + "%';");
        ArrayList<Customer> clist = new ArrayList<>();

        while (result.next()) {
            clist.add(new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)
            ));
        }
        return clist;
    }

    @Override
    public boolean delete(String x) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Customer WHERE c_id='" + x + "';");
    }

    @Override
    public ArrayList<Customer> showAllData() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Customer;");
        ArrayList<Customer> slist = new ArrayList<>();

        while (result.next()) {
            slist.add(new Customer(

                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)

            ));
        }
        return slist;
    }

}