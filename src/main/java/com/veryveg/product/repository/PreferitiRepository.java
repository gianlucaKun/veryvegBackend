package com.veryveg.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.veryveg.product.entity.Preferiti;


@Repository
public interface PreferitiRepository extends MongoRepository<Preferiti, String> {

}
