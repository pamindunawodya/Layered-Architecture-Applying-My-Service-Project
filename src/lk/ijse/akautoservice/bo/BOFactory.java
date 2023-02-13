package lk.ijse.akautoservice.bo;

import lk.ijse.akautoservice.bo.custom.OwnerReservationDetailsBO;
import lk.ijse.akautoservice.bo.custom.impl.*;
import lk.ijse.akautoservice.dao.DAOFactory;

public class  BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getboFactory(){return boFactory==null?(boFactory=new BOFactory()):boFactory;
}
public enum BOTypes{
        CUSTOMER,ITEM,VEHICLE,OWNERCUSTOMER,OWNERRESERVATION,OWNERVEHICLE,PAYMENT,PURCHASE,RECEPTIONIST,RESERVATION
}

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case VEHICLE:
                return new VehicleBOImpl();
            case OWNERCUSTOMER:
                return new OwnerCustomerBOImpl();
            case OWNERRESERVATION:
                return new OwnerReserveDetailsBOImpl();
            case OWNERVEHICLE:
                return new OwnerVehicleBoImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case PURCHASE:
                return new PurchaseItemBOImpl();
            case RECEPTIONIST:
                return new ReceptionistBOImpl();
            case RESERVATION:
                return new ReservationBOImpl();
            default:
                return null;
        }
    }
}
