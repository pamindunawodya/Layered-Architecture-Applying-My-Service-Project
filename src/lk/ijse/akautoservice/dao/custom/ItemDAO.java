package lk.ijse.akautoservice.dao.custom;

import lk.ijse.akautoservice.dao.CrudDAO;
import lk.ijse.akautoservice.dto.ItemDTO;
import lk.ijse.akautoservice.entity.CustomerOrderDetails;
import lk.ijse.akautoservice.entity.Item;
import lk.ijse.akautoservice.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<Item,String> {

     ArrayList getItemCodes() throws SQLException, ClassNotFoundException;
     boolean save(ArrayList<Item> ilist);
}
