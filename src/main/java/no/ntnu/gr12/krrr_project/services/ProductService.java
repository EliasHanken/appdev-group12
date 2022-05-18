package no.ntnu.gr12.krrr_project.services;

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
    private ProductRepository productRepository;

    public List<Product> getAll() {
        List<Product> products = new LinkedList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }
}
