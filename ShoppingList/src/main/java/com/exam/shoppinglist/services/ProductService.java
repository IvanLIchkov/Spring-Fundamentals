package com.exam.shoppinglist.services;

import com.exam.shoppinglist.models.dtos.ProductAddDto;
import com.exam.shoppinglist.models.entities.Product;

import java.util.List;

public interface ProductService {

    void addProduct(ProductAddDto productAddDto);

    List<Product> allProducts();

    void buyProduct(Long id);

    void buyAll();
}
