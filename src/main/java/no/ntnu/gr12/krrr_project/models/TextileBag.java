package no.ntnu.gr12.krrr_project.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Class containing the textileBag
 */
@Entity
@PrimaryKeyJoinColumn(name = "bagID")
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
