package no.ntnu.gr12.krrr_project.DBClasses;

import jdk.jshell.execution.Util;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="users")
public class User {
    @Id
    private String userID;

    private String description;

    public User() {

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "user{" + "" +
                "id=" + userID +
                ", description='" + description + "\'" +
                "}";
    }
}
