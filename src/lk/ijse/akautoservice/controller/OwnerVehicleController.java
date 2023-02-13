package lk.ijse.akautoservice.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.akautoservice.bo.BOFactory;
import lk.ijse.akautoservice.bo.custom.OwnerCustomerBO;
import lk.ijse.akautoservice.bo.custom.OwnerVehicleBO;
import lk.ijse.akautoservice.bo.custom.impl.OwnerVehicleBoImpl;
import lk.ijse.akautoservice.dto.VehicleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OwnerVehicleController {

    public AnchorPane homeVehicleContext;
    public TextField htxtSearch;
    public TableColumn hcolCustomerId;
    public TableView htblVehicle;
    public TableColumn hColVehicleNo;
    public TableColumn hColVehicleBrand;
    public TableColumn hcolVehicleCategory;
    ArrayList<VehicleDTO> rarray = null;
    OwnerVehicleBO ownerVehicleBo= (OwnerVehicleBO) BOFactory.getboFactory().getBO(BOFactory.BOTypes.OWNERVEHICLE);

    public void initialize() throws SQLException, ClassNotFoundException {
        viewAllVehicleData();


        hcolCustomerId.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        hColVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicle_number"));
        hcolVehicleCategory.setCellValueFactory(new PropertyValueFactory<>("vehicle_category"));
        hColVehicleBrand.setCellValueFactory(new PropertyValueFactory<>("vehicle_brand"));
    }

    public void htxtSearchVehicleNumber(KeyEvent keyEvent) {
        htblVehicle.getItems().clear();
        ObservableList<VehicleDTO> obl = FXCollections.observableArrayList();

        try {
            rarray = ownerVehicleBo.searchVehicle(htxtSearch.getText());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        obl.setAll(rarray);
        htblVehicle.setItems(obl);
    }


    public void mtblVehicleOnAction(MouseEvent mouseEvent) {
    }

    private void viewAllVehicleData() {
        ArrayList<VehicleDTO> carray = new ArrayList();

        ObservableList<VehicleDTO> obl = FXCollections.observableArrayList();
        try {
            carray = ownerVehicleBo.showAllVehicleData();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        obl.setAll(carray);
        htblVehicle.setItems(obl);

    }
}
