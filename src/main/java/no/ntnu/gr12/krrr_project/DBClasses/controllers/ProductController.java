package no.ntnu.gr12.krrr_project.DBClasses.controllers;

import no.ntnu.gr12.krrr_project.DBClasses.models.Product;
import no.ntnu.gr12.krrr_project.DBClasses.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
