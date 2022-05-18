package no.ntnu.gr12.krrr_project.models;
/**
 * Class for the Helmet that contains it`s price modelNumber and ID
 *
 * @author Tor Oveland Gikling
 * @version 0.0.1
 */
public class Helmet extends Item {
    public Helmet() {
        super();
    }

    public Helmet(String helmetID, String modelNumber, float price) {
        super(helmetID, modelNumber, price);
    }
}
