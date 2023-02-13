package lk.ijse.akautoservice.view.tm;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class ReservationGraphtm {
    private String CheckbookedOrnot;
    private String Month_Limit;
    private String Month_Day;
    private String ReserveCounts;
    private ProgressBar pbar;
    private Label lbl;

    public ReservationGraphtm(String checkbookedOrnot, String month_Limit, String month_Day, String reserveCounts, ProgressBar pbar, Label lbl) {
        CheckbookedOrnot = checkbookedOrnot;
        Month_Limit = month_Limit;
        Month_Day = month_Day;
        ReserveCounts = reserveCounts;
        this.pbar = pbar;
        this.lbl = lbl;
    }

    public String getCheckbookedOrnot() {
        return CheckbookedOrnot;
    }

    public void setCheckbookedOrnot(String checkbookedOrnot) {
        CheckbookedOrnot = checkbookedOrnot;
    }

    public String getMonth_Limit() {
        return Month_Limit;
    }

    public void setMonth_Limit(String month_Limit) {
        Month_Limit = month_Limit;
    }

    public String getMonth_Day() {
        return Month_Day;
    }

    public void setMonth_Day(String month_Day) {
        Month_Day = month_Day;
    }

    public String getReserveCounts() {
        return ReserveCounts;
    }

    public void setReserveCounts(String reserveCounts) {
        ReserveCounts = reserveCounts;
    }

    public ProgressBar getPbar() {
        return pbar;
    }

    public void setPbar(ProgressBar pbar) {
        this.pbar = pbar;
    }

    public Label getLbl() {
        return lbl;
    }

    public void setLbl(Label lbl) {
        this.lbl = lbl;
    }
}
