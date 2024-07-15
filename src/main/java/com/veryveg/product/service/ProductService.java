package com.veryveg.product.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.veryveg.product.entity.Ingredient;
import com.veryveg.product.entity.Product;
import com.veryveg.product.repository.IngredientRepository;
import com.veryveg.product.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IngredientRepository ingredientRepository;
    
    
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

        // Se non ci sono ingredienti nel payload, utilizza i dati del prodotto stesso
        if (product.getIngredients().isEmpty()) {
            // Calcola vegano e vegetariano basandosi sui dati del prodotto
            boolean vegan = product.isVegan();
            boolean vegetarian = product.isVegetarian();

            // Imposta i valori vegan e vegetarian nel prodotto
            product.setVegan(vegan);
            product.setVegetarian(vegetarian);
        } else {
            // Altrimenti, gestisci gli ingredienti come prima
            Set<Ingredient> savedIngredients = new HashSet<>();

            for (Ingredient ingredient : product.getIngredients()) {
                // Controlla se l'ingrediente è già presente nel database
                Optional<Ingredient> existingIngredient = ingredientRepository.findByName(ingredient.getName());

                if (existingIngredient.isPresent()) {
                    // Utilizza l'ingrediente esistente come riferimento
                    savedIngredients.add(existingIngredient.get());
                } else {
                    // Salva l'ingrediente nuovo nel database
                    Ingredient savedIngredient = ingredientRepository.save(ingredient);
                    savedIngredients.add(savedIngredient);
                }
            }

            // Imposta gli ingredienti salvati nel prodotto
            product.setIngredients(savedIngredients);

            // Calcola vegano e vegetariano basandosi sugli ingredienti salvati
            boolean vegan = true;
            boolean vegetarian = true;

            for (Ingredient ingredient : savedIngredients) {
                if (!ingredient.isVegan()) {
                    vegan = false;
                }
                if (!ingredient.isVegetarian()) {
                    vegetarian = false;
                }
            }

            // Imposta i valori vegan e vegetarian nel prodotto
            product.setVegan(vegan);
            product.setVegetarian(vegetarian);
        }

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
    
    public Set<Ingredient> getIngredientsByBarcode(String barcode) {
        Product product = productRepository.findByBarcode(barcode);
        if (product != null) {
            return product.getIngredients();
        }
        return new HashSet<>();
    }
}
