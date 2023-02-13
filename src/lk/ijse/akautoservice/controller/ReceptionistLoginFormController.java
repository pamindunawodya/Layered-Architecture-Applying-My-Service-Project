package lk.ijse.akautoservice.controller;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class ReceptionistLoginFormController {
    private final String[] cmboxsstrings = {"Receptionist", "Owner", "Selleer"};
    public AnchorPane replogincontext;
    public ImageView resceptionistLoadingImg;
    public AnchorPane mainStageLoadContext;
    public ComboBox cmbRole;
    public TextField txtfldpassword;
    public TextField txtfldusername;
    private boolean ismatchedpassword;

  public void initialize() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.addAll(cmboxsstrings);
        cmbRole.setItems(obList);

    }


    public void btnloginOnAction(ActionEvent actionEvent) throws IOException, InterruptedException {
       // mainStageLoadContext.setVisible(true);
        if (cmbRole.getSelectionModel().getSelectedIndex() == 0) {
            //loadpage();
            Stage stageloginwindow = (Stage) replogincontext.getScene().getWindow();


            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReceptionistMainForm.fxml"))));
            primaryStage.show();

        } else if (cmbRole.getSelectionModel().getSelectedIndex() == 1) {
            //loadpage();
            Stage stageloginwindow = (Stage) replogincontext.getScene().getWindow();


            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/OwnerForm.fxml"))));
           // primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();

        } else if (cmbRole.getSelectionModel().getSelectedIndex() == 2) {
           // loadpage();
            Stage stageloginwindow = (Stage) replogincontext.getScene().getWindow();


            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/SellerForm.fxml"))));
            primaryStage.show();


        }


    }

    /*public void loadpage() {
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2), e -> {
            Stage oldstage = (Stage) replogincontext.getScene().getWindow();
            oldstage.close();
            Stage primarystage = new Stage();
            try {
                primarystage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReceptionistMainForm.fxml"))));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primarystage.show();

        }));

        timeline.play();
    }*/

    public void cmbSelectRoleOnAction(ActionEvent actionEvent) throws IOException {

    }
}
