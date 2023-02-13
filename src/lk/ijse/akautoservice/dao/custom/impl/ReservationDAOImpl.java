package lk.ijse.akautoservice.dao.custom.impl;

import lk.ijse.akautoservice.dao.custom.ReservationDAO;
import lk.ijse.akautoservice.dto.CustomerDTO;
import lk.ijse.akautoservice.dto.ReservationGraphtoDTO;
import lk.ijse.akautoservice.dto.ReservationtoDTO;
import lk.ijse.akautoservice.dto.VehicleDTO;
import lk.ijse.akautoservice.entity.Customer;
import lk.ijse.akautoservice.entity.Reservation;
import lk.ijse.akautoservice.entity.Vehicle;
import lk.ijse.akautoservice.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationDAOImpl implements ReservationDAO {


    public  ArrayList<Customer> getCustomerIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Customer;");
        ArrayList<Customer> custList = new ArrayList<>();

        while (result.next()) {
            Customer c = new Customer(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)
            );
            custList.add(c);
        }
        return custList;
    }

    public  ArrayList<Vehicle>getVehicleNumbers() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Vehicle;");
        ArrayList<Vehicle> vlist = new ArrayList<>();

        while (result.next()) {
          Vehicle vehicle = new Vehicle(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)


            );
            vlist.add(vehicle);
        }
        return vlist;
    }

    public  ArrayList<ReservationGraphtoDTO> GetMonthDatesForReservedTotalAll() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT\n" +
                "Reservations.Reserved_Id,ReservationsLimitsForMonthDates.Month_Limit,ReservationsLimitsForMonthDates.Month_Day,COUNT(*)\n" +
                "FROM \n" +
                "ReservationsLimitsForMonthDates LEFT JOIN Reservations ON Day(Reserved_Date)=Month_Day\n" +
                "GROUP BY ReservationsLimitsForMonthDates.Month_Day\n" +
                "HAVING COUNT(*) >0\n" +
                "ORDER BY ReservationsLimitsForMonthDates.Month_Day ASC;");
        ArrayList<ReservationGraphtoDTO> slist = new ArrayList<>();

        while (result.next()) {
            slist.add(new ReservationGraphtoDTO(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            ));
        }
        System.out.println(slist.size());
        return slist;
    }

    public  String GetLastReservationID() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT Reserved_Id FROM Reservations ORDER BY Reserved_Id DESC LIMIT 1;");
        String id = null;
        while (result.next()) {
            id = result.getString(1);
        }
        return id;

    }

    public  boolean save(Reservation r) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Reservations VALUES(?,?,?,?,?,?)",
                r.getReserved_Id(),
                r.getReserved_CustomerID(),
                r.getReserved_VehicleNo(),
                r.getReserved_ServiceType(),
                r.getReserved_ServiceFee(),
                r.getReserved_Date()
        );
    }



    @Override
    public boolean Update(Reservation r) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Reservation> search(String x) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String x) throws SQLException, ClassNotFoundException {
        return false;
    }

    public  ArrayList<Reservation> showAllData() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Reservations;");
        ArrayList<Reservation> slist = new ArrayList<>();

        while (result.next()) {
            slist.add(new Reservation(

                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getDouble(5),
                    result.getDate(6)


            ));
        }
        return slist;
    }

    public  ArrayList<String> getReserveIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT RESERVED_ID FROM RESERVATIONS;");
        ArrayList resevlist = new ArrayList<>();

        while (result.next()) {
            resevlist.add(result.getString(1));
        }
        return resevlist;


    }


}








