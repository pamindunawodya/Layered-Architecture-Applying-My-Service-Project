package lk.ijse.akautoservice.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.akautoservice.bo.BOFactory;
import lk.ijse.akautoservice.bo.custom.VehicleBO;
import lk.ijse.akautoservice.bo.custom.impl.VehicleBOImpl;
import lk.ijse.akautoservice.dto.VehicleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleFormController {

    public JFXButton btnAdd;
    public JFXButton btnModify;
    public JFXButton btnDelete;
    public AnchorPane homeVehicleContext;
    public ImageView btnSearch1;
    public AnchorPane addVehicleFormContext;
    public TextField atxtVehicleNo;
    public AnchorPane deleteVehicleFormContext;
    public TextField dtxtSearch;
    public TextField dtxtVehicleNo;
    public TextField dtxtVehicleBrand;
    public AnchorPane modifyVehicleFormContext1;
    public TextField mtxtVehicleNo;
    public TextField mtxtVehicleBrand;
    public TextField mtxtVehicleCategory;
    public TextField atxtVehicleCategory;
    public TextField atxtVehicleBrand;
    public ComboBox acmbCustomerID;
    public TextField atxtFldCustomerId;
    public TableView atblVehicle;
    public TableColumn acolCustomerId;
    public TableColumn aColVehicleNo;
    public TableColumn aColVehicleBrand;
    public TableColumn acolVehicleCategory;
    public TableView mtblVehicle;
    public TableColumn mcolCustomerId;
    public TableColumn mColVehicleNo;
    public TableColumn mColVehicleBrand;
    public TableColumn mcolVehicleCategory;
    public TextField dtxtVehicleCategory;
    public TableView dtblVehicle;
    public TableColumn dcolCustomerId;
    public TableColumn dColVehicleNo;
    public TableColumn dColVehicleBrand;
    public TableColumn dcolVehicleCategory;
    public TextField mtxtCustomerID;
    public ComboBox mcmbCustomerID;
    public TextField mtxtSearch;
    public ComboBox dcmbCustomerID;
    public TextField dtxtCustomerID;
    public TableView htblVehicle;
    public TableColumn hcolCustomerId;
    public TableColumn hColVehicleNo;
    public TableColumn hColVehicleBrand;
    public TableColumn hcolVehicleCategory;
    public TextField htxtSearch;
    ArrayList<VehicleDTO> rarray = null;

    VehicleBO vehicleBO= (VehicleBO) BOFactory.getboFactory().getBO(BOFactory.BOTypes.VEHICLE);


    public void initialize() throws SQLException, ClassNotFoundException {

        clearallcontexts();
        homeVehicleContext.setVisible(true);
        viewAllVehicleData();

        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.addAll(vehicleBO.existsCustomerIds());
        dcmbCustomerID.setItems(obList);

        dcolCustomerId.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        dColVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicle_number"));
        dcolVehicleCategory.setCellValueFactory(new PropertyValueFactory<>("vehicle_category"));
        dColVehicleBrand.setCellValueFactory(new PropertyValueFactory<>("vehicle_brand"));


        obList.addAll(vehicleBO.existsCustomerIds());
        mcmbCustomerID.setItems(obList);

        mcolCustomerId.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        mColVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicle_number"));
        mcolVehicleCategory.setCellValueFactory(new PropertyValueFactory<>("vehicle_category"));
        mColVehicleBrand.setCellValueFactory(new PropertyValueFactory<>("vehicle_brand"));

        obList.addAll(vehicleBO.existsCustomerIds());
        acmbCustomerID.setItems(obList);

        acolCustomerId.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        aColVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicle_number"));
        acolVehicleCategory.setCellValueFactory(new PropertyValueFactory<>("vehicle_category"));
        aColVehicleBrand.setCellValueFactory(new PropertyValueFactory<>("vehicle_brand"));

        hcolCustomerId.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        hColVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicle_number"));
        hcolVehicleCategory.setCellValueFactory(new PropertyValueFactory<>("vehicle_category"));
        hColVehicleBrand.setCellValueFactory(new PropertyValueFactory<>("vehicle_brand"));

    }

    private void clearallcontexts() {
        homeVehicleContext.setVisible(false);
        addVehicleFormContext.setVisible(false);
        modifyVehicleFormContext1.setVisible(false);
        deleteVehicleFormContext.setVisible(false);
    }

    public void modifyBtnOnAction(ActionEvent actionEvent) {
        VehicleDTO vehicle = new VehicleDTO(mtxtVehicleNo.getText(), mtxtVehicleBrand.getText(), mtxtVehicleCategory.getText(), mtxtCustomerID.getText());
        try {
            vehicleBO.updateVehicle(vehicle);
            new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            viewAllVehicleData();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Data not Updated!" + e).show();

        }
    }


    public void btnAddVehicleOnAction(ActionEvent actionEvent) {
        clearallcontexts();
        addVehicleFormContext.setVisible(true);
    }

    public void btnDeleteVehicleOnAction(ActionEvent actionEvent) {
        clearallcontexts();
        deleteVehicleFormContext.setVisible(true);
    }

    public void btnModifyVehicleOnAction(ActionEvent actionEvent) {
        clearallcontexts();
        modifyVehicleFormContext1.setVisible(true);
    }

    public void cmbCustomerfIdOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        atxtFldCustomerId.setText((String) acmbCustomerID.getSelectionModel().selectedItemProperty().getValue());
        ObservableList<VehicleDTO> obl = FXCollections.observableArrayList();
        obl.setAll(
              vehicleBO.showVehicleFromCustomerID(atxtFldCustomerId.getText())//showVehicleFromCustomerID
        );
        atblVehicle.setItems(obl);

    }



    public void btnAddOnAction(ActionEvent actionEvent) {

        VehicleDTO vehicle=new VehicleDTO(atxtVehicleNo.getText(), atxtVehicleCategory.getText(), atxtVehicleBrand.getText(), atxtFldCustomerId.getText());

       // VehicleDTO vehicle = new VehicleDTO(vehicle_number, vehicle_category, vehicle_brand, customer_id);
        try {
            boolean isAdded = vehicleBO.saveVehicle(vehicle);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "VehicleDTO Added!").show();
            }
            viewAllVehicleData();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            if (vehicleBO.deleteVehicle(dtxtVehicleNo.getText())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();

            }
            viewAllVehicleData();
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, "Not Deleted.Try Again!").show();
        }

    }

    public void mcmbCustomerIDOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        mtxtCustomerID.setText((String) mcmbCustomerID.getSelectionModel().selectedItemProperty().getValue());
        ObservableList<VehicleDTO> obl = FXCollections.observableArrayList();
        obl.setAll(
                vehicleBO.showVehicleFromCustomerID(mtxtCustomerID.getText())//showVehicleFromCustomerID
        );
        mtblVehicle.setItems(obl);

    }

    public void msearchvehicleIDOnAction(KeyEvent keyEvent) {
        mtblVehicle.getItems().clear();
        ObservableList<VehicleDTO> obl = FXCollections.observableArrayList();

        try {
            rarray = vehicleBO.searchVehicle(mtxtSearch.getText());//showVehicleFromCustomerID
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        obl.setAll(rarray);
        mtblVehicle.setItems(obl);
    }

    public void mtblVehicleOnAction(MouseEvent mouseEvent) {

        mtxtCustomerID.setText(rarray.get(mtblVehicle.getSelectionModel().getSelectedIndex()).getCustomer_id());
        mtxtVehicleNo.setText(rarray.get(mtblVehicle.getSelectionModel().getSelectedIndex()).getVehicle_number());
        mtxtVehicleCategory.setText(rarray.get(mtblVehicle.getSelectionModel().getSelectedIndex()).getVehicle_category());
        mtxtVehicleBrand.setText(rarray.get(mtblVehicle.getSelectionModel().getSelectedIndex()).getVehicle_brand());

    }

    public void dtxtSearchFldOnAction(KeyEvent keyEvent) {
        dtblVehicle.getItems().clear();
        ObservableList<VehicleDTO> obl = FXCollections.observableArrayList();

        try {
            rarray = vehicleBO.searchVehicle(dtxtSearch.getText());//showVehicleFromCustomerID
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        obl.setAll(rarray);
        dtblVehicle.setItems(obl);
    }

    public void dtblVehicleOnAction(MouseEvent mouseEvent) {

        dtxtCustomerID.setText(rarray.get(dtblVehicle.getSelectionModel().getSelectedIndex()).getVehicle_number());
        dtxtVehicleNo.setText(rarray.get(dtblVehicle.getSelectionModel().getSelectedIndex()).getVehicle_number());
        dtxtVehicleCategory.setText(rarray.get(dtblVehicle.getSelectionModel().getSelectedIndex()).getVehicle_category());
        dtxtVehicleBrand.setText(rarray.get(dtblVehicle.getSelectionModel().getSelectedIndex()).getVehicle_brand());

    }

    public void cmbVehicleIDOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        dtxtCustomerID.setText((String) dcmbCustomerID.getSelectionModel().selectedItemProperty().getValue());
        ObservableList<VehicleDTO> obl = FXCollections.observableArrayList();
        obl.setAll(
                vehicleBO.showVehicleFromCustomerID(dtxtCustomerID.getText()));
        dtblVehicle.setItems(obl);

    }

    public void htxtSearchVehicleNumber(KeyEvent keyEvent) {
        htblVehicle.getItems().clear();
        ObservableList<VehicleDTO> obl = FXCollections.observableArrayList();

        try {
            rarray = vehicleBO.searchVehicle(htxtSearch.getText()); //showVehicleFromCustomerID
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        obl.setAll(rarray);
        htblVehicle.setItems(obl);
    }

    private void viewAllVehicleData() {

        ArrayList<VehicleDTO> carray = new ArrayList();

        ObservableList <VehicleDTO> obl = FXCollections.observableArrayList();
        try {
            carray = vehicleBO.showAllVehicleData();

        } catch (SQLException | ClassNotFoundException e) {
            viewAllVehicleData();
        }
        obl.setAll(carray);
        htblVehicle.setItems(obl);
        atblVehicle.setItems(obl);
        dtblVehicle.setItems(obl);
        mtblVehicle.setItems(obl);

    }

    public void dbtnVehicleOnAction(ActionEvent actionEvent) {
    }

    public void mtxtCustomerIdOnAction(ActionEvent actionEvent) {
    }

    public void atxtFldCustomerIdOnAction(ActionEvent actionEvent) {
    }
}


