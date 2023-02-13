package lk.ijse.akautoservice.dao.custom.impl;

import lk.ijse.akautoservice.dao.custom.VehicleDAO;
import lk.ijse.akautoservice.dto.VehicleDTO;
import lk.ijse.akautoservice.entity.Vehicle;
import lk.ijse.akautoservice.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDAOImpl implements VehicleDAO {
    @Override
    public boolean save(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Vehicle VALUES(?, ?, ?, ?)",
                vehicle.getVehicle_number(),
                vehicle.getVehicle_category(),
                vehicle.getVehicle_brand(),
                vehicle.getCustomer_id()


        );
    }

    @Override
    public boolean Update(Vehicle v) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Vehicle SET  c_id = '" + v.getCustomer_id() + "',v_category='" + v.getVehicle_category() + "',v_brand='" + v.getVehicle_brand() + "' WHERE v_number='" + v.getVehicle_number() + "' ;");
    }

    @Override
    public ArrayList<Vehicle> search(String x) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT*FROM Vehicle WHERE v_number LIKE '%" + x + "%';");
        ArrayList<Vehicle> vlist = new ArrayList<>();

        while (result.next()) {
            vlist.add(new Vehicle(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            ));
        }
        return vlist;
    }

    @Override
    public boolean delete(String x) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Vehicle WHERE  v_number='" + x + "';");
    }

    @Override
    public ArrayList<Vehicle> showAllData() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Vehicle;");
        ArrayList<Vehicle> slist = new ArrayList<>();

        while (result.next()) {
            slist.add(new Vehicle(

                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)

            ));
        }
        return slist;
    }

    @Override
    public ArrayList <String>getCustomerIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT c_id FROM Customer;");
        ArrayList custList = new ArrayList<>();

        while (result.next()) {
            custList.add(result.getString(1));
        }
        return custList;
    }

    @Override
    public ArrayList showVehicleFromCustomerID(String x) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT*FROM VEHICLE WHERE C_ID='" + x + "';");
        ArrayList<Vehicle> vlist = new ArrayList<>();

        while (result.next()) {
            vlist.add(new Vehicle(

                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            ));
        }
        return vlist;
    }





}







