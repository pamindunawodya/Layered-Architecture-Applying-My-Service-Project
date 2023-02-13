package lk.ijse.akautoservice.controller;

import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.akautoservice.util.Navigation;
import lk.ijse.akautoservice.util.Routes;

import java.io.IOException;

public class OwnerFormController {
    public AnchorPane midanchorpane;
    public AnchorPane loadingcontext;
    public ProgressBar pbart;
    public AnchorPane mainSideBarContext;
    public AnchorPane animationBarContext;

    public void openCustomerFormOnAction(MouseEvent mouseEvent) {
        loadingcontext.setVisible(true);
        Task tskload1 = new Task() {

            @Override
            protected Object call() throws Exception {
                int i = 0;
                for (int k = 0; k < 10; k++) {
                    Thread.sleep(100);
                    i++;
                    updateProgress(i, 2);
                }
                return null;
            }
        };
        //navigate to customer form
        pbart.progressProperty().bind(tskload1.progressProperty());
        tskload1.setOnSucceeded(event ->
        {
            midanchorpane.setVisible(true);
            try {
                Navigation.navigate(Routes.OWNERCUSTOMER, midanchorpane);
            } catch (IOException e) {
                e.printStackTrace();
            }
            loadingcontext.setVisible(false);
        });
        new Thread(tskload1).start();

    }

    public void mouseOnExitmaincontext(MouseEvent mouseEvent) {
        mainSideBarContext.setVisible(true);
        animationBarContext.setVisible(false);

    }

    public void openVehicleFormOnAction(MouseEvent mouseEvent) {
        loadingcontext.setVisible(true);
        Task tskload2 = new Task() {

            @Override
            protected Object call() throws Exception {
                int i = 0;
                for (int k = 0; k < 10; k++) {
                    Thread.sleep(100);
                    i++;
                    updateProgress(i, 2);
                }
                return null;
            }
        };
        //navigate to customer form
        pbart.progressProperty().bind(tskload2.progressProperty());
        tskload2.setOnSucceeded(event ->
        {
            midanchorpane.setVisible(true);
            try {
                Navigation.navigate(Routes.OWNERVEHICLE, midanchorpane);
            } catch (IOException e) {
                e.printStackTrace();
            }
            loadingcontext.setVisible(false);
        });
        new Thread(tskload2).start();

    }

    public void openReservationFormOnAction(MouseEvent mouseEvent) {
        loadingcontext.setVisible(true);
        Task tskload3 = new Task() {
            @Override
            protected Object call() throws Exception {
                int i = 0;
                for (int k = 0; k < 10; k++) {
                    Thread.sleep(100);
                    i++;
                    updateProgress(i, 8);
                }
                return null;

            }
        };
        pbart.progressProperty().bind(tskload3.progressProperty());
        tskload3.setOnSucceeded(event ->
        {
            midanchorpane.setVisible(true);
            try {
                Navigation.navigate(Routes.RESERVATION_FORM, midanchorpane); //Navigate
            } catch (IOException e) {
                e.printStackTrace();
            }
            loadingcontext.setVisible(false);
        });
        new Thread(tskload3).start();
    }

    public void mouseOnEnterMainContext(MouseEvent mouseEvent) {
        mainSideBarContext.setVisible(false);
        animationBarContext.setVisible(true);
    }
}
