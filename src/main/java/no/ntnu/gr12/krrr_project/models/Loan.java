package no.ntnu.gr12.krrr_project.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Loan {
    @Id
    private Long id;

    @ManyToOne
    private User user;
    @ManyToOne
    private Bike bike;

    private String borrow_date;
    private String due_date;

    public Loan(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return user.getId();
    }

    public void setUserId(Long id) {
        this.user.setId(id);
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
