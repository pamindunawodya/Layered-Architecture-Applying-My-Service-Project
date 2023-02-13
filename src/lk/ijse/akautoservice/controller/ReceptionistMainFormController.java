package lk.ijse.akautoservice.controller;

import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.akautoservice.util.Navigation;
import lk.ijse.akautoservice.util.Routes;

import java.io.IOException;

public class ReceptionistMainFormController {
    public AnchorPane maincontext;
    public AnchorPane navigatecontext;
    public AnchorPane pane;
    public AnchorPane midanchorpane;
    public AnchorPane loadingcontext;
    public ProgressBar pbart;
    public AnchorPane mainContext;
    public AnchorPane navigateContext;
    public AnchorPane animationBarContext;
    public AnchorPane mainSideBarContext;


    public void mouseOnEntermaincontext(MouseEvent mouseEvent) {
        mainSideBarContext.setVisible(false);
        animationBarContext.setVisible(true);
    }

    public void mouseOnExitmaincontext(MouseEvent mouseEvent) {
        mainSideBarContext.setVisible(true);
        animationBarContext.setVisible(false);
    }



    public void openVehicleFormOnAction(MouseEvent mouseEvent) throws IOException {
        loadingcontext.setVisible(true);
        Task tskload0 = new Task() {

            @Override
            protected Object call() throws Exception {
                int i = 0;
                for (int k = 0; k < 10; k++) {
                    Thread.sleep(10);
                    i++;
                    updateProgress(i, 3);
                }
                return null;
            }
        };
        //navigate to vehicle form
        pbart.progressProperty().bind(tskload0.progressProperty());
        tskload0.setOnSucceeded(event ->
        {
            midanchorpane.setVisible(true);
            try {
                Navigation.navigate(Routes.VEHICLE, midanchorpane);
            } catch (IOException e) {
                e.printStackTrace();
            }
            loadingcontext.setVisible(false);
        });
        new Thread(tskload0).start();

        // midanchorpane.getChildren().clear();
        // midanchorpane.getChildren().add(FXMLLoader.load(Routes.class.getResource("../view/VehicleForm.fxml")));

    }

    public void btnhomeOnAction(MouseEvent mouseEvent) throws IOException {


    }

    public void openReservationFormOnAction(MouseEvent mouseEvent) throws IOException {
        loadingcontext.setVisible(true);
        Task tskload2 = new Task() {
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
        pbart.progressProperty().bind(tskload2.progressProperty());
        tskload2.setOnSucceeded(event ->
        {
            midanchorpane.setVisible(true);
            try {
                Navigation.navigate(Routes.RESERVATION_FORM, midanchorpane); //Navigate
            } catch (IOException e) {
                e.printStackTrace();
            }
            loadingcontext.setVisible(false);
        });
        new Thread(tskload2).start();
    }

    public void openCustomerFormOnAction(MouseEvent mouseEvent) throws IOException {

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
                Navigation.navigate(Routes.CUSTOMER, midanchorpane);
            } catch (IOException e) {
                e.printStackTrace();
            }
            loadingcontext.setVisible(false);
        });
        new Thread(tskload1).start();

    }

    public void openRepHomeFormOnAction(MouseEvent mouseEvent) throws IOException {

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
                Navigation.navigate(Routes.RECEPTIONIST_HOME, midanchorpane);   //Navigate
            } catch (IOException e) {
                e.printStackTrace();
            }
            loadingcontext.setVisible(false);
        });
        new Thread(tskload3).start();
    }
}

