package lk.ijse.akautoservice.dao.custom;

import lk.ijse.akautoservice.dao.CrudDAO;
import lk.ijse.akautoservice.db.DBConnection;
import lk.ijse.akautoservice.dto.CustomerOrderDTO;
import lk.ijse.akautoservice.dto.CustomerOrderDetailsDTO;
import lk.ijse.akautoservice.dto.ItemDTO;
import lk.ijse.akautoservice.entity.CustomerOrder;
import lk.ijse.akautoservice.entity.CustomerOrderDetails;
import lk.ijse.akautoservice.entity.Item;
import lk.ijse.akautoservice.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerOrderDAO extends CrudDAO<CustomerOrder,String > {
    String GetLastOrderID() throws SQLException, ClassNotFoundException ;

   boolean CreateOrder(ArrayList<CustomerOrderDetails> clist, CustomerOrder c, ArrayList<Item> ilist) throws SQLException, ClassNotFoundException;

   boolean save(ArrayList<CustomerOrderDetails> clist) throws SQLException, ClassNotFoundException ;


}
