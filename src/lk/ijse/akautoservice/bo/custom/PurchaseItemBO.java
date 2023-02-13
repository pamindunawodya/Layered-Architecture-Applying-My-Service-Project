package lk.ijse.akautoservice.bo.custom;

import lk.ijse.akautoservice.bo.SuperBO;
import lk.ijse.akautoservice.dto.CustomerOrderDTO;
import lk.ijse.akautoservice.dto.CustomerOrderDetailsDTO;
import lk.ijse.akautoservice.dto.ItemDTO;
import lk.ijse.akautoservice.dto.ReservationtoDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseItemBO extends SuperBO {
     ArrayList<String> reserveIds() throws SQLException, ClassNotFoundException ;

     ArrayList<String>existsItemCodes() throws SQLException, ClassNotFoundException ;

     String existsLastOrderID() throws SQLException, ClassNotFoundException ;

     ArrayList<ItemDTO> showItemData() throws SQLException, ClassNotFoundException ;

     ArrayList<ReservationtoDTO> showReservationData() throws SQLException, ClassNotFoundException ;

     boolean requestOrder(ArrayList<CustomerOrderDetailsDTO> clist, CustomerOrderDTO c, ArrayList<ItemDTO> ilist) throws SQLException, ClassNotFoundException;

     }

