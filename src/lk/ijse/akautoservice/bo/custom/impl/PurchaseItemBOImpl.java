package lk.ijse.akautoservice.bo.custom.impl;

import lk.ijse.akautoservice.bo.custom.PurchaseItemBO;
import lk.ijse.akautoservice.dao.DAOFactory;
import lk.ijse.akautoservice.dao.custom.CustomerOrderDAO;
import lk.ijse.akautoservice.dao.custom.ItemDAO;
import lk.ijse.akautoservice.dao.custom.ReservationDAO;
import lk.ijse.akautoservice.db.DBConnection;
import lk.ijse.akautoservice.dto.CustomerOrderDTO;
import lk.ijse.akautoservice.dto.CustomerOrderDetailsDTO;
import lk.ijse.akautoservice.dto.ItemDTO;
import lk.ijse.akautoservice.dto.ReservationtoDTO;
import lk.ijse.akautoservice.entity.CustomerOrder;
import lk.ijse.akautoservice.entity.CustomerOrderDetails;
import lk.ijse.akautoservice.entity.Item;
import lk.ijse.akautoservice.entity.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;


public class PurchaseItemBOImpl implements PurchaseItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    CustomerOrderDAO customerOrderDAO = (CustomerOrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMERORDER);
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);


    public ArrayList<String> reserveIds() throws SQLException, ClassNotFoundException {

        return reservationDAO.getReserveIds();
    }

    public ArrayList<String> existsItemCodes() throws SQLException, ClassNotFoundException {
        return itemDAO.getItemCodes();
    }

    public String existsLastOrderID() throws SQLException, ClassNotFoundException {
        // return customerOrderDAO.GetLastOrderID(new CustomerOrderDAO());
        return customerOrderDAO.GetLastOrderID();

    }

    @Override
    public ArrayList<ItemDTO> showItemData() throws SQLException, ClassNotFoundException {
        ArrayList<Item> all =itemDAO.showAllData();
        ArrayList<ItemDTO>allReservation=new ArrayList<>();
        for(Item item :all){
            allReservation.add(new ItemDTO(item.getItem_code(),item.getItem_name(),item.getDescription(),item.getBrand(),item.getStock(),item.getUnit_price()));
        }
        return allReservation;
    }


    /*    public ArrayList<ItemDTO> showItemData() throws SQLException, ClassNotFoundException {

        }*/
    public ArrayList<ReservationtoDTO> showReservationData() throws SQLException, ClassNotFoundException {
        ArrayList<Reservation> all =reservationDAO.showAllData();
        ArrayList<ReservationtoDTO>allReservation=new ArrayList<>();
        for(Reservation reservation :all){
            allReservation.add(new ReservationtoDTO(reservation.getReserved_Id(), reservation.getReserved_CustomerID(), reservation.getReserved_VehicleNo(), reservation.getReserved_ServiceType(),reservation.getReserved_ServiceFee(),reservation.getReserved_Date()));
        }
        return allReservation;
    }
    public boolean requestOrder(ArrayList<CustomerOrderDetailsDTO> clist, CustomerOrderDTO c, ArrayList<ItemDTO> ilist) throws SQLException, ClassNotFoundException {
        ArrayList<CustomerOrderDetails> newclist = new ArrayList<>();
        for(CustomerOrderDetailsDTO cb:clist){
            newclist.add(new CustomerOrderDetails(cb.getOrder_id(), cb.getItem_code(), cb.getItem_name(), cb.getQty(), cb.getUnit_price()));
        }
        CustomerOrder neewc=new CustomerOrder(c.getOrder_id(),c.getReservation_id(),c.getReservation_date(),c.getTotal_price());
        ArrayList<Item> newilist = new ArrayList<>();
        for(ItemDTO i:ilist){
            newilist.add(new Item(i.getItem_code(),i.getItem_name(),i.getDescription(),i.getBrand(),i.getStock(),i.getUnit_price()));
        }
        try{
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            if(customerOrderDAO.save(newclist)){
                if(customerOrderDAO.save(neewc)){
                    if(itemDAO.save(newilist)){
                        DBConnection.getInstance().getConnection().commit();
                        return true;
                    }
                }
            }
        }finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
        return false;
    }

}
