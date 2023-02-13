package lk.ijse.akautoservice.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.akautoservice.bo.BOFactory;
import lk.ijse.akautoservice.bo.custom.CustomerBO;
import lk.ijse.akautoservice.bo.custom.impl.CustomerBOImpl;
import lk.ijse.akautoservice.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class CustomerFormController {
    public AnchorPane pane;
    public AnchorPane modifycontext;
    public TextField mtxtldname;
    public TextField mtxtldnic;
    public TextField mtxtldaddress;
    public TextField mtxtfldsearchcustomer;
    public TextField mtxtldcustomerid;
    public TextField mtxtldmobilenumber;
    public AnchorPane addcontext;
    public TextField atxtfldname;
    public TextField atxtfldnic;
    public TextField atxtfldaddress;
    public TextField atxtfldcustomerid;
    public TextField atxtfldmobile;
    public AnchorPane deletecontext;
    public TextField dtxtfldname;
    public TextField dtxtfldnic;
    public TextField dtxtfldaddress;
    public TextField dtxtfldsearch;
    public TextField dtxtfldcustomerid;
    public TableColumn mcolCustomerID;
    public TableColumn mcolCustomerAddress;
    public TableColumn mcolMobileNo;
    public TableColumn acolCustomerID;
    public TableColumn acolCustomerName;
    public TableColumn acolCustomerNic;
    public TableColumn acolCustomerAddress;
    public TableColumn acolCustomerMobileNo;
    public TextField dtxtfldmobile;
    public TableColumn dcolCustomerID;
    public TableColumn dcolCustomerName;
    public TableColumn dcolCustomerNic;
    public TableColumn dcolCustomerAddress;
    public TableColumn dcolCustomerMobileNo;
    public TableColumn mcolCustomerName;
    public TableColumn mcolCustomerNic;
    public AnchorPane customerHomeContext;
    public TableView dcustomertbl;
    public TableView mtblCustomer;
    public TableView htblCustomer;
    public TableColumn hcolCustomerID;
    public TableColumn hcolCustomerName;
    public TableColumn hcolCustomerNic;
    public TableColumn hcolCustomerAddress;
    public TableColumn hcolCustomerMobileNo;
    public TextField htxtSearch;
    public TableView atblCustomer;
    public Label lblCustomerWarning;
    ArrayList<CustomerDTO> rarray = null;
    CustomerBO customerBo= (CustomerBO) BOFactory.getboFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    @FXML

        private Pattern customerIDPattern;
        private Pattern customernamePattern;
        private Pattern customerNicPattern;
        private Pattern customerAddressPattern;
        private Pattern mobilePattern;


        public void initialize() {



        clearallContexts();
        customerHomeContext.setVisible(true);
        viewAllCustomerData();

        customerIDPattern = Pattern.compile("^[a-z0-9]{4,}$");
        customernamePattern = Pattern.compile("^[a-z0-9]{4,}$");
        customerNicPattern = Pattern.compile("^[a-z0-9]{4,}$");
        customerAddressPattern = Pattern.compile("^[a-zA-Z-\\s]+$");
        mobilePattern = Pattern.compile("^07(7|6|8|1|2|5|0|4)-[0-9]{7}$");

        String successMessage = String.format("-fx-text-fill: GREEN;");
        String errorMessage = String.format("-fx-text-fill: RED;");
        String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
        String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");

//boilerplate codes


        dcolCustomerID.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        dcolCustomerName.setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        dcolCustomerNic.setCellValueFactory(new PropertyValueFactory<>("customer_nic"));
        dcolCustomerAddress.setCellValueFactory(new PropertyValueFactory<>("customer_address"));
        dcolCustomerMobileNo.setCellValueFactory(new PropertyValueFactory<>("customer_mobile"));

        mcolCustomerID.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        mcolCustomerName.setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        mcolCustomerNic.setCellValueFactory(new PropertyValueFactory<>("customer_nic"));
        mcolCustomerAddress.setCellValueFactory(new PropertyValueFactory<>("customer_address"));
        mcolMobileNo.setCellValueFactory(new PropertyValueFactory<>("customer_mobile"));

        acolCustomerID.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        acolCustomerName.setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        acolCustomerNic.setCellValueFactory(new PropertyValueFactory<>("customer_nic"));
        acolCustomerAddress.setCellValueFactory(new PropertyValueFactory<>("customer_address"));
        acolCustomerMobileNo.setCellValueFactory(new PropertyValueFactory<>("customer_mobile"));

        hcolCustomerID.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        hcolCustomerName.setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        hcolCustomerNic.setCellValueFactory(new PropertyValueFactory<>("customer_nic"));
        hcolCustomerAddress.setCellValueFactory(new PropertyValueFactory<>("customer_address"));
        hcolCustomerMobileNo.setCellValueFactory(new PropertyValueFactory<>("customer_mobile"));


    }

    private void clearallContexts() {
        modifycontext.setVisible(false);
        addcontext.setVisible(false);
        deletecontext.setVisible(false);
        customerHomeContext.setVisible(false);
    }


    public void btnAddOnAction(ActionEvent actionEvent) {
        clearallContexts();
        addcontext.setVisible(true);
    }

    public void btnModifyOnAction(ActionEvent actionEvent) {
        clearallContexts();
        modifycontext.setVisible(true);
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        clearallContexts();
        deletecontext.setVisible(true);

    }


    public void mbtnmodifucustomerOnAction(ActionEvent actionEvent) {

        CustomerDTO customer = new CustomerDTO(mtxtldcustomerid.getText(), mtxtldname.getText(), mtxtldnic.getText(), mtxtldaddress.getText(), mtxtldmobilenumber.getText());
        try {
           customerBo.updateCustomer(customer);//customerDAO.Update(customer);
            new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            viewAllCustomerData();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Data not Updated!" + e).show();


        }
    }


    public void abtnaddcustomerOnAction(ActionEvent actionEvent) {

        // boilerplate codes
        //No DI
        //Tight Coupling

        CustomerDTO customer=new CustomerDTO(atxtfldcustomerid.getText(), atxtfldname.getText(), atxtfldnic.getText(), atxtfldaddress.getText(), atxtfldmobile.getText());
        //CustomerDTO customer = new CustomerDTO(customer_id, customer_name, customer_nic, customer_address, customer_mobile);
        try {
            boolean isAdded = customerBo.saveCustomer(customer);// isAdded = customerDAO.save(customer);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "CustomerDTO Added!").show();
                viewAllCustomerData();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "CustomerDTO Data Not Added!" + e).show();
        }
        boolean isCustIDMatched = customerIDPattern.matcher(atxtfldcustomerid.getText()).matches();
        boolean isUserNameMatched = customernamePattern.matcher(atxtfldname.getText()).matches();
        boolean isMobileMatched = mobilePattern.matcher(atxtfldmobile.getText()).matches();
        boolean isaddressMatched = customerAddressPattern.matcher(atxtfldaddress.getText()).matches();
        boolean isNicMatched = customerNicPattern.matcher(atxtfldnic.getText()).matches();

        if (isUserNameMatched) {
            if (isCustIDMatched) {
                if (isMobileMatched) {
                    if (isaddressMatched) {
                        if (isNicMatched) {
                            System.out.println("Registration started!");
                        } else {
                            atxtfldname.setText("Invalid");
                            clearFields();
                            atxtfldname.requestFocus();
                        }
                    } else {
                        atxtfldcustomerid.setText("Invalid CustomerID");
                        clearFields();
                        atxtfldcustomerid.requestFocus();
                    }
                } else {
                    atxtfldmobile.setText("Invalid Mobile No");
                    clearFields();
                    atxtfldmobile.requestFocus();
                }
            } else {
                atxtfldnic.setText("Invalid ");
                clearFields();
                atxtfldnic.requestFocus();
            }

        }
    }

    public void ddeleteCustomerOnAction(ActionEvent actionEvent) {
        // boilerplate codes
        //No DI
        //Tight Coupling

        try {
            if (customerBo.deleteCustomer(dtxtfldcustomerid.getText())) { //customerDAO.delete
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
                viewAllCustomerData();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, "Not Deleted.Try Again!").show();
        }


    }


    public void dtxtSearchFldOnAction(KeyEvent keyEvent) {
        clearFields();

        ObservableList<CustomerDTO> obl = FXCollections.observableArrayList();

        try {
            rarray = customerBo.searchCustomer(dtxtfldsearch.getText());//customerDAO.search
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        obl.setAll(rarray);
        dcustomertbl.setItems(obl);

    }

    public void mtxtSearchCustOnAction(KeyEvent keyEvent) {


        mtblCustomer.getItems().clear();
        ObservableList<CustomerDTO> obl = FXCollections.observableArrayList();

        try {
            rarray = customerBo.searchCustomer(mtxtfldsearchcustomer.getText());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        obl.setAll(rarray);
        mtblCustomer.setItems(obl);

        clearFields();
    }

    public void htxtSearchIDOnAction(KeyEvent keyEvent) {

        ObservableList<CustomerDTO> obl = FXCollections.observableArrayList();
       viewAllCustomerData();

        try {
            rarray = customerBo.searchCustomer(htxtSearch.getText());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();


        }
        obl.setAll(rarray);
        htblCustomer.setItems(obl);
    }


    public void dtblCustomerOnAction(MouseEvent mouseEvent) {


        dtxtfldcustomerid.setText(rarray.get(dcustomertbl.getSelectionModel().getSelectedIndex()).getCustomer_id());
        dtxtfldname.setText(rarray.get(dcustomertbl.getSelectionModel().getSelectedIndex()).getCustomer_name());
        dtxtfldnic.setText(rarray.get(dcustomertbl.getSelectionModel().getSelectedIndex()).getCustomer_nic());
        dtxtfldaddress.setText(rarray.get(dcustomertbl.getSelectionModel().getSelectedIndex()).getCustomer_address());
        dtxtfldmobile.setText(rarray.get(dcustomertbl.getSelectionModel().getSelectedIndex()).getCustomer_mobile());
    }


    public void mtblCustomerOnAction(MouseEvent mouseEvent) {

        mtxtldcustomerid.setText(rarray.get(mtblCustomer.getSelectionModel().getSelectedIndex()).getCustomer_id());
        mtxtldname.setText(rarray.get(mtblCustomer.getSelectionModel().getSelectedIndex()).getCustomer_name());
        mtxtldnic.setText(rarray.get(mtblCustomer.getSelectionModel().getSelectedIndex()).getCustomer_nic());
        mtxtldaddress.setText(rarray.get(mtblCustomer.getSelectionModel().getSelectedIndex()).getCustomer_address());
        mtxtldmobilenumber.setText(rarray.get(mtblCustomer.getSelectionModel().getSelectedIndex()).getCustomer_mobile());
    }



    private void clearFields() {
        mtxtldcustomerid.clear();
        mtxtldname.clear();
        mtxtldnic.clear();
        mtxtldaddress.clear();
        mtxtldmobilenumber.clear();
        dtxtfldcustomerid.clear();
        dtxtfldname.clear();
        dtxtfldnic.clear();
        dtxtfldaddress.clear();
        dtxtfldmobile.clear();
    }

    private void viewAllCustomerData() {
        ArrayList<CustomerDTO> carray = new ArrayList();

        ObservableList<CustomerDTO> obl = FXCollections.observableArrayList();
        try {
            carray = customerBo.showAllCustomerData();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        viewAllCustomerData();
        }
        obl.setAll(carray);
        atblCustomer.setItems(obl);
        htblCustomer.setItems(obl);
        dcustomertbl.setItems(obl);
        mtblCustomer.setItems(obl);

    }
}









