package lk.ijse.akautoservice.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.akautoservice.bo.BOFactory;
import lk.ijse.akautoservice.bo.custom.OwnerCustomerBO;
import lk.ijse.akautoservice.bo.custom.impl.OwnerCustomerBOImpl;
import lk.ijse.akautoservice.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;


public class OwnerCustomerFormController {


    public TableView atblCustomer;
    public TableColumn hcolCustomerID;
    public TableColumn hcolCustomerName;
    public TableColumn hcolCustomerNic;
    public TableColumn hcolCustomerAddress;
    public TableColumn hcolCustomerMobileNo;
    public TextField htxtSearch;
    ArrayList<CustomerDTO> rarray = null;

    OwnerCustomerBO ownerCustomerBO= (OwnerCustomerBO) BOFactory.getboFactory().getBO(BOFactory.BOTypes.OWNERCUSTOMER);

    public void initialize() {
        viewAllCustomerData();
        hcolCustomerID.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        hcolCustomerName.setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        hcolCustomerNic.setCellValueFactory(new PropertyValueFactory<>("customer_nic"));
        hcolCustomerAddress.setCellValueFactory(new PropertyValueFactory<>("customer_address"));
        hcolCustomerMobileNo.setCellValueFactory(new PropertyValueFactory<>("customer_mobile"));

    }


    private void viewAllCustomerData() {
        ArrayList<CustomerDTO> carray = new ArrayList();

        ObservableList<CustomerDTO> obl = FXCollections.observableArrayList();
        try {
            carray = ownerCustomerBO.showAllCustomerData();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        obl.setAll(carray);
        atblCustomer.setItems(obl);


    }

    public void htxtSearchIDOnAction(KeyEvent keyEvent) {
        ObservableList<CustomerDTO> obl = FXCollections.observableArrayList();
        viewAllCustomerData();

        try {
            rarray = ownerCustomerBO.searchCustomer(htxtSearch.getText());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();


        }
        obl.setAll(rarray);
        atblCustomer.setItems(obl);
    }
}

