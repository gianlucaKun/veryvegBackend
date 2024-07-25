package com.veryveg.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.veryveg.product.entity.Supermercato;


@Repository
public interface SupermercatoRepository extends MongoRepository<Supermercato, String> {

}