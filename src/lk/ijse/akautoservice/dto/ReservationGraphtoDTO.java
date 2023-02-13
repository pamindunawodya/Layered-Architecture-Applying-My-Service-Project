package lk.ijse.akautoservice.dto;

public class ReservationGraphtoDTO {
    private String CheckbookedOrnot;
    private String Month_Limit;
    private String Month_Day;
    private String ReserveCounts;

    public ReservationGraphtoDTO(String checkbookedOrnot, String month_Limit, String month_Day, String reserveCounts) {
        CheckbookedOrnot = checkbookedOrnot;
        Month_Limit = month_Limit;
        Month_Day = month_Day;
        ReserveCounts = reserveCounts;
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
}
