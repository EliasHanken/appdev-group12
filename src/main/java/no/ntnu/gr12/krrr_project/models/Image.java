package no.ntnu.gr12.krrr_project.models;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import no.ntnu.gr12.krrr_project.Utils;

/**
 * Model for storing image data
 */

@Entity
public class Image {
  @Id
  @GeneratedValue
  private Integer id;
  @Lob
  private byte[] data;
  private String extension;
  private String contentType;
  /**To be used to search for images.
   * Should have the same name as the product they represent, I.E; picture of
   * bike model "Commuter" should have an imageName of "Commuter".
   */
  private String productName;

  public Image(){
  }

  public Image(byte[] data, String extension, String contentType, String productName) {
    this.data = data;
    this.extension = extension;
    this.contentType = contentType;
    this.productName = productName;
  }


  //Getters&Setters\\
  public Integer getId() { return id; }

  public void setId(Integer id) { this.id = id; }

  public byte[] getData() { return data; }

  public void setData(byte[] data) { this.data = data; }

  public String getExtension() { return extension; }

  public void setExtension(String extension) { this.extension = extension; }

  public String getContentType() { return contentType; }

  public void setContentType(String contentType) { this.contentType = contentType; }

  public String getImageName() {
    return productName;
  }

  public void setImageName(String productName) {
    this.productName = productName;
  }

  public String getFileName(){ return id + "." + extension; }
}
