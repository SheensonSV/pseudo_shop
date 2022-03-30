package main.services;

import main.entitys.Product;
import main.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getProducts() {
        List<Product> allProducts = new ArrayList<>();
        productRepo.findAll().forEach(allProducts::add);
        allProducts.forEach(System.out::println);
        return allProducts;
    }

    public Product getProductById(Long id) {
        Optional<Product> productById = productRepo.findById(id);
        return productById.orElse(null);
    }

    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }
}
