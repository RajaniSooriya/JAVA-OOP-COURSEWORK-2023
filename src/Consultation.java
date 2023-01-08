import java.time.LocalDate;

public class Consultation { //consultation is a class
    // instance variables
    private LocalDate dateTime ; //restricted access -----------ENCAPSULATION OOP CONCEPT BEING USED HERE-------------------
    private double cost;           //restricted access
    private String notes;           //restricted access

    public Consultation(LocalDate dateTime,double cost,String notes){ //parameterized constructor
        this.dateTime = dateTime;
        this.cost = cost;
        this.notes = notes;
    }

    public Consultation() { //non arg constructor

    }

    // get method for local date
    public LocalDate getDateTime() {
        return dateTime;
    }

    //set method for local date
    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    //get method for cost

    public double getCost() {
        return cost;
    }

    //set method for cost
    public void setCost(double cost) {
        this.cost = cost;
    }

    //get method for notes

    public String getNotes() {
        return notes;
    }

    //set method for notes

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
