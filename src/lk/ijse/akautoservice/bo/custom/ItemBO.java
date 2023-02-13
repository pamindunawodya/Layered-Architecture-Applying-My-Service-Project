package lk.ijse.akautoservice.bo.custom;

import lk.ijse.akautoservice.bo.SuperBO;
import lk.ijse.akautoservice.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    boolean saveItem(ItemDTO item) throws SQLException, ClassNotFoundException ;

    ArrayList<ItemDTO> searchItem(String x) throws SQLException, ClassNotFoundException ;

   boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException;

   boolean deleteItem(String item) throws SQLException, ClassNotFoundException;

    ArrayList<ItemDTO>showAllItemData() throws SQLException, ClassNotFoundException;

}
