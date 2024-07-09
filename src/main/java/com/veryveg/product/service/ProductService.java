package com.veryveg.product.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.veryveg.product.entity.Ingredient;
import com.veryveg.product.entity.Product;
import com.veryveg.product.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    @Transactional
    public String saveProduct(Product product) {
        // Verifica se il set di ingredienti è nullo e inizializzalo se necessario
        if (product.getIngredients() == null) {
            product.setIngredients(new HashSet<>());
        }

        // Calcola se il prodotto è vegan o vegetariano in base agli ingredienti
        boolean vegan = true;
        boolean vegetarian = true;

        // Se ci sono ingredienti, calcola vegan e vegetarian
        if (!product.getIngredients().isEmpty()) {
            for (Ingredient ingredient : product.getIngredients()) {
                if (!ingredient.isVegan()) {
                    vegan = false;
                }
                if (!ingredient.isVegetarian()) {
                    vegetarian = false;
                }
            }
        }

        // Imposta i valori vegan e vegetarian nel prodotto
        product.setVegan(vegan);
        product.setVegetarian(vegetarian);

        // Salva il prodotto nel repository
        productRepository.save(product);
        return product.getName();
    }

    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }

    public Product getByBarcode(String barcode) {
        return productRepository.findByBarcode(barcode);
    }
}
