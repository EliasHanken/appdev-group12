package no.ntnu.gr12.krrr_project.models;

import javax.persistence.*;

/**
 * Class for the Helmet that contains it`s price modelNumber and ID
 *
 * @author Tor Oveland Gikling
 * @version 0.0.1
 */
@Entity
@DiscriminatorValue("002")
public class Helmet extends Item {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long helmetID;

    public Helmet() {
        super();
    }

    public Helmet(Long id, String modelNumber, float price) {
        super(modelNumber, price);
        this.helmetID = id;
    }

    public Helmet(String modelNumber, float price, String imgLink) {
        super(modelNumber, price, imgLink);
    }

    public Long getHelmetID() {
        return helmetID;
    }

    public void setHelmetID(Long itemID) {
        this.helmetID = itemID;
    }
}
