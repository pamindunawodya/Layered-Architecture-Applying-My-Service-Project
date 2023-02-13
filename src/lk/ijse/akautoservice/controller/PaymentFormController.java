package lk.ijse.akautoservice.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lk.ijse.akautoservice.bo.BOFactory;
import lk.ijse.akautoservice.bo.custom.PaymentBO;
import lk.ijse.akautoservice.bo.custom.impl.PaymentBOImpl;
import lk.ijse.akautoservice.dto.CustomerOrderDTO;
import lk.ijse.akautoservice.dto.ReservationtoDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentFormController {


    public ComboBox cmbReservationID;
    public TextField txtReservationID;
    public ComboBox cmbItemCodes;
    public TextField txtStock;
    public TextField txtResvecustID;
    public TextField txtRedveVehicleId;
    public TextField txtResveServiceType;
    public TextField txtResveServiceFee;
    public TextField txtResveDate;
    public TextField txtItemName;
    public TextField txtDate;
    public TextField txtTotalOrderPrice;
    public TextField txtQty;
    public TextField txtReserveID;
    public ComboBox cmbOrderID;
    ArrayList<ReservationtoDTO> rlist = new ArrayList<>();
    ArrayList<CustomerOrderDTO> clist = new ArrayList<>();
    PaymentBO paymentBO= (PaymentBO) BOFactory.getboFactory().getBO(BOFactory.BOTypes.PAYMENT);


    public void initialize() throws SQLException, ClassNotFoundException {

        load();

    }

    private void load() throws SQLException, ClassNotFoundException {
        loadReservationData();
        loadCustomerOrderDetails();

        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.setAll(
                paymentBO.GetLastReservationID());
        cmbReservationID.setItems(obList);

        ObservableList<String> olist = FXCollections.observableArrayList();
        obList.setAll(
                paymentBO.GetLastOrderID());
        cmbOrderID.setItems(obList);


    }

    private void loadCustomerOrderDetails() {
    }

    private void loadReservationData() throws SQLException, ClassNotFoundException {
        ObservableList<String> obl = FXCollections.observableArrayList();
        rlist = paymentBO.showAllReservationData();
        ArrayList<String> reserveArray = new ArrayList<>();

        for (ReservationtoDTO r : rlist) {
            reserveArray.add(r.getReserved_Id());
        }
        obl.setAll(reserveArray);
        cmbOrderID.setItems(obl);
    }

    public void cmbItemCodesOnAction(ActionEvent actionEvent) {

    }

    public void addToCartOnAction(ActionEvent actionEvent) {
    }

    public void tblCartOnAction(MouseEvent mouseEvent) {
    }

    public void cmbReservationIDOnAction(ActionEvent actionEvent) {
        txtReservationID.setText(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).getReserved_Id());
        txtResvecustID.setText(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).getReserved_CustomerID());
        txtRedveVehicleId.setText(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).getReserved_VehicleNo());
        txtResveServiceType.setText(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).getReserved_ServiceType());
        txtResveServiceFee.setText(String.valueOf(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).getReserved_ServiceFee()));
        txtResveDate.setText(String.valueOf(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).getReserved_Date()));


    }

    public void cmbOrderIDOnAction(ActionEvent actionEvent) {
        txtReservationID.setText(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).getReserved_Id());

       /* txtRedveVehicleId.setText(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).getReserved_Id());
        txtDate.setText(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).getReserved_Date());
        txtTotalOrderPrice.setText(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).g);
*/
    }
}
