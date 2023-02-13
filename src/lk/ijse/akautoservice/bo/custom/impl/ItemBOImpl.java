package lk.ijse.akautoservice.bo.custom.impl;

import lk.ijse.akautoservice.bo.custom.ItemBO;
import lk.ijse.akautoservice.dao.DAOFactory;
import lk.ijse.akautoservice.dao.custom.ItemDAO;
import lk.ijse.akautoservice.dao.custom.impl.ItemDAOImpl;
import lk.ijse.akautoservice.dto.ItemDTO;
import lk.ijse.akautoservice.dto.ReservationtoDTO;
import lk.ijse.akautoservice.entity.Item;
import lk.ijse.akautoservice.entity.Reservation;
import lk.ijse.akautoservice.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
   ItemDAO itemDAO= (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    public boolean saveItem(ItemDTO item) throws SQLException, ClassNotFoundException {

        return itemDAO.save(new Item(item.getItem_code(),item.getItem_name(),item.getDescription(), item.getBrand(),item.getStock(),item.getUnit_price()));
    }

    public ArrayList<ItemDTO> searchItem(String x) throws SQLException, ClassNotFoundException {
        ArrayList<Item> search = itemDAO.search(x);
        ArrayList<ItemDTO>allItems=new ArrayList<>();
        for(Item item :search){
            allItems.add(new ItemDTO(item.getItem_code(),item.getItem_name(),item.getDescription(), item.getBrand(),item.getStock(),item.getUnit_price()));
        }
        return allItems;
    }


    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException{
        return itemDAO.Update(new Item(item.getItem_code(),item.getItem_name(),item.getDescription(), item.getBrand(),item.getStock(),item.getUnit_price()));
    }

    public boolean deleteItem(String item) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(item);
    }

    public ArrayList<ItemDTO>showAllItemData() throws SQLException, ClassNotFoundException {
        ArrayList<Item> all = itemDAO.showAllData();
        ArrayList<ItemDTO>allItems=new ArrayList<>();
        for(Item item :all){
            allItems.add(new ItemDTO(item.getItem_code(),item.getItem_name(),item.getDescription(), item.getBrand(),item.getStock(),item.getUnit_price()));
        }
        return allItems;
    }
}