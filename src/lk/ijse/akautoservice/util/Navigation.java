package lk.ijse.akautoservice.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Navigation {
    private static AnchorPane maincontext;

    public static void navigate(Routes routes, AnchorPane maincontext) throws IOException {
        Navigation.maincontext = maincontext;
        Navigation.maincontext.getChildren().clear();
        switch (routes) {
            case CUSTOMER:
                setUi("../view/CustomerForm.fxml");
                break;
        }
        switch (routes) {
            case VEHICLE:
                setUi("../view/VehicleForm.fxml");
                break;
        }
        switch (routes) {
            case RECEPTIONIST_HOME:
                setUi("../view/ReceptionistHomeForm.fxml");
                break;
        }
        switch (routes) {
            case RESERVATION_FORM:
                setUi("../view/ReservationForm.fxml");
                break;
        }
        switch (routes) {
            case OWNER:
                setUi("../view/OwnerForm.fxml");
                break;
        }
        switch (routes) {
            case SELLER:
                setUi("../view/SellerForm.fxml");
                break;
        }
        switch (routes) {
            case ITEM:
                setUi("../view/ItemForm.fxml");
                break;
        }
        switch (routes) {
            case PICKITEM:
                setUi("../view/PickItem.fxml");
                break;
        }
        switch (routes) {
            case OWNERCUSTOMER:
                setUi("../view/OwnerCustomerForm.fxml");
                break;
        }
        switch (routes) {
            case OWNERVEHICLE:
                setUi("../view/OwnerVehicle.fxml");
                break;
        }
    }

    private static void setUi(String location) throws IOException {
        Navigation.maincontext.getChildren().add(FXMLLoader.load(Routes.class.getResource("" + location)));

    }
}