package no.ntnu.gr12.krrr_project.controllers;

import io.swagger.models.Response;
import no.ntnu.gr12.krrr_project.models.Product;
import no.ntnu.gr12.krrr_project.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
public class ProductController {
  Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

  @Autowired
  private ProductService productService;

  /**
   * Get all products stored in the database
   *
   * @return List of all products
   */
  @GetMapping("/api/products")
  public List<Product> getAll() {
    try {
      Thread.sleep(3000); // Imitate long loading of data...
    } catch (InterruptedException e) {
      logger.error("Product-loading thread interrupted!");
    }
    return productService.getAll();
  }

  /**
   * Add a new product to the DB. Called on HTTP POST
   *
   * @param product Product to add
   * @return HTTP OK on success and product ID in the body, else, BAD REQUEST
   */
  @PostMapping("/products")
  public ResponseEntity<String> add(@RequestBody Product product) {
    ResponseEntity<String> response;
    String errorMessage = productService.add(product);
    if (errorMessage == null) {
      response = new ResponseEntity<>("" + product.getId(), HttpStatus.OK);
    } else {
      response = new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    return response;
  }


  /**
   * Update a product in the DB. Called on HTTP PUT
   *
   * @param product New product data
   * @param id      ID of the product to be updated
   * @return HTTP OK on success, else BAD REQUEST
   */
  @PutMapping("/products/{id}")
  public ResponseEntity<String> update(@RequestBody Product product, @PathVariable Integer id) {
    ResponseEntity<String> response;
    String errorMessage = productService.update(id, product);
    if (errorMessage == null) {
      response = new ResponseEntity<>(HttpStatus.OK);
    } else {
      response = new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    return response;
  }

  /**
   * Delete a product from the DB. Called on HTTP DELETE
   *
   * @param id The ID of the product to be deleted.
   * @return HTTP OK on success, else BAD REQUEST
   */
  public ResponseEntity<String> delete(@PathVariable Integer id) {
    ResponseEntity<String> response;
    String errorMessage = productService.delete(id);
    if (errorMessage == null) {
      response = new ResponseEntity<>(HttpStatus.OK);
    } else {
      response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return response;
  }
}