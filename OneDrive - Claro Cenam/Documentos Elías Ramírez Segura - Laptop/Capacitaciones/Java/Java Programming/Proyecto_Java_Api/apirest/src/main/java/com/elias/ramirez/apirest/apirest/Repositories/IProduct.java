package com.elias.ramirez.apirest.apirest.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.elias.ramirez.apirest.apirest.Entities.Product;

public interface IProduct extends JpaRepository<Product, Long> {

}
