package no.ntnu.gr12.krrr_project.models;

/**
 * Enum class for different types of items. Meant to store model-number and price.
 */
public enum ItemEnum {


  HELMET_NORMAL("2", 150),
  SUNGLASSES_BASIC("3", 75),
  TEXTILE_BAG_BASIC("4", 150),
  CHALK_BASIC("5", 50);



  String modelNumber;
  float price;

  ItemEnum(String modelNumber, float price) {
    this.modelNumber = modelNumber;
    this.price = price;
  }

  public String getModelNumber() {
    return modelNumber;
  }

  public void setModelNumber(String modelNumber) {
    this.modelNumber = modelNumber;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }
}
