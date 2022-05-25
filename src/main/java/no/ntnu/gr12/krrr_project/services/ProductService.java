package no.ntnu.gr12.krrr_project.services;

import java.util.Optional;
import no.ntnu.gr12.krrr_project.models.Product;
import no.ntnu.gr12.krrr_project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Business logic for products
 */
@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepo;

  public List<Product> getAll() {
    List<Product> products = new LinkedList<>();
    productRepo.findAll().forEach(products::add);
    return products;
  }

  /**
   * Get a product by ID
   *
   * @param id Unique ID
   * @return The product mathicng the ID, or null if none were found.
   */
  public Product getById(Integer id) {
    Optional<Product> product = productRepo.findById(id);
    return product.orElse(null);
  }

  /**
   * Updates a product with given ID in the database
   *
   * @param id The ID of the product to be updated.
   * @param product the new data for the product
   * @return null on success, else, error message.
   */
  public String update(int id, Product product) {
    Optional<Product> exisingProduct = productRepo.findById(id);
    String errorMessage = null;
    if(exisingProduct.isPresent()) {
      product.setId(id);
      try{
        productRepo.save(product);
      } catch (Exception e) {
        errorMessage = "Error while saving the product to DB: " + e.getMessage();
      }
    } else {
      errorMessage = "Product with given ID not found";
    } return errorMessage;
  }

  /**
   * Delete a product with the given ID from the DB
   *
   * @param id ID of the product to be deelted.
   * @return null on success, else, error message.
   */
  public String delete(Integer id){
    String errorMessage = null;
    try{
      productRepo.deleteById(id);
    } catch (Exception e) {
      errorMessage = "Error while deleting a product from DB: " + e.getMessage();
    }
    return errorMessage;
  }


  /**
   * Add a new product to the DB
   *
   * @param product Product to be added to the DB
   * @return null on success, else, error message.
   */
  public String add(Product product) {
    String errorMessage = null;
    if(product.getId() > 0 ) {
      Optional<Product> existingProduct = productRepo.findById(product.getId());
      if(existingProduct.isPresent()) {
        errorMessage = "Product with that ID already exists";
      }
    }
    if(errorMessage == null) {
      try{
        Product savedProduct = productRepo.save(product);
        product.setId(savedProduct.getId());
      } catch (Exception e) {
        errorMessage = "Error while adding the product to DB: " + e.getMessage();
      }
    }
    return errorMessage;
  }
}
