package lk.ijse.akautoservice.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.akautoservice.bo.BOFactory;
import lk.ijse.akautoservice.bo.custom.ItemBO;
import lk.ijse.akautoservice.bo.custom.impl.ItemBOImpl;
import lk.ijse.akautoservice.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemFormController {
    public AnchorPane addItemContext;
    public TextField atxtItemName;
    public TextField atxtItemDetails;
    public TextField atxtbrand;
    public TextField atxtSearchItem;
    public TextField atxtItemCode;
    public TextField atxtItemStock;
    public TableView atblItem;
    public TableColumn acolItemCode;
    public TableColumn acolItemName;
    public TableColumn acolDetails;
    public TableColumn acolBrand;
    public TableColumn acolStock;
    public TableColumn acolUnitPrice;
    public TextField atxtItemUnitPrice;
    public AnchorPane modifyItemContext;
    public TextField mtxtItemName;
    public TextField mtxtDetails;
    public TextField mtxtBrand;
    public TextField mtxtSearchItemOnAction;
    public TextField mtxtItemCode;
    public TextField mtxtStock;
    public TableView mtblItem;
    public TableColumn mColItemName;
    public TableColumn mColDetails;
    public TableColumn mColBrand;
    public TableColumn mcolStock;
    public TableColumn mcolUnityPrice;
    public TextField mtxtUnitPrice;
    public AnchorPane deleteItemContext;
    public TextField dtxtItemName;
    public TextField dtxtDetails;
    public TextField dtxtBrand;
    public TextField dtxtSearchItems;
    public TextField dtxtItemCode;
    public TextField dtxtStocks;
    public TableView dtblItem;
    public TableColumn dColItemCode;
    public TableColumn dColItemName;
    public TableColumn dColdetails;
    public TableColumn dColBrand;
    public TableColumn dColStock;
    public TableColumn dColUnitPrice;
    public TextField dtxtUnitPrice;
    public TableColumn mcolItemCode;
    ArrayList<ItemDTO> rarry;
    ItemBO itemBO= (ItemBO) BOFactory.getboFactory().getBO(BOFactory.BOTypes.ITEM);



    public void initialize() throws SQLException, ClassNotFoundException {


        clearallContexts();
        viewAllItemData();

        acolItemCode.setCellValueFactory(new PropertyValueFactory<>("item_code"));
        acolItemName.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        acolDetails.setCellValueFactory(new PropertyValueFactory<>("description"));
        acolBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        acolStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        acolUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unit_price"));

        mcolItemCode.setCellValueFactory(new PropertyValueFactory<>("item_code"));
        mColItemName.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        mColDetails.setCellValueFactory(new PropertyValueFactory<>("description"));
        mColBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        mcolStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        mcolUnityPrice.setCellValueFactory(new PropertyValueFactory<>("unit_price"));

        dColItemCode.setCellValueFactory(new PropertyValueFactory<>("item_code"));
        dColItemName.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        dColdetails.setCellValueFactory(new PropertyValueFactory<>("description"));
        dColBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        dColStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        dColUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unit_price"));


    }

    public void btnOpenAddItemFormOnAction(ActionEvent actionEvent) {
        clearallContexts();
        addItemContext.setVisible(true);
    }

    public void btnOpenModifyFormOnAction(ActionEvent actionEvent) {
        clearallContexts();
        modifyItemContext.setVisible(true);
    }

    public void btnOpenDeleteItemFormOnAction(ActionEvent actionEvent) {
        clearallContexts();
        deleteItemContext.setVisible(true);
    }


    private void clearallContexts() {
        modifyItemContext.setVisible(false);
        addItemContext.setVisible(false);
        deleteItemContext.setVisible(false);
    }

    public void abtnAddItemOnAction(ActionEvent actionEvent) {
        ItemDTO item = new ItemDTO(atxtItemCode.getText(), atxtItemName.getText(), atxtItemDetails.getText(), atxtbrand.getText(), atxtItemStock.getText(), Double.parseDouble(atxtItemUnitPrice.getText()));

       // ItemDTO item = new ItemDTO(item_code, item_name, description, brand, stock, unit_price);
        try {
            boolean isAdded =itemBO.saveItem(item);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "ItemDTO Added!").show();
                viewAllItemData();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "ItemDTO Data Not Added!" + e).show();
        }
    }

    public void atxtSearchItemOnAction(KeyEvent keyEvent) {

        ArrayList<ItemDTO> iarry = new ArrayList<>();
        ObservableList<ItemDTO> obl = FXCollections.observableArrayList();

        try {
            iarry =itemBO.searchItem(atxtSearchItem.getText());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        obl.setAll(iarry);

        atblItem.setItems(obl);

    }

    public void mtxtSearchItemOnAction(KeyEvent keyEvent) {
        ArrayList<ItemDTO> iarry = new ArrayList<>();
        ObservableList<ItemDTO> obl = FXCollections.observableArrayList();

        try {
            iarry = itemBO.searchItem(mtxtItemCode.getText());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        obl.setAll(iarry);
        mtblItem.setItems(obl);

    }

    public void mbtnmodifyItmOnAction(ActionEvent actionEvent) {

        ItemDTO item = new ItemDTO(mtxtItemCode.getText(), mtxtItemName.getText(), mtxtDetails.getText(), mtxtBrand.getText(), mtxtStock.getText(), Double.parseDouble(mtxtUnitPrice.getText()));
        try {
            itemBO.updateItem(item);
            new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            viewAllItemData();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Data not Updated!" + e).show();

        }
    }

    public void dtxtSearchItemOnAction(KeyEvent keyEvent) {

        ObservableList<ItemDTO> obl = FXCollections.observableArrayList();

        try {
            rarry = itemBO.searchItem(dtxtSearchItems.getText());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        obl.setAll(rarry);
        dtblItem.setItems(obl);
    }

    public void dtxtDeleteItemOnAction(ActionEvent actionEvent) {
        try {
            if (itemBO.deleteItem(dtxtItemCode.getText())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
            viewAllItemData();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, "Not Deleted.Try Again!").show();
        }
    }

    public void aatblItemOnAction(MouseEvent mouseEvent) {
        atxtItemCode.setText(rarry.get(atblItem.getSelectionModel().getSelectedIndex()).getItem_code());
        atxtItemName.setText(rarry.get(atblItem.getSelectionModel().getSelectedIndex()).getItem_name());
        atxtItemDetails.setText(rarry.get(atblItem.getSelectionModel().getSelectedIndex()).getDescription());
        atxtbrand.setText(rarry.get(atblItem.getSelectionModel().getSelectedIndex()).getBrand());
        atxtItemStock.setText(rarry.get(atblItem.getSelectionModel().getSelectedIndex()).getStock());
        atxtItemUnitPrice.setText(String.valueOf(rarry.get(atblItem.getSelectionModel().getSelectedIndex()).getUnit_price()));

    }

    public void mtblItemOnAction (MouseEvent mouseEvent) {
        mtxtItemCode.setText(rarry.get(mtblItem.getSelectionModel().getSelectedIndex()).getItem_code());
        mtxtItemName.setText(rarry.get(mtblItem.getSelectionModel().getSelectedIndex()).getItem_name());
        mtxtDetails.setText(rarry.get(mtblItem.getSelectionModel().getSelectedIndex()).getDescription());
        mtxtBrand.setText(rarry.get(mtblItem.getSelectionModel().getSelectedIndex()).getBrand());
        mtxtStock.setText(rarry.get(mtblItem.getSelectionModel().getSelectedIndex()).getStock());
        mtxtUnitPrice.setText(String.valueOf(rarry.get(mtblItem.getSelectionModel().getSelectedIndex()).getUnit_price()));

    }

    public void dtblItemOnAction(MouseEvent mouseEvent) {

        dtxtItemCode.setText(rarry.get(dtblItem.getSelectionModel().getSelectedIndex()).getItem_code());
        dtxtItemName.setText(rarry.get(dtblItem.getSelectionModel().getSelectedIndex()).getItem_name());
        dtxtDetails.setText(rarry.get(dtblItem.getSelectionModel().getSelectedIndex()).getDescription());
        dtxtBrand.setText(rarry.get(dtblItem.getSelectionModel().getSelectedIndex()).getBrand());
        dtxtStocks.setText(rarry.get(dtblItem.getSelectionModel().getSelectedIndex()).getStock());
        dtxtUnitPrice.setText(String.valueOf(rarry.get(dtblItem.getSelectionModel().getSelectedIndex()).getUnit_price()));

    }

    private void viewAllItemData() throws SQLException, ClassNotFoundException {

        ObservableList<ItemDTO> obsl = FXCollections.observableArrayList();
        try {
            rarry = itemBO.showAllItemData();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        obsl.setAll(rarry);
        atblItem.setItems(obsl);
        mtblItem.setItems(obsl);
        dtblItem.setItems(obsl);


    }
    }

