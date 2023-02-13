package lk.ijse.akautoservice.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.akautoservice.bo.BOFactory;
import lk.ijse.akautoservice.bo.custom.OwnerReservationDetailsBO;
import lk.ijse.akautoservice.bo.custom.impl.OwnerReserveDetailsBOImpl;
import lk.ijse.akautoservice.dto.ReservationtoDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OwnerReserveDetailsViewController {

    public TableView tblReservationDetails;
    public TableColumn colReserveID;
    public TableColumn colCustID;
    public TableColumn colVnumber;
    public TableColumn colServicecode;
    public TableColumn colServiceType;
    public TableColumn colServiceDate;
    public TableColumn colServiceFee;
    OwnerReservationDetailsBO ownerReserveDetailsBO= (OwnerReservationDetailsBO) BOFactory.getboFactory().getBO(BOFactory.BOTypes.OWNERRESERVATION);

    public void initialize() throws SQLException, ClassNotFoundException, InterruptedException {
        viewAllReserveData();

        colReserveID.setCellValueFactory(new PropertyValueFactory<>("Reserved_Id"));
        colCustID.setCellValueFactory(new PropertyValueFactory<>("Reserved_CustomerID"));
        colVnumber.setCellValueFactory(new PropertyValueFactory<>("reserved_VehicleNo"));
        colServiceType.setCellValueFactory(new PropertyValueFactory<>("Reserved_ServiceType"));
        colServiceDate.setCellValueFactory(new PropertyValueFactory<>("reserved_Date"));
        colServiceFee.setCellValueFactory(new PropertyValueFactory<>("reserved_ServiceFee"));
    }

    private void viewAllReserveData() {
        ArrayList<ReservationtoDTO> relist = new ArrayList();
        ObservableList<ReservationtoDTO> obl = FXCollections.observableArrayList();
        try {
            relist = ownerReserveDetailsBO.showReservationAllData();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        obl.setAll(relist);
        tblReservationDetails.setItems(obl);

    }

}
