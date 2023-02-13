package lk.ijse.akautoservice.controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.akautoservice.util.Navigation;
import lk.ijse.akautoservice.util.Routes;

import java.io.IOException;

public class SellerFormController {

    public AnchorPane midanchorpane;
    public AnchorPane mainSideBarContext;
    public AnchorPane loadingcontext;
    public AnchorPane animationBarContext;

    public void initialize() {


    }


    public void openItemFormOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.ITEM, midanchorpane);
    }

    public void btnhomeOnAction(MouseEvent mouseEvent) {
    }

    public void mouseOnEntermaincontext(MouseEvent mouseEvent) {
        mainSideBarContext.setVisible(false);
        animationBarContext.setVisible(true);

    }


    public void openPickItemFormOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.PICKITEM, midanchorpane);
    }

    public void mouseOnExitmaincontext(MouseEvent mouseEvent) {
        mainSideBarContext.setVisible(true);
        animationBarContext.setVisible(false);
    }
}
