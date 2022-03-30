package no.ntnu.gr12.krrr_project.DBClasses.Rental;

import no.ntnu.gr12.krrr_project.DBClasses.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Loan {
    @Id
    private String id;

    @ManyToOne
    private User user;
    @ManyToOne
    private Bike bike;

    private String borrow_date;
    private String due_date;

    public Loan(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return user.getUserID();
    }

    public void setUserId(String userId) {
        this.user.setUserID(userId);
    }

    public String getBikeId() {
        return bike.getBikeId();
    }

    public void setBikeId(String bikeId) {
        this.bike.setBikeId(bikeId);
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }
}
