package no.ntnu.gr12.krrr_project.models;

import javax.persistence.*;

/**
 * Class for the Helmet that contains it`s price modelNumber and ID
 *
 * @author Tor Oveland Gikling
 * @version 0.0.1
 */
@Entity
public class Helmet extends Item {

    public Helmet() {
        super();
    }

    public Helmet(String modelNumber, float price) {
        super(modelNumber, price);
    }

    public Helmet(String modelNumber, float price, String imgLink) {
        super(modelNumber, price, imgLink);
    }

}
