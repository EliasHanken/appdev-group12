package no.ntnu.gr12.krrr_project.models;
/**
 * Class for the Helmet that contains it`s price modelNumber and ID
 *
 * @author Tor Oveland Gikling
 * @version 0.0.1
 */
public class Helmet extends Item {

    /**Link to image of product*/
    private String imgLink;

    public Helmet() {
        super();
    }

    public Helmet(String helmetID, String modelNumber, float price) {
        super(helmetID, modelNumber, price);
    }

}
