package com.exam.shoppinglist.services.impl;

import com.exam.shoppinglist.models.dtos.AddProductMapper;
import com.exam.shoppinglist.models.dtos.ProductAddDto;
import com.exam.shoppinglist.models.entities.Product;
import com.exam.shoppinglist.repositories.CategoryRepository;
import com.exam.shoppinglist.repositories.ProductRepository;
import com.exam.shoppinglist.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private  final ProductRepository productRepository;
    private final AddProductMapper addProductMapper;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, AddProductMapper addProductMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.addProductMapper = addProductMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void addProduct(ProductAddDto productAddDto) {
        Product product = addProductMapper.addDtoToEntity(productAddDto);
        product.setCategory(this.categoryRepository.findById(productAddDto.getCategoryId()).get());
        product.setNeedBefore(productAddDto.getBefore());
        this.productRepository.save(product);
    }

    @Override
    public List<Product> allProducts() {

        return this.productRepository.findAll();
    }

    @Override
    public void buyProduct(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        this.productRepository.deleteAll();
    }
}
