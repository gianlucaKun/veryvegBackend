package com.veryveg.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.veryveg.product.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByBarcode(String barcode);
}
