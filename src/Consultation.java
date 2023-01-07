import java.time.LocalDate;

public class Consultation {
    // instance variables
    private LocalDate dateTime ;
    private double cost;
    private String notes;

    public Consultation(LocalDate dateTime,double cost,String notes){
        this.dateTime = dateTime;
        this.cost = cost;
        this.notes = notes;
    }

    public Consultation() {

    }

    // getters and setters for instance variables
    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
