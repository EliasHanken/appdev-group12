package no.ntnu.gr12.krrr_project.models;

import javax.persistence.*;

/**
 * Class containing the textileBag
 */
@Entity
public class TextileBag extends Item{

    public TextileBag() {
        super();
    }

    public TextileBag(String modelNumber, float price) {
        super(modelNumber, price);
    }

    public TextileBag(String modelNumber, float price, String imgLink){
        super(modelNumber, price, imgLink);
    }

}
