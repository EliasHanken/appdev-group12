package no.ntnu.gr12.krrr_project.models;

import javax.persistence.Entity;

@Entity
public class Chalk extends Item{

  public Chalk() {
    super();
  }

  public Chalk(String modelNumber, float price) {
    super(modelNumber, price);
  }

  public Chalk(String modelNumber, float price, String imgLink) {
    super(modelNumber, price, imgLink);
  }
}
