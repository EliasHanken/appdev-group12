package no.ntnu.gr12.krrr_project.models;

/**
 * Class containing the textileBag
 */
public class TextileBag extends Item{

    /**Link to image of product*/
    private String imgLink;

    public TextileBag() {
        super();
    }

    public TextileBag(String textileBagID, String modelNumber, float price) {
        super(textileBagID, modelNumber, price);
    }

}
