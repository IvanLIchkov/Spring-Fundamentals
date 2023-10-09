package com.exam.shoppinglist.repositories;

import com.exam.shoppinglist.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {


    Optional<Product> findByName(String value);
}
