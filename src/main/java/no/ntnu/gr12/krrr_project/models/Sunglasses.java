package no.ntnu.gr12.krrr_project.models;

/**
 * Class that contains sunglasses where new sunglasses can be added
 * Extends the Item class
 *
 * @author Tor Oveland Gikling
 * @version 0.0.1
 */
public class Sunglasses extends Item {

    /**Link to image of product*/
    private String imgLink;

    public Sunglasses() {
        super();
    }

    public Sunglasses(String sunglassesID, String modelNumber, float price) {
        super(sunglassesID, modelNumber, price);
    }
}
