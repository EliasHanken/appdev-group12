package no.ntnu.gr12.krrr_project.models;

/**
 * Class containing the textileBag
 */
public class TextileBag extends Item{

    public TextileBag() {
        super();
    }

    public TextileBag(String textileBagID, String modelNumber, float price) {
        super(textileBagID, modelNumber, price);
    }

    public TextileBag(String textileBagID, String modelNumber, float price, String imgLink){
        super(textileBagID, modelNumber, price, imgLink);
    }

}
