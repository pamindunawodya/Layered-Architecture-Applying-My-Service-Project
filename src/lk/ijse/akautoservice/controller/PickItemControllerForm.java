package lk.ijse.akautoservice.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.akautoservice.bo.BOFactory;
import lk.ijse.akautoservice.bo.custom.PurchaseItemBO;
import lk.ijse.akautoservice.bo.custom.impl.PurchaseItemBOImpl;
import lk.ijse.akautoservice.db.DBConnection;
import lk.ijse.akautoservice.dto.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PickItemControllerForm {


    public TextField txtQty;
    public ComboBox<String> cmbItemCodes;
    public ComboBox cmbReservationID;
    public TextField txtReservationID;
    public TableView tblCart;
    public TextField txtOrderId;
    public TextField txtStock;
    public TableColumn colCode;
    public TableColumn colItemName;
    public TableColumn colItemDetails;
    public TableColumn colBrand;
    public TableColumn colStock;
    public TableColumn colUnitPrice;
    public TableColumn colqty;
    public Label lblTotal;
    public TextField txtResvecustID;
    public TextField txtRedveVehicleId;
    public TextField txtResveServiceType;
    public TextField txtResveServiceFee;
    public TextField txtItemName;
    public TextField txtResveDate;
    public TextField txtItemDetalis;
    public TextField txtBrand;
    public TextField txtUnitPrice;
    public TextField txtItemCode;
    public TableColumn colOrderID;
    public Text txttotal;

    ArrayList<ReservationtoDTO> rlist = new ArrayList<>();
    ArrayList<ItemDTO> ilist = new ArrayList<>();
    ArrayList<CustomerOrderDetailsDTO> clist = new ArrayList<>();

    PurchaseItemBO purchaseItemBO= (PurchaseItemBO) BOFactory.getboFactory().getBO(BOFactory.BOTypes.PURCHASE);


    public void initialize() throws SQLException, ClassNotFoundException {

        load();


        colOrderID.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        colCode.setCellValueFactory(new PropertyValueFactory<>("item_code"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unit_price"));


    }

    public void load() throws SQLException, ClassNotFoundException {
        loadReservationData();
        loadItemData();
        loadOrderID();

       /* ObservableList<String> obList = FXCollections.observableArrayList();
        obList.setAll(
                purchaseItemBO.reserveIds());
        cmbReservationID.setItems(obList);

        ObservableList<String> ilist = FXCollections.observableArrayList();
        ilist.setAll(
                purchaseItemBO.existsItemCodes());
        cmbItemCodes.setItems(ilist);*/
    }

    private void loadOrderID() {

        String id = null;
        try {
            id = purchaseItemBO.existsLastOrderID();
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.CONFIRMATION, e + "").show();

        }
        String[] array = id.split("-");
        int tempNumber = Integer.parseInt(array[1]);
        int finalizeOrderId = tempNumber + 1;
        txtOrderId.setText("O-" + finalizeOrderId);
    }


    private void loadItemData() throws SQLException, ClassNotFoundException {

        ObservableList<String> obl = FXCollections.observableArrayList();
        ilist = purchaseItemBO.showItemData();//  ilist = itemDAO.showAllData();
        ArrayList<String> itemArray = new ArrayList<>();

        for (ItemDTO i : ilist) {
            itemArray.add(i.getItem_code());


        }
       obl.setAll(itemArray);
        cmbItemCodes.setItems(obl);


    }

    private void loadReservationData() throws SQLException, ClassNotFoundException {
        ObservableList<String> obl = FXCollections.observableArrayList();
        rlist = purchaseItemBO.showReservationData();
        ArrayList<String> reserveidArray = new ArrayList<>();

        for (ReservationtoDTO r : rlist) {
            reserveidArray.add(r.getReserved_Id());
        }
        obl.setAll(reserveidArray);
        cmbReservationID.setItems(obl);

    }

    public void placeOrderOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {


    }

    public void addToCartOnAction(ActionEvent actionEvent) {
        CustomerOrderDetailsDTO customerOrderDetails = new CustomerOrderDetailsDTO(txtOrderId.getText(),
                txtItemCode.getText(),
                txtItemName.getText(),
                Integer.parseInt(txtQty.getText()),
                Double.parseDouble(txtUnitPrice.getText()));
        clist.add(customerOrderDetails);
        ObservableList<CustomerOrderDetailsDTO> oblist = FXCollections.observableArrayList();
        oblist.setAll(clist);
        tblCart.setItems(oblist);
        double total = 0;
        for (CustomerOrderDetailsDTO c : clist) {
            total += c.getUnit_price() * c.getQty();
        }
        txttotal.setText(String.valueOf(total));

    }

    public void cmbReservationIDOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        txtReservationID.setText(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).getReserved_Id());
        txtResvecustID.setText(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).getReserved_CustomerID());
        txtRedveVehicleId.setText(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).getReserved_VehicleNo());
        txtResveServiceType.setText(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).getReserved_ServiceType());
        txtResveServiceFee.setText(String.valueOf(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).getReserved_ServiceFee()));
        txtResveDate.setText(String.valueOf(rlist.get(cmbReservationID.getSelectionModel().getSelectedIndex()).getReserved_Date()));


    }

    public void cmbItemCodesOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        txtItemCode.setText(ilist.get(cmbItemCodes.getSelectionModel().getSelectedIndex()).getItem_code());
        txtItemName.setText(ilist.get(cmbItemCodes.getSelectionModel().getSelectedIndex()).getItem_name());
        txtItemDetalis.setText(ilist.get(cmbItemCodes.getSelectionModel().getSelectedIndex()).getDescription());
        txtBrand.setText(ilist.get(cmbItemCodes.getSelectionModel().getSelectedIndex()).getBrand());
        txtStock.setText(ilist.get(cmbItemCodes.getSelectionModel().getSelectedIndex()).getStock());
        txtUnitPrice.setText(String.valueOf(ilist.get(cmbItemCodes.getSelectionModel().getSelectedIndex()).getUnit_price()));


    }

    public void tblCartOnAction(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {

    }

    public void createpickupOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Date utildate = new Date();
        java.sql.Date sqldate = new java.sql.Date(utildate.getTime());

        CustomerOrderDTO c = new CustomerOrderDTO(
                txtOrderId.getText(),
                txtReservationID.getText(),
                sqldate,
                Double.parseDouble(txttotal.getText())
        );
        if (purchaseItemBO.requestOrder(
                clist,
                c,
                ilist))
        {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved!").show();
            cmbItemCodes.getItems().clear();
            cmbReservationID.getItems().clear();
            ilist.clear();
            rlist.clear();
            clist.clear();
            tblCart.getItems().clear();
            txttotal.setText("0.00");
            load();
            //textfieldclear
            Thread cq = new Thread(new Runnable() {
                @Override
                public void run() {
                    HashMap hm = new HashMap<>();
                    InputStream inputStream = null;
                    inputStream = this.getClass().getClassLoader().getResourceAsStream("lk/ijse/akautoservice/report/allview_1.jrxml");
                    try {
                        JasperReport compileReport = JasperCompileManager.compileReport(inputStream);
                        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, hm, DBConnection.getInstance().getConnection());
                        // JasperPrintManager.printReport(jasperPrint,true);//--> print karanawanam.
                        JasperViewer.viewReport(jasperPrint, false);
                    } catch (JRException | SQLException | ClassNotFoundException e) {
                        //throw new RuntimeException(e);
                    }
                }
            });
            cq.start();

        } else {
            new Alert(Alert.AlertType.ERROR, "Try Again!").show();
        }

    }

    }
