package no.ntnu.gr12.krrr_project.models;

import javax.persistence.*;

/**
 * Class that contains sunglasses where new sunglasses can be added
 * Extends the Item class
 *
 * @author Tor Oveland Gikling
 * @version 0.0.1
 */
@Entity
public class Sunglasses extends Item {

    public Sunglasses() {
        super();
    }

    public Sunglasses(String modelNumber, float price) {
        super(modelNumber, price);
    }

    public Sunglasses(String modelNumber, float price, String imgLink) {
        super(modelNumber, price, imgLink);
    }
}
