package lk.ijse.akautoservice.controller;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import lk.ijse.akautoservice.bo.custom.ReceptionistBO;
import lk.ijse.akautoservice.bo.custom.impl.ReceptionistBOImpl;
import lk.ijse.akautoservice.dto.ReservationGraphtoDTO;
import lk.ijse.akautoservice.view.tm.ReservationGraphtm;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReceptionistHomeFormController {

    public AnchorPane smwlsbrcmaincontext;
    public HBox hbox1pbar;
    public HBox hbox2pbar;
    public HBox hbox3pbar;
    public HBox hbox4pbar;
    public HBox hbox1lbl;
    public HBox hbox2lbl;
    public HBox hbox3lbl;
    public HBox hbox4lbl;
    private ArrayList<ProgressBar> pbararray;
    private ArrayList<Label> lblarray;
    private ArrayList<String> lblidarray;
    int count=0;
    private ReceptionistBO receptionistBO=new ReceptionistBOImpl();




    public void initialize() throws SQLException, ClassNotFoundException, InterruptedException {
        pbararray = new ArrayList<>();
        lblarray = new ArrayList<>();
        lblidarray = new ArrayList<>();
        smwlsbrcLoadData();

    }

    private void smwlsbrcLoadData() throws SQLException, ClassNotFoundException {
        hbox1lbl.getChildren().clear();
        hbox1pbar.getChildren().clear();
        hbox2lbl.getChildren().clear();
        hbox2pbar.getChildren().clear();
        hbox3lbl.getChildren().clear();
        hbox3pbar.getChildren().clear();
        hbox4lbl.getChildren().clear();
        hbox4pbar.getChildren().clear();
        pbararray.clear();
        lblarray.clear();
        lblidarray.clear();
        count = 0;
        ArrayList<ReservationGraphtoDTO> warray = receptionistBO.GetMonthDatesForReservedTotalAll();
        //System.out.println(warray.size());
        for (ReservationGraphtoDTO w : warray) {
            Label lbl = new Label();
            ProgressBar pbar = new ProgressBar();
            ReservationGraphtm wt = new ReservationGraphtm(
                    w.getCheckbookedOrnot(),
                    w.getMonth_Limit(),
                    w.getMonth_Day(),
                    w.getReserveCounts(),
                    pbar,
                    lbl
            );
            setPbarToArray(wt);
        }
    }

    private void setPbarToArray(ReservationGraphtm r) {

        lblarray.add(new Label(" Day:" + r.getMonth_Day() + " \n Reserved:" + (r.getCheckbookedOrnot() == null ? "0" : r.getReserveCounts())));
        lblarray.get(count).setStyle("-fx-opacity:1;-fx-font-size:13; -fx-font-weight:bold; -fx-border-color:black;-fx-text-alignment:center;-fx-text-fill:black; -fx-pref-width:80; -fx-pref-height:120;-fx-max-height:126; -fx-max-width:80; -fx-border-width:1;");
        pbararray.add(new ProgressBar(Double.parseDouble(r.getReserveCounts()) / Integer.parseInt(r.getMonth_Limit())));
        pbararray.get(count).setStyle("-fx-accent: green;-fx-font-size:13; -fx-text-fill:white; -fx-border-color:black; -fx-max-height:126; -fx-max-width:80; -fx-border-width:1;");
        addPbarAddToContext();
    }

    private void addPbarAddToContext() {


        if (pbararray.size() < 9) {
            hbox1lbl.getChildren().add(lblarray.get(count));
            hbox1pbar.getChildren().add(pbararray.get(count));
        } else if (pbararray.size() > 8 && pbararray.size() < 17) {
            hbox2lbl.getChildren().add(lblarray.get(count));
            hbox2pbar.getChildren().add(pbararray.get(count));
        } else if (pbararray.size() > 16 && pbararray.size() < 25) {
            hbox3lbl.getChildren().add(lblarray.get(count));
            hbox3pbar.getChildren().add(pbararray.get(count));
        } else if (pbararray.size() > 24 && pbararray.size() < 32) {
            hbox4lbl.getChildren().add(lblarray.get(count));
            hbox4pbar.getChildren().add(pbararray.get(count));
        }
        count++;


    }
}
