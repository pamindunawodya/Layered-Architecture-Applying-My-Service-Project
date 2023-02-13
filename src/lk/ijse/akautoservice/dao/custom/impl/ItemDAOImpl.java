package lk.ijse.akautoservice.dao.custom.impl;

import lk.ijse.akautoservice.dao.custom.ItemDAO;
import lk.ijse.akautoservice.dto.ItemDTO;
import lk.ijse.akautoservice.entity.Item;
import lk.ijse.akautoservice.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Item VALUES(?, ?, ?, ?, ?, ?)",
                item.getItem_code(),
                item.getItem_name(),
                item.getDescription(),
                item.getBrand(),
                item.getStock(),
                item.getUnit_price()

        );
    }

    @Override
    public boolean Update(Item r) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Item SET item_name = '" + r.getItem_name() + "', item_details='" + r.getDescription() + "',brand='" + r.getBrand() + "',stock='" + r.getStock() + "',unity_price='" + r.getUnit_price() + "'WHERE item_code='" +
                r.getItem_code() + "'");
    }

    @Override
    public ArrayList<Item> search(String x) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Item WHERE item_code ='%" + x + "%';");
        ArrayList<Item> ilist = new ArrayList<>();

        while (result.next()) {
            ilist.add(new Item(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getDouble(6)
            ));

        }
        return ilist;
    }


    @Override
    public boolean delete(String x) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Item WHERE item_code='" + x + "';");
    }

    @Override
    public ArrayList showAllData() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Item;");
        ArrayList<Item> slist = new ArrayList<>();

        while (result.next()) {
            Item item = new Item(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getDouble(6)

            );
            slist.add(item);
        }
        return slist;
    }

    @Override
    public ArrayList<Item> getItemCodes() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT  item_code FROM Item;");
        ArrayList custList = new ArrayList<>();

        while (result.next()) {
            custList.add(result.getString(1));
        }
        return custList;

    }

    @Override
    public boolean save(ArrayList<Item> ilist) {
        return false;
    }



}

