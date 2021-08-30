package digitalinnovation.one.experts.productcatalog.controller;

import digitalinnovation.one.experts.productcatalog.model.Product;
import digitalinnovation.one.experts.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @RequestMapping
    public List<Product> list() {
        return StreamSupport
                .stream(productRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @RequestMapping("/{id}")
    public Product findById(@PathVariable("id") Integer id) {
        return productRepository.findById(id).orElse(new Product());
    }

    @RequestMapping("/name/{name}")
    public List<Product> findByName(@PathVariable("name") String name) {
        return StreamSupport
                .stream(productRepository.findByName(name).spliterator(), false)
                .collect(Collectors.toList());
    }

}
