package lk.ijse.akautoservice.dao.custom.impl;

import lk.ijse.akautoservice.dao.custom.CustomerOrderDAO;
import lk.ijse.akautoservice.db.DBConnection;
import lk.ijse.akautoservice.dto.CustomerDTO;
import lk.ijse.akautoservice.dto.CustomerOrderDetailsDTO;
import lk.ijse.akautoservice.entity.CustomerOrder;
import lk.ijse.akautoservice.entity.CustomerOrderDetails;
import lk.ijse.akautoservice.entity.Item;
import lk.ijse.akautoservice.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerOrderDAOImpl implements CustomerOrderDAO {
    @Override
    public boolean save(CustomerOrder c) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Customer_order VALUES(?, ?, ?, ?)",
                c.getOrder_id(),
                c.getReservation_id(),
                c.getReservation_date(),
                c.getTotal_price()
        );
    }

    @Override
    public boolean Update(CustomerOrder r) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<CustomerOrder> search(String x) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String x) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<CustomerOrder> showAllData() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String GetLastOrderID() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT*FROM Customer_order ORDER BY order_id DESC LIMIT 1;");
        String id = null;
        while (result.next()) {
            id = result.getString(1);
        }
        return id;
    }


    @Override
    public boolean CreateOrder(ArrayList<CustomerOrderDetails> clist, CustomerOrder c, ArrayList<Item> ilist) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isaddedorder = save(c);
            if (isaddedorder) {
                boolean isaddedorderdetail = save(clist);
                if (isaddedorderdetail) {
                    DBConnection.getInstance().getConnection().commit();
                    return true;
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }

    @Override
    public boolean save(ArrayList<CustomerOrderDetails> clist) throws SQLException, ClassNotFoundException {
        boolean t = false;
        for (CustomerOrderDetails c : clist) {
            t = CrudUtil.execute("INSERT INTO Customer_orderDetails VALUES(?, ?, ?, ?, ?)",
                    c.getOrder_id(),
                    c.getItem_code(),
                    c.getItem_name(),
                    c.getQty(),
                    c.getUnit_price()
            );
        }
        return t;
    }
}


   /* public  String GetLastOrderID() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT*FROM Customer_order ORDER BY order_id DESC LIMIT 1;");
        String id = null;
        while (result.next()) {
            id = result.getString(1);
        }
        return id;
    }

    public  boolean save(CustomerOrderDTO c) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Customer_order VALUES(?, ?, ?, ?)",
                c.getOrder_id(),
                c.getReservation_id(),
                c.getReservation_date(),
                c.getTotal_price()
        );
    }

    public  boolean save(ArrayList<CustomerOrderDetailsDTO> clist) throws SQLException, ClassNotFoundException {
        boolean t = false;
        for (CustomerOrderDetailsDTO c : clist) {
            t = CrudUtil.execute("INSERT INTO Customer_orderDetails VALUES(?, ?, ?, ?, ?)",
                    c.getOrder_id(),
                    c.getItem_code(),
                    c.getItem_name(),
                    c.getQty(),
                    c.getUnit_price()
            );
        }
        return t;
    }

    public  boolean CreateOrder(ArrayList<CustomerOrderDetailsDTO> clist, CustomerOrderDTO c, ArrayList<ItemDTO> ilist) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isaddedorder = save(c);
            if (isaddedorder) {
                boolean isaddedorderdetail = save(clist);
                if (isaddedorderdetail) {
                    DBConnection.getInstance().getConnection().commit();
                    return true;
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }*/

