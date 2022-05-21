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
@DiscriminatorValue("006")
public class Sunglasses extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long glassID;

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
