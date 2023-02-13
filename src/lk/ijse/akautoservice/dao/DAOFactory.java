package lk.ijse.akautoservice.dao;

import lk.ijse.akautoservice.dao.custom.CustomerDAO;
import lk.ijse.akautoservice.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;


    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        return daoFactory==null?(daoFactory=new DAOFactory()):daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,VEHICLE,RESERVATION,SERVICE,CUSTOMERORDER,QUERYDAO,CUSTOMERORDERDETAIL
    }
    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case ITEM:
                return new ItemDAOImpl();
            case VEHICLE:
                return new VehicleDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            case RESERVATION:
                return new ReservationDAOImpl();
            case CUSTOMERORDER:
                return new CustomerOrderDAOImpl();
            case SERVICE:
                return new ServiceDAOImpl();
            case QUERYDAO:
                return new QueryDAOImpl();

            default:
                return null;

        }
    }
}
