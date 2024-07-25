package com.veryveg.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.veryveg.product.entity.ListaSpesa;


@Repository
public interface ListaSpesaRepository extends MongoRepository<ListaSpesa, String> {

}