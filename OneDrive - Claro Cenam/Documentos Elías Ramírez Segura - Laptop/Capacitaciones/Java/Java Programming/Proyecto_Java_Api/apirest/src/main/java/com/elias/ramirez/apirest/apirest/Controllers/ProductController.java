package com.elias.ramirez.apirest.apirest.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elias.ramirez.apirest.apirest.Entities.Product;
import com.elias.ramirez.apirest.apirest.Repositories.IProduct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProduct productInterfaceRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return productInterfaceRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productInterfaceRepository.findById(id).
        orElseThrow(() -> new RuntimeException("The product with the id " + id + " does not exists"));
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        //Return the new created product
        return productInterfaceRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product product = productInterfaceRepository.findById(id).
        orElseThrow(() -> new RuntimeException("The product with the id " + id + " does not exists"));

        product.setNombre(productDetails.getNombre());
        product.setPrecio(productDetails.getPrecio());

        return productInterfaceRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Product product = productInterfaceRepository.findById(id).
        orElseThrow(() -> new RuntimeException("The product with the id " + id + " does not exists"));

        productInterfaceRepository.delete(product);
        return "The product with the id " + id + " has been deleted";
    }
}
