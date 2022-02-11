package no.ntnu.gr12.krrr_project.DBClasses;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Bike {
    @Id
    private String bikeID;
    private String modelNumber;
    private boolean rentedFlag;
    //TODO: Unsure if this will work, may need to use another format for timestamps.
    private Date loanStartTime;
    private Date loanEndTime;
    private String userKey;

    public Bike() {
        this.rentedFlag = false;
        this.loanStartTime = null;
        this.loanEndTime = null;
        this.bikeID = null;
        this.modelNumber = null;
        this.userKey = null;
    }

    public Bike(String bikeID, String modelNumber, boolean rentedFlag) {
        this.bikeID = bikeID;
        this.modelNumber = modelNumber;
        this.rentedFlag = rentedFlag;
        this.loanStartTime = null;
        this.loanEndTime = null;
        this.userKey = null;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public boolean isRentedFlag() {
        return rentedFlag;
    }

    public void setRentedFlag(boolean rentedFlag) {
        this.rentedFlag = rentedFlag;
    }

    public Date getLoanStartTime() {
        return loanStartTime;
    }

    public void Date (Date loanStartTime) {
        this.loanStartTime = loanStartTime;
    }

    public Date getLoanEndTime() {
        return loanEndTime;
    }

    public void setLoanEndTime(Date loanEndTime) {
        this.loanEndTime = loanEndTime;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    @Id
    public String getBikeID() {
        return bikeID;
    }


}
