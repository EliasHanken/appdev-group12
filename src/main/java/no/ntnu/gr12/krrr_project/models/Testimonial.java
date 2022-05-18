package no.ntnu.gr12.krrr_project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Thomas Ystenes
 * Class representing customer testimonials.
 */

@Entity
public class Testimonial {
  @Id
  @GeneratedValue
  private long testimonialId;


  /**The main text of the testimonial*/
  private String text;
  /**The name of the customer who posted the testimonial*/
  private String posterName;

  /**
   * No-arg constructor for Testimonial
   */
  public Testimonial(){
  }

  /**
   * Constructor method for Testimonial
   * @param text The main text of the Testimonial
   * @param posterName The name of the customer who posted the Testimonial
   */
  public Testimonial(String text, String posterName){
    this.text = text;
    this.posterName = posterName;
  }

  /////Getters/Setters\\\\\

  /**
   * Returns the text of the Testimonial
   * @return text of Testimonial
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the text of the Testimonial
   * @param text text of the Testimonial
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Returns the name of the customer who posted the Testimonial
   * @return The name of the customer who posted the Testimonial
   */
  public String getPosterName() {
    return posterName;
  }

  /**
   * Sets the name of the customer who posted the Testimonial
   * @param posterName The name of the customer who posted the Testimonial
   */
  public void setPosterName(String posterName) {
    this.posterName = posterName;
  }
}
