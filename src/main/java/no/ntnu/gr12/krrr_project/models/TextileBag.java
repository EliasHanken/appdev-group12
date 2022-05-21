package no.ntnu.gr12.krrr_project.models;

import javax.persistence.*;

/**
 * Class containing the textileBag
 */
@Entity
@DiscriminatorValue("005")
public class TextileBag extends Item{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long TextileID;

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
